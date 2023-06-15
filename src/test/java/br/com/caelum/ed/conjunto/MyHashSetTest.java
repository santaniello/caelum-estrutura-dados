package br.com.caelum.ed.conjunto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MyHashSetTest {
    @Test
    void deve_listar_todas_as_palavras(){
        MyHashSet<String> conjunto = new MyHashSet();
        conjunto.adiciona("Rafael");
        conjunto.adiciona("Ana");
        conjunto.adiciona("Paulo");

        Assertions.assertEquals("[Ana, Paulo, Rafael]",conjunto.pegaTodas().toString());
        Assertions.assertEquals(3,conjunto.pegaTodas().size());
    }

    @Test
    void deve_remover_palavras(){
        MyHashSet<String> conjunto = new MyHashSet();
        conjunto.adiciona("Rafael");
        conjunto.adiciona("Ana");
        conjunto.adiciona("Paulo");

        Assertions.assertEquals("[Ana, Paulo, Rafael]",conjunto.pegaTodas().toString());

        conjunto.remove("Rafael");
        Assertions.assertEquals("[Ana, Paulo]",conjunto.pegaTodas().toString());
    }

    @Test
    void deve_testar_se_contem_um_elemento(){
        MyHashSet<String> conjunto = new MyHashSet();
        conjunto.adiciona("Rafael");
        conjunto.adiciona("Ana");
        conjunto.adiciona("Paulo");

        Assertions.assertTrue(conjunto.contem("Paulo"));
    }

    @Test
    void deve_testar_tamanho(){
        MyHashSet<String> conjunto = new MyHashSet();
        conjunto.adiciona("Rafael");
        conjunto.adiciona("Ana");
        conjunto.adiciona("Paulo");

        System.out.println(conjunto.pegaTodas().toString());
        Assertions.assertEquals(3, conjunto.tamanho());
    }

    @Test
    void deve_imprimir_tabela(){
        MyHashSet<String> conjunto = new MyHashSet();
        for (int i = 0; i < 20; i++) {
            conjunto.adiciona("" + i);
        }
        conjunto.imprimeTabelaEspalhamento();
    }

//    @Test
//    void deve_testar_tempo_execucao_com_redimensionamento_da_tabela(){
//        // Teste Com Redimensionamento
//        long inicioComRedimensionamento = System.currentTimeMillis();
//        MyHashSet conjuntoComRedimensionamento = new MyHashSet();
//        for (int i = 0; i < 50000; i++) {
//            conjuntoComRedimensionamento.adicionaComRedimensionamentoDaTabelaDeEspalhamento("palavra" + i);
//        }
//        for (int i = 0; i < 50000; i++) {
//            conjuntoComRedimensionamento.contem("palavra" + i);
//        }
//        long fimComRedimensionamento = System.currentTimeMillis();
//        double tempoComRedimensionamento = (fimComRedimensionamento - inicioComRedimensionamento) / 1000.0;
//
//        // Teste Sem Redimensionamento
//        long inicioSemRedimensionamento = System.currentTimeMillis();
//        MyHashSet conjuntoSemRedimensionamento = new MyHashSet();
//        for (int i = 0; i < 50000; i++) {
//            conjuntoSemRedimensionamento.adiciona("palavra" + i);
//        }
//        for (int i = 0; i < 50000; i++) {
//            conjuntoSemRedimensionamento.contem("palavra" + i);
//        }
//        long fimSemRedimensionamento = System.currentTimeMillis();
//        double tempoSemRedimensionamento = (fimSemRedimensionamento - inicioSemRedimensionamento) / 1000.0;
//
//        // Abaixo verificamos que o tempo sem redimensionamento é mais que o dobro do tempo com redimensionamento
//        Assertions.assertTrue(tempoSemRedimensionamento > tempoComRedimensionamento * 2);
//    }
}
