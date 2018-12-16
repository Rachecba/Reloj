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
    int alarmaHoras=0;
    int alarmaMinutos=0;
    String hora="";
    String alarma="";
    Timer timer = new Timer();

    
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
    
    public void nextMinAlarm() {
        alarmaHoras++;
    }

    public void previusMinAlarm() {
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
    
    public void timeCronometro2() {
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
                        if(alarmaHoras==horas&&alarmaMinutos==minutos){
                            alarmaSonando=true;
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask, 0, 1000);
        
    }
    
    public String horaAlarma(){
        if(alarmaHoras<10){
            if(alarmaMinutos<10){
                alarma = "0"+alarmaHoras+"0"+alarmaMinutos;
            }else{
                alarma = "0"+alarmaHoras+alarmaMinutos;
            }
        }else{
            if(alarmaMinutos<10){
                alarma = alarmaHoras+"0"+alarmaMinutos;
            }else{
                alarma = ""+alarmaHoras+alarmaMinutos;
            }
        }
        return alarma;
    }
    
    public String getHora(){ //manda la hora al view.
        return this.hora;
    }

    public boolean isAlarmaOn() {
        return alarmaOn;
    }

    public void setAlarmaOn(boolean alarmaOn) {
        this.alarmaOn = alarmaOn;
    }

    public boolean isAlarmaSonando() {
        return alarmaSonando;
    }

    public void setAlarmaSonando(boolean alarmaSonando) {
        this.alarmaSonando = alarmaSonando;
    }

    public List<String> getEmisorasList() {
        return EmisorasList;
    }

    public void setEmisorasList(List<String> EmisorasList) {
        this.EmisorasList = EmisorasList;
    }

    public static int getEmisora() {
        return Emisora;
    }

    public static void setEmisora(int Emisora) {
        RadioRelojEngine.Emisora = Emisora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getAlarmaHoras() {
        return alarmaHoras;
    }

    public void setAlarmaHoras(int alarmaHoras) {
        this.alarmaHoras = alarmaHoras;
    }

    public int getAlarmaMinutos() {
        return alarmaMinutos;
    }

    public void setAlarmaMinutos(int alarmaMinutos) {
        this.alarmaMinutos = alarmaMinutos;
    }
    
}
