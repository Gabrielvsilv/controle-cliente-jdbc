import java.util.Scanner;
import dao.ClienteDao;
import model.Cliente;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClienteDao dao = new ClienteDao();

        int opcao;

        do {

            System.out.println("\n===== CONTROLE DE CLIENTES =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Atualizar cliente");
            System.out.println("4 - Excluir cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("Insira o nome do cliente:");
                    String nome = scanner.nextLine();

                    System.out.println("Insira o email do cliente:");
                    String email = scanner.nextLine();

                    System.out.println("Insira o telefone do cliente:");
                    String telefone = scanner.nextLine();

                    Cliente cliente = new Cliente (nome, email, telefone);
                    dao.cadastrar(cliente);

                    break;

                case 2:
                    
                   List<Cliente> clientes = dao.listar();

                   for (Cliente c : clientes) {
                    System.out.println(c);
                   }
                    break;

                case 3:
                    System.out.println("Insira o ID do cliente a ser atualizado:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Insira o novo nome do cliente:");
                    String novoNome = scanner.nextLine();
                    System.out.println("Insira o novo email do cliente:");
                    String novoEmail = scanner.nextLine();
                    System.out.println("Insira o novo telefone do cliente:");
                    String novoTelefone = scanner.nextLine();

                    Cliente clienteAtualizado = new Cliente(id, novoNome, novoEmail, novoTelefone);
                    dao.atualizar(clienteAtualizado);
                    break;

                case 4:
                    System.out.println("Insira o ID do cliente a ser excluído:");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine();
                    dao.excluir(idExcluir);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");

            }

        } while (opcao != 0);

        scanner.close();
    }
}