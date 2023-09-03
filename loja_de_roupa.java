import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Roupa {
    private String nome;
    private int quantidade;

    public Roupa(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionar(int quantidade) {
        this.quantidade += quantidade;
    }

    public void remover(int quantidade) {
        if (quantidade <= this.quantidade) {
            this.quantidade -= quantidade;
        } else {
            System.out.println("Quantidade insuficiente em estoque.");
        }
    }

    public void atualizarQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Quantidade: " + quantidade;
    }
}

class LojaDeRoupas {
    private List<Roupa> estoque = new ArrayList<>();

    public void adicionarRoupa(String nome, int quantidade) {
        Roupa roupa = new Roupa(nome, quantidade);
        estoque.add(roupa);
    }

    public void removerRoupa(String nome, int quantidade) {
        Roupa roupa = encontrarRoupa(nome);
        if (roupa != null) {
            roupa.remover(quantidade);
            if (roupa.getQuantidade() == 0) {
                estoque.remove(roupa);
            }
        }
    }

    public void listarRoupas() {
        for (Roupa roupa : estoque) {
            System.out.println(roupa);
        }
    }

    public void atualizarQuantidade(String nome, int quantidade) {
        Roupa roupa = encontrarRoupa(nome);
        if (roupa != null) {
            roupa.atualizarQuantidade(quantidade);
        }
    }

    private Roupa encontrarRoupa(String nome) {
        for (Roupa roupa : estoque) {
            if (roupa.getNome().equalsIgnoreCase(nome)) {
                return roupa;
            }
        }
        System.out.println("Roupa não encontrada.");
        return null;
    }
}

public class LojaDeRoupasApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LojaDeRoupas loja = new LojaDeRoupas();

        while (true) {
            System.out.println("\nLoja de Roupas - Sistema de Gerenciamento de Estoque");
            System.out.println("1. Adicionar Roupa");
            System.out.println("2. Remover Roupa");
            System.out.println("3. Listar Roupas");
            System.out.println("4. Atualizar Quantidade");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.print("Nome da Roupa: ");
                    String nomeAdicionar = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidadeAdicionar = scanner.nextInt();
                    loja.adicionarRoupa(nomeAdicionar, quantidadeAdicionar);
                    break;
                case 2:
                    System.out.print("Nome da Roupa: ");
                    String nomeRemover = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidadeRemover = scanner.nextInt();
                    loja.removerRoupa(nomeRemover, quantidadeRemover);
                    break;
                case 3:
                    loja.listarRoupas();
                    break;
                case 4:
                    System.out.print("Nome da Roupa: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.print("Nova Quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    loja.atualizarQuantidade(nomeAtualizar, novaQuantidade);
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
