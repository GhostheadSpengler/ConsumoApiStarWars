package conexion;


import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        System.out.println("Hola trooper, introduce el numero de episodio del cual deseas informacion:\n");
        try{  ConexionApi consulta= new ConexionApi();

 /*  var episodio= teclado.nextLine();
 AQUI solicita una variable tipo int, pero recibe el String, se hace el cambio con un ValueOf (El que intentaste hacer directamente en la clase Conexion)*/

            var numEpisodio=Integer.valueOf(teclado.nextLine());

            PeliculaRecord peliculaRecord= consulta.episodio(numEpisodio);
            System.out.println(peliculaRecord);} catch(RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Ejecucion finalizada");

        }


    }


}

//Condicionales: if else, if, switch  case
// Ciclos: for, while, do while