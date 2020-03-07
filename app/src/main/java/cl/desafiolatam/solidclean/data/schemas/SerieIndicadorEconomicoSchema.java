package cl.desafiolatam.solidclean.data.schemas;

import com.google.gson.annotations.SerializedName;

public class SerieIndicadorEconomicoSchema {

    @SerializedName("fecha")
    private String fecha;
    @SerializedName("valor")
    private double valor;

    public SerieIndicadorEconomicoSchema(String fecha, double valor){
        this.fecha = fecha;
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
