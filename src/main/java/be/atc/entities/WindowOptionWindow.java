package be.atc.entities;

import be.atc.entities.compoundID.WindowOptionWindowPK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass( WindowOptionWindowPK.class )
@Table( name = "windows_options_windows" )
public class WindowOptionWindow implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn( name = "windows", nullable = false )
    private Window window;

    public void setWindows( Window windows ) {
        this.window = windows;
    }

    @Id
    @ManyToOne
    @JoinColumn( name = "options_windows", nullable = false )
    private OptionsWindow optionsWindow;

    public void setOptionsWindow( OptionsWindow optionsWindows ) {
        this.optionsWindow = optionsWindows;
    }

    public Window getWindows() {
        return window;
    }

    public OptionsWindow getOptionsWindow() {
        return optionsWindow;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow( Window window ) {
        this.window = window;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        WindowOptionWindow that = (WindowOptionWindow) o;
        return Objects.equals( window, that.window ) && Objects.equals( optionsWindow,
                that.optionsWindow );
    }

    @Override public int hashCode() {
        return Objects.hash( window, optionsWindow );
    }
}
