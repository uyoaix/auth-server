package com.yufei.learn.authservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yufei.learn.authservice.domain.PassUser;
import com.yufei.learn.authservice.mapper.UserMapper;
import com.yufei.learn.authservice.service.PassUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author yufei.wang
 * @date 2020/05/24 22:27
 */
@Slf4j
@Service
public class PassUserServiceImpl implements PassUserService {

    private final UserMapper userMapper;

    public PassUserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public PassUser getUserByUserId(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public PassUser getUserByEmail(String email) {
        return userMapper.selectOne(
                new QueryWrapper<PassUser>()
                        .eq("email", email)
        );
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        PassUser passUser = null;

        if (userName.contains("@")) {
            passUser = this.getUserByEmail(userName);
        } else {
            Long userId = Long.parseLong(userName);
            passUser = userMapper.selectById(userId);
        }

        if (passUser == null) {
            throw new UsernameNotFoundException("账号不存在");
        }

        return passUser;

    }
}
