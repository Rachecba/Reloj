/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2.model;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;

/**
 *
 * @author tvkev
 */
public class RadioRelojEngine {
    boolean playing = false;
    private List<String> EmisorasList;
    static int Emisora;
    int segundos = 1;
    int minutos = 0;
    int Alarmaminutos=0;
    int AlarmaSegndos=0;
    
    public String turnOn() {
        setPlaying(true);
        return "Encedido" + getRadioList().get(Emisora);
    }

    public String turnOff() {
        setPlaying(false);
        return "Apagado ";
    }
    
    
    public String nextEmisora() {
        Emisora++;
        if (Emisora > getRadioList().size() - 1) {
            Emisora = 0;
        }
        if (isPlaying()) {
            return "Playing " + getRadioList().get(Emisora);
        } else {
            return "" + getRadioList().get(Emisora);
        }
    }

    public String previusEmisora() {
        Emisora--;
        if (Emisora < 0) {
            Emisora = getRadioList().size() - 1;
        }
        if (isPlaying()) {
            return "Playing " + getRadioList().get(Emisora);
        } else {
            return "" + getRadioList().get(Emisora);
        }
    }
    
    public void nextMin() {
        minutos++;
    }

    public void previusMin() {
        segundos--;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public List<String> getRadioList() {
        return EmisorasList;
    }

    public void setRadioList(List<String> EmisorasList) {
        this.EmisorasList = EmisorasList;
    }

    public static int getCurrentTrack() {
        return Emisora;
    }

    public static void setCurrentTrack(int Emisora) {
        RadioRelojEngine.Emisora = Emisora;
    }
    
    
    private void timeCronometro2(int tiemp) {
        Timer timer;
        timer = new Timer();
        TimerTask timerTask;
        timerTask = new TimerTask() {
        String hora="";
            @Override
            public void run() {
                Platform.runLater(() -> {
                    segundos++;
                    if (segundos == 60) {
                        segundos = 0;
                        if (segundos < 10) {
                            hora=(minutos + ":" + "0" + segundos);
                        } else {
                            hora=(minutos + ":" + segundos);
                        }

                    } else {
                        if (segundos < 10) {
                            hora=(minutos + ":" + "0" + segundos);
                        } else {
                            hora=(minutos + ":" + segundos);
                        }
                    }
                    if (segundos == 0) {
                        minutos++;
                        if (segundos < 10) {
                            hora=(minutos + ":" + "0" + segundos);
                        } else {
                            hora=(minutos + ":" + segundos);
                        }
                        if (minutos < 10) {
                            hora=("0" +minutos + ":" + segundos);
                        } else {
                            hora=("0" +minutos + ":" + segundos);
                        }
                    }
//                    if(minutos>=tiemp){
//                      timer.cancel();     //Cancela el tiempo      
//                    }
                });
            }
        };
        timer.schedule(timerTask, 0, 1000);
    }
    
}
