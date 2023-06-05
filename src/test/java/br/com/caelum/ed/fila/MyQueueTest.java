package br.com.caelum.ed.fila;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyQueueTest {
    @Test
    void deve_inserir_na_fila(){
        MyQueue<String> fila = new MyQueue<>();
        fila.insere("Paulo");
        Assertions.assertFalse(fila.vazia());
    }

    @Test
    void deve_remover_da_fila(){
        MyQueue<String> fila = new MyQueue<>();
        fila.insere("Paulo");
        fila.remove();
        Assertions.assertTrue(fila.vazia());
    }
}
