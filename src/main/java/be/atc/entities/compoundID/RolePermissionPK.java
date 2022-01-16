package be.atc.entities.compoundID;

import java.io.Serializable;
import java.util.Objects;

public class RolePermissionPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private int role;
    private int permission;

    public RolePermissionPK() {
    }

    public RolePermissionPK( int role, int permission ) {
        this.role = role;
        this.permission = permission;
    }

    public int getRole() {
        return role;
    }

    public void setRole( int role ) {
        this.role = role;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission( int permission ) {
        this.permission = permission;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        RolePermissionPK that = (RolePermissionPK) o;
        return Objects.equals( role, that.role ) && Objects.equals( permission, that.permission );
    }

    @Override public int hashCode() {
        return Objects.hash( role, permission );
    }
}
