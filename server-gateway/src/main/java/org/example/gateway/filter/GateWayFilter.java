package org.example.gateway.filter;

import org.example.util.JwtHelper;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class GateWayFilter implements GlobalFilter {
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        System.out.println("过滤器执行");
        //获取请求信息
        ServerHttpRequest request = exchange.getRequest();
        //获取请求路径信息判定
        String path = request.getURI().getPath();
        //放行登陆请求
        boolean match = antPathMatcher.match("/**/login/**", path);
        if (match){
            return chain.filter(exchange);
        }
        if (antPathMatcher.match("/**/drug/**",path)) {
            //获取请求或者cookie携带的token
            // TODO: 2022/12/13 可能为假
            String token = getToken(exchange, "token");
            Long userId = JwtHelper.getUserId(token);
            String userName = JwtHelper.getUserName(token);
            if (userId !=null && userName !=null){
                return chain.filter(exchange);
            }else{
                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                //结束处理
                return exchange.getResponse().setComplete();
            }
        }
        return chain.filter(exchange);
    }

    private String getToken(ServerWebExchange exchange, String key) {
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, HttpCookie> cookies = request.getCookies();
        if (cookies != null) {
            HttpCookie tokenCookie = cookies.getFirst(key);
            if (tokenCookie != null){
                String token = tokenCookie.getValue();
                if (!StringUtils.isEmpty(token)){
                    return token;
                }
            }
        }
        return request.getHeaders().getFirst(key);
    }
}