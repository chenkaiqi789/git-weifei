package com.gec.hazardous.shrio;

import com.gec.hazardous.entity.SysUser;
import com.gec.hazardous.service.ISysResourceService;
import com.gec.hazardous.service.ISysRoleService;
import com.gec.hazardous.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService sysRoleServices;
    @Autowired
    private ISysResourceService sysResourceService;

    /**
     * 用户认证
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        log.info(username + " 当前..................");
        SysUser user = userService.findUserByUsername(username);
        if (user == null) {
            return null;
        }
        //用户名作为盐
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getUsername()),
                "MyRealm"
        );
        return info;
    }

    /**
     * 权限列表
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SysUser user = (SysUser) principal.getPrimaryPrincipal();
        //角色
        List<String> roles = new ArrayList<>();
        //遍历角色列表
        sysRoleServices.selectByUid(user.getId()).forEach(sysRole -> {
            if (!roles.contains(sysRole.getName())) {
                roles.add(sysRole.getName());
            }
        });
        System.out.println("{角色列表}" + roles);
        //权限列表
        List<String> resourceList = new ArrayList<>();
        //遍历权限列表
        sysResourceService.selectByUid(user.getId()).forEach(sysResource -> {
            if (!resourceList.contains(sysResource.getPermissionStr())) {
                resourceList.add(sysResource.getPermissionStr());
            }
        });
        System.out.println("{权限列表}" + resourceList);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(resourceList);
        return info;
    }
}
