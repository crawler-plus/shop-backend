package site.it4u.order.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @ApiOperation(value="test", notes="test")
    @GetMapping("/test")
    public String test() {
        return "hello, world";
    }
}
