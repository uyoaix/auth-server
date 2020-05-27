package com.yufei.learn.authservice.service;

import com.yufei.learn.authservice.domain.PassUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author yufei.wang
 * @date 2020/05/24 10:47
 */
public interface PassUserService extends UserDetailsService {

    PassUser getUserByUserId(Long userId);

    PassUser getUserByEmail(String email);

}
