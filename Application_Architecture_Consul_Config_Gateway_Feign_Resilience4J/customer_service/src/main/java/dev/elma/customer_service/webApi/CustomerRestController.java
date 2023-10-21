package dev.elma.customer_service.webApi;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class CustomerRestController {
    @Value(value = "${global.params.x}")
    private String x;
    @Value(value = "${global.params.y}")
    private String y;
    @Value(value = "${customer.params.a}")
    private String a;
    @Value(value = "${customer.params.b}")
    private String b;


    @GetMapping("/configs")
    public Map getParams(){
        return Map.of("x",x,"y",y,"a",a,"b",b);
    }
}
