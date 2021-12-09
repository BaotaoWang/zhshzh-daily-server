package cn.com.zhshzh.daily.test.service.impl;

import cn.com.zhshzh.daily.repository.entity.SysUserInfo;
import cn.com.zhshzh.daily.repository.mapper.SysUserInfoMapper;
import cn.com.zhshzh.daily.test.service.SysUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author wangbt
 * @since 2022-01-01
 */
@Service
public class SysUserInfoServiceImpl extends ServiceImpl<SysUserInfoMapper, SysUserInfo> implements SysUserInfoService {

}
