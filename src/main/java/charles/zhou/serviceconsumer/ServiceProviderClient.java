package charles.zhou.serviceconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-provider")
interface ServiceProviderClient {
    @GetMapping("/service")
    String getService();
}