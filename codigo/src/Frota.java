package src;

import java.util.ArrayList;

public class Frota {

    private int tamanhoFrota = 0;
    private static ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

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
                    "Placa: " + veiculo.getPlaca() + "\n Litros Abastecidos: " + veiculo.tanque.getTotalReabastecido() +
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
        Veiculo maiorKm = new Veiculo("00", 0, tanque);

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
        Veiculo veiculo1 = new Veiculo("null", 0, tanque1);
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
    public String addVeiculo(Veiculo veiculo) {

        if (veiculo != null) {
            veiculos.add(veiculo);
            tamanhoFrota += 1;
            return "Cadastro com sucesso!!! \n " + veiculo.toString();

        } else {
            return "Não é possível utilizar esse tipo de veículo!!!";

        }
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

    // #endregion

}
