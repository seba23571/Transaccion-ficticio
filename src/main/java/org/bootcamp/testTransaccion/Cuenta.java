package org.bootcamp.testTransaccion;

import org.bootcamp.loginmodulo.User;

public abstract class Cuenta {

    private User myUsers;
    private double moto;

    private int numeroCuenta;


    public Cuenta(User myUsers, double moto, int numeroCuenta) {
        this.myUsers = myUsers;
        this.moto = moto;
        this.numeroCuenta = numeroCuenta;
    }

    public User getMyUsers() {
        return myUsers;
    }

    public void setMyUsers(User myUsers) {
        this.myUsers = myUsers;
    }

    public double getMoto() {
        return moto;
    }

    public void setMoto(double moto) {
        this.moto = moto;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "myUsers=" + myUsers +
                ", moto=" + moto +
                ", numeroCuenta=" + numeroCuenta +
                '}';
    }
}
