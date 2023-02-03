package org.bootcamp.loginmodulo;

import java.util.List;

interface IUpdateData {     // clase cerrada a modificacion pero abierta a extensiones
    List<User> textoParaActualizar(String valorActual, String valor_a_atualizar);
}