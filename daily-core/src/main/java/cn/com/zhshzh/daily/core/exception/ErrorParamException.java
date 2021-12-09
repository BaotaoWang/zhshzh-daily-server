package cn.com.zhshzh.daily.core.exception;

import cn.com.zhshzh.daily.core.annotation.RestResultAnnotation;
import cn.com.zhshzh.daily.core.enums.RestResultEnum;

/**
 * 参数错误异常
 *
 * @author wangbt
 * @since 2022-01-01
 */
@RestResultAnnotation(RestResultEnum.ERROR_PARAM)
public class ErrorParamException extends RestException {
    public ErrorParamException() {
        super();
    }

    public ErrorParamException(String message) {
        super(message);
    }
}
