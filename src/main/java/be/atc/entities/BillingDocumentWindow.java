package be.atc.entities;

import be.atc.enums.OperationTypeEnum;
import be.atc.entities.compoundID.BillingDocumentWindowPK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass( BillingDocumentWindowPK.class )
@Table( name = "billing_document_window" )
public class BillingDocumentWindow implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn( name = "windows", nullable = false )
    private Window window;

    public void setWindow( Window window ) {
        this.window = window;
    }

    @Id
    @ManyToOne
    @JoinColumn( name = "billing_documents", nullable = false )
    private BillingDocument billingDocument;

    public void setBillingDocument( BillingDocument billingDocument ) {
        this.billingDocument = billingDocument;
    }

    @Column( name = "unite_price", nullable = false )
    private int unitePrice;

    @Column( name = "qty", nullable = false )
    private int qty;

    @Column( name = "operation_type", nullable = false, length = 255 )
    @Enumerated( EnumType.STRING )
    private OperationTypeEnum operationTypeEnum;

    public Window getWindow() {
        return window;
    }

    public BillingDocument getBillingDocument() {
        return billingDocument;
    }

    public int getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice( int unitePrice ) {
        this.unitePrice = unitePrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty( int qty ) {
        this.qty = qty;
    }

    public OperationTypeEnum getOperationTypeEnum() {
        return operationTypeEnum;
    }

    public void setOperationTypeEnum( OperationTypeEnum operationTypeEnum ) {
        this.operationTypeEnum = operationTypeEnum;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        BillingDocumentWindow that = (BillingDocumentWindow) o;
        return unitePrice == that.unitePrice && qty == that.qty && Objects.equals( window, that.window )
                && Objects.equals( billingDocument, that.billingDocument )
                && operationTypeEnum == that.operationTypeEnum;
    }

    @Override public int hashCode() {
        return Objects.hash( window, billingDocument, unitePrice, qty, operationTypeEnum );
    }
}
