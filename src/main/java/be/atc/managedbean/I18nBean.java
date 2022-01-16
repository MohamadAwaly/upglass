package be.atc.managedbean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Named
@SessionScoped
public class I18nBean implements Serializable {

    private static final long serialVersionUID = 1L;


    private Locale   locale   = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
    private String   language;
    private TimeZone timeZone = TimeZone.getTimeZone( "Europe/Brussels" );

    public String selectLanguage() {
        // Update language
        int index = this.language.indexOf( "_" );
        if ( index > 0 ) {
            String selectLanguage = this.language.substring( 0, index );
            String country = this.language.substring( index + 1 );
            locale = new Locale( selectLanguage, country );
        } else {
            locale = new Locale( this.language );
        }

        // Loading language to the view
//        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
//        viewRoot.setLocale( locale );
//        FacesContext.getCurrentInstance().getApplication().setDefaultLocale( locale );
//
//        // Navigation - back to the outcome
//        FacesContext context = FacesContext.getCurrentInstance();
//        String viewId = context.getViewRoot().getViewId();
//        ViewHandler handler = context.getApplication().getViewHandler();
//        UIViewRoot root = handler.createView( context, viewId );
//        root.setViewId( viewId );
//        context.setViewRoot( root );

        return "";
    }

    // Getters and Setters

    public String getLanguage() {
        return language;
    }

    public void setLanguage( String language ) {
        this.language = language;
    }

    public Locale getLocale() {

        return locale;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone( TimeZone timeZone ) {
        this.timeZone = timeZone;
    }

    public Date getDate() {
        return new Date();
    }

}
