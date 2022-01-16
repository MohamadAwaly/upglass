package be.atc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@NamedQueries( value = {
        @NamedQuery( name = "Window.ReferencesList", query = "select w from Window w ORDER BY w.idWindow DESC " ),
        @NamedQuery( name = "Windows.ReferenceExist", query = "select w from Window w where w.code = :code" ),

        @NamedQuery( name = "Windows.StockList", query = "select w from Window w where w.totalQty > 0 ORDER BY w.code" )
} )

@Entity
@Table( name = "windows" )

public class Window implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_window", nullable = false )
    private int    idWindow;
    @Column( name = "code", nullable = false, length = 255 )
    private String code;
    @Column( name = "name", nullable = false, length = 255 )
    private String name;
    @Column( name = "total_quantity", nullable = false )
    private int    totalQty;
    @Column( name = "unit_sale_price", nullable = false )
    private int    unitSalePrice;

    @ManyToOne
    @JoinColumn( name = "id_model", referencedColumnName = "id_model", nullable = false )
    private Model       model;
    @ManyToOne
    @JoinColumn( name = "id_windowsType", referencedColumnName = "id_windowsType", nullable = false )
    private WindowsType windowsType;

    @OneToMany( mappedBy = "window", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
    private Collection<WindowOptionWindow>    windowOptionWindows;
    @OneToMany( mappedBy = "window", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
    private Collection<WindowOrder>           windowOrders;
    @OneToMany( mappedBy = "window", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
    private Collection<BillingDocumentWindow> billingDocumentWindows;

    //Constructor
    public Window() {
    }

    public int getIdWindow() {
        return idWindow;
    }

    public void setIdWindow( int idWindow ) {
        this.idWindow = idWindow;
    }

    public String getCode() {
        return code;
    }

    public void setCode( String code ) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int getUnitSalePrice() {
        return unitSalePrice;
    }

    public void setUnitSalePrice( int unitSalePrice ) {
        this.unitSalePrice = unitSalePrice;
    }

    public Model getModel() {
        return model;
    }

    public void setModel( Model model ) {
        this.model = model;
    }

    public WindowsType getWindowsType() {
        return windowsType;
    }

    public void setWindowsType( WindowsType windowsType ) {
        this.windowsType = windowsType;
    }

    public Collection<WindowOptionWindow> getCarOptionWindows() {
        return windowOptionWindows;
    }

    public void setCarOptionWindows( Collection<WindowOptionWindow> windowOptionWindows ) {
        this.windowOptionWindows = windowOptionWindows;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty( int totalQty ) {
        this.totalQty = totalQty;
    }

    public Collection<WindowOptionWindow> getWindowOptionWindows() {
        return windowOptionWindows;
    }

    public void setWindowOptionWindows( Collection<WindowOptionWindow> windowOptionWindows ) {
        this.windowOptionWindows = windowOptionWindows;
    }

    public Collection<WindowOrder> getWindowOrders() {
        return windowOrders;
    }

    public void setWindowOrders( Collection<WindowOrder> windowOrders ) {
        this.windowOrders = windowOrders;
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
        Window window = (Window) o;
        return idWindow == window.idWindow && totalQty == window.totalQty && unitSalePrice == window.unitSalePrice
                && code.equals( window.code ) && name.equals( window.name ) && Objects.equals( model,
                window.model ) && Objects.equals( windowsType, window.windowsType ) && Objects.equals(
                windowOptionWindows, window.windowOptionWindows ) && Objects.equals( windowOrders,
                window.windowOrders ) && Objects.equals( billingDocumentWindows, window.billingDocumentWindows );
    }

    @Override public int hashCode() {
        return Objects.hash( idWindow, code, name, totalQty, unitSalePrice, model, windowsType, windowOptionWindows,
                windowOrders, billingDocumentWindows );
    }

}