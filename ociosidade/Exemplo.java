package giovana.sptech.api;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDateTime;

public class Exemplo {

    public static void main(String[] args) throws Exception {

        // Cria um objeto Robot
        Robot robot = new Robot();

        // Define o intervalo de tempo para verificar a inatividade
        Duration intervalo = Duration.ofSeconds(30);

        // Obtém a data/hora atual
        LocalDateTime ultimaAtividade = LocalDateTime.now();

        // Loop infinito
        while (true) {

            // Simula um clique do mouse
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);

            // Aguarda o intervalo de  tempo
            Thread.sleep(intervalo.toMillis());

            // Verifica quanto tempo se passou desde a última atividade
            LocalDateTime agora = LocalDateTime.now();
            Duration inatividade = Duration.between(ultimaAtividade, agora);

            // Se a inatividade for maior ou igual ao intervalo definido, exibe mensagem
            if (inatividade.compareTo(intervalo) >= 0) {
                System.out.println("Usuário ocioso há mais de " + intervalo.getSeconds() + " segundos!");
            }

            // Atualiza a data/hora da última atividade
            ultimaAtividade = agora;
        }
    }
}
