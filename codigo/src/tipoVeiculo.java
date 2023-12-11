package src;

public enum TipoVeiculo {

    CARRO(50d, 10000d, 10000d),
    VAN(60d, 10000d, 12000d),
    FURGAO(80d, 10000d, 12000d),
    CAMINHAO(250d, 20000d, 20000d);

    private Double capacidadeTanque;
    private Double manutencaoPeriodica;
    private Double manutencaoPecas;

    private TipoVeiculo(Double capacidadeTanque, Double manutencaoPeriodica, Double manutencaoPecas) {
        this.capacidadeTanque = capacidadeTanque;
        this.manutencaoPeriodica = manutencaoPeriodica;
        this.manutencaoPecas = manutencaoPecas;
    }

    public Double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public Double getManutencaoPeriodica() {
        return manutencaoPeriodica;
    }

    public Double getManutencaoPecas() {
        return manutencaoPecas;
    }

    static tipoVeiculo determinarVeiculo(int valor) {

        switch (valor) {
            case 1:
                return CARRO;
            case 2:
                return VAN;
            case 3:
                return FURGAO;
            case 4:
                return CAMINHAO;
            default:
                throw new IllegalArgumentException("Valor inválido para tipo de veículo");
        }

    }
}