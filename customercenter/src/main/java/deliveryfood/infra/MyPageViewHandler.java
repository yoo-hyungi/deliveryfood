package deliveryfood.infra;

import deliveryfood.config.kafka.KafkaProcessor;
import deliveryfood.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MyPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void when주문됨_then_CREATE_1(@Payload 주문됨 주문됨) {
        try {
            if (!주문됨.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setUserId(주문됨.getUserId());
            myPage.setFoodname(주문됨.getFoodname());
            myPage.setQty(주문됨.getQty());
            myPage.setPrice(주문됨.getPrice());
            myPage.setStore(주문됨.getStore());
            myPage.setOrderId(주문됨.getOrderId());
            myPage.setAddress(주문됨.getAddress());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void when배달시작됨_then_UPDATE_1(@Payload 배달시작됨 배달시작됨) {
        try {
            if (!배달시작됨.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByOrderId(
                배달시작됨.getOrderId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus(배달시작됨.getStatus());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
