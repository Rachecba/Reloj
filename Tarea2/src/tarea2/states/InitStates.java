/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2.states;

import java.util.ArrayList;
import java.util.List;
import tarea2.model.RadioRelojImpl;

/**
 *
 * @author Rachel
 */
public class InitStates extends State{

    public InitStates(RadioRelojImpl reloj) {
        super(reloj);
        
        List emisoras = new ArrayList<>();
        
        for(int i = 0; i < 10; i++) //creo las emisoras
            emisoras.add("99."+i);
        
        reloj.getEngine().setRadioList(emisoras); //seteo las emisoras en engine.
    }

    @Override
    public String onSwitch() {
        return "Starting...";
    }

    @Override
    public String onNext() {
        return "Starting...";
    }

    @Override
    public String onPrevious() {
       return "Starting...";
    }

    @Override
    public String set() {
        return "Starting...";
    }

    @Override
    public String Alarm() {
        return "Starting...";
    }
    
    
}
