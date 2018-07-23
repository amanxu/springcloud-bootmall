package com.mall.user.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @description:
 * @author: xiaoxu.nie
 * @date: 2018-07-22 16:54
 */
@ApiModel(value = "用户操作DTO")
@Setter
@Getter
@ToString
public class UserDto {

    @ApiParam(value = "用户ID")
    private Long id;

    @ApiParam(value = "用户名")
    private String username;
    @ApiParam(value = "账户名")
    private String account;
    @ApiParam(value = "账户密码")
    private String password;
    @ApiParam(value = "用户头像")
    private String imgurl;
    @ApiParam(value = "用户邮箱")
    private String email;
    @ApiParam(value = "用户手机")
    private String phone;
    @ApiParam(value = "密码找回问题")
    private String question;
    @ApiParam(value = "密码找回答案")
    private String answer;
    @ApiParam(value = "用户注册时间", hidden = true)
    private Date createTime;
    @ApiParam(value = "用户更新时间", hidden = true)
    private Date updateTime;

}
