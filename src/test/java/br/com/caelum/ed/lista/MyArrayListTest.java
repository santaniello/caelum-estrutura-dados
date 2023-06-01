package br.com.caelum.ed.lista;

import br.com.caelum.ed.lista.Aluno;
import br.com.caelum.ed.lista.MyArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {
    @Test
    void deve_adicionar_elemento_linear_no_fim_da_lista(){
        Aluno a1 = new Aluno("João");
        Aluno a2 = new Aluno("José");
        MyArrayList<Aluno> lista = new MyArrayList();
        lista.adicionaLinear(a1);
        lista.adicionaLinear(a2);
        assertEquals("[João, José]", lista.toString());
    }

    @Test
    void deve_adicionar_elemento_constante_no_fim_da_lista(){
        Aluno a1 = new Aluno("João");
        Aluno a2 = new Aluno("José");
        MyArrayList<Aluno> lista = new MyArrayList();
        lista.adicionaConstante(a1);
        lista.adicionaConstante(a2);
        assertEquals("[João, José]", lista.toString());
    }

    @Test
    void adicionar_elemento_linear_deve_ter_o_tempo_de_execucao_maior_que_adicionar_elemento_constante(){
        MyArrayList arrayLinear = new MyArrayList();
        MyArrayList arrayConstante = new MyArrayList();
        Instant startLinear = Instant.now();
        for(int index = 0; index < MyArrayList.TAMANHO_TOTAL_LISTA; index++ ){
            arrayLinear.adicionaLinear(new Aluno());
        }
        Instant finishLinear = Instant.now();
        long timeElapsedLinear = Duration.between(startLinear, finishLinear).toMillis();
        Instant startConstante = Instant.now();
        for(int index = 0; index < MyArrayList.TAMANHO_TOTAL_LISTA; index++ ){
            arrayConstante.adicionaConstante(new Aluno());
        }
        Instant finishConstante = Instant.now();
        long timeElapsedConstante = Duration.between(startConstante, finishConstante).toMillis();
        assertTrue(timeElapsedLinear > timeElapsedConstante);
    }

    @Test
    void deve_adicionar_elemento_por_posicao(){
        Aluno a1 = new Aluno("Rafael");
        Aluno a2 = new Aluno("Paulo");
        Aluno a3 = new Aluno("Ana");
        MyArrayList<Aluno> lista = new MyArrayList();
        lista.adicionaConstante(a1);
        lista.adiciona(0, a2);
        lista.adiciona(1, a3);
        assertEquals("[Paulo, Ana, Rafael]", lista.toString());
    }

    @Test
    void deve_dobrar_o_tamanho_do_array_quando_espaco_acabar(){
        MyArrayList vetor = new MyArrayList();
        for (int i = 0; i < 1001; i++) {
            Aluno aluno = new Aluno();
            vetor.adicionaConstante(aluno);
        }
        assertEquals(MyArrayList.TAMANHO_TOTAL_LISTA * 2, vetor.tamanhoReal());
    }

    @Test
    void deve_pegar_elemento_por_posicao_que_exista(){
        Aluno a1 = new Aluno("Rafael");
        Aluno a2 = new Aluno("Paulo");
        MyArrayList<Aluno> lista = new MyArrayList();
        lista.adicionaConstante(a1);
        lista.adicionaConstante(a2);
        Aluno aluno1 = lista.pega(0);
        Aluno aluno2 = lista.pega(1);
        assertEquals("Rafael", aluno1.getNome());
        assertEquals("Paulo", aluno2.getNome());
    }

    @Test
    void deve_lancar_uma_excessao_quando_pegar_elemento_por_posicao_que_nao_exista(){
        Aluno a1 = new Aluno("Rafael");
        Aluno a2 = new Aluno("Paulo");
        MyArrayList<Aluno> lista = new MyArrayList();
        lista.adicionaConstante(a1);
        lista.adicionaConstante(a2);
        assertThrows(IllegalArgumentException.class, () -> {
            lista.pega(3000);
        });
    }

    @Test
    void deve_lancar_uma_excessao_quando_pegar_elemento_por_posicao_que_tiver_nulo(){
        Aluno a1 = new Aluno("Rafael");
        Aluno a2 = new Aluno("Paulo");
        MyArrayList<Aluno> lista = new MyArrayList();
        lista.adicionaConstante(a1);
        lista.adicionaConstante(a2);
        assertThrows(IllegalArgumentException.class, () -> {
            lista.pega(3);
        });
    }



    @Test
    void deve_remover_elemento_por_posicao(){
        Aluno a1 = new Aluno("Rafael");
        Aluno a2 = new Aluno("Paulo");
        MyArrayList<Aluno> lista = new MyArrayList();
        lista.adicionaConstante(a1);
        lista.adicionaConstante(a2);
        lista.remove(0);
        assertEquals("[Paulo]", lista.toString());
    }

    @Test
    void deve_conter_elemento(){
        Aluno a1 = new Aluno("Rafael");
        Aluno a2 = new Aluno("Paulo");
        MyArrayList<Aluno> lista = new MyArrayList();
        lista.adicionaConstante(a1);
        lista.adicionaConstante(a2);
        assertTrue(lista.contem(a1));
        assertTrue(lista.contem(a2));
        Aluno aluno = new Aluno("Ana");
        assertFalse(lista.contem(aluno));
    }

    @Test
    void deve_testar_tamanho_da_lista(){
        Aluno a1 = new Aluno("Rafael");
        Aluno a2 = new Aluno("Paulo");
        Aluno a3 = new Aluno();
        MyArrayList<Aluno> lista = new MyArrayList();
        lista.adicionaConstante(a1);
        lista.adicionaConstante(a2);
        assertEquals(2,lista.tamanho());
        lista.adicionaConstante(a3);
        assertEquals(3,lista.tamanho());
    }

    @Test
    void deve_remover_todas_as_ocorrencias_do_objeto_na_lista(){
        Aluno a1 = new Aluno("Rafael");
        Aluno a2 = new Aluno("Paulo");
        Aluno a3 = new Aluno("Ana");
        Aluno a4 = new Aluno("Rafael");
        MyArrayList<Aluno> lista = new MyArrayList();
        lista.adicionaConstante(a1);
        lista.adicionaConstante(a2);
        lista.adicionaConstante(a3);
        lista.adicionaConstante(a4);
        lista.remove(a1);
        assertEquals("[Paulo, Ana]", lista.toString());
        lista.remove(a3);
        assertEquals("[Paulo]", lista.toString());

    }

    @Test
    void deve_limpar_array(){
        Aluno a1 = new Aluno("Rafael");
        Aluno a2 = new Aluno("Paulo");
        Aluno a3 = new Aluno("Ana");
        Aluno a4 = new Aluno("Rafael");
        MyArrayList<Aluno> lista = new MyArrayList();
        lista.adicionaConstante(a1);
        lista.adicionaConstante(a2);
        lista.adicionaConstante(a3);
        lista.adicionaConstante(a4);
        lista.clear();
        Assertions.assertEquals(0, lista.tamanho());
    }

    @Test
    void deve_retornar_a_primeira_ocorrencia_do_objeto_no_array(){
        Aluno a1 = new Aluno("Paulo");
        Aluno a2 = new Aluno("Rafael");
        Aluno a3 = new Aluno("Ana");
        Aluno a4 = new Aluno("Rafael");
        MyArrayList<Aluno> lista = new MyArrayList();
        lista.adicionaConstante(a1);
        lista.adicionaConstante(a2);
        lista.adicionaConstante(a3);
        lista.adicionaConstante(a4);
        Assertions.assertEquals(1, lista.indexOf(a4));
        Assertions.assertEquals(-1, lista.lastIndexOf(new Aluno("Jorge")));
    }

    @Test
    void deve_retornar_a_ultima_ocorrencia_do_objeto_no_array(){
        Aluno a1 = new Aluno("Paulo");
        Aluno a2 = new Aluno("Rafael");
        Aluno a3 = new Aluno("Ana");
        Aluno a4 = new Aluno("Rafael");
        MyArrayList<Aluno> lista = new MyArrayList();
        lista.adicionaConstante(a1);
        lista.adicionaConstante(a2);
        lista.adicionaConstante(a3);
        lista.adicionaConstante(a4);
        Assertions.assertEquals(3, lista.lastIndexOf(a2));
        Assertions.assertEquals(-1, lista.lastIndexOf(new Aluno("Jorge")));
    }
}
