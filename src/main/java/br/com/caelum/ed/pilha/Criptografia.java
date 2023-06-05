package br.com.caelum.ed.pilha;

public class Criptografia {

    public String criptografar(String texto){
        MyStack<Character> caracteres = new MyStack<>();
        String[] palavras = quebrarTexto(texto);
        for(int x = palavras.length - 1;  x >= 0; x--){
            char[] chars = quebrarPalavras(palavras[x]);
            for(int y = 0; y <= chars.length - 1 ; y++){
                caracteres.insere(chars[y]);
            }
            caracteres.insere(' ');
        }
        caracteres.remove();
        Character[] array = new Character[caracteres.tamanho()];
        int index = 0;
        while(!caracteres.vazia()){
            array[index] = caracteres.remove();
            index++;
        }

       return characterArrayToString(array);
    }

    public String descriptografar(String texto){
        return criptografar(texto);
    }

    private String characterArrayToString(Character[] chars){
        StringBuilder builder = new StringBuilder();
        for (Character c : chars)
            builder.append(c);

        return builder.toString();
    }

    private String[] quebrarTexto(String texto){
        return texto.split(" ");
    }

    private char[] quebrarPalavras(String palavra){
        return palavra.toCharArray();
    }

}
