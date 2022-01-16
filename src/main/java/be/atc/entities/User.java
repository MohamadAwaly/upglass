package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table( name = "users" )
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_user", nullable = false )
    private int     idUSer;
    @Column( name = "login", nullable = false, length = 60 )
    private String  login;
    @Column( name = "last_name", nullable = false, length = 60 )
    private String  lastName;
    @Column( name = "first_name", nullable = false, length = 60 )
    private String  firstName;
    @Column( name = "birthday" )
    private Date    birthday;
    @Column( name = "inscription_date", nullable = false )
    private Date    inscriptionDate;
    @Column( name = "vat", length = 20 )
    private String  vat;
    @Column( name = "mail", length = 255 )
    private String  mail;
    @Column( name = "password", nullable = false, length = 255 )
    private String  password;
    @Column( name = "actif", nullable = false )
    private boolean actif;

    @ManyToOne
    @JoinColumn( name = "id_role", referencedColumnName = "id_role", nullable = false )
    private Role role;
    @ManyToOne
    @JoinColumn( name = "id_team", referencedColumnName = "id_team")
    private Team team;

    @OneToMany( mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    private Collection<AddressUser>   addressUsers;
    @OneToMany( mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
    private Collection<PaymentMethod> paymentMethods;
    @OneToMany( mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
    private Collection<Order>         order;
    @OneToMany( mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
    private Collection<BillingDocument> billingDocuments;

    public int getIdUSer() {
        return idUSer;
    }

    public void setIdUSer( int idUSer ) {
        this.idUSer = idUSer;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday( Date birthday ) {
        this.birthday = birthday;
    }

    public Date getInscriptionDate() {
        return inscriptionDate;
    }

    public void setInscriptionDate( Date inscriptionDate ) {
        this.inscriptionDate = inscriptionDate;
    }

    public String getVat() {
        return vat;
    }

    public void setVat( String vat ) {
        this.vat = vat;
    }

    public String getMail() {
        return mail;
    }

    public void setMail( String mail ) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif( boolean actif ) {
        this.actif = actif;
    }

    public Role getRole() {
        return role;
    }

    public void setRole( Role role ) {
        this.role = role;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam( Team team ) {
        this.team = team;
    }

    public Collection<AddressUser> getAddressUsers() {
        return addressUsers;
    }

    public void setAddressUsers( Collection<AddressUser> addressUsers ) {
        this.addressUsers = addressUsers;
    }

    public Collection<PaymentMethod> getPayedModes() {
        return paymentMethods;
    }

    public void setPayedModes( Collection<PaymentMethod> paymentMethods ) {
        this.paymentMethods = paymentMethods;
    }

    public Collection<Order> getOrder() {
        return order;
    }

    public void setOrder( Collection<Order> order ) {
        this.order = order;
    }

    public Collection<BillingDocument> getBillingDocuments() {
        return billingDocuments;
    }

    public void setBillingDocuments( Collection<BillingDocument> billingDocuments ) {
        this.billingDocuments = billingDocuments;
    }

    public Collection<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods( Collection<PaymentMethod> paymentMethods ) {
        this.paymentMethods = paymentMethods;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        User user = (User) o;
        return idUSer == user.idUSer && actif == user.actif && login.equals( user.login ) && lastName.equals(
                user.lastName ) && firstName.equals( user.firstName ) && Objects.equals( birthday, user.birthday )
                && inscriptionDate.equals( user.inscriptionDate ) && Objects.equals( vat, user.vat )
                && Objects.equals( mail, user.mail ) && password.equals( user.password )
                && Objects.equals( role, user.role ) && Objects.equals( team, user.team )
                && Objects.equals( addressUsers, user.addressUsers ) && Objects.equals( paymentMethods,
                user.paymentMethods ) && Objects.equals( order, user.order ) && Objects.equals(
                billingDocuments, user.billingDocuments );
    }

    @Override public int hashCode() {
        return Objects.hash( idUSer, login, lastName, firstName, birthday, inscriptionDate, vat, mail, password, actif,
                role, team, addressUsers, paymentMethods, order, billingDocuments );
    }


}
