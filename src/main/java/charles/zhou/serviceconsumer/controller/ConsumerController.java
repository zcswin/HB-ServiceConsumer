package charles.zhou.serviceconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import charles.zhou.serviceconsumer.rpc.ServiceProviderClient;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/service-consumer")
public class ConsumerController {
	@Autowired
    private ServiceProviderClient serviceProviderClient;
	
    @Value("${server.port}")
    private String serverPort; // 注入当前服务的端口号
    
    @GetMapping("/call-service-provider")
    @ApiOperation("轮询服务端API及端口")
    public String consumeService() {
        return serviceProviderClient.getService();
    }
    
    @GetMapping("/service")
    @Operation(summary = "提供服务消息", description = "返回服务消息详细")
    public String providerService() {
        return "This is a service Consumer by the Charles Zhou.Port:" + serverPort;
    }   
}
