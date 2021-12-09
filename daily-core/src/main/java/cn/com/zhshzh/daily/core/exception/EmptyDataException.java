package cn.com.zhshzh.daily.core.exception;

import cn.com.zhshzh.daily.core.annotation.RestResultAnnotation;
import cn.com.zhshzh.daily.core.enums.RestResultEnum;

/**
 * 数据不存在异常
 *
 * @author wangbt
 * @since 2022-01-01
 */
@RestResultAnnotation(RestResultEnum.EMPTY_DATA)
public class EmptyDataException extends RestException {
    public EmptyDataException() {
        super();
    }

    public EmptyDataException(String message) {
        super(message);
    }
}
