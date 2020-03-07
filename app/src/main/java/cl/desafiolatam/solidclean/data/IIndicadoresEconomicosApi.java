package cl.desafiolatam.solidclean.data;

import cl.desafiolatam.solidclean.data.schemas.IndicadorEconomicoSchema;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IIndicadoresEconomicosApi {
        @GET("{tipoIndicador}/{fechaIndicador}")
        Observable<IndicadorEconomicoSchema> getIndicadorEconomico(@Path("tipoIndicador") String tipoIndicador, @Path("fechaIndicador") String fechaIndicador);
}
