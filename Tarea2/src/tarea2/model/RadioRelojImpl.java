/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2.model;

import java.util.function.Consumer;
import tarea2.states.InitState;
import tarea2.states.RadioState;
import tarea2.states.State;

/**
 *
 * @author tvkev
 */
public class RadioRelojImpl implements RadioReloj {
    State state; 
    RadioRelojEngine engine;
    Consumer<String> listener;
    
    public RadioRelojImpl(RadioRelojEngine radio){
        this.engine = radio;
        this.state = new InitState(this);
        this.state = new RadioState(this);
    }
    
    public void changeState(State state){
        System.out.println("Changing to " + state.getClass().getSimpleName()); //agarra el nombre de la clase del estado que se pasa por parametro.
        this.state = state;
    }

    public State getState(){
        return this.state;
    }
    
    public RadioRelojEngine getEngine(){
        return this.engine;
    }
    
    @Override
    public void attach(Consumer<String> listener) {
        this.listener = listener;
    }

    @Override
    public void onInit() { //inicializa
       listener.accept(engine.getRadioList().get(0)); //inicializa la emisora en 0.
       engine.timeCronometro2(); //para que se inicialice la hora. 
       listener.accept(engine.getHora()); //inicializa la hora del reloj.
    }

    @Override
    public void onSwitch() {
        listener.accept(state.onSwitch());
    }

    @Override
    public void onNext() {
        listener.accept(state.onNext());
    }

    @Override
    public void onPrevious() {
        listener.accept(state.onPrevious());
    }

    @Override
    public void set() {
        listener.accept(state.set());
    }

    @Override
    public void Alarm() {
        listener.accept(state.Alarm());
    }
    
    
}
