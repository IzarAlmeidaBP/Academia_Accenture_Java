package br.com.izarpaes.atividade6;

public class Carro {

    String marca;
    String CodigoCor;
    double preco;

    public Carro(String marca, String CodigoCor, double preco) {
        this.marca = marca;
        this.CodigoCor = CodigoCor;
        this.preco = preco;
    }

    public void Exibir() {
        System.out.println("marca: " + marca);
        System.out.println("codigo da cor: " + CodigoCor);
        System.out.println("preço: " + preco);
    }

    public void Ligar() {
    }

    public void Buzinar() {
        System.out.println("emitir som");
    }

    public void Movimentar() {
    }
}