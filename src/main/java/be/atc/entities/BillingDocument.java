package be.atc.entities;

import be.atc.enums.ModeOfPayementEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table( name = "billing_documents" )

public class BillingDocument implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_billingDocuments", nullable = false )
    private int                idBillingDocuments;
    @Column( name = "document_number", nullable = false )
    private int                documenNumber;
    @Temporal( TemporalType.DATE )
    @Column( name = "document_date", nullable = false )
    private Date               documentDate;
    @Temporal( TemporalType.DATE )
    @Column( name = "payement_date" )
    private Date               payementDate;
    @Enumerated( EnumType.STRING )
    @Column( name = "mode_of_payement" )
    private ModeOfPayementEnum modeOfPayement;
    @Column( name = "payed", nullable = false )
    private boolean            payed;

    // relation
    @ManyToOne
    @JoinColumn( name = "id_user", referencedColumnName = "id_user", nullable = false )
    private User          user;
    @ManyToOne
    @JoinColumn( name = "id_documentsType", referencedColumnName = "id_documentsType", nullable = false )
    private DocumentsType documentsType;
    @ManyToOne
    @JoinColumn( name = "id_order", referencedColumnName = "id_order", nullable = false )
    private Order         order;
    @ManyToOne
    @JoinColumn( name = "id_cars", referencedColumnName = "id_cars", nullable = false )
    private Car           car;

    @OneToMany( mappedBy = "billingDocument", cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY )
    private Collection<BillingDocumentWindow> billingDocumentWindows;

    //Constructor
    public BillingDocument() {

    }

    //getters and setters

    public int getIdBillingDocuments() {
        return idBillingDocuments;
    }

    public void setIdBillingDocuments( int idBillingDocuments ) {
        this.idBillingDocuments = idBillingDocuments;
    }

    public int getDocumenNumber() {
        return documenNumber;
    }

    public void setDocumenNumber( int documenNumber ) {
        this.documenNumber = documenNumber;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate( Date documentDate ) {
        this.documentDate = documentDate;
    }

    public Date getPayementDate() {
        return payementDate;
    }

    public void setPayementDate( Date payementDate ) {
        this.payementDate = payementDate;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed( boolean payed ) {
        this.payed = payed;
    }

    public User getUser() {
        return user;
    }

    public void setUser( User user ) {
        this.user = user;
    }

    public DocumentsType getDocumentsType() {
        return documentsType;
    }

    public void setDocumentsType( DocumentsType documentsType ) {
        this.documentsType = documentsType;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder( Order order ) {
        this.order = order;
    }

    public Car getCar() {
        return car;
    }

    public void setCar( Car car ) {
        this.car = car;
    }

    public ModeOfPayementEnum getModeOfPayement() {
        return modeOfPayement;
    }

    public void setModeOfPayement( ModeOfPayementEnum modeOfPayement ) {
        this.modeOfPayement = modeOfPayement;
    }

    public Collection<BillingDocumentWindow> getBillingDocumentWindows() {
        return billingDocumentWindows;
    }

    public void setBillingDocumentWindows( Collection<BillingDocumentWindow> billingDocumentWindows ) {
        this.billingDocumentWindows = billingDocumentWindows;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        BillingDocument that = (BillingDocument) o;
        return idBillingDocuments == that.idBillingDocuments && documenNumber == that.documenNumber
                && payed == that.payed
                && documentDate.equals( that.documentDate ) && Objects.equals( payementDate, that.payementDate )
                && modeOfPayement == that.modeOfPayement && Objects.equals( user, that.user )
                && Objects.equals( documentsType, that.documentsType ) && Objects.equals( order,
                that.order ) && Objects.equals( car, that.car ) && Objects.equals(
                billingDocumentWindows, that.billingDocumentWindows );
    }

    @Override public int hashCode() {
        return Objects.hash( idBillingDocuments, documenNumber, documentDate, payementDate, modeOfPayement, payed, user,
                documentsType, order, car, billingDocumentWindows );
    }

}