

import java.util.*;
import java.time.LocalDate;

public class Veiculo implements IRepara {

    private static int MAX_ROTAS = 30;
    private static final Double valorManutencaoPecas = 150d;
        private static final Double valorManutencaoPeriodica = 100d;
    private ArrayList<Rota> rotas;
    private String placa;
    private Tanque tanque;
    int manutencaopecas = 0;
    int manutencaoperiodica = 0;
    public TipoVeiculo tipoVeiculo;

    // #region Construtores
    /**
     * Construtor da classe Veiculo.
     * 
     * @param placa           A placa do veículo
     * @param numTipoVeiculo
     * @param TipoCombustivel
     */
    public Veiculo(String placa, TipoVeiculo veiculo, Tanque tanque) {
        this.rotas = new ArrayList<Rota>(MAX_ROTAS);
        this.placa = placa;
        this.tipoVeiculo = veiculo;
        this.tanque = tanque;;
    }

    public int quantRotas() {
        return rotas.size();

    }

    // #endregion

    // #region Manipulação de Dados

    /**
     * Adiciona uma rota à lista de rotas do veículo, desde que haja autonomia
     * suficiente.
     * 
     * @param rota A rota a ser adicionada.
     * @return Verdadeiro se a rota foi adicionada com sucesso, falso se a autonomia
     *         não é suficiente.
     */
    public String addRota(Double km) {
        Rota rota = new Rota(km);
        StringBuilder aux = new StringBuilder();
        if (rotas.size() <= MAX_ROTAS) {
            if(tanque.autonomiaAtual()<rota.getQuilometragem()){
                abastecer();
            }
            rotas.add(rota);
            rota.setData(new Date());
            tanque.queimarCombustivel(rota.getQuilometragem());
            verificarEstado();
            aux.append("Sua rota foi adicionada com sucesso!");
        }
        aux.append("Sua rota nao pode ser adicionada!");
        return aux.toString();
    }

    public void abastecer(){
        this.tanque.abastecer();
    }
    // #endregion

    // #region Métodos de Cálculos

    /**
     * Calcula a quilometragem total percorrida pelo veículo.
     * 
     * @return A quilometragem total do veículo em quilômetros.
     */
    public Double kmTotal() {
        Double quilometragemTotal = 0.0;

        for (Rota rota : rotas) {
            quilometragemTotal += rota.getQuilometragem();
        }

        return quilometragemTotal;
    }

    /**
     * Calcula a quilometragem total percorrida pelo veículo no mês atual.
     * 
     * @return A quilometragem total do veículo no mês atual em quilômetros.
     */
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
    // #endregion

    /**
     * Método publico para percorrer uma rota (não usado no código atual).
     * 
     * @param rota A rota a ser percorrida.
     */
    public Rota localizarRota(int ID) {
        for (Rota rota : rotas) {
            if (rota.getID() == ID) {
                return rota; // Retorna a rota se o ID correspondente for encontrado
            }
        }
        return null; // Retorna null se a rota não for encontrada
    }

    public String relatorioRotas() {

        StringBuilder sb = new StringBuilder();

        for (Rota rota : rotas) {
            sb.append(rota.toString());
        }
        return sb.toString();
    }

    @Override
    public void manutencaoPeriodica() {
        manutencaoperiodica += 1;
    }

    @Override
    public void ManutencaoPeca() {
        manutencaopecas += 1;
    }

    @Override
    public boolean verificarEstado() {
        if (kmTotal() >= manutencaoperiodica + 1 * tipoVeiculo.getManutencaoPeriodica()) {
            manutencaoPeriodica();
            return true;
        } else if (kmTotal() >= manutencaopecas + 1 * tipoVeiculo.getManutencaoPecas()) {
            ManutencaoPeca();
            return true;

        }
        return false;
    }

    // #region Getters e Setters

    public String getPlaca() {
        return placa;
    }

    public Tanque getTanque() {
        return tanque;
    }

    // #endregion

    @Override
    public String toString() {
        return " ==================================\n\nPlaca do Veículo: " + placa + ", Tipo: " + tipoVeiculo + " \n" +
                "KM Total : " + kmTotal()
                + "\n Custo Manutencao de pecas: " + manutencaopecas*valorManutencaoPecas +" vezes" + ", Custo Manutencao Periodica: " + manutencaoperiodica*valorManutencaoPecas
                + tanque.toString() + "\n" + "\nROTAS: \n"+relatorioRotas(); 
    }




}