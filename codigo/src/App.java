import java.time.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        // Crie um objeto de frota
        Frota frota = new Frota();

        // Crie alguns veículos
        Tanque tanque1 = new Tanque(50.0, 60.0);
        Veiculo veiculo1 = new Veiculo("ABC123", 0, tanque1, 0.0);

        // Adicione os veículos à frota
        frota.getVeiculos(veiculo1);

        // Registre algumas rotas
        Rota rota1 = new Rota(100.0, new Date());
        Rota rota2 = new Rota(100.0, new Date());

        // Adicione as rotas aos veículos
        veiculo1.addRota(rota1);
        veiculo1.addRota(rota2);

        veiculo1.abastecer(20.0);

        // Teste os métodos da frota e dos veículos
        System.out.println("Relatório da Frota:");
        System.out.println(frota);

        
    }

}
