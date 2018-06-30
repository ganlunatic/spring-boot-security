package cn.lunatic.springboot.security.configuration;

import cn.lunatic.springboot.security.biz.security.service.impl.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * Security配置类
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 注册Bean：认证用户信息获取服务
     *
     * @return
     */
    @Bean
    public UserDetailsService customUserService() {
        return new CustomUserService();
    }

    /**
     * 密码加密验证器
     *
     * @return
     */
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    /**
     * 认证Provider类，主要是用于
     * 1.实现不要隐藏UsernameNotFoundException异常内容
     * 2.设置认证用户获取服务Bean
     * 3.设置密码加密验证器
     *
     * @return
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setHideUserNotFoundExceptions(false);
        provider.setUserDetailsService(customUserService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


    /**
     * 认证配置
     * 1.配置所有请求都需要认证
     * 2.配置认证页面（即登录页面）和登录失败页面无需认证，记录登录失败页面需要“error=true”
     * 3.配置退出请求无需认证
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").successForwardUrl("/index").failureUrl("/login?error").permitAll()
                .and()
                .logout().permitAll();
    }


    /**
     * 配置忽略静态资源访问无需认证
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().mvcMatchers("/bootstrap/**");
    }


}
