package com.developerstack.security.config.permision;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.developerstack.security.config.permision.ApplicationUserPermission.*;

public enum ApplicationUserRole {
USER(Sets.newHashSet(ORDER_WRITE,PRODUCT_READ,CUSTOMER_WRITE,CUSTOMER_READ))
    ,ADMIN(Sets.newHashSet(ORDER_WRITE,ORDER_WRITE,PRODUCT_READ,PRODUCT_WRITE,CUSTOMER_WRITE,CUSTOMER_READ))
    ,MANAGER(Sets.newHashSet(ORDER_WRITE,PRODUCT_WRITE,CUSTOMER_READ));

    private final Set<ApplicationUserPermission> permission;

    ApplicationUserRole(Set<ApplicationUserPermission> permission) {
        this.permission = permission;
    }

    public Set<ApplicationUserPermission> getPermission(){
        return permission;
    }

    public Set<SimpleGrantedAuthority> getSimpleGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermission().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));

        return permissions;

    }
}
