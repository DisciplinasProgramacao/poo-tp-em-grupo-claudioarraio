import java.util.ArrayList;

public class Frota {

    private int tamanhoFrota;
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    @Override
    public String toString() { // Relatorio
        return "0.2";
    }

    public Veiculo localizarVeiculo(String placa) {

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo; // A placa foi encontrada
            }
        }
        System.out.println("Veiculo nao encontrado"); // TEMP
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

    // public Veiculo maiorKmMedia() {

    // }

}
