/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import java.util.Timer;
import java.util.TimerTask;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

/**
 *
 * @author Leo
 */
public class testeOshi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SystemInfo si = new SystemInfo();
        CentralProcessor cpu = si.getHardware().getProcessor();

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                long uptime = si.getOperatingSystem().getSystemUptime();
                long[] prevTicks = cpu.getSystemCpuLoadTicks();
                long prevIdle = prevTicks[CentralProcessor.TickType.IDLE.getIndex()];

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                long[] ticks = cpu.getSystemCpuLoadTicks();
                long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()];

                long total = 0L;
                for (int i = 0; i < ticks.length; i++) {
                    total += ticks[i] - prevTicks[i];
                }

                double idleTime = (double) (idle - prevIdle) / total;
                long uptimeMillis = (long) uptime * 1000;
                long idleTimeMillis = (long) (idleTime * uptimeMillis);

                System.out.println("Tempo ocioso em segundos: " + idleTimeMillis / 1000);
            }
        }, 0, 1000);

    }

}
