package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "roles" )
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_role", nullable = false )
    private int idRole;

    @Column( name = "role_name", nullable = false, length = 50 )
    private String roleName;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole( int idRole ) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName( String roleName ) {
        this.roleName = roleName;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Role role = (Role) o;
        return idRole == role.idRole && roleName.equals( role.roleName );
    }

    @Override public int hashCode() {
        return Objects.hash( idRole, roleName );
    }
}
