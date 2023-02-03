package org.bootcamp.moduloGenerarTicket;

import org.bootcamp.testTransaccion.TransaccionTest;

public class GenerarTicket {
    String datoHtml = "";
    String red = "color:hsl(0,100%,50%);";

    public String generarTicketHtml(TransaccionTest convertirHTML) {
        convertirHTML.getTipoCuenta();  // TIPO DE CUENTA
        convertirHTML.getIdNumeroCuenta(); // NUMERO DE CUENTA
        convertirHTML.getNombreUsuarioOrigen(); // usuario que hace el envio
        convertirHTML.getMotoTransaction();// MOTO QUE ENVIA USARIO ORIGEN
        convertirHTML.getNombreUsuarioDestino(); // usuario que recive los fondos






     /*   datoHtml = "<body> " +
                "<font color=\"#800080\">Impresion de ticket </font>" +
                "<ul type=\"square\" style=\"color: red\">" +
                "<li> <pre> TIPO DE CUENTA : "+ convertirHTML.getTipoCuenta()+" </pre>  </li>" +
                "<li> <pre> NUMERO DE CUENTA : "+ convertirHTML.getIdNumeroCuenta()+"   </pre>  </li>" +
                "<li> <pre> usuario que hace el envio :"+ convertirHTML.getNombreUsuarioOrigen()+"   </pre>  </li>" +
                "<li> <pre> MOTO QUE ENVIA USARIO ORIGEN : "+ convertirHTML.getMotoTransaction()+"</pre>  </li>" +
                "<li> <pre> usuario que recive los fondos : "+ convertirHTML.getNombreUsuarioDestino()+"</pre>  </li> "+
                "<li> <pre>  saldo actual destinatario es :  "+ convertirHTML.getSaldoActualDestinatario()+"</pre>  </li> "+
                "<li> <pre> saldo restado del que envia los fondos  :  "+ convertirHTML.getSaldoActualSender() +"</pre>  </li> "+
                "  </ul>   <br><br><br><img src=\"https://kodigo.org/wp-content/uploads/2021/01/logo-kodigo-50.png\" />         </body>";*/


        datoHtml = "<style>" +
                "table, th, td {" +
                "  border:0.2px solid black;" +
                "}" +
                "</style>" +
                "<body>" +
                "" +
                "<h2>Ticket de envio de fondos </h2>" +
                "" +
                "<table style=\"width:100%\">" +
                "  <tr>" +
                "    <th><pre> TIPO DE CUENTA : "+ convertirHTML.getTipoCuenta()+" </pre> </th>" +
                "  </tr>" +
                "  <tr>" +
                "    <th><pre>  NUMERO DE CUENTA : "+ convertirHTML.getIdNumeroCuenta()+"   </pre></th>" +

                "  </tr>" +
                "  <tr>" +
                "    <th><pre> usuario que hace el envio :"+ convertirHTML.getNombreUsuarioOrigen()+"   </pre></th>" +

                "  </tr>" +
                "  <tr>" +
                "    <th> <pre> usuario que recive los fondos : "+ convertirHTML.getNombreUsuarioDestino()+"</pre>  </th>" +
                "  </tr>" +

                "  <tr>" +
                "    <th> <pre> MOTO QUE ENVIA USARIO ORIGEN : "+ convertirHTML.getMotoTransaction()+"</pre>  </th>" +
                "  </tr>" +
                "  <tr>" +
                "    <th><pre>  saldo actual destinatario es :  "+ convertirHTML.getSaldoActualDestinatario()+"</pre>   </th>" +
                "  </tr>" +
                "  <tr>" +
                "    <th> <pre> saldo restado del que envia los fondos  :  "+ convertirHTML.getSaldoActualSender() +"</pre> </th>" +
                "  </tr>" +
                "</table>" +

                "<a target='_blank' href='https://kodigo.org/'><img src='https://kodigo.org/wp-content/uploads/2021/01/logo-kodigo-50.png' /> </a>"+
                "</body>";
          //datoHtml ="<table>  <tr>    <td>Emil</td>    <td>Tobias</td>    <td>Linus</td>  </tr></table>";

        return datoHtml;
    }
}
