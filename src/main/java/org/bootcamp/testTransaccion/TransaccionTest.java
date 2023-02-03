package org.bootcamp.testTransaccion;

import org.bootcamp.loginmodulo.User;

public class TransaccionTest {

    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private int idTransaccion;

    private int idUsuarioOrigen;
    private int idUsuarioDestino;

    private double  cuentaOrigenMoto;
    private  double valorTransferido;
    private String tipoCuenta;
    private int idNumeroCuenta;
    private double  motoTransaction;

    private User userOrigen;
    private User userDestino;

    private String nombreUsuarioOrigen;
    private String nombreUsuarioDestino;

    private double saldoActualDestinatario;
    private double saldoActualSender;

    public double getSaldoActualDestinatario() {
        return saldoActualDestinatario;
    }

    public void setSaldoActualDestinatario(double saldoActualDestinatario) {
        this.saldoActualDestinatario = saldoActualDestinatario;
    }

    public double getSaldoActualSender() {
        return saldoActualSender;
    }

    public void setSaldoActualSender(double saldoActualSender) {
        this.saldoActualSender = saldoActualSender;
    }

    public String getNombreUsuarioOrigen() {
        return nombreUsuarioOrigen;
    }

    public void setNombreUsuarioOrigen(String nombreUsuarioOrigen) {
        this.nombreUsuarioOrigen = nombreUsuarioOrigen;
    }

    public String getNombreUsuarioDestino() {
        return nombreUsuarioDestino;
    }

