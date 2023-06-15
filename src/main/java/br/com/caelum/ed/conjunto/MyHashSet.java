package br.com.caelum.ed.conjunto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet<T>{

    private List<List<T>> tabelaEspalhamento = new ArrayList<>();
    private int tamanho = 0;

    public MyHashSet() {
        for(int indice = 0; indice < 26;indice++){
            tabelaEspalhamento.add(new LinkedList<>());
        }
    }

    /**
     * Método antigo que calculava o indice de espalhamento
     * */
//    private int calcularIndiceEspalhamento(String palavra){
//        return palavra.toLowerCase().charAt(0) % 26;
//    }

    private int calcularIndiceEspalhamento(T objeto) {
        int codigoDeEspalhamento = objeto.hashCode();
        codigoDeEspalhamento = Math.abs(codigoDeEspalhamento);
        return codigoDeEspalhamento % tabelaEspalhamento.size();
    }

//    private int calculaCodigoDeEspalhamento(String palavra) {
//        int codigo = 1;
//        for (int i = 0; i < palavra.length(); i++) {
//            codigo = 31 * codigo + palavra.charAt(i);
//        }
//        return codigo;
//    }

    public void adiciona(T objeto){
        if(!contem(objeto)) {
            this.verificaCarga();
            int indiceEspalhamento = calcularIndiceEspalhamento(objeto);
            tabelaEspalhamento.get(indiceEspalhamento).add(objeto);
            this.tamanho++;
        }
    }

    public void remove(T objeto){
        if(contem(objeto)){
            int indiceEspalhamento = calcularIndiceEspalhamento(objeto);
            tabelaEspalhamento.get(indiceEspalhamento).remove(objeto);
            this.tamanho--;
            this.verificaCarga();
        }
    }

    public List<T> pegaTodas(){
        List<T> todasPalavras = new ArrayList<>();
        tabelaEspalhamento.forEach(te->todasPalavras.addAll(te));
        return todasPalavras;
    }

    public int tamanho(){
        return tamanho;
    }

    public boolean contem(T objeto){
        int indiceEspalhamento = calcularIndiceEspalhamento(objeto);
        return tabelaEspalhamento.get(indiceEspalhamento).contains(objeto);
    }

    public void imprimeTabelaEspalhamento(){
        for (List<T> lista : this.tabelaEspalhamento) {
            System.out.print("[");
            for (int i = 0; i < lista.size(); i++) {
                System.out.print("*");
            }
            System.out.println("]");
        }
    }

    private void verificaCarga() {
        int capacidade = this.tabelaEspalhamento.size();
        // a carga da Tabela é a razão entre o número de elementos e o número de Listas.
        double carga = (double) this.tamanho / capacidade;
        /**
         * Se esta carga ultrapassar o valor 0.75 significa que há uma alta chance de ocorrer colisões. Neste caso, aumentaremos o tamanho da Tabela.
         * Se a carga ficar menor do que o valor 0.25 significa que a Tabela tem muito espaço vazio. Neste caso, diminuiremos o tamanho dela.
         *
         */
        if (carga > 0.75) {
            this.redimensionaTabela(capacidade * 2);
        } else if (carga < 0.25) {
            /**
             Se a carga for menor que 0.25 a novaCapacidade será a metade da antiga mas para evitar
             ficar com uma capacidade muito pequena denimos que o mínimo é 10.
             **/
            this.redimensionaTabela(Math.max(capacidade / 2, 10));
        }
    }

    private void redimensionaTabela(int novaCapacidade){
        List<T> palavras = this.pegaTodas();
        this.tabelaEspalhamento.clear();
        this.tamanho = 0;
        for (int i = 0; i < novaCapacidade; i++) {
            this.tabelaEspalhamento.add(new LinkedList<T>());
        }
        for (T objeto : palavras) {
            this.adiciona(objeto);
        }
    }

}
