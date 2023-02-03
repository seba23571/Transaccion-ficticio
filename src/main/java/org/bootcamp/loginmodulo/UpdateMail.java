package org.bootcamp.loginmodulo;

import java.util.List;

public class UpdateMail extends ActualizarDatos {  //implements IUpdateData
    private List<User> usuarios;

    @Override
    public List<User> textoParaActualizar(String valorActual, String valor_a_atualizar) {
        usuarios = leerUser();

        for (User usuario : usuarios) {
            if (usuario.getMail().equals(valorActual)) {
                usuario.setMail(valor_a_atualizar);
            }
        }
        return usuarios;
    }



}