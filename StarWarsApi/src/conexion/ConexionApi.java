package conexion;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi { //CLASE
    public PeliculaRecord episodio(int numEpi){ //METODO.
// La linea de arriba (el metodo )no contaba con el public, se le agrego para poder ser identificado al momento de llamarse en la clase Principal.

        URI direccion=URI.create("https://swapi.py4e.com/api/films/?=" + numEpi);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
           // HttpResponse<String>response=null; ESTO ESTA MAL, va dentro del catch y sin el null. Al haber puesto el null, el return de la ultima linea, el cual fue reubicado, habria marcado un error de tipo "NULL" al ejecutar el programa, (A1)*


        try {
            //response = client (Esto estaba antes,A2, y se sustituyo con la linea de abajo, reemplazando el A1) (A2)*
            HttpResponse<String>response=client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //Aqui se reacomodo el Gson de B1. (B2)*
            return new Gson().fromJson(response.body(),PeliculaRecord.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e); }

           // Gson gson=new  GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create(); (ESTE CODIGO NO ERA NECESARIO, aunque se uso en el de peliculas, para permitir el uso variado de Upper case)

           /* return new Gson().fromJson(response.body()
         PeliculaRecord.class);

         Aca no corresponde poner el return, ya que debe ir dentro del CATCH, pues al haber cambiado el  HttpResponse<String>response=client dentro del try, no reconoceria las instrucciones fuera del corchete. (B1)**/
    }
}

//**************************  OBSERVACIONES ***************************/

/*

1. El String de la direccion, se hizo con URI directamente (URI.create(direccion URL)), anteriormente en otro proyecto "Pelicula" se habi hecho en la linea 18. Entonces se reemplazo ya con el nombre de variable  direccion.*

2. La excepcion del send, en vez de enviar un throw generico, se hizo a traves de un try catch, ademas de reducir codigo, porque se puso en una misma linea ambos warnings: IOException | InterruptedException.

3. RESPONSE: https://docs.oracle.com/en%2Fjava%2Fjavase%2F17%2Fdocs%2Fapi%2F%2F/java.net.http/java/net/http/HttpResponse.html
 */