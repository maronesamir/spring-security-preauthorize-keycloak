package com.wstutorial.preauthorizekeycloak.custom;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomMethodSecurityExpression extends SecurityExpressionRoot
        implements MethodSecurityExpressionOperations {

    public CustomMethodSecurityExpression(Authentication authentication) {
        super(authentication);
    }

    public boolean customPerm(String permissionName){
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) this.authentication;
        KeycloakPrincipal principal = (KeycloakPrincipal) token.getPrincipal();

        Map<String, Object> otherClaims = principal.getKeycloakSecurityContext().getToken().getOtherClaims();
        if(otherClaims != null){
            String customPermission = (String) otherClaims.get("customPermission");
            List<String> permissions = Stream.of(customPermission.split(";")).collect(Collectors.toList());
            return permissions.contains(permissionName);
        }

        return false;
    }

    @Override
    public void setFilterObject(Object o) {

    }

    @Override
    public Object getFilterObject() {
        return null;
    }

    @Override
    public void setReturnObject(Object o) {

    }

    @Override
    public Object getReturnObject() {
        return null;
    }

    @Override
    public Object getThis() {
        return null;
    }
}
