package tarea2.states;

import tarea2.model.RadioRelojImpl;


/**
 * Common interface for all states.
 */
public abstract class State {
    RadioRelojImpl reloj;

    /**
     * Context passes itself through the state constructor. This may help a
     * state to fetch some useful context data if needed.
     */
    State(RadioRelojImpl reloj) {
        this.reloj = reloj; 
    }
    
    public abstract String onSwitch();
    public abstract String onNext();
    public abstract String onPrevious();
    public abstract String set();
    public abstract String Alarm();
}