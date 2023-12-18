<<<<<<< HEAD
import java.util.ArrayList;

public class Frota {

    private int tamanhoFrota;
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    @Override
    public String toString() { // Relatorio
        for (Veiculo veiculo : veiculos){
        String teste= "Litros Abastecidos: "+veiculo.getTotalReabastecido()+"\nKm no Mes: "+veiculo.kmNoMes()+"\n Km total: "+veiculo.kmTotal();
        return teste;
        };
        return "Error";
    }


    public Veiculo localizarVeiculo(String placa) {

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo; // A placa foi encontrada
            }
        }
        System.out.println("Veiculo nao encontrado"); // TEMPORARIO
        return null;

    }

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

    public Double kmTotal() {

        Double kmTotal = 0.0;
        
        for (Veiculo veiculo : veiculos) {

            kmTotal += veiculo.kmTotal();
        }

        return kmTotal;
    }


    public void getVeiculos(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    // public Veiculo maiorKmMedia() {

    // }

}
=======
package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Frota {

    static Map<String, Veiculo> veiculos = new HashMap<String, Veiculo>();

    // #region Relatórios
    /**
     * Método de relatório String
     * 
     * @return Placa, dados de litros abastecidos, km total, quantidade de rotas, km
     *         no mês.
     */
    @Override
    public String toString() { // Método de relatório
        return veiculos.values().stream()
                .map(Veiculo::toString)
                .collect(Collectors.joining("------------------", "", ""));
    }

    // #endregion

    // #region Métodos de comparação

    /**
     * Método para encontrar o veículo com maior quilometragem total.
     */
    public Veiculo maiorKmTotal() {

        return veiculos.values().stream()
                .max(Comparator.comparing(veiculo -> kmTotal()))
                .orElse(null);

    }
    /**
     * Método para encontrar o veículo com a maior quilometragem média por rota
     */
    public Veiculo maiorKmMedia() {

        return veiculos.values().stream()
                .max(Comparator.comparing(veiculo -> kmTotal() / veiculo.quantRotas()))
                .orElse(null);
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
        veiculos.put(veiculo.getPlaca(), veiculo);
    }

    /**
     * Método para localizar um veículo por placa.
     * 
     * @param placa
     * @return veículo
     */

     public Veiculo localizarVeiculo(String placa) {
        // mudar esse metodo pra stream
        if(veiculos.get(placa)==null){
            throw new RuntimeException("aaaaaaaaa");
        }
        else
        return veiculos.get(placa);
    }


    public String addRota(String placa, Double km){

        return localizarVeiculo(placa).addRota(km);


    }

    public boolean veiculoExiste(String placa)throws IOException {
        boolean existe = false;
        if(veiculos.get(placa)!=null){
            existe = true;
        }
        return existe;
    }

    public void abastecer(String placa){
        localizarVeiculo(placa).abastecer();
    }

    // #endregion

    // #region Métodos de Calculos
    /**
     * Método para calcular a quilometragem total de todos os veículos na frota.
     */
    public Double kmTotal() {
        return veiculos.values().stream()
                .mapToDouble(veiculo -> veiculo.kmTotal()) // Substitua isso pelo método real
                .sum();
    }

    // #endregion

}
>>>>>>> ultimo
