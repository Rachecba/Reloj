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
public class AlarmState extends State{

    public AlarmState(RadioRelojImpl reloj) {
        super(reloj);
        
        if(!reloj.getEngine().isAlarmaOn()){
            reloj.getEngine().setAlarmaHoras(reloj.getEngine().getHoras());
            reloj.getEngine().setAlarmaMinutos(reloj.getEngine().getMinutos());
            reloj.getEngine().setAlarmaOn(true);
        }
    }

    @Override
    public String onSwitch() {
        reloj.changeState(new OffState(reloj));
        return "Come back soon...";
    }

    @Override
    public String onNext() {
        reloj.getEngine().nextMinAlarm();
        
    }

    @Override
    public String onPrevious() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String set() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Alarm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
