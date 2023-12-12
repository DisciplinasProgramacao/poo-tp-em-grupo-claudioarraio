package src;

public class Tanque implements IAbastece{
    private Double capacidadeAtual;
    private Double capacidadeMax;
    private Double totalReabastecido;
    private Combustivel combustivel;

    // #region Construtores
    /**
     * Construtor da classe Tanque.
     * 
     * @param capacidadeAtual A capacidade atual do tanque em litros.
     * @param capacidadeMax   A capacidade máxima do tanque em litros.
     */
    public Tanque(Double capacidadeAtual, Double capacidadeMax, int valorTipo) {
        this.capacidadeAtual = capacidadeAtual;
        this.capacidadeMax = capacidadeMax;
        this.totalReabastecido = 0d;
        this.combustivel = tipoCombustivel().tipoCombustivel;
    }
    // #endregion

    // #region Métodos de Calculos
    /**
     * Abastece o tanque com a quantidade especificada de litros.
     * 
     * @param litros A quantidade de litros a ser abastecida.
     * @return A capacidade atual do tanque após o abastecimento.
     */
    public Double abastecer(Double litros) {
        if((this.capacidadeAtual + litros) > capacidadeMax){
            //exceção
        }
        capacidadeAtual += litros;
        return capacidadeAtual;
    }

    public void queimarCombustivel(double km){
        capacidadeAtual -= km/combustivel.getConsumoMedio();
    }

    /**
     * Calcula a autonomia máxima do veículo com base na capacidade atual do tanque
     * e no consumo médio.
     * 
     * @return A autonomia máxima do veículo em quilômetros.
     */
    public Double autonomiaMaxima() {
        return this.capacidadeMax * combustivel.getConsumoMedio();
    }

    /**
     * Calcula a autonomia atual do veículo com base na capacidade atual do tanque e
     * no consumo médio.
     * 
     * @return A autonomia atual do veículo em quilômetros.
     */
    public Double autonomiaAtual() {
        return this.capacidadeAtual * combustivel.getConsumoMedio();
    }

    // #endregion
    public Double getTotalReabastecido() {
        return totalReabastecido;
    }

    /**
     * Obtém a capacidade atual do tanque.
     * 
     * @return A capacidade atual do tanque em litros.
     */
    public Double getCapacidadeAtual() {
        return this.capacidadeAtual;
    }
}