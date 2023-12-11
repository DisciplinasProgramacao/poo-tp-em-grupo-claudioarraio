public class Tanque {
    private static final Double CONSUMO = 8.2;
    private Double capacidadeAtual;
    private Double capacidadeMax;

    // #region Construtores
    /**
     * Construtor da classe Tanque.
     * 
     * @param capacidadeAtual A capacidade atual do tanque em litros.
     * @param capacidadeMax   A capacidade máxima do tanque em litros.
     */
    public Tanque(Double capacidadeAtual, Double capacidadeMax) {
        this.capacidadeAtual = capacidadeAtual;
        this.capacidadeMax = capacidadeMax;
    }

    /**
     * Obtém a capacidade atual do tanque.
     * 
     * @return A capacidade atual do tanque em litros.
     */
    public Double getCapacidadeAtual() {
        return this.capacidadeAtual;
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
        capacidadeAtual += litros;
        return capacidadeAtual;
    }

    /**
     * Calcula a autonomia máxima do veículo com base na capacidade atual do tanque
     * e no consumo médio.
     * 
     * @return A autonomia máxima do veículo em quilômetros.
     */
    public Double autonomiaMaxima() {
        return this.capacidadeAtual * CONSUMO;
    }

    /**
     * Calcula a autonomia atual do veículo com base na capacidade atual do tanque e
     * no consumo médio.
     * 
     * @return A autonomia atual do veículo em quilômetros.
     */
    public Double autonomiaAtual() {
        return this.capacidadeAtual * CONSUMO;
    }
    //#endregion

    public String getCapacidadeMax() {
        return null;
    }

}
