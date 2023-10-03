import java.time.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        // Crie um objeto de frota
        Frota frota = new Frota();

        // Crie alguns veículos
        Tanque tanque1 = new Tanque(50.0, 60.0);
        Veiculo veiculo1 = new Veiculo("ABC123", 0, tanque1, 0.0);

        Tanque tanque2 = new Tanque(50.0, 60.0);
        Veiculo veiculo2 = new Veiculo("BC123", 0, tanque1, 0.0);

        // Registre algumas rotas
        Rota rota1 = new Rota(100.0, new Date());
        Rota rota2 = new Rota(110.0, new Date());
        // Criando outras rotas
        Rota rota3 = new Rota(10.0, new Date());
        Rota rota4 = new Rota(110.0, new Date());

        // Adicioanr Rota no respectivo veiculo
        veiculo1.addRota(rota1);
        veiculo1.addRota(rota2);

        // Adicionando Rota no respectivo veiculo
        veiculo2.addRota(rota3);
        veiculo2.addRota(rota4);

        // Adicione os veículos à frota
        frota.addVeiculos(veiculo1);
        frota.addVeiculos(veiculo2);

        // System.out.println(frota.maiorKmMedia().getPlaca());

        // System.out.println(frota.maiorKmTotal().getPlaca());

        // Adicionar veiculo (param = placa);
        // Criar rota (param= quilometragem e data)
        // Adicionar rota em determinado veiculo (void ou boolea)
        // localizar veiculo e imprimir seus respectivos dados (retorna String)

        System.out.println(frota);

    }

}
