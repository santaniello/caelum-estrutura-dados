package br.com.caelum.ed.listaligada;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyLinkedListTest {
    @Test
    void deve_adicionar_elemento_no_fim(){
        MyLinkedList lista = new MyLinkedList();
        lista.adiciona("Rafael");
        lista.adiciona("Paulo");
        Assertions.assertEquals("[Rafael, Paulo]", lista.toString());
    }

    @Test
    void deve_adicionar_elemento_por_posicao(){
        MyLinkedList lista = new MyLinkedList();
        lista.adiciona("Rafael");
        lista.adiciona(0, "Paulo");
        lista.adiciona(1, "Camila");
        Assertions.assertEquals("[Paulo, Camila, Rafael]", lista.toString());
    }

    @Test
    void deve_pegar_elemento_por_posicao(){
        MyLinkedList lista = new MyLinkedList();
        lista.adiciona("Rafael");
        lista.adiciona("Paulo");
        Assertions.assertEquals("Rafael", lista.pega(0).getElemento());
        Assertions.assertEquals("Paulo", lista.pega(1).getElemento());
     }

    @Test
    void deve_remover_elemento_por_posicao(){
        MyLinkedList lista = new MyLinkedList();
        lista.adiciona("Rafael");
        lista.adiciona("Paulo");
        lista.adiciona("Camila");
        lista.remove(1);
        Assertions.assertEquals("[Rafael, Camila]", lista.toString());
    }

    @Test
    void deve_testar_tamanho_da_lista(){
        MyLinkedList lista = new MyLinkedList();
        lista.adiciona("Rafael");
        lista.adiciona("Paulo");
        Assertions.assertEquals(2, lista.tamanho());
        lista.adiciona("Camila");
        Assertions.assertEquals(3, lista.tamanho());
    }

    @Test
    void deve_conter_elemento_na_lista(){
        MyLinkedList lista = new MyLinkedList();
        lista.adiciona("Rafael");
        lista.adiciona("Paulo");
        Assertions.assertTrue(lista.contem("Rafael"));
        Assertions.assertFalse(lista.contem("Camila"));
    }

    @Test
    void deve_adicionar_elemento_no_comeco_da_lista(){
        MyLinkedList lista = new MyLinkedList();
        lista.adicionaNoComeco("Rafael");
        lista.adicionaNoComeco("Paulo");
        Assertions.assertEquals("[Paulo, Rafael]", lista.toString());
    }

    @Test
    void deve_remover_elemento_no_comeco_da_lista(){
        MyLinkedList lista = new MyLinkedList();
        lista.adiciona("Rafael");
        lista.adiciona("Paulo");
        lista.removeDoComeco();
        Assertions.assertEquals("[Paulo]", lista.toString());
    }

    @Test
    void deve_remover_elemento_no_fim_da_lista(){
        MyLinkedList lista = new MyLinkedList();
        lista.adiciona("Rafael");
        lista.adiciona("Paulo");
        lista.removeDoFim();
        Assertions.assertEquals("[Rafael]", lista.toString());
    }

}
