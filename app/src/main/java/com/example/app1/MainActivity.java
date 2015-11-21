package com.example.app1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    //Variables objetos UI
    EditText txt_num1;
    EditText txt_num2;
    Button btn_Suma;
    Button btn_Resta;
    Button btn_Multi;
    Button btn_Divide;
    TextView txt_res;

    //Variables Code
    Integer num1;
    Integer num2;
    int resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarUI();
    }

    private void inicializarUI()
    {
        //Inicializacion de campos de texto
        txt_num1 = (EditText)findViewById(R.id.editTextNum1);
        txt_num2 = (EditText)findViewById(R.id.editTextNum2);
        //Inicializacion de botones
        btn_Suma = (Button)findViewById(R.id.buttonSuma);
        btn_Resta = (Button)findViewById(R.id.buttonResta);
        btn_Multi = (Button)findViewById(R.id.buttonMulti);
        btn_Divide = (Button)findViewById(R.id.buttonDivide);
        //Inicializacion de Texto de Respuesta
        txt_res = (TextView)findViewById(R.id.textViewResultado);
    }


    public void sumar(View v)
    {
        if(validar(1)) {
            resultado = num1 + num2;
            txt_res.setText("El resultado es: " + resultado);
        } else {
            txt_res.setText("Error");
        }
     }

    public void restar(View v)
    {
        if(validar(2)) {
            resultado = num1 - num2;
            txt_res.setText("El resultado es: " + resultado);
        } else {
            txt_res.setText("Error");
        }
    }

    public void multiplicar(View v)
    {
        if(validar(3)) {
            resultado = num1 * num2;
            txt_res.setText("El resultado es: " + resultado);
        } else {
            txt_res.setText("Error");
        }
    }

    public void dividir(View v)
    {
        if(validar(4)) {
            resultado = num1 / num2;
            txt_res.setText("El resultado es: " + resultado);
        } else {
            txt_res.setText("Error");
        }
    }

    public boolean validar(int operacion)
    {

        if(txt_num1.getText().toString().isEmpty() || txt_num2.getText().toString().isEmpty())
        {
            return false;
        }else
        {
            num1 = Integer.parseInt(txt_num1.getText().toString());
            num2 = Integer.parseInt(txt_num2.getText().toString());
            if(num2==0 && operacion==4)
                return false;
            return true;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
