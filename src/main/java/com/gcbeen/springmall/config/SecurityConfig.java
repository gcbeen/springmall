package com.gcbeen.springmall.config;

import java.util.List;

import com.gcbeen.springmall.component.AdminPermission;
import com.gcbeen.springmall.component.JwtAuthenticationTokenFilter;
import com.gcbeen.springmall.component.RestAuthenticationEntryPoint;
import com.gcbeen.springmall.component.RestfulAccessDeniedHandler;
import com.gcbeen.springmall.dto.AdminUserDetails;
import com.gcbeen.springmall.model.UmsAdmin;
import com.gcbeen.springmall.model.UmsPermission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * SpringSecurity 的配置
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private AdminPermission adminPermission;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf() // JWT 不需要 csrf
        .disable()
        .sessionManagement() // JWT 基于 token 不需要session
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        // 静态资源 不需要授权
        .antMatchers(HttpMethod.GET, "/", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js", "/swagger-resources/**", "/v3/api-docs/**").permitAll()
        // 登录注册 匿名访问
        .antMatchers("/admin/login", "/admin/register").permitAll()
        // 跨域请求 先进行一次 options 请求
        .antMatchers(HttpMethod.OPTIONS).permitAll()
        // 除了上面的 规则外 其他请求 需要验证
        .anyRequest().authenticated();
        // 禁用缓存
        httpSecurity.headers().cacheControl();
        // 添加 jwt filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        httpSecurity.exceptionHandling().accessDeniedHandler(restfulAccessDeniedHandler).authenticationEntryPoint(restAuthenticationEntryPoint);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }


    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return username -> {
            UmsAdmin admin = adminPermission.getAdminByUsername(username);
            if (admin != null) {
                List<UmsPermission> permissionList = adminPermission.getPermissionList(admin.getId());
                LOGGER.info("permissionList  : {}", permissionList);
                return new AdminUserDetails(admin, permissionList);
            }
            throw new UsernameNotFoundException("用户名或秘密错误");
        };
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
