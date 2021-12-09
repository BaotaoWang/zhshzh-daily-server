package cn.com.zhshzh.daily.repository.entity;

import cn.com.zhshzh.daily.repository.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author wangbt
 * @since 2022-01-01
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user_info")
public class SysUserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户登录名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 登录密码
     */
    @TableField("password")
    private String password;

    /**
     * 用户显示名
     */
    @TableField("full_name")
    private String fullName;

    /**
     * 用户年龄
     */
    @TableField("user_age")
    private Integer userAge;


}
