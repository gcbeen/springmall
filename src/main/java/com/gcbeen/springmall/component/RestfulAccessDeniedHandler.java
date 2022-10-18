package com.gcbeen.springmall.component;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcbeen.springmall.util.Result;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import cn.hutool.json.JSONUtil;

@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException e) throws IOException, ServletException {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                Result<String> res = Result.forbidden(e.getMessage());
                response.getWriter().println(JSONUtil.parse(res));
                response.getWriter().flush();
        
    }
    
}
