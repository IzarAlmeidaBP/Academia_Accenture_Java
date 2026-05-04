package br.com.izarpaes.atividade10;

import java.util.*;

public class Principal {
    private static List<Produto> produtos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static int contadorPedidos = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\nMenu:");
            System.out.println("1 Adicionar Produto");
            System.out.println("2 Listar Produtos");
            System.out.println("3 Adicionar Cliente");
            System.out.println("4 Criar Pedido");
            System.out.println("5 Reservar Estoque");
            System.out.println("6 Pagar Pedido");
            System.out.println("7 Cancelar Pedido");
            System.out.println("8 Relatórios");
            System.out.println("0 Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1: adicionarProduto(scanner); break;
                case 2: listarProdutos(scanner); break;
                case 3: adicionarCliente(scanner); break;
                case 4: criarPedido(scanner); break;
                case 5: reservarEstoque(scanner); break;
                case 6: pagarPedido(scanner); break;
                case 7: cancelarPedido(scanner); break;
                case 8: gerarRelatorios(); break;
            }
        }
        scanner.close();
    }

    private static void adicionarProduto(Scanner scanner) {
        System.out.print("SKU: ");
        String sku = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Estoque: ");
        int estoque = Integer.parseInt(scanner.nextLine());
        produtos.add(new Produto(sku, nome, categoria, preco, estoque));
        System.out.println("Produto adicionado");
    }

    private static void listarProdutos(Scanner scanner) {
        System.out.print("Ordenar por (1 para SKU, 2 para Preço): ");
        String ordem = scanner.nextLine();
        List<Produto> listaOrdenada = new ArrayList<>(produtos);

        if ("1".equals(ordem)) {
            listaOrdenada.sort(Comparator.comparing(Produto::getSku));
        } else if ("2".equals(ordem)) {
            listaOrdenada.sort(Comparator.comparingDouble(Produto::getPreco));
        }

        System.out.println("\n Produtos");
        for (Produto p : listaOrdenada) {
            System.out.printf("%s | %s | R$%.2f | Estoque: %d\n", p.getSku(), p.getNome(), p.getPreco(), p.getEstoque());
        }
    }

    private static void adicionarCliente(Scanner scanner) {
        System.out.print("ID do Cliente: ");
        String id = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        clientes.add(new Cliente(id, nome));
        System.out.println("Cliente adicionado");
    }

    private static void criarPedido(Scanner scanner) {
        System.out.print("ID do Cliente: ");
        String clienteId = scanner.nextLine();
        Cliente cliente = clientes.stream().filter(c -> c.getId().equals(clienteId)).findFirst().orElse(null);

        if (cliente == null) {
            System.out.println("Cliente não encontrado");
            return;
        }

        List<ItemPedido> itens = new ArrayList<>();
        while (true) {
            System.out.print("SKU do Produto (ou 'sair'): ");
            String sku = scanner.nextLine();
            if (sku.equalsIgnoreCase("sair")) break;

            Produto produto = produtos.stream().filter(p -> p.getSku().equals(sku)).findFirst().orElse(null);
            if (produto == null) {
                System.out.println("Produto não encontrado");
                continue;
            }

            System.out.print("Quantidade: ");
            int qtd = Integer.parseInt(scanner.nextLine());
            itens.add(new ItemPedido(produto, qtd));
        }

        if (!itens.isEmpty()) {
            Pedido pedido = new Pedido(contadorPedidos++, cliente, itens);
            pedidos.add(pedido);
            System.out.println("Pedido " + pedido.getId() + " criado");
        }
    }

    private static void reservarEstoque(Scanner scanner) {
        System.out.print("ID do Pedido: ");
        int id = Integer.parseInt(scanner.nextLine());
        Pedido pedido = pedidos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

        if (pedido != null && pedido.getStatus().equals("PENDENTE")) {
            boolean temEstoque = true;
            for (ItemPedido item : pedido.getItens()) {
                if (item.getProduto().getEstoque() < item.getQuantidade()) {
                    temEstoque = false;
                    break;
                }
            }

            if (temEstoque) {
                for (ItemPedido item : pedido.getItens()) {
                    item.getProduto().setEstoque(item.getProduto().getEstoque() - item.getQuantidade());
                }
                pedido.setStatus("RESERVADO");
                System.out.println("Estoque reservado");
            } else {
                System.out.println("Estoque insuficiente");
            }
        }
    }

    private static void pagarPedido(Scanner scanner) {
        System.out.print("ID do Pedido: ");
        int id = Integer.parseInt(scanner.nextLine());
        Pedido pedido = pedidos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

        if (pedido != null && pedido.getStatus().equals("RESERVADO")) {
            System.out.print("Aprovar pagamento? (s/n): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                pedido.setStatus("PAGO");
                System.out.println("Pedido pago");
            } else {
                pedido.setStatus("FALHOU");
                System.out.println("Pagamento falhou");
            }
        }
    }

    private static void cancelarPedido(Scanner scanner) {
        System.out.print("ID do Pedido: ");
        int id = Integer.parseInt(scanner.nextLine());
        Pedido pedido = pedidos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

        if (pedido != null && !pedido.getStatus().equals("CANCELADO") && !pedido.getStatus().equals("PAGO")) {
            if (pedido.getStatus().equals("RESERVADO") || pedido.getStatus().equals("FALHOU")) {
                for (ItemPedido item : pedido.getItens()) {
                    item.getProduto().setEstoque(item.getProduto().getEstoque() + item.getQuantidade());
                }
            }
            pedido.setStatus("CANCELADO");
            System.out.println("Pedido cancelado");
        }
    }

    private static void gerarRelatorios() {
        double faturamentoTotal = pedidos.stream()
                .filter(p -> p.getStatus().equals("PAGO"))
                .mapToDouble(Pedido::calcularTotal)
                .sum();
        System.out.printf("\n Faturamento total: R$%.2f\n", faturamentoTotal);

        Map<String, Integer> produtosVendidos = new HashMap<>();
        Map<String, Double> faturamentoCategoria = new HashMap<>();
        Map<String, Integer> comprasClientes = new HashMap<>();

        for (Pedido p : pedidos) {
            if (p.getStatus().equals("PAGO")) {
                String nomeCliente = p.getCliente().getNome();
                comprasClientes.put(nomeCliente, comprasClientes.getOrDefault(nomeCliente, 0) + 1);

                for (ItemPedido item : p.getItens()) {
                    String nomeProd = item.getProduto().getNome();
                    String cat = item.getProduto().getCategoria();

                    produtosVendidos.put(nomeProd, produtosVendidos.getOrDefault(nomeProd, 0) + item.getQuantidade());
                    faturamentoCategoria.put(cat, faturamentoCategoria.getOrDefault(cat, 0.0) + item.getSubtotal());
                }
            }
        }

        System.out.println("\n Top 3 produtos");
        produtosVendidos.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        System.out.println("\n Faturamento por categoria");
        faturamentoCategoria.forEach((k, v) -> System.out.printf("%s: R$%.2f\n", k, v));

        System.out.println("\n Melhores clientes");
        comprasClientes.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " pedidos"));
    }
}