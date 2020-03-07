package cl.desafiolatam.solidclean.presentation.view;

import cl.desafiolatam.solidclean.presentation.model.IndicadorEconomicoModel;

public interface IIndicadorEconomicoView {

    void showResponseIndicadorEconomico(IndicadorEconomicoModel indicadorEconomicoModel);
    void showLoadSpinner();
    void hideLoadSpinner();
}
