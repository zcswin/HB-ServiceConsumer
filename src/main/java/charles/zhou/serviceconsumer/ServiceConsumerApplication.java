package charles.zhou.serviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class ServiceConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication.class, args);
    }

    private final ServiceProviderClient serviceProviderClient;

    public ServiceConsumerApplication(ServiceProviderClient serviceProviderClient) {
        this.serviceProviderClient = serviceProviderClient;
    }

    @GetMapping("/consume")
    public String consumeService() {
        return serviceProviderClient.getService();
    }
}

