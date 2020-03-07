package cl.desafiolatam.solidclean.data.repository;

import cl.desafiolatam.solidclean.data.schemas.IndicadorEconomicoSchema;
import cl.desafiolatam.solidclean.data.schemas.mapper.IndicadorEconomicoMapper;
import cl.desafiolatam.solidclean.domain.model.IndicadorEconomico;
import cl.desafiolatam.solidclean.domain.repository.IIndicadorEconomicoRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class IndicadoresEconomicosDataRepository implements IIndicadorEconomicoRepository {
    private final IndicadorEconomicoNubeDataStore indicadorEconomicoNubeDataStore;
    private final IndicadorEconomicoMapper indicadorEconomicoMapper;

    public IndicadoresEconomicosDataRepository(IndicadorEconomicoNubeDataStore indicadorEconomicoNubeDataStore,
                                               IndicadorEconomicoMapper indicadorEconomicoMapper){
        this.indicadorEconomicoNubeDataStore = indicadorEconomicoNubeDataStore;
        this.indicadorEconomicoMapper = indicadorEconomicoMapper;
    }

    @Override
    public Observable<IndicadorEconomico> getIndicadorEconomicoFromApiLayer(String tipoIndicador, String fechaIndicador){

        return indicadorEconomicoNubeDataStore
                .getIndicadorEconomicoDataSchema(tipoIndicador, fechaIndicador)
                .map(new Function<IndicadorEconomicoSchema, IndicadorEconomico>() {

                @Override
                public IndicadorEconomico apply(IndicadorEconomicoSchema indicadorEconomicoSchema) throws Exception {
                    return indicadorEconomicoMapper.transform(indicadorEconomicoSchema);
                }
            });
    }
}
