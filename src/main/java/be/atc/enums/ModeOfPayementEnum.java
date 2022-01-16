package be.atc.enums;

public enum ModeOfPayementEnum {

    Domicile("CASH");

    private String text;

    private ModeOfPayementEnum( String text ) {
        this.text = text;
    }

    public String display() {
        return text;
    }
}
