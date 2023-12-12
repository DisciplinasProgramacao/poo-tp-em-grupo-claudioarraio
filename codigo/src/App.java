package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class App {

    private static Scanner teclado;
    private static Frota frota = new Frota();


    // #region criando comandos de limpeza e pausa
    static void pausa() {
        System.out.println("Enter para continuar.");
        teclado.nextLine();
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    // #endregion

    // #region criação da abertura de App e menus para que o usuário escolha através
    // do Scanner(teclado)

    private static TipoVeiculo obterTipoVeiculo(int tipo) {
        switch (tipo) {
            case 1:
                return TipoVeiculo.CARRO;
            case 2:
                return TipoVeiculo.VAN;
            case 3:
                return TipoVeiculo.FURGAO;
            case 4:
                return TipoVeiculo.CAMINHAO;

            default:
                throw new IllegalArgumentException("Tipo de veículo inválido !!!");
        }
    }

    private static Combustivel obterTipoCombustivel(int tipo) {

        return Combustivel.tipoCombustivel(tipo);
    }

    private static Veiculo criarVeiculo(String placa, int tipo, int tipoCombustivel) {
        TipoVeiculo tipoVeiculo = obterTipoVeiculo(tipo);
        Combustivel combustivel = obterTipoCombustivel(tipoCombustivel);

        if (tipoVeiculo != null) {
            Veiculo veiculo = new Veiculo(placa, tipoVeiculo, combustivel);
            String mensagem = frota.addVeiculo(veiculo); // Captura a mensagem da frota
            System.out.println(mensagem); // Imprime a mensagem
            return veiculo;
        }

        return null;
    }

    public static void menuVeiculo() throws FileNotFoundException {

        String nomeArq = "codigo\\Util\\menuVeiculo.txt";
        int opcao = -1;
        limparTela();
        opcao = menu(nomeArq);

        switch (opcao) {
            case 1 -> {
                limparTela();

                System.out.println("  🚛🛻  INFORME A PLACA DO VEÍCULO 🚚🚗");
                String placa = teclado.nextLine();
                nomeArq = "codigo\\Util\\tipoVeiculo.txt";
                opcao = menu(nomeArq);
                int tipo = opcao;
                nomeArq = "codigo\\Util\\tipoCombustivel.txt";
                opcao = menu(nomeArq);
                int combustivel = opcao;

                criarVeiculo(placa, tipo, combustivel);
                pausa();

            }
            case 2 -> {
                // Veiculo adiciona rota???     Veiculo.addRota();
            }
            case 3 -> {
                // Abastecer Veículo
            }
            case 4 ->{
                // Localizar veículo
            }
            case 5 -> {
                // Percorrer Rota
            }
        }
    }

    public static void menuRelatorio() throws FileNotFoundException {
        String nomeArq = "codigo\\Util\\relatorioVeiculo.txt";
        int opcao = -1;
        limparTela();
        opcao = menu(nomeArq);

        switch (opcao) {
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
                // abrirApp();
            default:
                System.out.println("Valor inválido");
                break;
        }
    }

    // #endregion
    /**
     * Método para montagem de menu. Lê as opções de um arquivo e as numera
     * automaticamente a partir de 1.
     * 
     * @param nomeArquivo Nome do arquivo texto com as opções (uma por linha)
     * @return Opção do usuário (int)
     * @throws FileNotFoundException em caso de arquivo não encontrado.
     */
    public static int menu(String nomeArquivo) throws FileNotFoundException {
        limparTela();
        File arqMenu = new File(nomeArquivo);
        Scanner leitor = new Scanner(arqMenu, "UTF-8");
        System.out.println(leitor.nextLine());
        System.out.println("==================================");
        int contador = 1;
        while (leitor.hasNextLine()) {
            System.out.println(contador + " - " + leitor.nextLine());
            contador++;
        }
        System.out.println("0 - Sair");
        System.out.print("\nSua opção: ");
        int opcao = Integer.parseInt(teclado.nextLine());
        leitor.close();
        return opcao;
    }

    // #endregion
    public static void main(String[] args) throws Exception {
        teclado = new Scanner(System.in);
        String nomeArq = "codigo\\Util\\appFrota.txt";
        int opcao = -1;
        while (opcao != 0) {
            limparTela();
            opcao = menu(nomeArq);
            switch (opcao) {
                case 1 -> menuVeiculo();
                case 2 -> menuRelatorio();
            }

        }
        System.out.println("VLW FLW OBG T+.");
        teclado.close();
    }
}
