package com.example.app1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class CalculadoraFinancieraActivity extends ActionBarActivity {

    EditText valor;
    EditText cuota_inicial;
    EditText interes;
    Spinner plazo;
    TextView credito;
    TextView valor_cuota;
    TextView total_pago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_financiera);
        inicializar_spinner();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora_financiera, menu);
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

    public void inicializar_spinner()
    {
        plazo = (Spinner)findViewById(R.id.SpinnerPlazo);
        String [] items = new String[]{
                "1 Año",
                "2 Años",
                "3 Años",
                "4 Años",
                "5 Años"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        plazo.setAdapter(adapter);
    }

    public void calcular(View v)
    {
        valor = (EditText)findViewById(R.id.EditTextValor);
        cuota_inicial = (EditText)findViewById(R.id.EditTextCuota);
        interes = (EditText)findViewById(R.id.EditTextInteres);
        plazo = (Spinner)findViewById(R.id.SpinnerPlazo);

        double val = Double.parseDouble(valor.getText().toString());
        double c_ini = Double.parseDouble(cuota_inicial.getText().toString());
        double inter = Double.parseDouble(interes.getText().toString())/100;
        double meses = (plazo.getSelectedItemPosition()+1)*12;

        System.out.println(val+" "+c_ini+" "+inter+" "+meses);

        double total = ((val-c_ini)*inter)/(1-(Math.pow((1+inter),-60)));
        valor_cuota = (TextView)findViewById(R.id.TextViewCuotaCredito);
        valor_cuota.setText("El valor de la cuota es de: "+(int) total);
    }
}
