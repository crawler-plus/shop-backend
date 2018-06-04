package site.it4u.user.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.it4u.domain.BaseEntity;

import java.util.Arrays;

@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value="test", notes="test")
    @GetMapping("/test")
    public BaseEntity test() {
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setContent(Arrays.asList(1, 2, 3));
        return baseEntity;
    }
}
