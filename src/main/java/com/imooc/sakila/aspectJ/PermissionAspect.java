package com.imooc.sakila.aspectJ;

import com.imooc.sakila.annotation.HasPermission;
import com.imooc.sakila.enums.LogCode;
import com.imooc.sakila.constants.Permission;
import com.imooc.sakila.utils.NoPermissionException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class PermissionAspect {

    @Pointcut("@annotation(hasPermission)")
    public void permissionCheck(HasPermission hasPermission) {}

    @Around("permissionCheck(hasPermission)")
    public Object doBefore(ProceedingJoinPoint pjp, HasPermission hasPermission) throws Throwable {
        try {
            String[] methodPermissions = hasPermission.value();
            if (includePermission(methodPermissions)) {
                return pjp.proceed();
            } else {
                throw new NoPermissionException(LogCode.NO_PERMISSION);
            }
        } catch (Exception ex) {
            throw new NoPermissionException(LogCode.NO_PERMISSION);
        }
    }

    // todo 获取当前登录用户具有的权限列表
    private boolean includePermission(String[] permissions) {
        List<String> userPermissions = new ArrayList<>();
        userPermissions.add(Permission.product_list);
        userPermissions.add(Permission.product_add);
        userPermissions.add(Permission.product_delete);
        for (String permission : permissions) {
            if (userPermissions.contains(permission)) {
                return true;
            }
        }
        return false;
    }
}
