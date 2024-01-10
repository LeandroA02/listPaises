package com.example.listpaises;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
public class Nombress {
    String Nombre;
    String UrlLogo;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public String getUrlLogo() {
        return UrlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        UrlLogo = urlLogo;
    }

    public Nombress(String CodePais,JSONObject DatoPais) throws JSONException {
        Nombre = DatoPais.getString("Name");
        UrlLogo = "http://www.geognos.com/api/en/countries/flag/" +
                CodePais + ".png";
    }

    public static ArrayList<Nombress> JsonObjectsBuild(JSONObject datos) throws JSONException {
        ArrayList<Nombress> lstpaises = new ArrayList<>();
        Iterator<String> keys = datos.keys();
        while (keys.hasNext()) {
            String CodePais = keys.next();
            JSONObject DatoPais = datos.getJSONObject(CodePais);
            lstpaises.add(new Nombress (CodePais,DatoPais));
        }
        return lstpaises;
    }

}
