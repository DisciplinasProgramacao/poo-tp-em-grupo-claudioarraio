import java.util.ArrayList;

public class Frota {

    private int tamanhoFrota;
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    @Override
    public String toString() { // Relatorio
        String teste="";
        for (Veiculo veiculo : veiculos) {
            teste +="\n--------------------------\n"+ 
            "Placa: " +veiculo.getPlaca()  + "\n Litros Abastecido: " +veiculo.getTotalReabastecido() + 
            "\n Km total: " + veiculo.kmTotal()+ "\n Quantidade de rotas: " +veiculo.getQuantRotas() +"\n KM no mes:"+veiculo.kmNoMes();
        }
       return teste;
    }


    //Placa:

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

    public Double kmTotal() { // kmTotal

        Double kmTotal = 0.0;

        for (Veiculo veiculo : veiculos) {

            kmTotal += veiculo.kmTotal();

        }

        return kmTotal;
    }

    public void addVeiculos(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public Veiculo maiorKmMedia() {

        Double maiorMedia = 0.0;
        Double temp = 0.0;
        Tanque tanque1 = new Tanque(50.0, 60.0);
        Veiculo veiculo1 = new Veiculo("null", 0, tanque1, 0.0);
        for (Veiculo veiculo : veiculos) {
            temp = veiculo.kmTotal() / veiculo.getQuantRotas();
            if (temp > maiorMedia) {
                maiorMedia = temp;
                veiculo1 = veiculo;
            }
        }
                    return veiculo1;
    }

}
