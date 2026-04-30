package br.com.izarpaes;

public class Arvore {
    private String tipo; // Alterado de especie para tipo

    public Arvore(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}