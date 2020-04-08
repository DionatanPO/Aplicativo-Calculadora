package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView display;
    TextView txtResultado;
    Button button0,  button1, button2; Button button3; Button button4; Button button5;
    Button button6; Button button7; Button button8; Button button9; Button button1Mais;
    Button buttonMenos; Button buttonDivisao; Button buttonMultiplicacao; Button buttonDeleta;
    Button buttonIgual; Button buttonPonto; Button buttonc1; Button buttonc2; Button btnRaiz;


    String texto = "";
    boolean operacao = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.textView);
        txtResultado = findViewById(R.id.textViewResultado);

        //verificacao da orientacao da tela
        Configuration configuration = getResources().getConfiguration();
        if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            buttonc1 = findViewById(R.id.buttonc1);
            buttonc1.setOnClickListener(this);
            buttonc2 = findViewById(R.id.buttonc2);
            buttonc2.setOnClickListener(this);
            btnRaiz = findViewById(R.id.buttonRaiz);
            btnRaiz.setOnClickListener(this);
        }


        button0 = findViewById(R.id.button0);
        button0.setOnClickListener(this);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);
        button9 = findViewById(R.id.button9);
        button9.setOnClickListener(this);
        button1Mais = findViewById(R.id.button1Mais);
        button1Mais.setOnClickListener(this);
        buttonDeleta = findViewById(R.id.buttonDelete);
        buttonDeleta.setOnClickListener(this);
        buttonDivisao = findViewById(R.id.buttonDivisao);
        buttonDivisao.setOnClickListener(this);
        buttonIgual = findViewById(R.id.buttonIgual);
        buttonIgual.setOnClickListener(this);
        buttonMenos = findViewById(R.id.buttonMenos);
        buttonMenos.setOnClickListener(this);
        buttonMultiplicacao = findViewById(R.id.buttonMultiplicacao);
        buttonMultiplicacao.setOnClickListener(this);
        buttonPonto = findViewById(R.id.buttonPonto);
        buttonPonto.setOnClickListener(this);

        //  acao longa no botao de deletar
        buttonDeleta.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                txtResultado.setText("");
                display.setText("");
                operacao = false;
                return false;
            }
        });


        if(savedInstanceState == null){

        }else{
            display.setText(savedInstanceState.getString("form"));
            txtResultado.setText(savedInstanceState.getString("result"));

        }

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("form",display.getText().toString());
        outState.putString("result",txtResultado.getText().toString());
    }



    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button0:
                display.setText(display.getText()+"0");
                if(operacao==true){
                    realizar_Calculo(display.getText().toString());
                }
                break;
            case R.id.button1:
                display.setText(display.getText()+"1");

                if(operacao==true){
                    realizar_Calculo(display.getText().toString());
                }

                break;
            case R.id.button2:
                display.setText(display.getText()+"2");
                if(operacao==true){
                    realizar_Calculo(display.getText().toString());
                }

                break;
            case R.id.button3:
                display.setText(display.getText()+"3");
                if(operacao==true){
                    realizar_Calculo(display.getText().toString());
                }
                break;
            case R.id.button4:
                display.setText(display.getText()+"4");
                if(operacao==true){
                    realizar_Calculo(display.getText().toString());
                }
                break;
            case R.id.button5:
                display.setText(display.getText()+"5");
                if(operacao==true){
                    realizar_Calculo(display.getText().toString());
                }
                break;
            case R.id.button6:
                display.setText(display.getText()+"6");
                if(operacao==true){
                    realizar_Calculo(display.getText().toString());
                }
                break;
            case R.id.button7:
                display.setText(display.getText()+"7");
                if(operacao==true){
                    realizar_Calculo(display.getText().toString());
                }
                break;
            case R.id.button8:
                display.setText(display.getText()+"8");
                if(operacao==true){
                    realizar_Calculo(display.getText().toString());
                }
                break;
            case R.id.button9:
                display.setText(display.getText()+"9");
                if(operacao==true){
                    realizar_Calculo(display.getText().toString());
                }
                break;
            case R.id.buttonPonto:
                display.setText(display.getText()+".");
                if(operacao==false){
                    operacao = true;
                }
                break;
            case R.id.button1Mais:
                display.setText(display.getText()+"+");
                if(operacao==false){
                    operacao = true;
                }
                break;
            case R.id.buttonMenos:
                display.setText(display.getText()+"-");
                if(operacao==false){
                    operacao = true;
                }
                break;
            case R.id.buttonMultiplicacao:
                display.setText(display.getText()+"*");
                if(operacao==false){
                    operacao = true;
                }
                break;
            case R.id.buttonDivisao:
                display.setText(display.getText()+"/");
                if(operacao==false){
                    operacao = true;
                }
                break;

            case R.id.buttonDelete:
                 texto = display.getText().toString();
                if(texto.length() > 0){
                    display.setText(texto.substring(0,texto.length() -1));
                    txtResultado.setText("");
                    operacao = false;
                }else{

                }

                break;
            case R.id.buttonIgual:
                realizar_Calculo(display.getText().toString());
                break;
            case R.id.buttonc1:
                display.setText(display.getText()+"(");
                break;
            case R.id.buttonc2:
                display.setText(display.getText()+")");
                break;
            case R.id.buttonRaiz:
                display.setText(display.getText()+"√");

                break;
        }
    }
    public void realizar_Calculo(String s) {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");



        boolean tipoFloat = false;

        try {

            String formula = display.getText().toString();
            String resultado = String.valueOf(engine.eval(formula));
            char c = resultado.charAt(0);
            if (c == 'N' || c =='I') {
                txtResultado.setText("NaN");
            }else {


                for (int i = 0; i < resultado.length(); i++) {

                    c = resultado.charAt(i);
                    if (c == '.' || c == 'N' || c == 'a') {

                        c = resultado.charAt(i + 1);

                        if (c == '0' && resultado.charAt(0) != 'N') {
                            tipoFloat = false;
                            break;

                        } else {
                            tipoFloat = true;
                        }

                    }

                }

                if (tipoFloat == true) {
                    txtResultado.setText(resultado);
                } else {
                    int res;
                    double rsuldouble = Double.parseDouble(resultado);
                    res = (int) rsuldouble;
                    txtResultado.setText(String.valueOf(res));
                }

            }

            } catch(Exception e){

            }

    }

}

