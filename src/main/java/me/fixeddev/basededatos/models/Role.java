package me.fixeddev.basededatos.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rolesId")
    private Long rolesId;

    @Column(nullable = false, unique = true, name = "roleName")
    private String roleName;

    public Role(Long rolesId, String roleName) {
        this.rolesId = rolesId;
        this.roleName = roleName;
    }

    public Role() {
    }

    public Long getRolesId() {
        return rolesId;
    }

    public void setRolesId(Long rolesId) {
        this.rolesId = rolesId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(rolesId, role.rolesId) && Objects.equals(roleName, role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolesId, roleName);
    }

    @Override
    public String toString() {
        return "Role{" +
                "rolesId=" + rolesId +
                ", roleName='" + roleName + '\'' +
                '}';
    }

}