package com.example.ejercicio0602;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Spinner spDia, spMes, spAno;
    Button btnIva, btnMas, btnMenos, btnCalcular, btnGeneral;
    EditText etNombre, etTelefono, etSueldo, etPrima, etTotal;
    int prima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prima=0;

        etNombre = (EditText)findViewById(R.id.etNombre);
        etTelefono = (EditText)findViewById(R.id.etTelefono);
        etSueldo = (EditText)findViewById(R.id.etSueldo);
        etPrima = (EditText)findViewById(R.id.etPrima);
        etTotal = (EditText)findViewById(R.id.etTotal);

        spDia = (Spinner)findViewById(R.id.spDia);
        String[] dias = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        ArrayAdapter<String> adaptadorDias = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, dias);
        spDia.setAdapter(adaptadorDias);

        spMes = (Spinner)findViewById(R.id.spMes);
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        ArrayAdapter<String> adaptadorMeses = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, meses);
        spMes.setAdapter(adaptadorMeses);

        spAno = (Spinner)findViewById(R.id.spAño);
        String[] anos = {"1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000"};
        ArrayAdapter<String> adaptadorAnos = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, anos);
        spAno.setAdapter(adaptadorAnos);

        btnIva = (Button)findViewById(R.id.btnIva);



    }

    public void clickIva(View view){
        String cajaSueldo = etSueldo.getText().toString();
        if (cajaSueldo.equals("")){
            Toast.makeText(getApplicationContext(), "Debes de introducir un sueldo", Toast.LENGTH_SHORT).show();
        }else{
            double sueldo = Double.parseDouble(cajaSueldo);
            double sueldoNuevo = sueldo-(sueldo*0.10);
            etSueldo.setText(sueldoNuevo+"");
            btnIva.setEnabled(false);
            etSueldo.setEnabled(false);
            btnIva.setText("Aplicado");

        }


    }
    public void clickMas(View view){
        //Sumar de 1 en 1 prima++;
        if (prima<100) {
            prima=prima+10;
            etPrima.setText(prima+"");
        }


    }
    public void clickMenos(View view){
        //Restar de 1 en 1 prima--;
        if(prima>0){
            prima=prima-10;
            etPrima.setText(prima+"");
        }

    }
    public void clickCalcular(View view){

    }
    public void clickGeneral(View view){
        //Recoger el valor de la caka de texto Completo
        String nombreCompleto = etNombre.getText().toString();

        //Comprobar si el nombre está vacío
        if(nombreCompleto.equals("") || nombreCompleto.length()==0){
            Toast.makeText(getApplicationContext(), "Debes de rellenar tu nombre", Toast.LENGTH_SHORT).show();
        }else{
            //Split: devuelve un array de String separados por el valor
            String[] arrayNombre = nombreCompleto.split("");
            //Si el Array de Nombre tiene menos de tres posiciones, avisamos al usuario
            if(arrayNombre.length<3){
                Toast.makeText(getApplicationContext(), "El formato del nombre no es correcto\n"+"Formato: Nombre Apellido1 Apellido2", Toast.LENGTH_SHORT).show();
            }else{
                int tamArray = arrayNombre.length;
                String apellido2 = arrayNombre[tamArray-1];
                String apellido1 = arrayNombre[tamArray-2];

                int tamRestante = tamArray-2;

                String nombre ="";
                for (int i=0; i<=tamRestante; i++){
                    nombre+=arrayNombre[i];
                }

                Toast.makeText(getApplicationContext(), "Nombre: "+nombre+"Apellido1: "+apellido1+"Apellido2: "+apellido2, Toast.LENGTH_SHORT).show();
            }
        }
        //Comprobar teléfono
        String cajaTelefono = etTelefono.getText().toString();

        if(cajaTelefono.equals("")){
            Toast.makeText(getApplicationContext(), "Debes de completar el teléfono", Toast.LENGTH_SHORT).show();
        }else{
            //Convertir el valor String a int
            int telefono = Integer.parseInt(cajaTelefono);

            if (telefono<600000000 || telefono>999999999){
                Toast.makeText(getApplicationContext(), "Formato incorrecto. Debe comenzar por 6, 7, 8 o 9", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Teléfono "+telefono+" añadido", Toast.LENGTH_SHORT).show();
            }
        }

    }

}//FIN MAIN
