package cl.desafiolatam.solidclean.presentation.presenter;

public interface Presenter {

    void startConsulta(String tipoIndicador, String fechaIndicador);
    void stopListeners();

}
