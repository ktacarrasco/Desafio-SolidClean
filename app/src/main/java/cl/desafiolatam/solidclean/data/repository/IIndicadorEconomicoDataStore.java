package cl.desafiolatam.solidclean.data.repository;

import cl.desafiolatam.solidclean.data.schemas.IndicadorEconomicoSchema;
import io.reactivex.Observable;

public interface IIndicadorEconomicoDataStore {
    Observable<IndicadorEconomicoSchema> getIndicadorEconomicoDataSchema(String tipoIndicador, String fechaIndicador);
}
