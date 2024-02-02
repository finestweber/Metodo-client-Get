import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientGet {
    public static void main(String[] args) {
        try {
            // Criar uma URL para a solicitação
            //URL url = new URL("https://xkcd.com/info.0.json");
            URL url = new URL("http://192.168.18.199:8080/emails/all");

            // Abrir uma conexão HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar o método de solicitação (GET, POST, etc.)
            connection.setRequestMethod("GET");

            // Ler a resposta
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Exibir a resposta
            System.out.println(response.toString());

            // Fechar a conexão
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}