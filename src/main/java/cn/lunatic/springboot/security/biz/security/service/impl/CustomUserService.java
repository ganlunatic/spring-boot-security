package cn.lunatic.springboot.security.biz.security.service.impl;

import cn.lunatic.springboot.security.facade.model.LoginUser;
import cn.lunatic.springboot.security.persistence.auto.mapper.UserInfoMapper;
import cn.lunatic.springboot.security.persistence.auto.model.UserInfo;
import cn.lunatic.springboot.security.persistence.auto.model.UserInfoExample;
import cn.lunatic.springboot.security.persistence.ext.mapper.UserRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.List;

/**
 * 认证用户信息获取服务
 *
 * @see UserDetailsService
 */
@Slf4j
public class CustomUserService implements UserDetailsService {
    @Resource
    UserRoleMapper userRoleMapper;

    @Resource
    UserInfoMapper userInfoMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUsernameEqualTo(s);

        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        if (userInfos.size() == 0) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        LoginUser loginUser = new LoginUser();
        loginUser.setId(userInfos.get(0).getId());
        loginUser.setUsername(userInfos.get(0).getUsername());
        loginUser.setPassword(userInfos.get(0).getPassword());
        loginUser.setRoles(userRoleMapper.selectByUserId(userInfos.get(0).getId()));
        return loginUser;
    }
}
