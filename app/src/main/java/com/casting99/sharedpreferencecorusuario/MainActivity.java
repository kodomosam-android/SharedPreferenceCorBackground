package com.casting99.sharedpreferencecorusuario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonSelecionado;
    private Button botaoSalvar;
    private ConstraintLayout layout;
    private static final String ARQUIVO_PREFERENCIA = "ArqPreference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroupId);
        botaoSalvar = (Button)findViewById(R.id.botaoSalvar);
        layout = (ConstraintLayout)findViewById(R.id.idLayout);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();

                if(idRadioButtonEscolhido > 0){

                    radioButtonSelecionado = (RadioButton)findViewById(idRadioButtonEscolhido);

                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    String corEscolhida = radioButtonSelecionado.getText().toString();
                    editor.putString("corEscolhida", corEscolhida);
                    editor.commit();

                    setBackgound(corEscolhida);

                }

            }
        });

        //recupera a cor escolhida
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if(sharedPreferences.contains("corEscolhida")){
            String corRecuperada = sharedPreferences.getString("corEscolhida","Laranja");
            setBackgound(corRecuperada);
        }

    }

    private void setBackgound(String cor){

        if(cor.equals("Azul")){
            layout.setBackgroundColor(Color.parseColor("#495b7c"));
        }else if(cor.equals("Laranja")){
            layout.setBackgroundColor(Color.parseColor("#ffce26"));
        }else if(cor.equals("Verde")){
            layout.setBackgroundColor(Color.parseColor("#009670"));
        }
    }

}
