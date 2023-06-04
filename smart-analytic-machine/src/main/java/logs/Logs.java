/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logs;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.util.Conversor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Lenovo
 */
public class Logs {
    private static final String DIRETORIO_LOGS = Paths.get(System.getProperty("user.home"), "PastaSam").toString();
    private static final long INTERVALO_LOG = TimeUnit.MINUTES.toMillis(1);
    private static final long INTERVALO_VERIFICACAO_LOG = TimeUnit.SECONDS.toMillis(20);

    private static List<String> logs = new ArrayList<>();
    private static Date horaUltimoArquivoLog;

    private static String gerarMensagemLog(Date timestamp, Memoria memoria, Conversor conversor, Processador processador, Volume volume, RedeInterface rede) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        long memoriaUtilizada = memoria.getEmUso();
        double processadorUtilizado = processador.getUso();
        double discoUtilizado = volume.getTotal() - volume.getDisponivel();
        long bytesRecebidos = rede.getBytesRecebidos();
        long bytesEnviados = rede.getBytesEnviados();
        String usoMemoriaFormatado = conversor.formatarBytes(memoriaUtilizada);

        return String.format("[%s]: Uso de memória: %s\n[%s]: Uso do Processador: %.2f\n[%s]: Disco Utilizado: %.2f\n[%s]: Bytes Recebidos: %s\n[%s]: Bytes Enviados: %s\n",
                sdf.format(timestamp), 
                usoMemoriaFormatado, 
                sdf.format(timestamp), 
                processadorUtilizado, 
                sdf.format(timestamp),
                discoUtilizado,
                sdf.format(timestamp),
                bytesRecebidos, 
                sdf.format(timestamp),
                bytesEnviados);
    }

    private static void criarArquivoLog(List<String> logs) {
        if (logs.isEmpty()) {
            return;
        }

        SimpleDateFormat sdfNomeArquivoLog = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String nomeArquivoLog = "logs_" + sdfNomeArquivoLog.format(horaUltimoArquivoLog) + ".txt";

        try {
            FileWriter writer = new FileWriter(Paths.get(DIRETORIO_LOGS, nomeArquivoLog).toString(), true);

            for (String log : logs) {
                writer.write(log);
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startLogging() throws InterruptedException {
        File diretorio = new File(DIRETORIO_LOGS);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        Looca looca = new Looca();
        Memoria memoria = looca.getMemoria();
        Processador processador = looca.getProcessador();
        List<Volume> volumes = looca.getGrupoDeDiscos().getVolumes();
        List<RedeInterface> interfacesRede = looca.getRede().getGrupoDeInterfaces().getInterfaces();

        Conversor conversor = new Conversor();

        horaUltimoArquivoLog = new Date();

        while (true) {
            Date agora = new Date();

            long tempoDecorrido = agora.getTime() - horaUltimoArquivoLog.getTime();

            if (tempoDecorrido >= INTERVALO_LOG) {
                criarArquivoLog(logs);
                logs.clear();
                horaUltimoArquivoLog = agora;
            }

            StringBuilder mensagemLog = new StringBuilder();

            for (RedeInterface rede : interfacesRede) {
                long bytesRecebidos = rede.getBytesRecebidos();
                long bytesEnviados = rede.getBytesEnviados();

                if (bytesRecebidos != 0 || bytesEnviados != 0) {
                    mensagemLog.append(gerarMensagemLog(agora, memoria, conversor, processador, volumes.get(0), rede));
                }
            }

            System.out.print(mensagemLog);

            logs.add(mensagemLog.toString());

            TimeUnit.MILLISECONDS.sleep(INTERVALO_VERIFICACAO_LOG);
        }
    }
}