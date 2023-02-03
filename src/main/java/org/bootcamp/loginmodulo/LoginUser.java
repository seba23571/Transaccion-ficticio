package org.bootcamp.loginmodulo;

import com.google.gson.Gson;


import java.io.FileReader;
import java.util.List;

public class LoginUser extends UserLeer {
    private User user = null;
    private Gson gson = new Gson();
    private FileReader reader = null;


    public User hacerLogin(String mail, String password) {
        try {
            List<User> usuarios1 = leerUser();
            for (User usuario : usuarios1) {
                if (usuario.getMail().equals(mail) && usuario.getPassword().equals(password)) {
                    user = new User(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getMail(), usuario.getPassword(), usuario.getTelefono(), usuario.getRoles());
                }
            }
            if (user == null) {
                System.out.println("usuario no encontrado ");
               // throw new RuntimeException("usuario no encontrado ");
                System.exit(0);


            } else {
                System.out.println("Usuario logueado: " + user.getNombre() + " su apellido es " + user.getApellido() + " "
                   );
            }
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }



        return user;


    }
}
