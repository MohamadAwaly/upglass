package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "permissions" )
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_permission", nullable = false )
    private int idPermission;

    @Column( name = "permission_name", nullable = false, length = 50 )
    private String permissionName;

    public int getIdPermission() {
        return idPermission;
    }

    public void setIdPermission( int idPermission ) {
        this.idPermission = idPermission;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName( String permissionName ) {
        this.permissionName = permissionName;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Permission that = (Permission) o;
        return idPermission == that.idPermission && permissionName.equals( that.permissionName );
    }

    @Override public int hashCode() {
        return Objects.hash( idPermission, permissionName );
    }
}
