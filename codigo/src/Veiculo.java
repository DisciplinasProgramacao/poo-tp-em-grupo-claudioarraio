import java.util.*;

public class Veiculo {
    private static int MAX_ROTAS = 30;
    private static double CONSUMO = 8.2; 
    private String placa;
    private int quantRotas = 0;
    private ArrayList<Rota> rotas = new ArrayList<Rota>();
    private Tanque tanque;
    private Double totalReabastecido;

    public Double getTotalReabastecido() {
        return totalReabastecido;
    }
//#region Construtores 
    /**
     * Construtor da classe Veiculo.
     * 
     * @param placa             A placa do veículo.
     * @param quantRotas        A quantidade de rotas realizadas pelo veículo.
     * @param tanque            O tanque do veículo.
     * @param totalReabastecido O total de litros reabastecidos no veículo.
     */
    public Veiculo(String placa, int quantRotas, Tanque tanque, Double totalReabastecido) {
        this.placa = placa;
        this.quantRotas = quantRotas;
        this.tanque = tanque;
        this.totalReabastecido = totalReabastecido;
    }
//#endregion

//#region Getters e Setters

    public String getPlaca() {
        return placa;
    }

    public Tanque getTanque() {
        return tanque;
    }
    
    public int getQuantRotas() {
        return quantRotas;
    }
//#endregion

//#region Manipulação de Dados

    /**
     * Adiciona uma rota à lista de rotas do veículo, desde que haja autonomia
     * suficiente.
     * 
     * @param rota A rota a ser adicionada.
     * @return Verdadeiro se a rota foi adicionada com sucesso, falso se a autonomia
     *         não é suficiente.
     */
    public boolean addRota(Rota rota) {
        if (autonomiaAtual() >= rota.getQuilometragem()) {
            rotas.add(rota);
            return true;
        }
        return false;
    }
//#endregion

//#region Métodos de Cálculos
    /**
     * Calcula a autonomia máxima do veículo com base no tanque atual e no consumo médio.
     * 
     * @return A autonomia máxima do veículo em quilômetros.
     */
    private Double autonomiaMaxima() {
        return tanque.autonomiaMaxima();
    }

    /**
     * Calcula a autonomia atual do veículo com base no tanque atual e no consumo
     * médio.
     * 
     * @return A autonomia atual do veículo em quilômetros.
     */
    private Double autonomiaAtual() {
        return this.tanque.autonomiaAtual();
    }

    /**
     * Calcula a quilometragem total percorrida pelo veículo.
     * 
     * @return A quilometragem total do veículo em quilômetros.
     */
    public Double kmTotal() {
        Double quilometragemTotal = 0.0;

        for (Rota rota : rotas) {
            quilometragemTotal += rota.getQuilometragem();
        }

        return quilometragemTotal;
    }

    /**
     * Calcula a quilometragem total percorrida pelo veículo no mês atual.
     * 
     * @return A quilometragem total do veículo no mês atual em quilômetros.
     */
    public Double kmNoMes() {
        Calendar calAtual = Calendar.getInstance();
        Double quilometragemMes = 0.0;

        for (Rota rota : rotas) {
            Calendar calRota = Calendar.getInstance();
            calRota.setTime(rota.getData());

            if (calAtual.get(Calendar.MONTH) == calRota.get(Calendar.MONTH)) {
                quilometragemMes += rota.getQuilometragem();
            }
        }

        return quilometragemMes;
    }
//#endregion

    /**
     * Abastece o veículo com a quantidade especificada de litros.
     * 
     * @param litros A quantidade de litros a ser abastecida.
     * @return A capacidade atual do tanque após o abastecimento.
     */
    public Double abastecer(Double litros) {
        this.totalReabastecido += litros;
        return tanque.abastecer(litros);
    }

    /**
     * Método privado para percorrer uma rota (não usado no código atual).
     * 
     * @param rota A rota a ser percorrida.
     */
    private void percorrerRota(Rota rota) {
        Double distPercorrida = rota.getQuilometragem();
    }
}

// Placa:
// Litros abastecidos:
// Quantidade de rotas:
// KM no mes:
// KM total:
// Km media:
