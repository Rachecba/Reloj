/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2.model;

import java.util.function.Consumer;

/**
 *
 * @author tvkev
 */
public interface RadioReloj {
    void attach(Consumer<String> listener);
    void onInit();
    
    void onSwitch();
    void onNext();
    void onPrevious();
    void set();
    void Alarm();
}
