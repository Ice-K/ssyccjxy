package com.ssyccjxy.web.controller.system;

import com.ssyccjxy.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description：系统用户Controller
 * Cteated by wangpeng
 * 2018/4/3 9:43
 */
@Controller
@RequestMapping("/system")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

}
