package cl.desafiolatam.solidclean.data.repository;

import cl.desafiolatam.solidclean.data.IndicadoresEconomicosService;
import cl.desafiolatam.solidclean.data.schemas.IndicadorEconomicoSchema;
import io.reactivex.Observable;

public class IndicadorEconomicoNubeDataStore implements IIndicadorEconomicoDataStore{

    @Override
    public Observable<IndicadorEconomicoSchema> getIndicadorEconomicoDataSchema(String tipoIndicador, String fechaIndicador) {
        return IndicadoresEconomicosService.getIndicadoresEconomicosService()
                .getIndicadorEconomico(tipoIndicador, fechaIndicador);
    }
}
