package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table( name = "documents_type" )

public class DocumentsType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_documentsType", nullable = false )
    private int idDocumentsType;

    @Column( name = "document_type", nullable = false, length = 255 )
    private String documentType;

    @OneToMany( mappedBy = "documentsType",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
    private Collection<BillingDocument> billingDocuments;

    //    @OneToMany( mappedBy = "documents_type" )
    //    private Collection<Billing> addressUsers;

    //Constructor
    public DocumentsType() {

    }

    public int getIdDocumentsType() {
        return idDocumentsType;
    }

    public void setIdDocumentsType( int idDocumentsType ) {
        this.idDocumentsType = idDocumentsType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType( String documentType ) {
        this.documentType = documentType;
    }

    public Collection<BillingDocument> getBillingDocuments() {
        return billingDocuments;
    }

    public void setBillingDocuments( Collection<BillingDocument> billingDocuments ) {
        this.billingDocuments = billingDocuments;
    }


    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        DocumentsType that = (DocumentsType) o;
        return idDocumentsType == that.idDocumentsType && documentType.equals( that.documentType )
                && Objects.equals( billingDocuments, that.billingDocuments );
    }

    @Override public int hashCode() {
        return Objects.hash( idDocumentsType, documentType, billingDocuments );
    }

}