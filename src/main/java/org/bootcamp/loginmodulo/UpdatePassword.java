package org.bootcamp.loginmodulo;

import java.util.List;

public class UpdatePassword extends ActualizarDatos  {
    private List<User> usuarios;


    @Override
    public List<User> textoParaActualizar(String valorActual, String valor_a_atualizar) {
        usuarios = leerUser();
        for (User usuario : usuarios) {
            if (usuario.getPassword().equals(valorActual)) {
                usuario.setPassword(valor_a_atualizar);
            }
        }
        return usuarios;
    }
}