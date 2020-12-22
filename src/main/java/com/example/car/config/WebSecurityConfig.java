package com.example.car.config;

import com.example.car.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private LoginSuccessHandler successHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //首页所有人可以访问，功能页需要对应权限的人才可以访问
        //注意  ：拦截的时请求的路径，而不是直接时页面
        http.authorizeRequests().antMatchers("/").permitAll()
                                .antMatchers("/admin").hasRole("ADMIN")
                                .antMatchers("/user").hasRole("USER")
                                .anyRequest()
                                .authenticated()
                                .and()
                                .formLogin()    //开启登录
                                .loginPage("/toLogin") //登录页面路径
                                .loginProcessingUrl("/login") // 登录请求路径
                                .successHandler(successHandler).permitAll()
                                .and()
                                .logout()  //开启注销
                                .permitAll(); //登出成功后显示的页面

        //关闭跨域
        http.csrf().disable();


    }

    /*在非自定义页面的情况下，在内存中配置用户名，密码以及角色*/
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
	 	.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("wangsj").password(new BCryptPasswordEncoder().encode("123456")).roles("ROLE_ADMIN").and()
                .withUser("wangym").password(new BCryptPasswordEncoder().encode("123456")).roles("ROLE_USER");
    }*/
}
