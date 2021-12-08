package it.unisa.oldTables;

import java.util.ArrayList;

public class ParsingTable {
    private ParsingTable parent;
    private ArrayList<Row> rows;
    private ArrayList<ParsingTable> children;


    public ParsingTable(){
        parent = null;
        rows = new ArrayList<Row>();
        children = new ArrayList<ParsingTable>();
    }

    public ParsingTable(ParsingTable parent){
        this.parent = parent;
        rows = new ArrayList<Row>();
        children = new ArrayList<ParsingTable>();
    }

    public ParsingTable getParent() {
        return parent;
    }

    public void setParent(ParsingTable parent) {
        this.parent = parent;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public ArrayList<ParsingTable> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<ParsingTable> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ParsingTable{" +
                "parent=" + parent +
                ", rows=" + rows.toString() +
                ", children=" + children +
                '}';
    }

    public Row lookup(String id) {
        //Controllo se l'identificatore è nella Parsing Table corrente
        for (Row row : rows) {
            if (row.getId().equals(id)) return row;
        }

        //L'identificatore non è nella parsing table corrente, effettuo il lookup al parent, se esiste.
        if(this.parent != null){
            return this.parent.lookup(id);
        }

        //L'identificatore non è presente nell'albero delle parsing table
        throw new LookupException("Lookup failed for identifier " +  id);
    }

    public ParsingTable generate(){
        ParsingTable pt = new ParsingTable(this);
        this.children.add(pt);
        return pt;
    }
}
