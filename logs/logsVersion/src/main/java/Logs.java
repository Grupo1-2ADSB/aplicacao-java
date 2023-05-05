import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
public class Logs {
    private static final String LOG_DIR = String.format("%s\\Documents\\logs", System.getProperty("user.home"));
    //System.getProperty("user.home") -> Pega o caminho desde o C:/ até a pasta do usuário do sistema
    //private static final cria uma variavel que o valor não pode ser alterado depois de ser definido.
    
    private static String LOG_FILE = "";
    //variável estática inicializada com uma string vazia. Vai ser usada para armazenar o nome do arquivo de log que será criado.

    public static void main(String[] args) throws InterruptedException {
        // Criação da pasta de logs
        File dir = new File(LOG_DIR);
        if (!dir.exists()) {
        //Aqui estou vendo se a pasta já existe, caso não eu crio
            dir.mkdir();
        }

        Looca looca = new Looca();
        Memoria memoria = looca.getMemoria();

        while (true) {
            // Configuração do formato da data
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
            //Formatar a data e hora atual.
            
            SimpleDateFormat sdfNameLogDate = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            //É usado para formatar a data e hora atual como o nome do arquivo de log.
            
            Date now = new Date();
            //Cria um objeto do tipo Date com a data e hora atuais.

            // Criação do arquivo de logs
            LOG_FILE = "log_" + sdfNameLogDate.format(now) + ".txt";
            try {
                FileWriter writer = new FileWriter(LOG_DIR + "\\" + LOG_FILE, true);

                // Geração de logs
                double memoriaEmUso = memoria.getEmUso().doubleValue();
                String message = String.format("%s - Uso de memória: %.2f%%\n", sdf.format(now), memoriaEmUso);
                writer.write(message);
                System.out.print(message); // ExibiR os logs no console

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            TimeUnit.MINUTES.sleep(1);
        }
    }
    
    
}


