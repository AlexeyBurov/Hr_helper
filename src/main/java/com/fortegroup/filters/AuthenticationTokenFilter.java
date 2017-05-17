
/**
 * Authentication filter it work with JWT(Json web token)
 * @author Alexey Burov
 * @version 1.0
 */

package com.fortegroup.filters;


import com.fortegroup.model.accounts.User;
import com.fortegroup.service.accounts.UserService;
import com.fortegroup.utill.Constant;
import com.fortegroup.utill.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenUtils tokenUtils;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        tokenUtils = WebApplicationContextUtils
                .getRequiredWebApplicationContext(this.getServletContext())
                .getBean(TokenUtils.class);
        userService = WebApplicationContextUtils
                .getRequiredWebApplicationContext(this.getServletContext())
                .getBean(UserService.class);

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, " + Constant.tokenHeader);


        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if(!httpRequest.getRequestURL().toString().contains("/protected/")) {
            chain.doFilter(httpRequest, httpResponse);
        }else {
            String authToken = httpRequest.getHeader(Constant.tokenHeader);
            String userName = tokenUtils.getUsernameFromToken(authToken);
            User user = this.userService.loadUserByUsername(userName);
            if (tokenUtils.isTokenExpired(authToken)) {
                httpResponse.sendError(401);
            } else if (user == null) {
                httpResponse.sendError(401);
            } else {
                httpRequest.setAttribute("id", user.getId());
                httpRequest.setAttribute("role", user.getAuthorities());
            }
            chain.doFilter(request, response);
        }
    }

}

