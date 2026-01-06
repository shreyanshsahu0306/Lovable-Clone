package com.myprojects.clone.Lovable_clone.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class JwtAuthFilter extends OncePerRequestFilter {

    AuthUtil authUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /*this method takes http request and extract the authorization header from which it will get the auth token.
        Once the token is fetched, it validates the token and then fetches user information in security context holder.
        And then the request will pass along the filter chain.
         */
        log.info("Incoming Request: {}", request.getRequestURI());
        final String requestHeaderToken = request.getHeader("Authorization");
        if(requestHeaderToken == null || !requestHeaderToken.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }
        String token = requestHeaderToken.split("Bearer ")[1];
        JwtUserPrincipal  user = authUtil.verifyAccessToken(token);
        if(user!=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    user, null, user.authorities()
            );
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        filterChain.doFilter(request, response);
    }
}
