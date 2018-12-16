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
public class RadioState extends State{

    public RadioState(RadioRelojImpl reloj) {
        super(reloj);
        reloj.getEngine().turnOff(); //inicia el reloj apagado
    }

    @Override
    public String onSwitch() {
        String msg = "Goodbye my friend...";
        reloj.changeState(new OffState(reloj));
        
        return msg;
    }

    @Override
    public String onNext() {
        return reloj.getEngine().nextEmisora();
    }

    @Override
    public String onPrevious() {
        return reloj.getEngine().previusEmisora();
    }

    @Override
    public String set() {
        reloj.changeState(new ClockState(reloj));
        return "Changing to clock mode...";
    }

    @Override
    public String Alarm() {
        reloj.changeState(new AlarmState(reloj));
        return "Changing to alarm mode...";
    }
    
}
