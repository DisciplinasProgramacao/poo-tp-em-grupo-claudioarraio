public class Tanque {
    private static final Double CONSUMO = 8.2;
    private Double capacidadeAtual;
    private Double capacidadeMax;

    public Tanque(Double capacidadeAtual, Double capacidadeMax) {
        this.capacidadeAtual = capacidadeAtual;
        this.capacidadeMax = capacidadeMax;
    }

    public Double abastecer(Double litros) {

        capacidadeAtual += litros;

        return capacidadeAtual;

    }

    public Double autonomiaMaxima() {

        return this.capacidadeAtual * CONSUMO;

    }

    public Double autonomiaAtual() {
        return this.capacidadeAtual * CONSUMO;

    }

    public Double getCapacidadeAtual() {
        return this.capacidadeAtual;
    }

}
