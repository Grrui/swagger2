package com.example.swagger2.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(description = "用户信息")
public class User {

    @ApiModelProperty(value = "姓名")
    String name;
    @ApiModelProperty(value = "年龄")
    Integer age;
}
