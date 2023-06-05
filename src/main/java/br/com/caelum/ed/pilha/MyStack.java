package br.com.caelum.ed.pilha;

import java.util.LinkedList;
import java.util.List;

/**
 * Na biblioteca do Java existe uma classe que implementa a estrutura de dados de uma Pilha, esta
 * classe chama-se Stack !
 * */
public class MyStack<T> {
    private List<T> objetos = new LinkedList<T>();
    private int tamanho;
    public void insere(T t) {
        this.tamanho++;
        this.objetos.add(t);
    }
    public T remove() {
        this.tamanho--;
        return this.objetos.remove(this.objetos.size() - 1);
    }

    public int tamanho(){
        return this.tamanho;
    }

    public boolean vazia() {
        return this.objetos.size() == 0;
    }
}
