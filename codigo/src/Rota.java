<<<<<<< Updated upstream
import java.util.Date;

public class Rota {
    private double quilometragem;
    private Date data;

    public Rota(double quilometragem, Date data) {
        this.quilometragem = quilometragem;
        this.data = data;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    @Override
    public String toString() { // Relatorio
        return "0.2";
    }

}
=======
import java.util.Date;

public class Rota {
    private double quilometragem;
    private Date data;

    public Date getData() {
        return data;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public Rota(double quilometragem, Date data) {
        this.quilometragem = quilometragem;
        this.data = data;
    }

    @Override
    public String toString() { // Relatorio
        return "0.2";
    }

}
>>>>>>> Stashed changes
