package conexion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneraArchivo {

    public void generaJson(PeliculaRecord peliculaRecord) throws IOException {
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura=new FileWriter(peliculaRecord.title()+".json");
        escritura.write(gson.toJson(peliculaRecord));
        escritura.close();
    }
}
