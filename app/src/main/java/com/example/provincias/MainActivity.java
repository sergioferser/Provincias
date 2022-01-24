package com.example.provincias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private Spinner spinnerM;
    private AutoCompleteTextView etAdd;
    private ArrayList<String> arrayListProvincias;
    private ArrayList<String> arrayListMunicipios;
    private ArrayList<String> MunicipiosCoruña;
    private ArrayList<String> MunicipiosLugo;
    private ArrayList<String> MunicipiosOurense;
    private ArrayList<String> MunicipiosPontevedra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner= findViewById(R.id.spProvincias);
        spinnerM=findViewById(R.id.spMunicipios);
        etAdd= findViewById(R.id.etAdd);
//        Simulacro!!! Añadimos elementos al array de forma dinamica
        arrayListProvincias= new ArrayList<String>();
        arrayListProvincias.add("Coruña");
        arrayListProvincias.add("Lugo");
        arrayListProvincias.add("Ourense");
        arrayListProvincias.add("Pontevedra");
        arrayListProvincias.add("Palencia");
        arrayListProvincias.add("Caceres");
        arrayListProvincias.add("Lleida");
        arrayListProvincias.add("Ouiedo");

        arrayListMunicipios= new ArrayList<String>();
        MunicipiosCoruña= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.Coruña)));
        MunicipiosLugo= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.Lugo)));
        MunicipiosOurense= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.Ourense)));
        MunicipiosPontevedra= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.Pontevedra)));





//   Creacion del adaptador
        ArrayAdapter<String> adaptador= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arrayListProvincias);
        ArrayAdapter<String> adaptadorM= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arrayListMunicipios);

//        Asignar adaptador
        spinner.setAdapter(adaptador);
        spinnerM.setAdapter(adaptadorM);

        ArrayAdapter<String> adapterET = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, arrayListProvincias);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.etAdd);
        textView.setAdapter(adapterET);

//        Listener del spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int r= spinner.getSelectedItemPosition();
                if(r==0){
                    arrayListMunicipios.clear();
                    arrayListMunicipios.addAll(MunicipiosCoruña);
                    adaptadorM.notifyDataSetChanged();
                }else if(r==1){
                    arrayListMunicipios.clear();
                    arrayListMunicipios.addAll(MunicipiosLugo);
                    adaptadorM.notifyDataSetChanged();
                }else if(r==2){
                    arrayListMunicipios.clear();
                    arrayListMunicipios.addAll(MunicipiosOurense);
                    adaptadorM.notifyDataSetChanged();
                }else if(r==3){
                    arrayListMunicipios.clear();
                    arrayListMunicipios.addAll(MunicipiosPontevedra);
                    adaptadorM.notifyDataSetChanged();
                }else{
                    arrayListMunicipios.clear();
                    adaptadorM.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Municipios no disponibles", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        etAdd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String provinciaAuto= (String)adapterView.getItemAtPosition(i);
                if(provinciaAuto.equals("Coruña")){
                    arrayListMunicipios.clear();
                    arrayListMunicipios.addAll(MunicipiosCoruña);
                    adaptadorM.notifyDataSetChanged();
                }else if(provinciaAuto.equals("Lugo")){
                    arrayListMunicipios.clear();
                    arrayListMunicipios.addAll(MunicipiosLugo);
                    adaptadorM.notifyDataSetChanged();
                }else if(provinciaAuto.equals("Ourense")){
                    arrayListMunicipios.clear();
                    arrayListMunicipios.addAll(MunicipiosOurense);
                    adaptadorM.notifyDataSetChanged();
                }else if(provinciaAuto.equals("Pontevedra")){
                    arrayListMunicipios.clear();
                    arrayListMunicipios.addAll(MunicipiosPontevedra);
                    adaptadorM.notifyDataSetChanged();
                }else{
                    arrayListMunicipios.clear();
                    adaptadorM.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Municipios no disponibles", Toast.LENGTH_SHORT).show();
                }

            }
        });
        spinnerM.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String municipio= spinnerM.getSelectedItem().toString();
                String provincia= etAdd.getText().toString();
                if(provincia.equals("Coruña")||provincia.equals("Lugo")||provincia.equals("Ourense")||provincia.equals("Pontevedra")) {
                    Toast.makeText(MainActivity.this, "Provincia de " + provincia + "\nMunicipio de " + municipio, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Provincia invalida, seleccione una valida", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}