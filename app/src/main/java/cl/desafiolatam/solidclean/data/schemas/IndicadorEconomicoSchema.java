package cl.desafiolatam.solidclean.data.schemas;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class IndicadorEconomicoSchema {

    @SerializedName("nombre")
    private String nombre;
    @SerializedName("unidad_medida")
    private String unidadMedida;
    @SerializedName("serie")
    private ArrayList<SerieIndicadorEconomicoSchema> serie;

    public IndicadorEconomicoSchema(String nombre, String unidadMedida, ArrayList<SerieIndicadorEconomicoSchema> serie){
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.serie = serie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public ArrayList<SerieIndicadorEconomicoSchema> getSerie() {
        return serie;
    }

    public void setSerie(ArrayList<SerieIndicadorEconomicoSchema> serie) {
        this.serie = serie;
    }
}
