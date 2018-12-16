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
public class OffState extends State{

    public OffState(RadioRelojImpl reloj) {
        super(reloj);
    }

    @Override
    public String onSwitch() {
        String msg = "Starting radio...";
        reloj.changeState(new RadioState(reloj));
        return msg;
    }

    @Override
    public String onNext() {
        return "Turn on the radio.";
    }

    @Override
    public String onPrevious() {
        return "Turn on the radio.";
    }

    @Override
    public String set() {
        return "Turn on the radio.";
    }

    @Override
    public String Alarm() {
        return "Turn on the radio.";
    }
    
}
