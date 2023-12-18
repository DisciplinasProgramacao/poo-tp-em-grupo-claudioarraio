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
    

    public static String imprimirValoresVeic() {
        StringBuilder sb = new StringBuilder("Tipo de Veículo:\n");

        for (TipoVeiculo tipoVeiculo : values()) {
            sb.append(tipoVeiculo.ordinal() + 1).append("-").append(tipoVeiculo.name()).append("\n");
        }
        return sb.toString();
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

    

    
}
