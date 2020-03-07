package cl.desafiolatam.solidclean.domain.model;

import java.util.ArrayList;

public class IndicadorEconomico {

        private String nombre;
        private String unidadMedida;
        private ArrayList<SerieIndicadorEconomico> serie;

        public IndicadorEconomico(String nombre, String unidadMedida, ArrayList<SerieIndicadorEconomico> serie) {
            super();
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

        public void setUnidadMedida(String unidad_medida) {
            this.unidadMedida = unidad_medida;
        }

        public ArrayList<SerieIndicadorEconomico> getSerie() {
            return serie;
        }

        public void setSerie(ArrayList<SerieIndicadorEconomico> serie) {
            this.serie = serie;
        }
    }
