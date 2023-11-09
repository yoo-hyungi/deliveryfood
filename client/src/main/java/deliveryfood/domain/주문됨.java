package deliveryfood.domain;

import deliveryfood.domain.*;
import deliveryfood.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class 주문됨 extends AbstractEvent {

    private Long id;
    private String userId;
    private String foodname;
    private Integer qty;
    private String status;
    private String store;
    private Long price;
    private String orderId;
    private String address;

    public 주문됨(주문 aggregate) {
        super(aggregate);
    }

    public 주문됨() {
        super();
    }
}
//>>> DDD / Domain Event
