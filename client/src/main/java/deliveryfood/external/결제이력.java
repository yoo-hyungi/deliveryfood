package deliveryfood.external;

import java.util.Date;
import lombok.Data;

@Data
public class 결제이력 {

    private Long id;
    private String userId;
    private String orderId;
    private Long price;
    private String payStatus;
}
