package charles.zhou.serviceconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import charles.zhou.serviceconsumer.rpc.ServiceProviderClient;

@RestController
@RequestMapping("/service-consumer")
public class ConsumerController {

	@Autowired
    private ServiceProviderClient serviceProviderClient;    
    
    @GetMapping("/call-service-provider")
    public String consumeService() {
        return serviceProviderClient.getService();
    }
}
