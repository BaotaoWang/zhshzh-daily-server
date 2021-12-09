package cn.com.zhshzh.daily.core.enums;

import com.alibaba.fastjson.JSON;

/**
 * 接口返回消息的枚举类
 * (每组异常消息至少预留20个)
 *
 * @author wangbt
 * @since 2022-01-01
 */
public enum RestResultEnum {
    SUCCESS(10000, "成功"),
    FAIL(9000, "失败"),

    /* 系统级异常 */
    EMPTY_DATA(9001, "数据不存在"),
    ERROR_PARAM(9002, "参数错误"),

    ;

    private final int code;
    private final String message;

    RestResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
