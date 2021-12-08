package it.unisa.oldTables;

import java.util.ArrayList;

public class Row {
    private String id;
    private String type;
    private ArrayList<String> args;
    private ParsingTable table;


    public Row(String id, String type){
        this.id = id;
        this.type = type;
        this.args = new ArrayList<String>();
        this.table = null;
    }

    public Row(String id, String type, ParsingTable table){
        this.id = id;
        this.type = type;
        this.args = new ArrayList<String>();
        this.table = table;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public ParsingTable getTable() {
        return table;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public void setArgs(ArrayList<String> args) {
        this.args = args;
    }

    public void setTable(ParsingTable table){
        this.table = table;
    }

    @Override
    public String toString() {
        return "Row{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", args=" + args +
                ", table=" + table +
                '}';
    }
}
