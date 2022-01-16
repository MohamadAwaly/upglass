package be.atc.entities.compoundID;

import java.io.Serializable;
import java.util.Objects;

public class WindowOptionWindowPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private int window;
    private int optionsWindow;

    public WindowOptionWindowPK() {
    }

    public WindowOptionWindowPK( int window, int optionsWindow ) {
        this.window = window;
        this.optionsWindow = optionsWindow;
    }

    public int getWindow() {
        return window;
    }

    public void setWindow( int window ) {
        this.window = window;
    }

    public int getOptionsWindow() {
        return optionsWindow;
    }

    public void setOptionsWindow( int optionsWindow ) {
        this.optionsWindow = optionsWindow;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        WindowOptionWindowPK that = (WindowOptionWindowPK) o;
        return window == that.window && optionsWindow == that.optionsWindow;
    }

    @Override public int hashCode() {
        return Objects.hash( window, optionsWindow );
    }
}
