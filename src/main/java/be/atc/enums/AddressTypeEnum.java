package be.atc.enums;

public enum AddressTypeEnum {

    Domicile("Domicile"),
    Professional("Professional"),
    Facturation("Facturation"),
    Livraison("Livraison");

    private String text;

    private AddressTypeEnum(String text) {
        this.text = text;
    }

    public String display() {
        return text;
    }
}
