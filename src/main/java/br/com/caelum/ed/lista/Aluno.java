package br.com.caelum.ed.lista;

public class Aluno {
    private String nome;

    public Aluno() {
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return this.nome;
    }

    public boolean equals(Object o) {
        if(o == null)
            return false;

        Aluno outro = (Aluno)o;
        return this.nome.equals(outro.nome);
    }
}
