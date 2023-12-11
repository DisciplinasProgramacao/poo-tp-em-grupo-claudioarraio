public class TesteFrotas {

    public static void main(String[] args) {
        Frota frota = new Frota();

        // Adicione alguns veículos
        Tanque tanque1 = new Tanque(50.0, 60.0);
        Veiculo veiculo1 = new Veiculo("ABC123", 3, tanque1, 100.0);
        frota.addVeiculo(veiculo1);

        Tanque tanque2 = new Tanque(40.0, 60.0);
        Veiculo veiculo2 = new Veiculo("XYZ789", 5, tanque2, 80.0);
        frota.addVeiculo(veiculo2);

        // Salve os veículos no arquivo
        frota.salvarNoArquivo("codigo\\Util\\Frota");

        // Limpe a lista atual de veículos (apenas para fins de teste)
        //frota.getVeiculos().clear();

        // Carregue os veículos do arquivo
        frota.carregarDoArquivo("codigo\\Util\\Frota");

        // Exiba a lista de veículos carregada
        System.out.println("Veículos carregados do arquivo:");
        for (Veiculo veiculo : frota.getVeiculos()) {
            System.out.println("Placa: " + veiculo.getPlaca());
            System.out.println("Quantidade de Rotas: " + veiculo.getQuantRotas());
            System.out.println("Total Reabastecido: " + veiculo.getTotalReabastecido());
            System.out.println("Tanque Capacidade Atual: " + veiculo.getTanque().getCapacidadeAtual());
            System.out.println("Tanque Capacidade Máxima: " + veiculo.getTanque().getCapacidadeMax());
            System.out.println();
        }
    }
}
