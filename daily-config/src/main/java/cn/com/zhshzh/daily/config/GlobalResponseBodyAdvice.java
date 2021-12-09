package cn.com.zhshzh.daily.config;

import cn.com.zhshzh.daily.core.annotation.RestResultAnnotation;
import cn.com.zhshzh.daily.core.exception.RestException;
import cn.com.zhshzh.daily.core.model.RestResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 全局定义REST接口统一JSON格式返回类
 *
 * @author wangbt
 * @since 2022-01-01
 */
@Slf4j
@RestControllerAdvice(basePackages = {"cn.com.zhshzh.daily"})
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    /**
     * 定义需要拦截的类（方法），理论上controller中的所有方法都会被拦截
     *
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), RestController.class)
                || AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), Controller.class)
                || returnType.hasMethodAnnotation(ResponseBody.class);
    }

    /**
     * 对返回的数据进行自定义封装
     * 一定要注意这个配置{@link LocalWebMvcConfigurer#configureMessageConverters(List)}, 否则接口直接返回String时有可能报错
     *
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof RestResult || body instanceof LinkedHashMap) {
            return body;
        }
        return RestResult.success(body);
    }

    /**
     * 全局自定义异常处理
     * 只处理{@link RestException}异常及其子异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RestException.class)
    public ObjectNode restException(RestException e) {
        log.error(e.getMessage(), e);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonNodes = objectMapper.createObjectNode();
        RestResultAnnotation annotation = e.getClass().getAnnotation(RestResultAnnotation.class);
        jsonNodes.put("code", annotation.value().getCode());
        jsonNodes.put("message", StringUtils.isNotBlank(e.getMessage()) ? e.getMessage() : annotation.value().getMessage());
        return jsonNodes;
    }
}
