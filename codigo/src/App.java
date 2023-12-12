package src;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
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

    public static void menuVeiculo() throws FileNotFoundException {

        String nomeArq = "C:\\Users\\Victor\\Desktop\\Faculdade\\POO\\TI\\poo-tp-em-grupo-claudioarraio\\codigo\\Util\\menuVeiculo.txt";
        int opcao = -1;
        limparTela();
        opcao = menu(nomeArq);

        switch (opcao) {
            case 1 -> {
                limparTela();

                System.out.println("  🚛🛻  INFORME A PLACA DO VEÍCULO 🚚🚗");
                String placa = teclado.nextLine();
                System.out.println(Combustivel.imprimirValoresComb());
                int tipo = teclado.nextInt();
                System.out.println(TipoVeiculo.imprimirValoresVeic());
                tipo = teclado.nextInt();
                int combustivel = opcao;
                Veiculo veiculo = new Veiculo(placa, tipo, combustivel);
                frota.addVeiculo(veiculo);

                pausa();

            }
            case 2 -> { // CADASTRAR ROTA

                // Crie alguns veículos
                System.out.println("🚛🛻 DIGITE A PLACA DO VEICULO 🚚🚗");
                String placa = teclado.nextLine();
                //frota.localizarVeiculo(teclado.nextLine());

                // ex se nao achar
               
                System.out.println("🚛🛻 INFORME A QUILOMETRAGEM 🚚🚗");
                Rota rota = new Rota(teclado.nextDouble());

                frota.localizarVeiculo(placa).addRota(rota);

            }
            case 3 -> {
                // Abastecer Veículo
                System.out.println("🚛🛻 DIGITE A PLACA DO VEICULO 🚚🚗");
                String placa = teclado.nextLine();
                frota.localizarVeiculo(placa);
                // lançar ex
                System.out.println("Informe a quantidade");
                Double litrosAbast = teclado.nextDouble();
                frota.localizarVeiculo(placa).tanque.abastecer(litrosAbast);
                pausa();
            }
            case 4 -> { 
             
                System.out.println("  🚛🛻  INFORME A PLACA DO VEÍCULO 🚚🚗");
                String placa = teclado.nextLine();
                try{
                    System.out.println(frota.localizarVeiculo(placa));
                    System.out.println("Digite o ID da rota: ");
                    
                    System.out.println(frota.localizarVeiculo(placa).percorrerRota(teclado.nextInt()));

                    System.out.println("Rota percorrida");
                    pausa();
                }
                catch(Exception IlegallArgumentException){
                    System.out.println("Erro");
                }

            }

            //default {
               // catch (IllegalArgumentException e) {
                   // opcao = -1;
                 //   System.out.println("Favor digitar apenas números.");
               //     pausa();
             //   }
           // }
        }
    }

    public static void menuRelatorio() throws FileNotFoundException {
        String nomeArq = "C:\\Users\\Victor\\Desktop\\Faculdade\\POO\\TI\\poo-tp-em-grupo-claudioarraio\\codigo\\Util\\relatorioVeiculo.txt";
        int opcao = -1;
        limparTela();
        opcao = menu(nomeArq);

        switch (opcao) {
            case 1:
                System.out.println("  🚛🛻  INFORME A PLACA DO VEÍCULO 🚚🚗");
                System.out.println(frota.localizarVeiculo(teclado.nextLine()).relatorioRotas());
                pausa();
                break;
            case 2: // Relatório do veículo individual
                System.out.println("  🚛🛻  INFORME A PLACA DO VEÍCULO 🚚🚗");
                System.out.println(frota.localizarVeiculo(teclado.nextLine()));
                pausa();
                break;
            case 3: // Relatório da Frota
                System.out.println(frota);
                pausa();
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
        int opcao;
       // try {
            opcao = Integer.parseInt(teclado.nextLine());    
        //} catch (NumberFormatException e) {
           // opcao = -1;
            //System.out.println("Favor digitar apenas valores validos.");
            //pausa();
        //}
        leitor.close();
        return opcao;
    }

    // #endregion
    public static void main(String[] args) throws Exception {
        teclado = new Scanner(System.in);
        String nomeArq = "C:\\Users\\Victor\\Desktop\\Faculdade\\POO\\TI\\poo-tp-em-grupo-claudioarraio\\codigo\\Util\\appFrota.txt";
        int opcao = 1;
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


//OQUE FAZER?
//
//1-Exceções  (alguns try catch)
//2-Formatar direitinho no terminal  (Os dados dos enumeradores, é pra ser chamado os enumeradores, só que esta usando um arquivo, desnecessario)
//3-PercorrerRota
//4-Manutenção
//

