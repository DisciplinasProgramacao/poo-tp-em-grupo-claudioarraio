
import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Demonstração do aplicativo de automatização de frotas.
 * Este programa nada mais faz além de testar algumas operações da classe.
 */
public class AppFrota {

    // #region utilidades

    static Scanner teclado;
    static NumberFormat formatMoeda = NumberFormat.getCurrencyInstance();
    static Frota frota = new Frota();

    /**
     * "Limpa" a tela (códigos de terminal VT-100)
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Pausa para leitura de mensagens em console
     * 
     * @param teclado Scanner de leitura
     */
    static void pausa() {
        System.out.println("Enter para continuar.");
        teclado.nextLine();
    }

    /**
     * Encapsula uma leitura de teclado, com mensagem personalizada. A mensagem
     * sempre é completada com ":". Retorna uma string
     * que pode ser posteriormente convertida.
     * 
     * @param mensagem A mensagem a ser exibida, sem pontuação final.
     * @return String lida do usuário.
     */
    public static String leitura(String mensagem) {
        System.out.print(mensagem + ": ");
        return teclado.nextLine();
    }

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
        System.out.println("==========================");
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
    public static Frota menuFrota() throws FileNotFoundException {
        String nomeArq = "codigo\\Util\\menuFrota";
        int opcao = -1;
        limparTela();
        opcao = menu(nomeArq);
        switch (opcao) {
            case 1 -> {
                System.out.println("Informe a Placa do Veículo:");
                // Adicione aqui a lógica para lidar com a opção 1, se necessário.
            }
            case 2 -> {
                // Certifique-se de que você está lendo a frota antes de imprimir.
                System.out.println(frota.toString()); // Imprime toda a lista de frotas.
                
            }
            default -> {
                System.out.println("Tipo de pedido inválido");
            }
        }
        pausa();
        return frota;
    }
    public static Frota relatorioFrota() throws FileNotFoundException {
        String nomeArq = "codigo\\Util\\relatorioFrota";
        int opcao = -1;
        limparTela();
        opcao = menu(nomeArq);
        switch (opcao) {
            case 1 -> {
                 System.out.println(frota.toString()); // Imprime toda a lista de frotas
            }
            
            default -> {
                System.out.println("Tipo de pedido inválido");
            }
        }
        pausa();
        return frota;
    }
        
       // #endregion

    public static void main(String[] args) throws Exception {
        frota.lerArqFrota(); 
        teclado = new Scanner(System.in);
        String nomeArq = "codigo\\Util\\menuInicio";
        int opcao = -1;
        while (opcao != 0) {
            limparTela();
            opcao = menu(nomeArq);
            switch (opcao) {
                 case 1 -> menuFrota();
                 case 2 -> relatorioFrota();
            }
        }
        System.out.println("VLW FLW OBG T+.");
        teclado.close();
    }
}
