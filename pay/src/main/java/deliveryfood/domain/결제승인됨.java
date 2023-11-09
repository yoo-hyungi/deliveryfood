package deliveryfood.domain;

import deliveryfood.domain.*;
import deliveryfood.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class 결제승인됨 extends AbstractEvent {

    private Long id;
    private String userId;
    private String orderId;
    private Long price;
    private String payStatus;

    public 결제승인됨(결제이력 aggregate) {
        super(aggregate);
    }

    public 결제승인됨() {
        super();
    }
}
//>>> DDD / Domain Event
