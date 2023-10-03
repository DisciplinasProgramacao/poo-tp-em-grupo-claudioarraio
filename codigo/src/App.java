import java.time.*;
import java.util.*;

// inserir cadastro de carros:placa;
// inserir abastecimento de carros:placa;
//corrigir erro do switch 0 entrando no método programa;

public class App {

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void iniciarPrograma(int opcao, Scanner sc) {
        System.out.println("1 - Abrir programa");
        System.out.println("0 - Sair");
        System.out.println(" ");
        System.out.println("Insira uma opçãoo: ");
        System.out.println(" ");
        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                exibirMenu();
                programa(opcao, sc);
                break;
            case 0:
                System.out.println("Saindo do sistema...");
                break;
        }
    }

    public static void exibirMenu() {

        System.out.println(" ");
        System.out.println("Abrindo o programa...");
        System.out.println("====================");
        System.out.println("1 - Cadastrar carro; ");
        System.out.println("2 - Abastecer veículo; ");
        System.out.println("3 - Exibir a quantidade de gasolina abastecida de cada veículo; ");
        System.out.println("4 - Exibir a quilometragem do veículo no mês atual; ");
        System.out.println("5 - Exibir a quilometragem total do veículo; ");
        System.out.println("0 - Sair do programa; ");
    }

    public static void programa(int opcao, Scanner sc) {
        Veiculo veiculo = new Veiculo();
        String placa;
        double litros;
        while (opcao != 0) {
            System.out.println(" ");
            System.out.println("Insira uma opção1: ");
            System.out.println(" ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Saindo do sistema");
                    break;
                case 1:

                    break;
                case 2:
                    System.out.println("Digite a quantidade de Litros que deseja abastecer");
                    litros = sc.nextDouble();
                    veiculo.abastecer(litros);
                case 3:
                    System.out.println("A quantidade abastecida foi " + Veiculo.getTotalReabastecido() + " litros.");
                    break;
                case 4:
                    System.out.println(
                            "A quilometragem do veículo no mês atual foi de " + Veiculo.getKmNoMes() + " Kms.");
                    break;
                case 5:
                    System.out.println("A quilometragem total do veículo " + Veiculo.getPlaca() + " foi de "
                            + Veiculo.getKmTotal() + " Kms.");
                    break;
                default:
                    System.out.println("Número inválido. Tente novamente.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        limparTela();
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        iniciarPrograma(opcao, sc);

        sc.close();
    }

}
