package com.breze.service.portal;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.breze.entity.pojo.portal.Navbar;

/**
 * <p>
 * 导航连接表 服务类
 * </p>
 *
 * @author leochan
 * @since 2022-10-08
 */
public interface NavbarService extends IService<Navbar> {

    Page<Navbar> findNavbarPage(Page<Navbar> page, String titleName,Long parentId);
}
