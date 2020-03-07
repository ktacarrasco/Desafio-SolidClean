package cl.desafiolatam.solidclean.presentation.presenter;

import cl.desafiolatam.solidclean.domain.model.IndicadorEconomico;
import io.reactivex.observers.DisposableObserver;

public class IndicadorEconomicoObserverForPresenter extends DisposableObserver<IndicadorEconomico> {

    private IndicadorEconomicoPresenter indicadorEconomicoPresenter;

            public IndicadorEconomicoObserverForPresenter(IndicadorEconomicoPresenter indicadorEconomicoPresenter) {
                this.indicadorEconomicoPresenter = indicadorEconomicoPresenter;
            }

        @Override public void onComplete(){
            indicadorEconomicoPresenter.hideLoading();
        }

        @Override public void onError(Throwable e) {
            e.printStackTrace();
            indicadorEconomicoPresenter.hideLoading();
        }

        @Override public void onNext(IndicadorEconomico indicadorEconomico) {
            indicadorEconomicoPresenter.showIndicadorEconomicoResponse(indicadorEconomico);
        }
}
