import java.util.Date;

public class Rota {
    private double quilometragem;
    private Date data;
    
//#region Construtor
    /**
     * Construtor da classe Rota.
     * 
     * @param quilometragem A quilometragem percorrida durante a rota.
     * @param data A data em que a rota foi realizada.
     */
    public Rota(double quilometragem, Date data) {
        this.quilometragem = quilometragem;
        this.data = data;
    }
//#endregion

//#region Getters e Setters
    /**
     * Obtém a data da rota.
     * @return A data da rota.
     */
    public Date getData() {
        return data;
    }

    /**
     * Obtém a quilometragem percorrida durante a rota.
     * @return A quilometragem da rota.
     */
    public double getQuilometragem() {
        return quilometragem;
    }
//#endregion

//#region Relatórios
    /**
     * Método de relatório String
     * @return Retorna um valor fixo como exemplo; pode ser personalizado para fornecer informações relevantes.
     */
    @Override
    public String toString() {
return "0.2";    

    }
//#endregion
}
