/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slack;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author Alexa
 */
public class Slack {

    private static HttpClient client = HttpClient.newHttpClient();
    private static final String url = "https://hooks.slack.com/services/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";
    private static final JSONObject alertaNotifica = new JSONObject();

    public void validaMemoria() throws IOException, InterruptedException {
        alertaNotifica.put("text", "Memória acima de 80% em uso!");
        sendMessage(alertaNotifica);
    }

    public void validaDisco() throws IOException, InterruptedException {
        alertaNotifica.put("text", "Disco acima de 90% em uso!");
        sendMessage(alertaNotifica);
    }

    public void validaProcessador() throws IOException, InterruptedException {
        alertaNotifica.put("text", "Processador acima de 90% em uso!");
        sendMessage(alertaNotifica);
    }

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Response: %s", response.body()));
    }
}
