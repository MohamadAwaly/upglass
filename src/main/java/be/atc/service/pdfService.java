package be.atc.service;

import be.atc.connection.EMF;
import be.atc.entities.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public class pdfService {
    private static Logger logger = Logger.getLogger(pdfService.class);
    private EntityManager em = EMF.getEM();
    private EntityTransaction transaction = em.getTransaction();

    public static Document getBillingPdf(User pUser, Car pCar) throws FileNotFoundException,
            DocumentException {
        Document document = new Document();
        FileOutputStream file = new FileOutputStream("c:\'UpGlassDocuments\'");
        PdfWriter.getInstance(document,file);

        document.open();
        /**
        EN-TETE DOCUMENT
         */
        Paragraph titleParagraph = new Paragraph("Facture");
        String createdDate = new SimpleDateFormat("dd-MM-YYYY").format(new Date()).toString();
        Paragraph createdDateParagraph = new Paragraph(createdDate);

        /**
         * INFO UTILISATEUR / CLIENT
         */
//        Collection<AddressUser> userAdress = pUser.getAddressUsers();
//        for (AddressUser ua : userAdress ) {
//            ua.getAddressType();
//        }

        Paragraph userNameParagraph = new Paragraph(pUser.getLastName() +"  "+pUser.getFirstName());
        Paragraph adressUserParagraph = new Paragraph("pUser.getAddressUsers()");
        Paragraph userVatParagraph = new Paragraph(pUser.getVat());






        return document;
    }

}
