package com.example.swagger2.controller;


import com.example.swagger2.exception.SwaggerException;
import com.example.swagger2.model.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "接口服务", value = "/api/v1/swagger/**")
@RestController
@RequestMapping("/api/v1/swagger")
public class ApiController {

    @ApiOperation("保存用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", required = true, paramType = "path"),
            @ApiImplicitParam(name = "age", dataType = "int", value = "年龄", required = true, paramType = "query")
    })
    @PostMapping("/{name}")
    @ResponseBody
    public Boolean save(
            @PathVariable("name") String name,
            @RequestParam("age") Integer age
    ) {
        userInfo.put(name, new User(name, age));
        return true;
    }


    @ApiOperation("查询年龄")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 404, message = "用户不存在", response = SwaggerException.class)
    })
    @GetMapping("/{name}")
    @ResponseBody
    public User get(
            @PathVariable("name") String name
    ) throws SwaggerException {
        if (!userInfo.containsKey(name)) {
            throw new SwaggerException(name + "不存在！");
        }
        return userInfo.get(name);
    }

    public static Map<String, User> userInfo = new HashMap<>(16);
}
