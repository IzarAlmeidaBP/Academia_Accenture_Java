package br.com.izarpaes.atividade7;


public class PessoaController {
    private Pessoa model;
    private PessoaView view;

    public PessoaController(Pessoa model, PessoaView view) {
        this.model = model;
        this.view = view;
    }

    public void exibirInformacoes() {
        view.mostrarDetalhes(
                model.getNome(),
                model.getCasa().getCodigoCor(),
                model.getCarro().getMarca()
        );
    }


}