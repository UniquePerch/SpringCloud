package com.test.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class FeignRequestInterceptor implements RequestInterceptor { //令牌中继，openFeign不能直接中继令牌，因此服务调用会出错

    @Override
    public void apply(RequestTemplate requestTemplate) {
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
                SecurityContextHolder.getContext().getAuthentication().getDetails();
        requestTemplate.header("Authorization","Bearer" + details.getTokenValue());
    }
}