    public void setNombreUsuarioDestino(String nombreUsuarioDestino) {
        this.nombreUsuarioDestino = nombreUsuarioDestino;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdUsuarioOrigen() {
        return idUsuarioOrigen;
    }

    public void setIdUsuarioOrigen(int idUsuarioOrigen) {
        this.idUsuarioOrigen = idUsuarioOrigen;
    }

    public int getIdUsuarioDestino() {
        return idUsuarioDestino;
    }

    public void setIdUsuarioDestino(int idUsuarioDestino) {
        this.idUsuarioDestino = idUsuarioDestino;
    }

    public double getCuentaOrigenMoto() {
        return cuentaOrigenMoto;
    }

    public void setCuentaOrigenMoto(double cuentaOrigenMoto) {
        this.cuentaOrigenMoto = cuentaOrigenMoto;
    }

    public double getValorTransferido() {
        return valorTransferido;
    }

    public void setValorTransferido(double valorTransferido) {
        this.valorTransferido = valorTransferido;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getIdNumeroCuenta() {
        return idNumeroCuenta;
    }

    public void setIdNumeroCuenta(int idNumeroCuenta) {
        this.idNumeroCuenta = idNumeroCuenta;
    }

    public double getMotoTransaction() {
        return motoTransaction;
    }

    public void setMotoTransaction(double motoTransaction) {
        this.motoTransaction = motoTransaction;
    }

    public User getUserOrigen() {
        return userOrigen;
    }

    public void setUserOrigen(User userOrigen) {
        this.userOrigen = userOrigen;
    }

    public User getUserDestino() {
        return userDestino;
    }

    public void setUserDestino(User userDestino) {
        this.userDestino = userDestino;
    }

    public TransaccionTest(Cuenta cuentaOrigen, Cuenta cuentaDestino, int idTransaccion) {
        userOrigen = cuentaOrigen.getMyUsers();
        userDestino =cuentaDestino.getMyUsers();
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.idTransaccion =idTransaccion;
    }


    public void transferirMontoDestinatario(double motoEnviar){
        if(cuentaOrigen.getMoto()<motoEnviar){
            System.out.println( " el usuario "+userOrigen.getNombre() + " no tiene saldos suficiente para hacer el envio ");
            return  ;
        }
        double restaFondos = cuentaOrigen.getMoto() - motoEnviar;

        if(motoEnviar<0){
            System.out.println("no puede enviar montos negativos");
         // cuentaDestino.setMoto(valor);
            return  ;
        }

        cuentaOrigen.setMoto(restaFondos);
          valorTransferido = cuentaDestino.getMoto() + motoEnviar;
        cuentaDestino.setMoto(valorTransferido);
        setMotoTransaction(restaFondos);
        System.out.println("\n ID de la transaccion "+this.idTransaccion);
        setIdTransaccion(this.idTransaccion);
        System.out.println("\n ID Usuaro cuenta origen : "+this.cuentaOrigen.getMyUsers().getId() );
        setIdUsuarioOrigen(this.cuentaOrigen.getMyUsers().getId());
        System.out.println("\n ID Usuaro cuenta destino  : "+this.cuentaDestino.getMyUsers().getId() );
        setIdUsuarioDestino(this.cuentaDestino.getMyUsers().getId());

        if(cuentaOrigen instanceof CuentaCorriente){
            System.out.println("transaccion de cuenta Corriente \n numero cuenta : "+cuentaDestino.getNumeroCuenta() +" de "+cuentaDestino.getMyUsers().getNombre() +" "+cuentaDestino.getMyUsers().getApellido()

                    +" recivio fondos es de $ "+motoEnviar + " su saldo actual es de : "+""+cuentaDestino.getMoto() +   "" +
                    "\n se descuentan fondos  "+cuentaOrigen.getMyUsers().getNombre() + " de "+motoEnviar +" fondo actua es "+cuentaOrigen.getMoto()  );


           setTipoCuenta("Cuenta Corriente");
            setIdNumeroCuenta(cuentaDestino.getNumeroCuenta());
            setNombreUsuarioDestino(cuentaDestino.getMyUsers().getNombre() +" "+cuentaDestino.getMyUsers().getApellido());
            setNombreUsuarioOrigen(cuentaOrigen.getMyUsers().getNombre() +" "+cuentaOrigen.getMyUsers().getApellido());
            setMotoTransaction(motoEnviar);
            setCuentaOrigenMoto(cuentaOrigen.getMoto());
            setSaldoActualDestinatario(cuentaDestino.getNumeroCuenta());
            setSaldoActualSender(cuentaOrigen.getMoto());


        }
        if(cuentaOrigen instanceof CuentaAhorro){

            setTipoCuenta("Cuenta de Ahorro");
            System.out.println("transaccion de cuenta Ahorro \n numero cuenta : "+cuentaDestino.getNumeroCuenta() +" de "+cuentaDestino.getMyUsers().getNombre() +" "+cuentaDestino.getMyUsers().getApellido()

                    +" recivio de fondos es de $ "+motoEnviar + " su saldo actual es de : "+""+cuentaDestino.getMoto() +   "  "+
                    "\n se descuentan fondos  "+cuentaOrigen.getMyUsers().getNombre() + " de "+motoEnviar +" fondo actua es "+cuentaOrigen.getMoto()  );
            setIdNumeroCuenta(cuentaDestino.getNumeroCuenta());
            setNombreUsuarioDestino(cuentaDestino.getMyUsers().getNombre() +" "+cuentaDestino.getMyUsers().getApellido());
            setNombreUsuarioOrigen(cuentaOrigen.getMyUsers().getNombre() +" "+cuentaOrigen.getMyUsers().getApellido());
            setMotoTransaction(motoEnviar);
            setCuentaOrigenMoto(cuentaOrigen.getMoto());
            setSaldoActualDestinatario(cuentaDestino.getNumeroCuenta());
            setSaldoActualSender(cuentaOrigen.getMoto());
        }
        this.cuentaOrigen = null;
        this.cuentaDestino = null;
       // return cuentaDestino;
    }
}

class Main{
   /* public static void main(String[] args) {
        MyUsers usersorigen = new MyUsers("sebas", "este");
        Cuenta cuentaOrigen = new CuentaCorriente(usersorigen, 18.5,1);

        MyUsers userDestino = new MyUsers("pepe", "argento");
        Cuenta cuentaDestino = new CuentaCorriente(userDestino, 20.5,2);
        TransaccionTest transaccionTest = new TransaccionTest(cuentaOrigen, cuentaDestino);
        transaccionTest.transferirMontoDestinatario(10.0);
        System.out.println(" el usuario "+cuentaDestino.getMyUsers().getNombre()
        +" tiene un moto de "+cuentaDestino.getMoto()    );

    }*/
}
