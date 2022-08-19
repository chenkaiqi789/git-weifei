package com.gec;

import com.gec.hazardous.entity.SysUser;
import com.gec.hazardous.service.ISysUserService;
import org.apache.catalina.User;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class shrioTest {

    @Autowired
    private ISysUserService sysUserService;


    @Test
    public void Test1() {
        List<SysUser> list = sysUserService.list();
        list.forEach(sysUser -> {
            String password = "123456";
            Md5Hash md5 = new Md5Hash(password, sysUser.getUsername(), 3);
            System.out.println(md5);
            sysUser.setPassword(md5.toString());
            sysUserService.saveOrUpdate(sysUser);
        });
    }

    @Autowired //安全管理器
    private DefaultWebSecurityManager securityManager;

    @Test  //shrio配置正确 测试通过
    public void Test2() {


        SecurityUtils.setSecurityManager(securityManager);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken("admin", "123456"));
        System.out.println("是否是合法用户:" + subject.isAuthenticated());
        System.out.println("是否有权限:" + subject.isPermitted("user:select"));
        subject.logout();
        System.out.println("是否是合法用户:" + subject.isAuthenticated());
    }
}
