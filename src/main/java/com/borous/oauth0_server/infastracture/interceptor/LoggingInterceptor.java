package com.borous.oauth0_server.infastracture.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static com.borous.oauth0_server.infastracture.interceptor.LoggingRequestHelpers.buildHeadersMap;
import static com.borous.oauth0_server.infastracture.interceptor.LoggingRequestHelpers.buildParametersMap;

@Component
@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name()) && request.getMethod().equals(HttpMethod.GET.name())) {
            StringBuilder stringBuilder = new StringBuilder();
            Map<String, String> parameters = buildParametersMap(request);

            stringBuilder.append("REQUEST ");
            stringBuilder.append("method=[").append(request.getMethod()).append("] ");
            stringBuilder.append("path=[").append(request.getRequestURI()).append("] ");
            stringBuilder.append("headers=[").append(buildHeadersMap(request)).append("] ");

            if (!parameters.isEmpty()) {
                stringBuilder.append("parameters=[").append(parameters).append("] ");
            }

            log.info(stringBuilder.toString());
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
