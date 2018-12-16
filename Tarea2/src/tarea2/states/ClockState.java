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
public class ClockState extends State{

    public ClockState(RadioRelojImpl reloj) {
        super(reloj);
    }

    @Override
    public String onSwitch() {
        reloj.changeState(new OffState(reloj));
        return "See yah...";
    }

    @Override
    public String onNext() {
        reloj.getEngine().nextMin();
        return reloj.getEngine().getHora();
    }

    @Override
    public String onPrevious() {
        reloj.getEngine().previusMin();
        return reloj.getEngine().getHora();
    }

    @Override
    public String set() {
        reloj.changeState(new RadioState(reloj));
        return "Changing to radio mode...";
    }

    @Override
    public String Alarm() {
        reloj.changeState(new AlarmState(reloj));
        return "Changing to alarm mode...";
    }
    
}
