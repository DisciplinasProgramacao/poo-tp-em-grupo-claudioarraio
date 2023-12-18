package src;

public enum Combustivel {

    ALCOOL(7d, 3.29),
    GASOLINA(10d, 5.19),
    DIESEL(4d, 6.09);

    private Double consumoMedio;
    private Double precoMedio;

    Combustivel(Double consumoMedio, Double precoMedio) {
        this.consumoMedio = consumoMedio;
        this.precoMedio = precoMedio;
    }

    public static String imprimirValoresComb() {
        StringBuilder sb = new StringBuilder(" Tipo do Combustivel:\n");

        for (Combustivel combustivel : values()) {
            sb.append(combustivel.ordinal() + 1).append("-").append(combustivel.name()).append("\n");
        }
        return sb.toString();
    }

    public Double getConsumoMedio() {
        return consumoMedio;
    }

    public Double getPrecoMedio() {
        return precoMedio;
    }

    public Combustivel[] qualCombustivel() {

        return values();

    }

    public static Combustivel tipoCombustivel(int valor) {
        if (valor == 1) {
            return Combustivel.ALCOOL;
        } else if (valor == 2) {
            return Combustivel.GASOLINA;
        } else if (valor == 3) {
            return Combustivel.DIESEL;
        } else
            throw new IllegalArgumentException("Valor inválido para tipo de combustível");

    }

}
