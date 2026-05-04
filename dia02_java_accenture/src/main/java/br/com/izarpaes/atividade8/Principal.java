package br.com.izarpaes.atividade8;


public class Principal {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Izar", "Almeida", "111.111.111-11");
        Cliente cliente2 = new Cliente("Francisco", "Souza", "222.222.222-22");

        ContaCorrente conta1 = new ContaCorrente(1, cliente1, 0.0, "04/05/2026");

        System.out.println("Saldo: R$ " + conta1.getSaldo());
        conta1.depositar(200.0);

        ContaCorrente conta2 = new ContaCorrente(2, cliente2, 100.0, "04/05/2026");

        System.out.println("Nome: " + conta1.getCliente().getNome());

        conta1.depositar(50.0);
        conta1.sacar(30.0);
        conta1.transferir(conta2, 100.0);

        conta1.transferir(conta2, 500.0);
    }
}