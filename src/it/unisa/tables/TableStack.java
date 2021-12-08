package it.unisa.tables;

public interface TableStack<T>{
        T top();
        T pop();
        void push(T t);
        boolean isEmpty();
}

