package cn.com.zhshzh.daily.core.annotation;


import cn.com.zhshzh.daily.core.enums.RestResultEnum;

import java.lang.annotation.*;

/**
 *
 *
 * @author wangbt
 * @since 2022-01-01
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RestResultAnnotation {
    RestResultEnum value();
}
