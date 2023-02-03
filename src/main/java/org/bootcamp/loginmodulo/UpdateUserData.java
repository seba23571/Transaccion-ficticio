package org.bootcamp.loginmodulo;

import com.google.gson.Gson;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UpdateUserData extends UserLeer {
    private List<User> usuarios;
    private Gson gson = new Gson();
    private FileWriter writer;

    public void ActualizarDatosUsuarios(ActualizarDatos userLeer, String valorActual, String valor_a_atualizar) {

        //   usuarios =  leerUser();
        usuarios = userLeer.textoParaActualizar(valorActual, valor_a_atualizar);
        if (userLeer instanceof UpdatePassword) {
            dummySaveBackendData();
            System.out.println("actualizado  password correctamente ");
        }
        if (userLeer instanceof UpdateMail) {
            dummySaveBackendData();
            System.out.println("actualizado  eMail correctamente ");
        }


    }

    private void dummySaveBackendData() {
        try {
            writer = new FileWriter("usuarios.json");
            String json = gson.toJson(usuarios);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            System.out.println(" error " + e.getMessage());

        }
    }

}
