package cl.desafiolatam.solidclean.presentation.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import cl.desafiolatam.solidclean.R;

public abstract class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayoutView());

        ProgressBar progressBar = findViewById(R.id.progress);
        progressBar.setVisibility(View.INVISIBLE);
        EditText tipoIndicador = findViewById(R.id.idTipo);
        EditText fechaIndicador = findViewById(R.id.idFecha);
        Button consultarIndicador = findViewById(R.id.btnAction);
        TextView resultadoConsulta = findViewById(R.id.resultado);

        initializeComponentsForView(progressBar,
                tipoIndicador,
                fechaIndicador,
                consultarIndicador,
                resultadoConsulta);
    }

    public abstract int getContentLayoutView();

    public abstract void initializeComponentsForView(ProgressBar progressBar,
                                                     EditText tipoIndicador,
                                                     EditText fechaIndicador,
                                                     Button consultarIndicador,
                                                     TextView resultadoConsulta
                                                     );

}
