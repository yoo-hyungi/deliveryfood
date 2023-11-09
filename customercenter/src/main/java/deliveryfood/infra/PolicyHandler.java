package deliveryfood.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import deliveryfood.config.kafka.KafkaProcessor;
import deliveryfood.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='배달시작됨'"
    )
    public void whenever배달시작됨_카톡알림처리(
        @Payload 배달시작됨 배달시작됨
    ) {
        배달시작됨 event = 배달시작됨;
        System.out.println(
            "\n\n##### listener 카톡알림처리 : " + 배달시작됨 + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='주문됨'"
    )
    public void whenever주문됨_카톡알림처리(@Payload 주문됨 주문됨) {
        주문됨 event = 주문됨;
        System.out.println(
            "\n\n##### listener 카톡알림처리 : " + 주문됨 + "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
