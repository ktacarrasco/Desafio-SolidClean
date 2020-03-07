package cl.desafiolatam.solidclean.domain.model;

public class SerieIndicadorEconomico {
    private String fecha;
    private double valor;

    public SerieIndicadorEconomico(String fecha, double valor) {
        super();
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
