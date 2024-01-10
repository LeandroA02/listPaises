package com.example.listpaises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity extends AppCompatActivity
        implements Asynchtask, AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Map<String, String> datos2 = new HashMap<String, String>();
        WebService ws=
                new WebService("http://www.geognos.com/api/en/countries/info/all.json",
                datos2, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {

        ArrayList <Nombress> listaPaises = new ArrayList <Nombress>();


        //Parceo JSON
        JSONObject lista= new JSONObject(result);
        JSONObject resultsObject = lista.getJSONObject("Results");

        listaPaises = Nombress.JsonObjectsBuild(resultsObject);
        AdaptadorListaPaises adaptadorPaises =
                new AdaptadorListaPaises(this, listaPaises);

        //Paso3
        ListView lstOpciones = (ListView) findViewById(R.id.lstpaises);
        lstOpciones.setAdapter(adaptadorPaises);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}