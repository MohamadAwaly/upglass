package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@NamedQueries( value = {
        @NamedQuery( name = "WindowsType.getWindowsTypeList",
                query = "select wt from WindowsType wt" ),
        @NamedQuery( name = "WindowsType.checkWindowsTypeExist",
        query = "select wt.name from WindowsType wt where wt.name= :nameWt")
} )

@Entity
@Table( name = "windows_types" )
public class WindowsType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_windowsType", nullable = false )
    private int    idWindowsType;
    @Column( name = "name", nullable = false, length = 255 )
    private String name;

    @OneToMany( mappedBy = "windowsType", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
    private Collection<Window> windows;

    //Constructor
    public WindowsType() {

    }

    public int getIdWindowsType() {
        return idWindowsType;
    }

    public void setIdWindowsType( int idWindowsType ) {
        this.idWindowsType = idWindowsType;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Collection<Window> getWindows() {
        return windows;
    }

    public void setWindows( Collection<Window> windows ) {
        this.windows = windows;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        WindowsType that = (WindowsType) o;
        return idWindowsType == that.idWindowsType && Objects.equals( name, that.name )
                && Objects.equals( windows, that.windows );
    }

    @Override public int hashCode() {
        return Objects.hash( idWindowsType, name, windows );
    }
}