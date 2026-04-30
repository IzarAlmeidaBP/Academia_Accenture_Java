package br.com.izarpaes.atividade5;

public class Dog {

    String nome;
    int idade;

    public Dog(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void emitirSom() {
        System.out.println("au!");
    }
}