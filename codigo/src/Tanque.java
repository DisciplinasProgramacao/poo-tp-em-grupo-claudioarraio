package src;

public class Tanque {
    private Double capacidadeAtual;
    private Double capacidadeMax;
    private Double totalReabastecido;
    public Combustivel combustivel;

    // #region Construtores
    /**
     * Construtor da classe Tanque.
     * 
     * @param capacidadeAtual A capacidade atual do tanque em litros.
     * @param capacidadeMax   A capacidade máxima do tanque em litros.
     */
    public Tanque(Double capacidadeAtual, Double capacidadeMax, Combustivel tipoCombustivel) {
        this.capacidadeAtual = capacidadeAtual;
        this.capacidadeMax = capacidadeMax;
        this.totalReabastecido = 0d;
        this.combustivel = tipoCombustivel;
    }
    // #endregion

    // #region Métodos de Calculos
    /**
     * Abastece o tanque com a quantidade especificada de litros.
     * 
     * @param litros A quantidade de litros a ser abastecida.
     * @return A capacidade atual do tanque após o abastecimento.
     */

    public void abastecer() {
        double abs = capacidadeMax-capacidadeAtual;
        this.capacidadeAtual = capacidadeMax;
        this.totalReabastecido+=abs;
    }

    public boolean queimarCombustivel(double km){
        if(capacidadeAtual*combustivel.getConsumoMedio()>=km){
        capacidadeAtual -= km/combustivel.getConsumoMedio();
        return true;
    }
    else{
        return false;
    }

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


    public Double valorGastoCombustivel(){

        return totalReabastecido*combustivel.getPrecoMedio();


    }



    @Override
    public String toString() {

        return ", \n Combustivel: "+combustivel.toString()+", Total Reabastecido: "+totalReabastecido+", Total gasto em combustivel: R$"+valorGastoCombustivel();
    }

}