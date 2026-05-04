package br.com.izarpaes.atividade10;

import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private String status;

    public Pedido(int id, Cliente cliente, List<ItemPedido> itens) {
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
        this.status = "PENDING";
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<ItemPedido> getItens() { return itens; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }
}