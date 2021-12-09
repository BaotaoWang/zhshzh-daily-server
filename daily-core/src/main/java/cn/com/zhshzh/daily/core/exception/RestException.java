package cn.com.zhshzh.daily.core.exception;


import cn.com.zhshzh.daily.core.annotation.RestResultAnnotation;
import cn.com.zhshzh.daily.core.enums.RestResultEnum;

/**
 * 定义API接口异常
 *
 * @author wangbt
 * @since 2022-01-01
 */
@RestResultAnnotation(RestResultEnum.FAIL)
public class RestException extends RuntimeException {
    public RestException() {
        super();
    }

    public RestException(String message) {
        super(message);
    }
}
