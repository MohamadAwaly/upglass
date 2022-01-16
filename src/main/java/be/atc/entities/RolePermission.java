package be.atc.entities;

import be.atc.entities.compoundID.RolePermissionPK;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass( RolePermissionPK.class )
@Table( name = "role_permissions" )
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn( name = "role", nullable = false )
    private Role role;

    public void setRole( Role role ) {
        this.role = role;
    }

    @Id
    @ManyToOne
    @JoinColumn( name = "permission", nullable = false )
    private Permission permission;

    public void setPermission( Permission permission ) {
        this.permission = permission;
    }

    public Role getRole() {
        return role;
    }

    public Permission getPermission() {
        return permission;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        RolePermission that = (RolePermission) o;
        return Objects.equals( role, that.role ) && Objects.equals( permission, that.permission );
    }

    @Override public int hashCode() {
        return Objects.hash( role, permission );
    }
}
