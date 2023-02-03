package org.bootcamp.loginmodulo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class UserLeer {
    protected Gson gson = new Gson();
    protected List<User> usuarios = null;
    protected FileReader reader = null;
    protected  Type listType = null;
    public List<User> leerUser() {

        try {
              reader = new FileReader("usuarios.json");
            Type listType = new TypeToken<ArrayList<User>>() {
            }.getType();
            usuarios = gson.fromJson(reader, listType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

}












