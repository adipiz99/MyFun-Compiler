package it.unisa.tables;

public class Row {
    String value;
    String type;
    String struct;

    public Row(String value, String type, String struct) {
        this.value = value;
        this.type = type;
        this.struct = struct;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStruct() {
        return struct;
    }

    public void setStruct(String costrutto) {
        this.struct = costrutto;
    }

    @Override
    public String toString() {
        return "Row{" +
                "value='" + value + '\'' +
                ", type='" + type + '\'' +
                ", struct='" + struct + '\'' +
                '}';
    }
}
