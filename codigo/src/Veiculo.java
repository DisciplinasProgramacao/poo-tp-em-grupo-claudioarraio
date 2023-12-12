package src;

import java.util.*;
import java.time.LocalDate;

public class Veiculo implements IRepara {

    private static int MAX_ROTAS = 30;
    private ArrayList<Rota> rotas;
    private String placa;
    public Tanque tanque;
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
    public Veiculo(String placa, int numTipoVeiculo, int tipoCombustivel) {
        this.rotas = new ArrayList<Rota>();
        this.placa = placa;
        this.tipoVeiculo = TipoVeiculo.determinarVeiculo(numTipoVeiculo);
        this.tanque = new Tanque(0d, tipoVeiculo.getCapacidadeTanque(), Combustivel.tipoCombustivel(tipoCombustivel));
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
    public boolean addRota(Rota rota) {
        if (rotas.size() <= MAX_ROTAS) {
            rotas.add(rota);
            return true;
        }
        return false;
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
    public void percorrerRota(Rota rota) {

        tanque.queimarCombustivel(rota.getQuilometragem());
        rota.setData(new Date());
        verificarEstado();
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
        return "Veículo-->  Placa: " + placa + ", Tipo: " + tipoVeiculo + "kmTotal : " + kmTotal()
                + ", Trocou de pecas" + manutencaopecas + ", Manutencao Periodica:" + manutencaoperiodica
                + tanque.toString();
    }

}
