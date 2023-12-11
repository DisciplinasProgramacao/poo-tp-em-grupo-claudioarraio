import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Frota {

    private int tamanhoFrota;
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    // #region Relatórios
    /**
     * Método de relatório String
     * 
     * @return Placa, dados de litros abastecidos, km total, quantidade de rotas, km
     *         no mês.
     */
    @Override
    public String toString() { // Método de relatório
        String relatorio = ""; // Inicializa a string de relatório
        for (Veiculo veiculo : veiculos) {
            relatorio += "\n--------------------------\n" +
                    "Placa: " + veiculo.getPlaca() + "\n Litros Abastecidos: " + veiculo.getTotalReabastecido() +
                    "\n Km Total: " + veiculo.kmTotal() + "\n Quantidade de Rotas: " + veiculo.getQuantRotas() +
                    "\n KM no Mês: " + veiculo.kmNoMes();
        }
        return relatorio;
    }

    // #endregion

    // #region Métodos de comparação
    /**
     * Método para encontrar o veículo com maior quilometragem total.
     */
    public Veiculo maiorKmTotal() {

        Tanque tanque = new Tanque(null, null);
        Veiculo maiorKm = new Veiculo("00", 0, tanque, null);

        for (Veiculo veiculo : veiculos) {
            if (veiculo.kmTotal() > maiorKm.kmTotal()) {
                maiorKm = veiculo;
            }
        }
        return maiorKm;
    }

    /**
     * Método para encontrar o veículo com a maior quilometragem média por rota
     */
    public Veiculo maiorKmMedia() {

        Double maiorMedia = 0.0;
        Double temp = 0.0;
        Tanque tanque1 = new Tanque(50.0, 60.0);
        Veiculo veiculo1 = new Veiculo("null", 0, tanque1, 0.0);
        for (Veiculo veiculo : veiculos) {
            temp = veiculo.kmTotal() / veiculo.getQuantRotas();
            if (temp > maiorMedia) {
                maiorMedia = temp;
                veiculo1 = veiculo;
            }
        }
        return veiculo1;
    }
    // #endregion

    // #region Manipulação de dados e pesquisa
    /**
     * 
     * Método para adicionar um veículo à frota
     * 
     * @param veiculo
     */
    public void addVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void salvarNoArquivo(String nomeArquivo) {
        try (PrintWriter escritor = new PrintWriter(nomeArquivo)) {
            for (Veiculo veiculo : veiculos) {
                escritor.println(
                        veiculo.getPlaca() + ";" +
                                veiculo.getQuantRotas() + ";" +
                                veiculo.getTanque().getCapacidadeAtual() + ";" +
                                veiculo.getTanque().getCapacidadeMax() + ";" +
                                veiculo.getTotalReabastecido());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }

    // Leitura de Arquivo:

    public void lerArqFrota() throws FileNotFoundException {
        File arqFrota = new File("codigo\\Util\\Frota");
        Scanner leitor = new Scanner(arqFrota, "UTF-8");
    
        while (leitor.hasNextLine()) {
            String linha = leitor.nextLine();
            String[] partes = linha.split(";"); // Separe os atributos por ponto e vírgula
    
            // Lê as informações da frota de veículos
            String placa = partes[0];
            int quantRotas = Integer.parseInt(partes[1]);
            Double capacidadeAtual = Double.parseDouble(partes[2]);
            Double capacidadeMax = Double.parseDouble(partes[3]);
            Double totalReabastecido = Double.parseDouble(partes[4]);
    
            // Crie o veículo e adicione-o à lista
            Tanque tanque = new Tanque(capacidadeAtual, capacidadeMax);
            Veiculo veiculo = new Veiculo(placa, quantRotas, tanque, totalReabastecido);
            veiculos.add(veiculo);

        }
    
        leitor.close();
    }
    

    /**
     * Método para localizar um veículo por placa.
     * 
     * @param placa
     * @return veículo
     */
    public Veiculo localizarVeiculo(String placa) {

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo; // A placa foi encontrada
            }
        }
        System.out.println("Veículo não encontrado"); // TEMPORÁRIO: Mensagem de erro
        return null;
    }

    // #endregion

    // #region Métodos de Calculos
    /**
     * Método para calcular a quilometragem total de todos os veículos na frota.
     */
    public Double kmTotal() {
        Double kmTotal = 0.0;

        for (Veiculo veiculo : veiculos) {
            kmTotal += veiculo.kmTotal();
        }

        return kmTotal;
    }

    public Veiculo[] getVeiculos() {
        return null;
    }

    // #endregion

}
