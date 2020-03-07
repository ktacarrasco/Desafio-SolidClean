package cl.desafiolatam.solidclean.presentation.presenter;

import cl.desafiolatam.solidclean.domain.interactor.GetIndicadorEconomicoUseCase;
import cl.desafiolatam.solidclean.domain.model.IndicadorEconomico;
import cl.desafiolatam.solidclean.presentation.model.IndicadorEconomicoModel;
import cl.desafiolatam.solidclean.presentation.model.mapper.IndicadorEconomicoModelMapper;
import cl.desafiolatam.solidclean.presentation.view.IIndicadorEconomicoView;

public class IndicadorEconomicoPresenter implements Presenter{

    private IIndicadorEconomicoView mIIndicadorEconomicoView;
    private final GetIndicadorEconomicoUseCase getIndicadorEconomicoUseCase;
    private final IndicadorEconomicoModelMapper indicadorEconomicoModelMapper;

    public IndicadorEconomicoPresenter(GetIndicadorEconomicoUseCase getIndicadorEconomicoUseCase,
                                       IndicadorEconomicoModelMapper indicadorEconomicoModelMapper){
        this.getIndicadorEconomicoUseCase = getIndicadorEconomicoUseCase;
        this.indicadorEconomicoModelMapper = indicadorEconomicoModelMapper;
    }

    public void bindIIndicadorEconomicoView(IIndicadorEconomicoView iIndicadorEconomicoView){
        this.mIIndicadorEconomicoView = iIndicadorEconomicoView;
    }

    @Override
    public void startConsulta(String tipoIndicador, String fechaIndicador){
        this.showLoading();
        String[] params = new String[2];
        params[0] = tipoIndicador;
        params[1] = fechaIndicador;
        this.getIndicadorEconomico(params);
    }

    @Override
    public void stopListeners() {
        this.getIndicadorEconomicoUseCase.dispose();
        this.mIIndicadorEconomicoView.hideLoadSpinner();
        this.mIIndicadorEconomicoView = null;
    }

    private void getIndicadorEconomico(String[] params) {
        this.getIndicadorEconomicoUseCase.execute(new IndicadorEconomicoObserverForPresenter(this), params);
    }

    public void showIndicadorEconomicoResponse(IndicadorEconomico indicadorEconomico) {
        this.hideLoading();
        final IndicadorEconomicoModel indicadorEconomicoModel =
                this.indicadorEconomicoModelMapper.transform(indicadorEconomico);
        this.mIIndicadorEconomicoView.showResponseIndicadorEconomico(indicadorEconomicoModel);
    }

    public void showLoading() {
        this.mIIndicadorEconomicoView.showLoadSpinner();
    }

    public void hideLoading() {
        this.mIIndicadorEconomicoView.hideLoadSpinner();
    }
}
