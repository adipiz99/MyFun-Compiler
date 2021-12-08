package it.unisa.tables;

import java.util.HashMap;

public class Table {
    HashMap<String, Row> elements;
    Table parent;
    int parentIndex;

    public Table() {
        this.elements = new HashMap<>();
    }

    public Table(Table parent, int parentIndex) {
        this.elements = new HashMap<>();
        this.parent = parent;
        this.parentIndex = parentIndex;
    }

    public HashMap<String, Row> getElements() {
        return elements;
    }

    public void setElements(HashMap<String, Row> elements) {
        this.elements = elements;
    }

    public Table getParent() {
        return parent;
    }

    public void setParent(Table parent) {
        this.parent = parent;
    }

    public int getParentIndex() {
        return parentIndex;
    }

    public void setParentIndex(int parentIndex) {
        this.parentIndex = parentIndex;
    }

    @Override
    public String toString() {
        return "Table{" +
                "elements=" + elements +
                ", parent=" + parent +
                ", parentIndex=" + parentIndex +
                '}';
    }

    public void addRow(String key, Row row) {
        elements.put(key, row);
    }

    public Row find(String sym) {
        if (elements.containsKey(sym))
            return elements.get(sym);
        else if (parent != null)
            return parent.find(sym);
        else
            return null;
    }
}
