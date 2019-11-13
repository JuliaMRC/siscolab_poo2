/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.cruds;

/**
 *
 * @author Julia
 */
public class utils {
    
    public static String converteData(int[] dataNasc){
        
        String data;
        
        if(dataNasc[1]<10){
            
            data = String.format("%d-0%d-", dataNasc[2], dataNasc[1]);
        }
        else{
            data = String.format("%d-%d-", dataNasc[2], dataNasc[1]);
        }
        
        if(dataNasc[1]<10){
            data += String.format("0%d", dataNasc[0]);
        }
        else{
            data += String.format("%d", dataNasc[0]);
        }
        
        return data;
    
    }
}
