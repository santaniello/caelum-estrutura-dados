package br.com.caelum.ed.listaligada;

public class Celula {
    private Celula proxima;
    private Celula anterior;
    private Object elemento;

    public Celula(Object elemento) {
        this.elemento = elemento;
    }
    public Celula(Celula proxima, Object elemento) {
        this.proxima = proxima;
        this.elemento = elemento;
    }

    public Celula(Celula anterior, Object elemento,Celula proxima) {
        this.proxima = proxima;
        this.anterior = anterior;
        this.elemento = elemento;
    }
    public void setProxima(Celula proxima) {
        this.proxima = proxima;
    }
    public Celula getProxima() {
        return proxima;
    }
    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }
    public Celula getAnterior() {
        return anterior;
    }


    public Object getElemento() {
        return elemento;
    }
}
