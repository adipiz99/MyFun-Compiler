package it.unisa.tables;

import java.util.ArrayList;

public class StackTypeEnvironment implements TableStack<Table>{
    private TableStack<Table> stack;

    public StackTypeEnvironment(){
        this.stack = (TableStack<Table>) new ArrayList<Table>();
        this.push(new Table());
    }

    public String addId(String key, Row row)  {
        if (isEmpty()) {
            System.err.println("Stack is empty!");
            System.exit(1);
        }
        if(probe(key)){
            System.err.println("Multiple declaration for " + key);
            System.exit(1);
        }
        Table table= stack.top();
        table.addRow(key,row);

        return key;
    }

    public boolean probe(String k){
        Row i= stack.top().find(k);
        if (i!=null)
            return true;
        return false;
    }

    public Row lookup(String key) throws Exception {
        return stack.top().find(key);
    }

    public Table top() {
        return stack.top();
    }

    public void push(Table t) {
        stack.push(t);
    }

    public Table pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
