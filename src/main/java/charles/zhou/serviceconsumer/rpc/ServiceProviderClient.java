package charles.zhou.serviceconsumer.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-provider")
public interface ServiceProviderClient {
    @GetMapping("/service-provider/service")
    String getService();
}