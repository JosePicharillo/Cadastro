package br.edu.ifsp.scl.sdm.cadastro;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormularioActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtTelefone;
    private EditText txtEmail;
    private CheckBox selecionadoCb;
    private RadioButton radioMasc;
    private RadioButton radioFemin;
    private EditText txtCidade;
    private Spinner opcoesEstado;
    private Button buttonClean;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        declaracaoElementos();
        clickButtonSave();
        clickButtonClean();
    }

    /**
     * Declaração dos elementos da view
     */
    private void declaracaoElementos() {
        txtNome = findViewById(R.id.editText_nome_completo);
        txtTelefone = findViewById(R.id.editText_telefone);
        txtEmail = findViewById(R.id.editText_email);
        selecionadoCb = findViewById(R.id.comboBox_list_email);
        radioMasc = findViewById(R.id.radio_masc);
        radioFemin = findViewById(R.id.radio_femin);
        txtCidade = findViewById(R.id.editText_cidade);
        opcoesEstado = findViewById(R.id.opcoes_uf);
    }

    /**
     * Ação que será feita se clicar no botão "Salvar"
     */
    private void clickButtonSave() {
        buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(v -> {

            StringBuilder sb = new StringBuilder();

            sb.append(txtNome.getText().toString());
            sb.append('\n');

            sb.append(txtTelefone.getText().toString());
            sb.append('\n');

            sb.append(txtEmail.getText().toString());
            sb.append('\n');

            sb.append(selecionadoCb.isChecked() ? "E-mail Adicionado" : "E-mail Não Adicionado");
            sb.append('\n');

            sb.append(radioMasc.isChecked() ? "Masculino" : "Feminino");
            sb.append('\n');

            sb.append(txtCidade.getText().toString());
            sb.append('\n');

            sb.append(((TextView) opcoesEstado.getSelectedView()).getText());
            sb.append('\n');

            Toast.makeText(FormularioActivity.this,
                    sb.toString(),
                    Toast.LENGTH_SHORT).show();
        });
    }

    /**
     * Ação que será feita se clicar no botão "Limpar"
     */
    private void clickButtonClean() {
        buttonClean = findViewById(R.id.button_clean);
        buttonClean.setOnClickListener(v -> {

            txtNome.getText().clear();
            txtTelefone.getText().clear();
            txtEmail.getText().clear();
            selecionadoCb.setChecked(false);
            radioMasc.setChecked(true);
            radioFemin.setChecked(false);
            txtCidade.getText().clear();
            opcoesEstado.setSelection(0);

            Toast.makeText(FormularioActivity.this,
                    "Os Campos Foram Limpos",
                    Toast.LENGTH_SHORT).show();
        });
    }

}