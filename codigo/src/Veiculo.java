<<<<<<< Updated upstream
import java.util.*;

public class Veiculo {
    private static int MAX_ROTAS = 30;
    private static double CONSUMO = 8.2;
    private String placa;
    private int quantRotas;
    private ArrayList<Rota> rotas = new ArrayList<Rota>();
    private Tanque tanque;

    private Double totalReabastecido;

    
    
    public Veiculo(String placa, int quantRotas, Tanque tanque, Double totalReabastecido) {
        this.placa = placa;
        this.quantRotas = quantRotas;
        this.tanque = tanque;
        this.totalReabastecido = totalReabastecido;
    }

    public String getPlaca() {
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

        return tanque.abastecer(litros);

    }

    public Double kmNoMes() {
        return 0.2;
    }

    public Double kmTotal() {
        return 0.2;
    }
    

    private void percorrerRota(Rota rota) {

        Double distPercorrida = rota.getQuilometragem();

    }

}
=======
import java.util.*;

public class Veiculo {
    private static int MAX_ROTAS = 30;
    private static double CONSUMO = 8.2;
    private String placa;
    private int quantRotas=0;
    private ArrayList<Rota> rotas = new ArrayList<Rota>();
    private Tanque tanque;
    private Double totalReabastecido;


    
    public Double getTotalReabastecido() {
        return totalReabastecido;
    }

    public Veiculo(String placa, int quantRotas, Tanque tanque, Double totalReabastecido) {
        this.placa = placa;
        this.quantRotas = quantRotas;
        this.tanque = tanque;
        this.totalReabastecido = totalReabastecido;
    }

    public String getPlaca() {
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

    public Double kmTotal() {
        Double quilometragemTotal = 0.0;

        for (Rota rota : rotas) {
            quilometragemTotal += rota.getQuilometragem();
        }

        return quilometragemTotal;
    }
     public int getQuantRotas() {
        return quantRotas;
    }
    

    private void percorrerRota(Rota rota) {

        
        Double distPercorrida = rota.getQuilometragem();

    }

}


//Placa:
//Litros abastecidos:
//Quantidade de rotas:
//KM no mes:
//KM total:
//Km media:

>>>>>>> Stashed changes
