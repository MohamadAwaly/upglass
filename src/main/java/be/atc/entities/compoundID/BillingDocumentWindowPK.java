package be.atc.entities.compoundID;

import java.io.Serializable;
import java.util.Objects;

public class BillingDocumentWindowPK implements Serializable {
    private int window;
    private int billingDocument;

    public BillingDocumentWindowPK() {
    }

    public BillingDocumentWindowPK( int window, int billingDocument ) {
        this.window = window;
        this.billingDocument = billingDocument;
    }

    public int getWindow() {
        return window;
    }

    public void setWindow( int window ) {
        this.window = window;
    }

    public int getBillingDocument() {
        return billingDocument;
    }

    public void setBillingDocument( int billingDocument ) {
        this.billingDocument = billingDocument;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        BillingDocumentWindowPK that = (BillingDocumentWindowPK) o;
        return window == that.window && billingDocument == that.billingDocument;
    }

    @Override public int hashCode() {
        return Objects.hash( window, billingDocument );
    }
}
