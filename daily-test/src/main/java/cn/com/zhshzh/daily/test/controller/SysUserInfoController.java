package cn.com.zhshzh.daily.test.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author wangbt
 * @since 2022-01-01
 */
@RestController
@RequestMapping("/users")
public class SysUserInfoController {
    @GetMapping
    public String getMessage() {
        return "hello world";
    }
}

