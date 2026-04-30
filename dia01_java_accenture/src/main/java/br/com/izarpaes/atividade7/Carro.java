package br.com.izarpaes.atividade7;

public class Carro {
    private String marca;
    private String CodigoCor;
    private double preco;

    public Carro(String marca, String CodigoCor, double preco) {
        this.marca = marca;
        this.CodigoCor = CodigoCor;
        this.preco = preco;
    }

    public String getMarca() { return marca; }
    public String getCodigoCor() { return CodigoCor; }

    public void Buzinar() {
        System.out.println("emitir som");
    }
}