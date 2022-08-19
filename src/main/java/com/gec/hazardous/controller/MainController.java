package com.gec.hazardous.controller;

import com.gec.hazardous.entity.SysUser;
import com.gec.hazardous.service.ISysUserService;
import com.gec.hazardous.utils.ResponseStatus;
import com.gec.hazardous.utils.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @PostMapping("/doLogin")
    @ResponseBody
    public ResultBean doLogin(@RequestBody Map<String, Object> params, HttpSession session) {
        String username = (String) params.get("username");
        String password = (String) params.get("password");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        if (subject.isAuthenticated()) {
            //成功
            SysUser sysUser = (SysUser) subject.getPreviousPrincipals();
            session.setAttribute("loginUser", sysUser);
            Map<String, Object> map = new HashMap<>();
            map.put("loginUser", sysUser);
            return ResultBean.ok(map);
        }
        return ResultBean.fail(ResponseStatus.USERNAME_PASS_ERROR);
    }

    @GetMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.html";
    }


}
