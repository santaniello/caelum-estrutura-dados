package br.com.caelum.ed.conjunto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {

    private List<List<String>> tabelaEspalhamento = new ArrayList<>();
    private int tamanho;

    public MyHashSet() {
        for(int indice = 0; indice < 26;indice++){
            tabelaEspalhamento.add(new LinkedList<>());
        }
    }

    private int calcularIndiceEspalhamento(String palavra){
        return palavra.toLowerCase().charAt(0) % 26;
    }

    public void adiciona(String palavra){
        if(contem(palavra))
            return;

        int indiceEspalhamento = calcularIndiceEspalhamento(palavra);
        tabelaEspalhamento.get(indiceEspalhamento).add(palavra);
        tamanho++;
    }

    public void remove(String palavra){
        int indiceEspalhamento = calcularIndiceEspalhamento(palavra);
        tabelaEspalhamento.get(indiceEspalhamento).remove(palavra);
        tamanho--;
    }

    public List<String> pegaTodas(){
        List<String> todasPalavras = new ArrayList<>();
        tabelaEspalhamento.forEach(te->todasPalavras.addAll(te));
        return todasPalavras;
    }

    public int tamanho(){
        return tamanho;
    }

    public boolean contem(String palavra){
        int indiceEspalhamento = calcularIndiceEspalhamento(palavra);
        return tabelaEspalhamento.get(indiceEspalhamento).contains(palavra);
    }
}
