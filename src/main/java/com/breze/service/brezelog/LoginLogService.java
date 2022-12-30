package com.breze.service.brezelog;

import com.baomidou.mybatisplus.extension.service.IService;
import com.breze.entity.pojo.brezelog.HandleLog;
import com.breze.entity.pojo.brezelog.LoginLog;
import com.breze.entity.vo.LoginLogVO;

import java.util.List;

/**
 * <p>
 *  登录日志服务类
 * </p>
 *
 * @author tylt6688
 * @since 2022-06-23
 */
public interface LoginLogService extends IService<LoginLog> {

    List<LoginLogVO> getUserLoginCount();

    List<LoginLogVO> getUserLoginCategory(String currentDate);
}
