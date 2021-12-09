package cn.com.zhshzh.daily.core.model;

import cn.com.zhshzh.daily.core.enums.RestResultEnum;
import lombok.Data;

/**
 * 定义API返回数据规范
 *
 * @author wangbt
 * @since 2022-01-01
 */
@Data
public class RestResult<T> {

    private int code;

    private String message;

    private T data;

    /**
     * 定义返回成功消息的json对象（无返回数据）
     */
    public RestResult() {
        this.code = RestResultEnum.SUCCESS.getCode();
        this.message = RestResultEnum.SUCCESS.getMessage();
    }

    /**
     * 定义返回失败消息的json对象（无返回数据）
     *
     * @param message
     */
    public RestResult(String message) {
        this.code = RestResultEnum.FAIL.getCode();
        this.message = message;
    }

    /**
     * 自定义返回消息的json对象（无返回数据）
     *
     * @param RestResultEnum 返回消息的枚举
     */
    public RestResult(RestResultEnum RestResultEnum) {
        this.code = RestResultEnum.getCode();
        this.message = RestResultEnum.getMessage();
    }

    /**
     * 定义返回成功消息的json对象（有返回数据）
     *
     * @param data 返回的数据
     */
    public RestResult(T data) {
        this.code = RestResultEnum.SUCCESS.getCode();
        this.message = RestResultEnum.SUCCESS.getMessage();
        this.data = data;
    }

    /**
     * 自定义返回消息的json对象（有返回数据）
     *
     * @param RestResultEnum 返回消息的枚举
     * @param data           返回的数据
     */
    public RestResult(RestResultEnum RestResultEnum, T data) {
        this.code = RestResultEnum.getCode();
        this.message = RestResultEnum.getMessage();
        this.data = data;
    }

    /**
     * 返回成功的信息提示
     *
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> success() {
        return new RestResult<>();
    }

    /**
     * 返回成功的请求数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> success(T data) {
        return new RestResult<>(data);
    }

    /**
     * 返回失败的信息提示
     *
     * @param RestResultEnum
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> error(RestResultEnum RestResultEnum) {
        return new RestResult<>(RestResultEnum);
    }

    /**
     * 返回失败的信息提示
     *
     * @param errorMessage
     * @return
     */
    public static RestResult<String> error(String errorMessage) {
        return new RestResult<>(errorMessage);
    }
}
