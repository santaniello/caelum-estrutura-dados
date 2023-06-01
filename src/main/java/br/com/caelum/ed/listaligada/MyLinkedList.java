package br.com.caelum.ed.listaligada;

public class MyLinkedList {
    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;
    public void adiciona(Object elemento) {
        if(elemento == null)
            throw new IllegalArgumentException();
        if(totalDeElementos == 0) {
            adicionaNoComeco(elemento);
        }else{
            Celula novoElemento = new Celula(elemento);
            this.ultima.setProxima(novoElemento);
            novoElemento.setAnterior(this.ultima);
            this.ultima = novoElemento;
            totalDeElementos++;
        }
    }

    public void adiciona(int posicao, Object elemento) {
        if(!posicaoEhValida(posicao))
            throw new IllegalArgumentException();

        if(posicao == 0){
            adicionaNoComeco(elemento);
        }else if(posicao == totalDeElementos){
            adiciona(elemento);
        }else{
            Celula elementoAnterior = pega(posicao - 1);
            Celula elementoAlterado = elementoAnterior.getProxima();
            Celula novoElemento = new Celula(elementoAnterior, elemento, elementoAlterado);
            elementoAnterior.setProxima(novoElemento);
            elementoAlterado.setAnterior(novoElemento);
            totalDeElementos++;
        }
    }
    public Celula pega(int posicao) {
        if(!posicaoEhValida(posicao))
            throw new IllegalArgumentException();

        Celula atual = this.primeira;
        int index = 0;
        while(index != posicao){
            atual = atual.getProxima();
            index++;
        }
        return atual;
    }

    private boolean posicaoEhValida(int posicao){
        return posicao >= 0 && posicao < totalDeElementos;
    }

    public void remove(int posicao){
        if(totalDeElementos == 0)
            return;

        if(posicao == 0) {
            removeDoComeco();
        }else if(posicao == totalDeElementos - 1){
            removeDoFim();
        }else{
            Celula anterior = pega(posicao - 1);
            Celula posterior = anterior.getProxima().getProxima();
            posterior.setAnterior(anterior);
            anterior.setProxima(posterior);
           totalDeElementos--;
        }
    }
    public int tamanho() {return totalDeElementos;}
    public boolean contem(Object o) {
        Celula atual = this.primeira;
        for(int index = 0; index < totalDeElementos - 1 ; index++){
            if(atual.getElemento().equals(o))
                return true;

            atual.getProxima();
        }
        return false;
    }
    public void adicionaNoComeco(Object elemento) {
        if(elemento == null)
            throw new IllegalArgumentException();

        if(totalDeElementos == 0){
            Celula novaCelula = new Celula(elemento);
            this.primeira = novaCelula;
            this.ultima = novaCelula;
        }else{
            Celula novaCelula = new Celula(this.primeira,elemento);
            novaCelula.setProxima(this.primeira);
            this.primeira.setAnterior(novaCelula);
            this.primeira = novaCelula;
        }
        totalDeElementos++;
    }
    public void removeDoComeco() {
        if(totalDeElementos == 0)
            return;
        if(totalDeElementos == 1){
            this.primeira = null;
            this.ultima = null;
            totalDeElementos--;
            return;
        }
        Celula proximoPrimeiroElemento = this.primeira.getProxima();
        proximoPrimeiroElemento.setAnterior(null);
        this.primeira = proximoPrimeiroElemento;
        totalDeElementos--;
    }
    public void removeDoFim() {
        if(totalDeElementos == 0)
            return;

        if(totalDeElementos == 1) {
            removeDoComeco();
        }else{
            Celula anterior = this.ultima.getAnterior();
            anterior.setProxima(null);
            this.ultima = anterior;
        }
        totalDeElementos--;
    }

    @Override
    public String toString() {
        if(totalDeElementos == 0)
            return "[]";

        StringBuilder builder = new StringBuilder();
        Celula atual = this.primeira;
        builder.append("[");
        for(int index = 0; index < totalDeElementos - 1 ; index++){
            builder.append(atual.getElemento() + ", ");
            atual = atual.getProxima();
        }
        builder.append(atual.getElemento());
        builder.append("]");
        return builder.toString();
    }
}