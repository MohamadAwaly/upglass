package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@NamedQueries( value = {
        @NamedQuery( name = "Option.getOptionsList", query = "select o from OptionsWindow o ORDER BY o.idOptionsWindow DESC " ),
        @NamedQuery( name = "Option.CheckOptionExist", query = "select o.name from OptionsWindow o where o.name = :nameOption" )
} )

@Entity
@Table( name = "options_windows" )

public class OptionsWindow implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_optionsWindow", nullable = false )
    private int    idOptionsWindow;
    @Column( name = "name", nullable = false, length = 255 )
    private String name;

    @OneToMany( mappedBy = "optionsWindow", cascade = { CascadeType.PERSIST,
            CascadeType.MERGE }, fetch = FetchType.LAZY )
    private Collection<WindowOptionWindow> windowOptionWindows;

    //Constructor
    public OptionsWindow() {

    }

    public int getIdOptionsWindow() {
        return idOptionsWindow;
    }

    public void setIdOptionsWindow( int idOptionsWindow ) {
        this.idOptionsWindow = idOptionsWindow;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Collection<WindowOptionWindow> getCarOptionWindows() {
        return windowOptionWindows;
    }

    public void setCarOptionWindows( Collection<WindowOptionWindow> windowOptionWindows ) {
        this.windowOptionWindows = windowOptionWindows;
    }

    public Collection<WindowOptionWindow> getWindowOptionWindows() {
        return windowOptionWindows;
    }

    public void setWindowOptionWindows( Collection<WindowOptionWindow> windowOptionWindows ) {
        this.windowOptionWindows = windowOptionWindows;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        OptionsWindow that = (OptionsWindow) o;
        return idOptionsWindow == that.idOptionsWindow && Objects.equals( name, that.name )
                && Objects.equals( windowOptionWindows, that.windowOptionWindows );
    }

    @Override public int hashCode() {
        return Objects.hash( idOptionsWindow, name, windowOptionWindows );
    }
}