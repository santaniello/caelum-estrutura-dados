package br.com.caelum.ed.pilha;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyStackTestTest {
    @Test
    void deve_inserir_na_pilha(){
        MyStack<Peca> pilhaDePecas = new MyStack<>();
        Peca peca = new Peca("Pistão");
        pilhaDePecas.insere(peca);
        Assertions.assertEquals(1, pilhaDePecas.tamanho());
    }

    @Test
    void deve_remover_da_pilha(){
        MyStack<Peca> pilhaDePecas = new MyStack<>();
        Peca peca = new Peca("Pistão");
        pilhaDePecas.insere(peca);
        Peca pecaRemovida = pilhaDePecas.remove();
        Assertions.assertEquals(0, pilhaDePecas.tamanho());
        Assertions.assertEquals(peca, pecaRemovida);
    }

    @Test
    void deve_informar_que_a_pilha_nao_esta_vazia(){
        MyStack<Peca> pilhaDePecas = new MyStack<>();
        Peca peca = new Peca("Pistão");
        pilhaDePecas.insere(peca);
        Assertions.assertFalse(pilhaDePecas.vazia());
    }
}
