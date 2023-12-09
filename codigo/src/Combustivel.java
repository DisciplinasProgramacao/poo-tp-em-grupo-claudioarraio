import java.io.*;
import java.util.*;

public enum Combustivel {

	ALCOOL(7d,3.29),
	GASOLINA(10d,5.19),
	DIESEL(4d,6.09);

private Double consumoMedio;
private Double precoMedio;

 Combustivel(Double consumoMedio, Double precoMedio) {
    this.consumoMedio = consumoMedio;
    this.precoMedio = precoMedio;
}

public Double getConsumoMedio() {
    return consumoMedio;
}

public Double getPrecoMedio() {
    return precoMedio;
}

public Combustivel[] qualCombustivel(){

return values();

}



}


