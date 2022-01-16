package be.atc.entities.compoundID;

import java.io.Serializable;
import java.util.Objects;

public class WindowOrderPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private int window;
    private int order;

    public WindowOrderPK() {
    }

    public WindowOrderPK( int window, int order ) {
        this.window = window;
        this.order = order;
    }

    public int getWindow() {
        return window;
    }

    public void setWindow( int window ) {
        this.window = window;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder( int order ) {
        this.order = order;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        WindowOrderPK that = (WindowOrderPK) o;
        return window == that.window && order == that.order;
    }

    @Override public int hashCode() {
        return Objects.hash( window, order );
    }
}
