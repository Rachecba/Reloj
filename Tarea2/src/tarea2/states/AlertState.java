/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2.states;

import tarea2.model.RadioRelojImpl;

/**
 *
 * @author Rachel
 */
public class AlertState extends State{

    public AlertState(RadioRelojImpl reloj) {
        super(reloj);
    }

    @Override
    public String onSwitch() {
        reloj.changeState(new OffState(reloj));
        return "Bye bye...";
    }

    @Override
    public String onNext() {
        return "Press alarm to turn off the alarm...";
    }

    @Override
    public String onPrevious() {
        return "Press alarm to turn off the alarm...";
    }

    @Override
    public String set() {
        return "Press alarm to turn off the alarm...";
    }

    @Override
    public String Alarm() {
        reloj.changeState(new ClockState(reloj));
        reloj.getEngine().setAlarmaOn(false);
        
        return "Turning off the alarm...";
    }
    
}
