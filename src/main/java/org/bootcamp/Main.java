package org.bootcamp;

import org.bootcamp.loginmodulo.*;

import org.bootcamp.moduloGenerarTicket.GenerarTicketPdf;

import org.bootcamp.moduloGenerarTicket.GenerarTicket;
import org.bootcamp.testTransaccion.*;

public class Main {
    /*

  NOTA : Aplicación  que se conecta a un dummy backend.
  La simulación se hace a través del archivo usuarios.json.
  Esta aplicación hace una actualización de datos de password y correo .
  también simula un login
  usa librería lombok
  de la clase POJO User.
  usa los principios Solid llamados : Principio  Responsabilidad única .
  uso de polimorfismo atraves atravies de inversion de dependecia para actualizar mail o actualizar password
  envia detalles de la transaccion por Mail
  posteriormente genera un pdf mostrando detalles de la transaccion..



* */


    public static void main(String[] args) {

        // nota Se instancia Main para llamar a los metodos de forma ordenada y respetar el hilo de ejecucion evitando una mala sincronizacion ....
        Main m = new Main();
      //  m.updateMail();
        //  m.updatePassword();
           m.hacerLoginCorreto();

    }

    private void updateMail() {
        UpdateMail updateMail = new UpdateMail();
        new UpdateUserData().ActualizarDatosUsuarios(updateMail, "sebastian.esteban@gmail.com", "sebastian.esteban266@gmail.com");
    }

    private void updatePassword() {
        UpdatePassword updatePassword = new UpdatePassword();
        new UpdateUserData().ActualizarDatosUsuarios(updatePassword, "12345", "1234");
    }

    private void hacerLoginCorreto() {

     /*   Scanner scanner = new Scanner(System.in);
        int options = scanner.nextInt();

        System.out.println(" Opciones de envios : \n 1) Envio por Mail ticket \n 2) Generar ticket pdf ");
        if(options==1){
            // enviod por mail
        }
         else if (options==2) {
            // generar pdf
        }
*/

        LoginUser encontrarUsuario = new LoginUser();

        User usuarioSender = encontrarUsuario.hacerLogin("facturaciontimbradomx@gmail.com", "1234");//compruba con backend dummy

        System.out.println("\n.......................Primera Transaccion ...................................\n");

        Cuenta cuentaOrigen = new CuentaCorriente(usuarioSender, 18.5,1);

        User usuarioReciveFondo = encontrarUsuario.hacerLogin("sebastian.esteban266@gmail.com", "12342");//compruba con backend dummy
       // User userDestino = new User(2,"Pepe","Gomez","sebastian.esteban266@gmail.com","1234","+5423123","cliente");


        Cuenta cuentaCteDestino = new CuentaCorriente(usuarioReciveFondo, 20.5,2);
        TransaccionTest transaccionTest = new TransaccionTest(cuentaOrigen, cuentaCteDestino,1);
         transaccionTest.transferirMontoDestinatario(10);

        String ticketHteml = new GenerarTicket().generarTicketHtml(transaccionTest);

        //    new SendMailModule(usuarioSender.getMail(),usuarioReciveFondo.getMail(),ticketHteml).sendMailTicket();
        new GenerarTicketPdf().generarTicketPdf(ticketHteml);


/*

        System.out.println("\n.......................Segunda Transaccion ...................................\n");

        User usuarioOrigenctaAhorro =  new User(3,"Alberto","Torres","Pepe@example.com.com","password3","+555-555-5557","cliente");
        User usuarioOrigenctaDestino =  new User(5,"Juan","Carrizo","Juan@example.com.com","password4","+555-555-5558","cliente");

        CuentaAhorro cuentaAhorroOrigen = new CuentaAhorro(usuarioOrigenctaAhorro,280.12,3);//CUENTA DE ORIGEN SE DESCUENTAS FONDOS  EN MOTON TRANSACCION 20
        CuentaAhorro cuentaAhorroDestino = new CuentaAhorro(usuarioOrigenctaDestino,100,4);  // usuarioOrigenctaDestino El que recive los fondos de transaccion
        TransaccionTest transaccionTestCtaAhorro = new TransaccionTest(cuentaAhorroOrigen, cuentaAhorroDestino,2);
        transaccionTestCtaAhorro.transferirMontoDestinatario(20); // moto que se envia desde usuario origen hasta usuario destino con el descuento del usuario origen.



*/







    }

}