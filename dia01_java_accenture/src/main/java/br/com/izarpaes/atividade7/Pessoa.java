package br.com.izarpaes.atividade7;


public class Pessoa {
    private String nome;
    private Casa casa;
    private Carro carro;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }
    public void setCasa(Casa casa) { this.casa = casa; }
    public Casa getCasa() { return casa; }
    public void setCarro(Carro carro) { this.carro = carro; }
    public Carro getCarro() { return carro; }

    public String acaoMorar() {
        return nome + " está morando na casa de cor " + casa.getCodigoCor();
    }

    public String acaoDirigir() {
        return nome + " está dirigindo o carro da marca " + carro.getMarca();
    }
}