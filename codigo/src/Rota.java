package src;

import java.util.Date;

public class Rota {
    private double quilometragem;
    private Date data;

    // #region Construtor
    /**
     * Construtor da classe Rota.
     * 
     * @param quilometragem A quilometragem percorrida durante a rota.
     * @param data          A data em que a rota foi realizada.
     */
    public Rota(double quilometragem) {
        this.quilometragem = quilometragem;
        this.data = null;
    }
    // #endregion

    // #region Getters e Setters
    /**
     * Obtém a data da rota.
     * 
     * @return A data da rota.
     */
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Obtém a quilometragem percorrida durante a rota.
     * 
     * @return A quilometragem da rota.
     */
    public double getQuilometragem() {
        return quilometragem;
    }
    // #endregion

    // #region Relatórios
    /**
     * Método de relatório String
     * 
     * @return Retorna um valor fixo como exemplo; pode ser personalizado para
     *         fornecer informações relevantes.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("quilometragen:" + quilometragem);
        if (data != null)
            sb.append("Data de entrega" + data);
        else{
            sb.append("Ainda não entregue");
        }

        return sb.toString();
    }
    // #endregion
}
