package it.unisa.tables;

import java.util.ArrayList;

public class TypeEnvironment {
    ArrayList<Table> typeEnvironment;
    int index;
    int currentIndex;

    public TypeEnvironment() {
        index = 0;
        currentIndex = -1;
        this.typeEnvironment = new ArrayList<Table>();
    }

    public boolean probe(String id) {
        return typeEnvironment.get(index).getElements().containsKey(id);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<Table> getTypeEnvironment() {
        return typeEnvironment;
    }

    public void setTypeEnvironment(ArrayList<Table> typeEnvironment) {
        this.typeEnvironment = typeEnvironment;
    }

    public Row lookup(String symbol) {
        return typeEnvironment.get(index).find(symbol);
    }

    public void scopeIn() {
        Table newTable;
        if (typeEnvironment.size() > 0)
            newTable = new Table(typeEnvironment.get(index), index);
        else
            newTable = new Table();
        index = typeEnvironment.size();
        typeEnvironment.add(newTable);
    }

    public void scopeInClang() {
        currentIndex++;
        index = currentIndex;
    }

    public void scopeOut() {
        index = typeEnvironment.get(index).parentIndex;
    }

    public void addId(String id, Row row) {
        if (probe(id)) {
            System.err.println("Multiple declaration for " + id);
            System.exit(1);
        }
        Table table = typeEnvironment.get(index);
        table.addRow(id, row);
    }
}
