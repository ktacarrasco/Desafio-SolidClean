package cl.desafiolatam.solidclean.domain.repository;

import cl.desafiolatam.solidclean.domain.model.IndicadorEconomico;
        import io.reactivex.Observable;

public interface IIndicadorEconomicoRepository {
        Observable<IndicadorEconomico> getIndicadorEconomicoFromApiLayer(String tipoIndicador, String fechaIndicador);
}
