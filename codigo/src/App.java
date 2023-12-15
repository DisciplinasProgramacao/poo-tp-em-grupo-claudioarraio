package src;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

import java.util.Date;
import java.security.InvalidAlgorithmParameterException;

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

    public static void menuVeiculo() throws IOException {

        String nomeArq = "/Users/carlosdaniel/Documents/GitHub/poo-tp-em-grupo-claudioarraio/codigo/Util/menuVeiculo.txt";
        int opcao = -1;
        limparTela();
        opcao = menu(nomeArq);
        String placa;
        switch (opcao) {
            case 1:
                try {
                    limparTela();
                    System.out.println("  🚛🛻  INFORME A PLACA DO VEÍCULO 🚚🚗");
                    placa = teclado.nextLine();

                    if (frota.veiculoExiste(placa)) {
                        System.out.println("Veículo já existe na frota.");
                        pausa();
                    } else {
                        System.out.println(Combustivel.imprimirValoresComb());
                        int tipo = teclado.nextInt();
                        Combustivel comb = Combustivel.values()[tipo - 1];
                        System.out.println(TipoVeiculo.imprimirValoresVeic());
                        tipo = teclado.nextInt();
                        TipoVeiculo veic = TipoVeiculo.values()[tipo - 1];
                        Tanque tanque = new Tanque(0d, veic.getCapacidadeTanque(), comb);
                        Veiculo veiculo = new Veiculo(placa, veic, tanque);
                        frota.addVeiculo(veiculo);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } finally {
                    pausa();
                }
                break;

            case 2: // CADASTRAR ROTA

                System.out.println("🚛🛻 DIGITE A PLACA DO VEICULO 🚚🚗");
                placa = teclado.nextLine();
                try {
                    if (!frota.veiculoExiste(placa)) {
                        throw new IllegalArgumentException("Erro, veiculo inexistente");

                    } else {
                        System.out.println("🚛🛻 INFORME A QUILOMETRAGEM 🚚🚗");
                        double km = teclado.nextDouble();
                        frota.addRota(placa, km);
                        System.out.println("Rota adicionada");
                        teclado.nextLine();
                        pausa();

                    }
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro ao adicionar a rota: " + e.getMessage());
                    pausa();
                }

                break;
        }

    }

    public static void menuRelatorio() throws FileNotFoundException {
        String nomeArq = "/Users/carlosdaniel/Documents/GitHub/poo-tp-em-grupo-claudioarraio/codigo/Util/relatorioVeiculo.txt";
        int opcao = -1;
        limparTela();
        opcao = menu(nomeArq);

        switch (opcao) {
            case 1: // Relatório do veículo individual
                System.out.println("  🚛🛻  INFORME A PLACA DO VEÍCULO 🚚🚗");
                System.out.println(frota.localizarVeiculo(teclado.nextLine()));
                pausa();
                break;
            case 2: // Relatório da Frota
                System.out.println(frota.toString());
                pausa();
                break;
            case 0:
                break;

            default:
                System.out.println("Favor digitar apenas valores validos");
                pausa();
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
        int opcao = -1;
        try {
            opcao = Integer.parseInt(teclado.nextLine());
        } catch (IllegalArgumentException e) {
            opcao = -1;
        } finally {

            // 0 1 2 3 4

            if (opcao > contador || opcao < 0)
                opcao = -1;
        }
        return opcao;
    }

    // #endregion
    public static void main(String[] args) throws Exception {
        teclado = new Scanner(System.in);
        String nomeArq = "/Users/carlosdaniel/Documents/GitHub/poo-tp-em-grupo-claudioarraio/codigo/Util/appFrota.txt";
        int opcao = 1;
        while (opcao != 0) {
            limparTela();
            opcao = menu(nomeArq);
            switch (opcao) {
                case 1:
                    menuVeiculo();
                    break;
                case 2:
                    menuRelatorio();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Favor digitar apenas valores validos");
                    pausa();
                    break;
            }

        }
        System.out.println("VLW FLW OBG T+.");
        teclado.close();
    }




}