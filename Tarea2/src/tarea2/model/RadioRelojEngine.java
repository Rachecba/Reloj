/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
    boolean alarmaOn = false;
    boolean alarmaSonando = false;
    private List<String> EmisorasList;
    static int Emisora;
    int minutos = 1;
    int horas = 0;
    int Alarmahoras=0;
    int AlarmaSegndos=0;
    String hora="";

    
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
        horas++;
    }

    public void previusMin() {
        minutos--;
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
        
        Calendar calendario = new GregorianCalendar();
        horas = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    minutos++;
                    if (minutos == 60) {
                        minutos = 0;
                        if (minutos < 10) {
                            hora=(horas + ":" + "0" + minutos);
                        } else {
                            hora=(horas + ":" + minutos);
                        }

                    } else {
                        if (minutos < 10) {
                            hora=(horas + ":" + "0" + minutos);
                        } else {
                            hora=(horas + ":" + minutos);
                        }
                    }
                    if (minutos == 0) {
                        horas++;
                        if (minutos < 10) {
                            hora=(horas + ":" + "0" + minutos);
                        } else {
                            hora=(horas + ":" + minutos);
                        }
                        if (horas < 10) {
                            hora=("0" +horas + ":" + minutos);
                        } else {
                            hora=("0" +horas + ":" + minutos);
                        }
                    }
                    if(alarmaOn){
                        if(Alarmahoras==horas&&AlarmaSegndos==minutos){
                            alarmaSonando=true;
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask, 0, 1000);
    }
    
}
