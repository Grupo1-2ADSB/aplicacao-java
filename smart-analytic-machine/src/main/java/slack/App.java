/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slack;

import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author Alexa
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        JSONObject alertaNotifica = new JSONObject();
        
        alertaNotifica.put("text", "!!!");
 
        Slack.sendMessage(alertaNotifica);
    }
}
