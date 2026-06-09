package MenuInicial;
import java.io.FileInputStream;
import java.io.IOException;

public class LeituraArquivo {

    public static String lerArquivo(String caminho) throws IOException {
        FileInputStream inputStream = new FileInputStream(caminho);
        try {
            return new String(inputStream.readAllBytes());
        } finally {
            inputStream.close();
        }
    }
}

