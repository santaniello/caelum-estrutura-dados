package br.com.caelum.ed.fila;

import java.util.LinkedList;
import java.util.List;

public class MyQueue<T> {
    private List<T> objetos = new LinkedList<T>();
    public void insere(T t) {
        this.objetos.add(t);
    }
    public T remove() {
        return this.objetos.remove(0);
    }
    public boolean vazia() {
        return this.objetos.size() == 0;
    }
}
