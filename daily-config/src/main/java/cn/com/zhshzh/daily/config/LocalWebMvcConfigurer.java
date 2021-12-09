package cn.com.zhshzh.daily.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 配置spring框架提供的类型转换器
 * 该配置是为了解决java.lang.ClassCastException
 * 由于该系统定义了API接口统一JSON格式返回{@link GlobalResponseBodyAdvice#beforeBodyWrite}
 * 如果这里不配置json转换器，当接口返回String类型时会出现ClassCastException异常
 *
 * @author wangbt
 * @since 2022-01-01
 */
@Configuration
public class LocalWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 第一种方式是将 json 处理的转换器放到第一位，使得先让 json 转换器处理返回值，这样 String转换器就处理不了了。
        converters.add(0, new MappingJackson2HttpMessageConverter());
        // 第二种就是把String类型的转换器去掉，不使用String类型的转换器
        // converters.removeIf(httpMessageConverter -> httpMessageConverter.getClass() == StringHttpMessageConverter.class);
    }
}
