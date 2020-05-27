package com.yufei.learn.authservice.controller;

import com.yufei.learn.authservice.domain.PassUser;
import com.yufei.learn.authservice.service.PassUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yufei.wang
 * @date 2020/05/24 19:56
 */
@Slf4j
@RestController
public class UserController {

    private final PassUserService passUserService;

    public UserController(PassUserService passUserService) {
        this.passUserService = passUserService;
    }

    @GetMapping("/user/info/{userId}")
    public PassUser userInfo(@PathVariable("userId") Long userId){
        return passUserService.getUserByUserId(userId);
    }

    @GetMapping("/user/token_verify")
    public PassUser userInfo(Authentication authentication){
        return passUserService.getUserByUserId(Long.parseLong(authentication.getName()));
    }

}
