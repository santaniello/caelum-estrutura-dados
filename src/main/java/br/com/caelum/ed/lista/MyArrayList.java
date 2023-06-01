package br.com.caelum.ed.lista;

/**
 * Essa classe é similar a implementação ArrayList do Java
 *
 * */

public class MyArrayList<T> {
    public static int TAMANHO_TOTAL_LISTA = 1000;

    private Object [] objects = new Object [TAMANHO_TOTAL_LISTA];
    private int totalDeObjects = 0;

    public void adicionaConstante(T array) {
        aumentarArray();
        this.objects[totalDeObjects] = array;
        this.totalDeObjects++;
    }

    public void adicionaLinear(Aluno aluno) {
        aumentarArray();
        for(int index = 0; index < this.objects.length; index++){
            if(this.objects[index] == null){
                this.objects[index] = aluno;
                totalDeObjects++;
                break;
            }
        }
    }

    public void adiciona(int posicao, T array) {
        if(!posicaoValida(posicao))
            throw new IllegalArgumentException();

        aumentarArray();
        for(int index = tamanho()-1; index >= posicao; index--){
             this.objects[index+1] = this.objects[index];
        }
        this.objects[posicao] = array;
        this.totalDeObjects++;
    }

    private void aumentarArray(){
        if(this.totalDeObjects < this.objects.length)
            return;

        Object[] novoArray = new Object[this.objects.length * 2];
        for(int index = 0; index < this.objects.length; index++){
            novoArray[index] = this.objects[index];
        }
        this.objects = novoArray;
    }

    public T pega(int posicao) {
        if(!posicaoValida(posicao))
            throw new IllegalArgumentException();
        return (T) this.objects[posicao];
    }

    public void remove(int posicao) {
        if(!posicaoValida(posicao))
            throw new IllegalArgumentException();

        for(int index = tamanho()-1; index >= posicao; index--){
            if(index > 0 )
                this.objects[index-1] = this.objects[index];
        }
        this.totalDeObjects--;
    }

    public int indexOf(T object) {
        for (int index = 0; index < totalDeObjects; index++) {
            if (object.equals((T) objects[index]))
                return index;
        }
        return -1;
    }

    public int lastIndexOf(T object) {
        Integer ultimaPosicao = null;
        for (int index = 0; index < totalDeObjects; index++) {
            if (object.equals((T) objects[index]))
                ultimaPosicao = index;
        }
        if (ultimaPosicao == null)
            return -1;

        return ultimaPosicao;
    }

    public void remove(T object){
        int quantidadeRemovida = 0;
        for(int index = 0; index < this.totalDeObjects; index++){
            if(object.equals((T) objects[index])){
                this.objects[index] = this.objects[index+1];
                this.objects[index+1] = null;
                quantidadeRemovida++;
            }
            if(this.objects[index] == null){
               if(this.objects[index + 1] != null && !this.objects[index + 1].equals(object)) {
                   this.objects[index] = this.objects[index + 1];
                   this.objects[index + 1] = null;
               }
            }
        }
        this.totalDeObjects = totalDeObjects - quantidadeRemovida;
    }

    public boolean contem(Aluno aluno) {
        for (int index = 0; index < totalDeObjects; index++) {
            if(aluno.equals(this.objects[index]))
                return true;
        }
        return false;
    }

    public int tamanho() {
        return this.totalDeObjects;
    }

    public int tamanhoReal() {
        return this.objects.length;
    }

    public void clear(){
        this.objects = new Object[this.objects.length];
        this.totalDeObjects = 0;
    }


    /** Metodos auxiliares **/

    private boolean posicaoValida(int posicao){
        return posicao >= 0 && posicao < tamanho();
    }

    @Override
    public String toString() {
        if (this.totalDeObjects == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < this.totalDeObjects - 1; i++) {
            builder.append(this.objects[i]);
            builder.append(", ");
        }
        builder.append(this.objects[this.totalDeObjects - 1]);
        builder.append("]");
        return builder.toString();
    }

}
