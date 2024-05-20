package ua.lysenko.userserivce.security.handlers;


import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ua.lysenko.userserivce.textresources.ExceptionKeys;
import ua.lysenko.userserivce.exceptions.Responses.ApiExceptionModel;
import ua.lysenko.userserivce.shared.Utils;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    Logger logger = LoggerFactory.getLogger(ExceptionHandlerFilter.class);

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            ApiExceptionModel apiExceptionModel = ApiExceptionModel.builder()
                    .message(ExceptionKeys.JWT_EXPIRED.getMessage())
                    .build();
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().write(Utils.convertObjectToJson(apiExceptionModel));
            response.setContentType("application/json");
            logger.error(e.getMessage());
        }
    }
}