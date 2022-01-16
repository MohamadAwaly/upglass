package be.atc.enums;

public enum OperationTypeEnum {
    Livraison("Livraison"),
    Montage("Montage"),
    Reparation("Reparation");

    private String text;

    private OperationTypeEnum( String text ) {
        this.text = text;
    }

    public String display() {
        return text;
    }
}
