/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.modelos;

import java.util.ArrayList;

/**
 *
 * @author Julia
 */
public class Observable {
    ArrayList<Observer> monitores = new ArrayList();
    public void addObserver(Observer ob){
        this.monitores.add(ob);
    }

    public void notifyObserver(){
        for(Observer ob : monitores){
            ob.update(this);
        }
    }
}
