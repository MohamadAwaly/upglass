package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@NamedQueries( value = {
        @NamedQuery( name = "BodyShelType.getList", query = "select bst.name from BodyShellType bst ORDER BY bst.idbodyShelTypes" ),
        @NamedQuery( name = "BodyShelType.CheckExist", query = "select bst.name from BodyShellType  bst where bst.name = :name" )
} )

@Entity
@Table( name = "body_shel_types" )

public class BodyShellType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_body_shel_type", nullable = false )
    private int    idbodyShelTypes;
    @Column( name = "name", nullable = false, length = 60 )
    private String name;

    @OneToMany( mappedBy = "bodyShellType", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
    private Collection<Model> models;

    //Constructor
    public BodyShellType() {

    }

    public int getIdbodyShelTypes() {
        return idbodyShelTypes;
    }

    public void setIdbodyShelTypes( int idbodyShelTypes ) {
        this.idbodyShelTypes = idbodyShelTypes;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Collection<Model> getModels() {
        return models;
    }

    public void setModels( Collection<Model> models ) {
        this.models = models;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        BodyShellType that = (BodyShellType) o;
        return idbodyShelTypes == that.idbodyShelTypes && name.equals( that.name ) && Objects.equals( models,
                that.models );
    }

    @Override public int hashCode() {
        return Objects.hash( idbodyShelTypes, name, models );
    }
}