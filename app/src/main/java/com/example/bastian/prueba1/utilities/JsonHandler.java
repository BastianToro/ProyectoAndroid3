package com.example.bastian.prueba1.utilities;

import android.util.Log;

import com.example.bastian.prueba1.models.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by bastian on 29-05-16.
 */
public class JsonHandler {

    public String [] getMailPass(String usuario) {
        try{
            JSONArray ja = new JSONArray(usuario);
            String[] result = new String[ja.length()];
            String user;
            for(int i=0; i<ja.length();i++){
                JSONObject row = ja.getJSONObject(i);
                user =" " + row.getString("correoUsuario")+" "+row.getString("contrasenhaUsuario");
                result[i]=user;
            }
            return result;

        }catch(JSONException e){
            Log.e("Error",this.getClass().toString());
        }
        return null;

    }// getMailPass(String usuarios)


    public JSONObject setUsuario(Usuario usuario) {
        // build jsonObject
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.accumulate("administrador", usuario.isEsadministrador());
            jsonObject.accumulate("apellidoUsuario", usuario.getApellido());
            jsonObject.accumulate("carreraUsuario",usuario.getCarrera());
            jsonObject.accumulate("contrasenhaUsuario",usuario.getPass());
            jsonObject.accumulate("correoUsuario",usuario.getCorreo());
            jsonObject.accumulate("idTipoEstado",usuario.getIdEstado());
            jsonObject.accumulate("idUsuario",usuario.getId());
            jsonObject.accumulate("nombreUsuario",usuario.getNombre());
            return jsonObject;

        }catch(JSONException je){
            Log.e("ERROR",this.getClass().toString()+ " - "+ je.getMessage());
        }
        return null;
    }

    public String[] getCorreos(String json) {
        try {
            JSONArray ja = new JSONArray(json);
            String[] correos = new String[ja.length()];
            for (int i = 0; i < ja.length(); i++) {
                JSONObject row = ja.getJSONObject(i);
                correos[i]=row.getString("correoUsuario");
            }
            return correos;
        } catch (JSONException e) {
            Log.e("ERROR", this.getClass().toString() + " " + e.toString());
            return null;
        }
    }
}
