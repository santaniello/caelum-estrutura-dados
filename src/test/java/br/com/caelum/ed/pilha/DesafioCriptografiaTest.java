package br.com.caelum.ed.pilha;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DesafioCriptografiaTest {
    private String textoOriginal = "Uma mensagem confidencial";
    private String textoCriptografado = "amU megasnem laicnedifnoc";

    @Test
    void deve_criptografar_mensagem() {
        Criptografia cripto = new Criptografia();
        assertEquals(textoCriptografado, cripto.criptografar(textoOriginal));
    }

    @Test
    void deve_descriptografar_mensagem() {
        Criptografia cripto = new Criptografia();
        String textoCriptografado = cripto.criptografar(textoOriginal);
        assertEquals(textoOriginal, cripto.descriptografar(textoCriptografado));
    }
}
