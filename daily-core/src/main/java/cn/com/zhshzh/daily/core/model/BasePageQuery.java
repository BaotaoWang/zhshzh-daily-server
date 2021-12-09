package cn.com.zhshzh.daily.core.model;

import lombok.Data;

/**
 * 分页查询的基类
 *
 * @author wangbt
 * @since 2022-01-01
 */
@Data
public abstract class BasePageQuery {
    private Integer currentPage;
    private Integer pageSize;
}
