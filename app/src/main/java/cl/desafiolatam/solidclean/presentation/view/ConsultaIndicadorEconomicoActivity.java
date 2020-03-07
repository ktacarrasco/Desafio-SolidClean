package cl.desafiolatam.solidclean.presentation.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import cl.desafiolatam.solidclean.R;
import cl.desafiolatam.solidclean.data.repository.IndicadorEconomicoNubeDataStore;
import cl.desafiolatam.solidclean.data.repository.IndicadoresEconomicosDataRepository;
import cl.desafiolatam.solidclean.data.schemas.mapper.IndicadorEconomicoMapper;
import cl.desafiolatam.solidclean.domain.interactor.GetIndicadorEconomicoUseCase;
import cl.desafiolatam.solidclean.presentation.model.IndicadorEconomicoModel;
import cl.desafiolatam.solidclean.presentation.model.mapper.IndicadorEconomicoModelMapper;
import cl.desafiolatam.solidclean.presentation.presenter.IndicadorEconomicoPresenter;

public class ConsultaIndicadorEconomicoActivity extends MainActivity implements IIndicadorEconomicoView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText tipoIndicador, fechaIndicador;
    private TextView resultadoConsulta;
    private IndicadorEconomicoPresenter mIndicadorEconomicoPresenter;
    private IndicadoresEconomicosDataRepository mIndicadoresEconomicosDataRepository;
    private IndicadorEconomicoNubeDataStore mIndicadorEconomicoNubeDataStore;
    private IndicadorEconomicoMapper mIndicadorEconomicoMapper;
    private GetIndicadorEconomicoUseCase mGetIndicadorEconomicoUseCase;
    private IndicadorEconomicoModelMapper mIndicadorEconomicoModelMapper;

    @Override
    public void showLoadSpinner() {
        resultadoConsulta.setText("");
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadSpinner() {
       progressBar.setVisibility(View.GONE);
    }

    @Override
    public int getContentLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    public void initializeComponentsForView(ProgressBar progressBar,
                                            EditText tipoIndicador,
                                            EditText fechaIndicador,
                                            Button btnConsultarIndicador,
                                            TextView resultadoConsulta) {
        this.progressBar = progressBar;
        this.tipoIndicador = tipoIndicador;
        this.fechaIndicador = fechaIndicador;
        this.resultadoConsulta = resultadoConsulta;
        btnConsultarIndicador.setOnClickListener(this);
        mIndicadorEconomicoModelMapper = new IndicadorEconomicoModelMapper();
        mIndicadorEconomicoMapper = new IndicadorEconomicoMapper();
        mIndicadorEconomicoNubeDataStore = new IndicadorEconomicoNubeDataStore();
        mIndicadoresEconomicosDataRepository = new IndicadoresEconomicosDataRepository(mIndicadorEconomicoNubeDataStore,
                                                                                        mIndicadorEconomicoMapper);
        mGetIndicadorEconomicoUseCase = new GetIndicadorEconomicoUseCase(mIndicadoresEconomicosDataRepository);
        mIndicadorEconomicoPresenter = new IndicadorEconomicoPresenter(mGetIndicadorEconomicoUseCase, mIndicadorEconomicoModelMapper);
        mIndicadorEconomicoPresenter.bindIIndicadorEconomicoView(this);
    }

    @Override
    public void showResponseIndicadorEconomico(IndicadorEconomicoModel indicadorEconomicoModel) {
        resultadoConsulta.setText(indicadorEconomicoModel.getSerie() != null ?
                indicadorEconomicoModel.getSerie().get(0).getValor()
                        + " "+indicadorEconomicoModel.getUnidadMedida()
                : "Fecha sin datos");
    }

    @Override
    public void onClick(View v) {
        mIndicadorEconomicoPresenter.startConsulta(tipoIndicador.getText().toString(), fechaIndicador.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIndicadorEconomicoPresenter.stopListeners();
    }
}
