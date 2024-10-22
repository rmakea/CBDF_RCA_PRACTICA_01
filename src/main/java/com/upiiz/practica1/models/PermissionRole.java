package com.upiiz.practica1.models;

public class PermissionRole {
    private Long id;
    private Long permissionId;
    private Long roleId;

    public PermissionRole() {
    }

    public PermissionRole(Long id, Long permissionId, Long roleId) {
        this.id = id;
        this.permissionId = permissionId;
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
