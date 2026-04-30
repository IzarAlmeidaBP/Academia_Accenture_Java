package br.com.izarpaes.atividade7;

public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Izar Almeida");
        Casa c = new Casa("é um predio branco");
        Carro car = new Carro("onix", "cinza escuro", 250000.00);

        p.setCasa(c);
        p.setCarro(car);

        PessoaView view = new PessoaView();
        PessoaController controller = new PessoaController(p, view);

        controller.exibirInformacoes();
    }
}