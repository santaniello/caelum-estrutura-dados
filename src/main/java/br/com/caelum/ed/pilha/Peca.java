package br.com.caelum.ed.pilha;

import java.util.Objects;

public class Peca {
    private String nome;

    public Peca() {
    }

    public Peca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peca peca = (Peca) o;
        return Objects.equals(nome, peca.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
