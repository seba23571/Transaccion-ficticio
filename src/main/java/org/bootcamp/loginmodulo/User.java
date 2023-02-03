package org.bootcamp.loginmodulo;

import lombok.*;


@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class User {
    private int id;
    private String nombre;
    private String apellido;
    @NonNull
    private String mail;
    @NonNull
    private String password;
    private String telefono;

    private String roles;



    // public Usuario() {    }

   /* public Usuario(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public Usuario(int id, String nombre, String apellido, String mail, String password, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.password = password;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }*/
}
