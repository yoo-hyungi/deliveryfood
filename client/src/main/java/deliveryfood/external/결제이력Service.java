package deliveryfood.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "pay", url = "${api.url.pay}")
public interface 결제이력Service {
    @RequestMapping(method = RequestMethod.POST, path = "/결제이력")
    public void 결제(@RequestBody 결제이력 결제이력);
}
