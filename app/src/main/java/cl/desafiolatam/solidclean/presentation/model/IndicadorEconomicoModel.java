package cl.desafiolatam.solidclean.presentation.model;

import java.util.ArrayList;

public class IndicadorEconomicoModel {

        private String nombre;
        private String unidadMedida;
        private ArrayList<SerieIndicadorEconomicoModel> serie;

        public IndicadorEconomicoModel(String nombre, String unidadMedida, ArrayList<SerieIndicadorEconomicoModel> serie) {
            super();
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

        public void setUnidadMedida(String unidad_medida) {
            this.unidadMedida = unidad_medida;
        }

        public ArrayList<SerieIndicadorEconomicoModel> getSerie() {
            return serie;
        }

        public void setSerie(ArrayList<SerieIndicadorEconomicoModel> serie) {
            this.serie = serie;
        }

}
