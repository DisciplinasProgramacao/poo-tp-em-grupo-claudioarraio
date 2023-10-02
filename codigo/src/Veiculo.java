import java.util.*;

public class Veiculo {
    private static int MAX_ROTAS = 30;
    private static double CONSUMO = 8.2;
    private static String placa;
    private int quantRotas;
    private static ArrayList<Rota> rotas = new ArrayList<Rota>();
    private Tanque tanque;
    private static Double totalReabastecido;


    
    public static Double getTotalReabastecido() {
        return totalReabastecido;
    }

    public Veiculo(String placa, int quantRotas, Tanque tanque, Double totalReabastecido) {
        this.placa = placa;
        this.quantRotas = quantRotas;
        this.tanque = tanque;
        this.totalReabastecido = totalReabastecido;
    }

    public static String getPlaca() {
        return placa;
    }
        public Tanque getTanque() {
        return tanque;
    }

    public boolean addRota(Rota rota) {

        if (autonomiaAtual() >= rota.getQuilometragem()) {
            rotas.add(rota);
            return true;
        }
        return false;
    }

    private Double autonomiaMaxima() {
        return tanque.autonomiaMaxima();
    }

    private Double autonomiaAtual() {

        return this.tanque.autonomiaAtual();

    }

    public Double abastecer(Double litros) {

        this.totalReabastecido+=litros;
        return tanque.abastecer(litros);

    }

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

     public static Double getKmNoMes() {
        return kmTotal();
    }

    public static Double kmTotal() {
        Double quilometragemTotal = 0.0;

        for (Rota rota : rotas) {
            quilometragemTotal += rota.getQuilometragem();
        }

        return quilometragemTotal;
    }
    
    public static Double getKmTotal() {
        return kmTotal();
    }

    private void percorrerRota(Rota rota) {

        Double distPercorrida = rota.getQuilometragem();

    }

}
