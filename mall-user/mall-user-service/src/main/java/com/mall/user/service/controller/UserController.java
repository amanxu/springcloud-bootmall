package com.mall.user.service.controller;

import com.mall.common.pojo.Result;
import com.mall.common.utils.ResultUtil;
import com.mall.user.model.dto.UserDto;
import com.mall.user.model.pojo.User;
import com.mall.user.service.mapper.UserMapper;
import com.mall.user.service.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: xiaoxu.nie
 * @date: 2018-07-22 16:38
 */
@Api(value = "用户操作API")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "新增用户API")
    @RequestMapping("/add")
    public Result userAdd(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userMapper.insert(user);
        return ResultUtil.success(user);
    }

    @ApiOperation(value = "删除用户API")
    @RequestMapping("/delete")
    public Result userDelete(Long userId) {
        userMapper.deleteByPrimaryKey(userId);
        return ResultUtil.success();
    }

    @ApiOperation(value = "根据用户名查询用户API")
    @RequestMapping("/queryName")
    public Result userQuery(String userName) {
        User user = userRepository.findByUserName(userName);
        return ResultUtil.success(user);
    }

    @ApiOperation(value = "根据用户ID查询用户API")
    @RequestMapping("/queryId")
    public Result userQuery(Long userId) {
        userMapper.selectByPrimaryKey(userId);
        return ResultUtil.success();
    }

    @ApiOperation(value = "修改用户API")
    @RequestMapping("/modify")
    public Result userModify(UserDto userDto) {
        User user = userMapper.selectByPrimaryKey(userDto.getId());
        BeanUtils.copyProperties(userDto, user);
        userMapper.updateByPrimaryKey(user);

        return ResultUtil.success(user);
    }
}
