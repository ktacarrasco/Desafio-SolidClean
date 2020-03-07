package cl.desafiolatam.solidclean.presentation.model.mapper;

import java.util.ArrayList;

import cl.desafiolatam.solidclean.domain.model.IndicadorEconomico;
import cl.desafiolatam.solidclean.presentation.model.IndicadorEconomicoModel;
import cl.desafiolatam.solidclean.presentation.model.SerieIndicadorEconomicoModel;

public class IndicadorEconomicoModelMapper {

    public IndicadorEconomicoModel transform(IndicadorEconomico indicadorEconomicoDomain){
        IndicadorEconomicoModel indicadorEconomico = null;
        try {
            if (indicadorEconomicoDomain != null) {
                SerieIndicadorEconomicoModel serieIndicadorEconomico = null;
                serieIndicadorEconomico = new SerieIndicadorEconomicoModel(indicadorEconomicoDomain.getSerie().get(0).getFecha(),
                        indicadorEconomicoDomain.getSerie().get(0).getValor());
                ArrayList<SerieIndicadorEconomicoModel> listSerieIndicadorEconomico = new ArrayList<SerieIndicadorEconomicoModel>();
                listSerieIndicadorEconomico.add(serieIndicadorEconomico);

                indicadorEconomico = new IndicadorEconomicoModel(indicadorEconomicoDomain.getNombre(),
                        indicadorEconomicoDomain.getUnidadMedida(),
                        listSerieIndicadorEconomico);
            }
        }catch (Exception e){
            return new IndicadorEconomicoModel("", "", null);
        }
        return indicadorEconomico;
    }
}
