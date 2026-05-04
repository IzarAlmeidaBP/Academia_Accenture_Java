package br.com.izarpaes.atividade8;


public class ContaCorrente {
    private int numero;
    private Cliente cliente;
    private double saldo;
    private String data;

    public ContaCorrente(int numero, Cliente cliente, double saldo, String data) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = saldo;
        this.data = data;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Saldo após depósito: R$ " + this.saldo);
    }

    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saldo após saque: R$ " + this.saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void transferir(ContaCorrente contaDestino, double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Saldo após transferência: " + this.saldo);
        } else {
            System.out.println("Transferência cancelada. A conta ficaria negativa.");
        }
    }

    public void exibirExtrato() {
        System.out.println("Conta: " + this.numero + " | Cliente: " + this.cliente.getNome() + " | Saldo: R$ " + this.saldo);
    }

    public double getSaldo() { return saldo; }
    public Cliente getCliente() { return cliente; }
}