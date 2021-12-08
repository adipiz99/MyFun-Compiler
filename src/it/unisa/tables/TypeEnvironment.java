package it.unisa.tables;

import java.util.ArrayList;

public class TypeEnvironment {
    ArrayList<Table> typeEnvironment;
    int index;
    int currentIndex;

    public TypeEnvironment() {
        index = 0; //indice alla tabella corrente
        currentIndex = -1;
        this.typeEnvironment = new ArrayList<Table>();
    }

    public ArrayList<Table> getTypeEnvironment() {
        return typeEnvironment;
    }

    public void setTypeEnvironment(ArrayList<Table> typeEnvironment) {
        this.typeEnvironment = typeEnvironment;
    }

    // restituisce null se non trova l'elemento
    public Row lookup(String symbol) {
        return typeEnvironment.get(index).find(symbol);//prende la tabella corrente e fa ricerca
    }

    //Avviare un nuovo ambito
    public void enterScope() {
        Table newTable;
        if (typeEnvironment.size() > 0) //abbiamo tabelle già inserite
            newTable = new Table(typeEnvironment.get(index), index); //crea una nuova tabella usando il riferimento a quella del padre
        else // altrimenti crea da zero
            newTable = new Table();
        index = typeEnvironment.size();
        typeEnvironment.add(newTable);
    }

    public void enterScopeClang() {
        currentIndex++;
        index = currentIndex;
    }

    public void exitScope() {
        index = typeEnvironment.get(index).parentIndex;
    }

    public void addId(String id, Row row) {
        //se già presente
        if (probe(id)) {
            System.err.println("Multiple declaration for " + id);
            System.exit(1);
        }
        Table table = typeEnvironment.get(index);
        table.addRow(id, row);
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
}
