package src;

import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);
    public static String placa;

    // #region criando comandos de limpeza e pausa
    static void pausa() {
        System.out.println("Enter para continuar.");
        sc.nextLine();
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    // #endregion

    // #region criação da abertura de App e menus para que o usuário escolha através
    // do Scanner(teclado)

    public static void abrirApp() {
        System.out.println("APP FROTAS");
        System.out.println("\n ======================\n");

        System.out.println("1 - Gerenciar veículos");
        System.out.println("2 - Gerar relatórios");
        System.out.println("0 - Sair");
        System.out.println();
        System.out.println("Insira uma opção: ");

        int num = sc.nextInt();

        switch (num) {
            case 1:
                menuVeiculo(num, null);
                break;
            case 2:
                menuRelatorio(num);
                break;
            case 0:
                System.out.println("APP Finalizado");
                break;
            default:
                System.out.println("Valor inválido");
                break;
        }
    }

    public static void menuVeiculo(int num, Rota rota) {
        System.out.println("\n MENU DE VEÍCULOS");
        System.out.println("\n ======================\n");

        System.out.println("1 - Cadastrar veículo");
        System.out.println("2 - Cadastrar rota");
        System.out.println("3 - Abaster veículo");
        System.out.println("4 - Localizar veículo");
        System.out.println("5 - Percorrer rota");
        System.out.println("0 - Voltar ao menu principal");

        num = sc.nextInt();

        switch (num) {
            case 1:
                // Veiculo veiculo1 = new Veiculo("ABC123", 0, tanque);
                System.out.println("SWITCH 1");
                break;
            case 2:
                //
                System.out.println("SWITCH 2");
                break;
            case 3:
                // veiculo.abastecer
                System.out.println("SWITCH 3");
                break;
            case 4:
                System.out.println("Insira a placa do veículo: ");
                placa = sc.nextLine();
                // localizarVeiculo(placa);
                System.out.println("SWITCH 4");
                break;
            case 5:
                System.out.println("Insira a placa do veículo que irá percorrer a rota: ");
                placa = sc.nextLine();
                // Veiculo.percorrerRota(rota);
                System.out.println("SWITCH 5");
                break;
            case 0:
                limparTela();
                abrirApp();
            default:
                System.out.println("Valor inválido");
                break;
        }
    }

    public static void menuRelatorio(int num) {
        System.out.println("\n MENU DE RELATÓRIOS");
        System.out.println("\n ======================\n");

        System.out.println("1 - Relatório de despesas");
        System.out.println("2 - Relatório de um veículo individual");
        System.out.println("3 - Relatório da frota");
        System.out.println("0 - Voltar ao menu principal");
        num = sc.nextInt();

        switch (num) {
            case 1:
                // fazer relatorio despesas
                break;
            case 2:
                // veiculo.
                break;
            case 3:
                // relatorio toString frota
            case 0:
                limparTela();
                abrirApp();
            default:
                System.out.println("Valor inválido");
                break;
        }
    }
    // #endregion

    public static void main(String[] args) throws Exception {

        abrirApp();

        // menuVeiculo(sc.nextInt());

        // Crie um objeto de frota
        // Frota frota = new Frota();

        // Crie alguns veículos
        // Tanque tanque1 = new Tanque(50.0, 60.0);
        // Veiculo veiculo1 = new Veiculo("ABC123", 0, tanque1);

        // Tanque tanque2 = new Tanque(50.0, 60.0);
        // Veiculo veiculo2 = new Veiculo("BC123", 0, tanque2);

        // // Registre algumas rotas
        // Rota rota1 = new Rota(100.0, new Date());
        // Rota rota2 = new Rota(110.0, new Date());
        // // Registre algumas rotas
        // Rota rota3 = new Rota(10.0, new Date());
        // Rota rota4 = new Rota(110.0, new Date());

        // // Adicioanr Rota no respectivo veiculo
        // veiculo1.addRota(rota1);
        // veiculo1.addRota(rota2);

        // // Adicionando Rota no respectivo veiculo
        // veiculo2.addRota(rota3);
        // veiculo2.addRota(rota4);

        // // Adicione os veículos à frota
        // frota.addVeiculo(veiculo1);
        // frota.addVeiculo(veiculo2);

        // veiculo1.percorrerRota(rota1);

        // System.out.println(frota.maiorKmMedia().getPlaca());

        // System.out.println(frota.maiorKmTotal().getPlaca());

        // Adicionar veiculo (param = placa);
        // Criar rota (param= quilometragem e data)
        // Adicionar rota em determinado veiculo (void ou boolea)
        // localizar veiculo e imprimir seus respectivos dados (retorna String)

    }

}
