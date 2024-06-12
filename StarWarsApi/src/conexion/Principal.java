package conexion;


import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConexionApi consulta = new ConexionApi();
        System.out.println("Hola trooper, introduce el numero de episodio del cual deseas informacion:\n");
        try {
 /*  var episodio= teclado.nextLine();
 AQUI solicita una variable tipo int, pero recibe el String, se hace el cambio con un ValueOf (El que intentaste hacer directamente en la clase Conexion)*/

            var numEpisodio = Integer.valueOf(teclado.nextLine());
            PeliculaRecord peliculaRecord = consulta.episodio(numEpisodio);//Se llama al Generador
            System.out.println(peliculaRecord);

            //Se crea objeto del Generador
            GeneraArchivo genAr= new GeneraArchivo();
            genAr.generaJson(peliculaRecord);   //(C1)

        } catch (NumberFormatException e) {
            System.out.println("Caracteres no validos: " + e.getMessage());
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Ejecucion finalizada");

        }
    }
}

//**************  O B S E R V A C I O N E S  *****************/
/*

1.Hubo un error en el link de la api, IMPORTANTE revisar siempre la conexion en PostMan.

2. Se declaro como excepcion cualquier otra cosa que no sea un numero, con: FormatNumberException.

3. Para atrapar la excepcion que previamente surgio en GeneraArchivo (IOExeption), se junto al RunTimeExeption que ya estaba antes.

4. Se hizo el generador de JSON, el cual tiene como proposito hacer un documento de tipo Json con los datos de la pelicula seleccionada.

 */


//Condicionales: if else, if, switch  case
// Ciclos: for, while, do while