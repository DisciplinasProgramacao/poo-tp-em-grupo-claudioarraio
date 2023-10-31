
import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Demonstração do aplicativo de automatização de frotas.
 * Este programa nada mais faz além de testar algumas operações da classe.
 */
public class AppFrota {

    static Scanner teclado;
    static NumberFormat formatMoeda = NumberFormat.getCurrencyInstance();

    // #region utilidades

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
    // #endregion

    //// #region métodos do app (encapsulam ações de usuário)

    // #endregion

    // #region submenus do App
    public static Frota menuFrota() throws FileNotFoundException {
        String nomeArq = "menuPedidos";
        int opcao = -1;
        limparTela();
        Frota novo = null;
        opcao = menu(nomeArq);
        switch (opcao) {
            case 1 -> {
                //novo = new veiculo();
            }
            case 2 -> {
               // double distancia = Double.parseDouble(leitura("Pedido para entrega. Digite a distância do local"));
               // novo = new PedidoDelivery(distancia);
            }
            default -> {
                System.out.println("Tipo de pedido inválido");
            }
        }
      //  novo = menuComidas(novo);
        return novo;

    }

    // #endregion

    public static void main(String[] args) throws Exception {
        teclado = new Scanner(System.in);
        String nomeArq = "codigo\\Util\\menuInicio";
        int opcao = -1;
        while (opcao != 0) {
            limparTela();
            opcao = menu(nomeArq);
            switch (opcao) {
               // case 1 -> pedidos.addElemento(menuPedido());
            }
        }
        System.out.println("VLW FLW OBG T+.");
        teclado.close();
    }
}
