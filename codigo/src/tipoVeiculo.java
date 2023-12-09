import java.io.*;
import java.util.*;

public enum tipoVeiculo {

	CARRO(50d,10000d,10000d),
	VAN(60d,10000d,12000d),
	FURGAO(80d,10000d,12000d),
    CAMINHAO(250d,20000d,20000d);


private Double capacidadeTanque;
private Double manutencaoperiodica;
private Double manutencaoPecas;

tipoVeiculo (Double capacidadeTanque, Double manutencaoPeriodica,Double manutencaoPecas) {
    this.capacidadeTanque = capacidadeTanque;
    this.manutencaoperiodica = manutencaoperiodica;
     this.manutencaoPecas = manutencaoPecas;
}

 public Double getCapacidadeTanque() {
    return capacidadeTanque;
}


public Double getManutencaoPeriodica() {
    return manutencaoperiodica;
}


public Double getManutencaoPecas() {
    return manutencaoPecas;
}










}



