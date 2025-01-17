

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscolab.modelos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.text.*;

/**
 *
 * @author Julia
 */
public class Validacao {

    public static int[] splitDate(String date){
        
        String[] dateS = date.split("-");
        
        int[] dateI= new int[3];
        
        dateI[0] = Integer.parseInt(dateS[0]);
        dateI[1] = Integer.parseInt(dateS[1]);
        dateI[2] = Integer.parseInt(dateS[2]);
        
        return dateI;
    }
    
    public static String convertToDateString(Date date) {
        String pattern = "DD-MM-YYYY"; 
        //(or another date format, like in dutch: "DD-MM-YYY"
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }
    
    public static int[] convertDate(String data){
        char[] dataC = null;
        String dataS = data;
        
        dataC = dataS.toCharArray();
        
        //dia
        char data0 = dataC[0];
        char data1 = dataC[1];
        StringBuilder dia = new StringBuilder();
        dia.append(data0);
        dia.append(data1);
        
        //mes
        char data3 = dataC[3];
        char data4 = dataC[4];
        StringBuilder mes = new StringBuilder();
        mes.append(data3);
        mes.append(data4);
        
        //ano
        char data6 = dataC[6];
        char data7 = dataC[7];
        char data8 = dataC[8];
        char data9 = dataC[9];
        StringBuilder ano = new StringBuilder();
        ano.append(data6);
        ano.append(data7);
        ano.append(data8);
        ano.append(data9);
        
        
        int[] dataA = new int[3];
        
        dataA[0] = Integer.parseInt(dia.toString());
        dataA[1] = Integer.parseInt(mes.toString());
        dataA[2] = Integer.parseInt(ano.toString());
        
        return dataA;
    }

    
    /* public static void Mascara(String Mascara, JFormattedTextField campo){
        MaskFormatter F_Mascara;
        try{
            F_Mascara = new MaskFormatter(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter('_'); //Caracter para preencimento 
            F_Mascara.install(campo);
        }
        catch (ParseException excecao) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto.", "ERRO", JOptionPane.ERROR_MESSAGE);
           
        } 
    }*/
     
     
     
    /* public static class SoLetras extends PlainDocument{
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException{
            super.insertString(offs, str.replaceAll("[^a-zA-Z]", ""), a);
        }
    }*/
     
    /*public static class SoNumeros extends PlainDocument{
        
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException{
            super.insertString(offs, str.replaceAll("[^\\d.]", ""), a);
        }
    }*/
     
    public static boolean validaData(int[] data) throws Exception{
     int dia = Calendar.getInstance().get(Calendar.DATE);
        int mes = Calendar.getInstance().get(Calendar.MONTH);
        int ano = Calendar.getInstance().get(Calendar.YEAR);
        
        
        if (data[0] < dia){
            if (data[1] < mes){
                if (data[2] < ano){
                    throw new Exception("Data Inválida");
                }
            }
        }
        
        else{
            if (data[1] < mes){
                if (data[2] < ano){
                    throw new Exception("Data Inválida");
                }
            }
            else{
                if (data[2] < ano){
                    throw new Exception("Data Inválida");
                }
            }    
        }
        return true;
    }
    
    public static boolean validaNasc(int[] data) throws Exception{
     int dia = Calendar.getInstance().get(Calendar.DATE);
        int mes = Calendar.getInstance().get(Calendar.MONTH);
        int ano = Calendar.getInstance().get(Calendar.YEAR);

        if (data[0] > dia){
            if (data[1] > mes){
                if (data[2] > ano){
                    throw new Exception("Data Inválida");
                }
            }
        }
        
        else{
            if (data[1] > mes){
                if (data[2] > ano){
                    throw new Exception("Data Inválida");
                }
            }
            else{
                if (data[2] > ano){
                    throw new Exception("Data Inválida");
                }
            }    
        }
        return true;
    }
    
    public static boolean validaEmail(String email) throws Exception{
        if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", email))){
            
            throw new Exception("Email Inválido");
        }else{
            return true;
        }
    }
    
    public static boolean isNotEmpty(String text){
        if (text.equals("")) {
            return false;
        }else{
            return true;
        }   
    }
    
    public static boolean validaCpf(String cpf1) throws Exception{
        String cpf = cpf1.replaceAll("[^0-9]", "");
        if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999") ||
            (cpf.length() != 11)){
            
           throw new Exception("CPF Inválido");
        }
        
        else{
            char dig10, dig11;
            int sm, i, r, num, peso;
          
            sm = 0;
            peso = 10;
            
            for (i=0; i<9; i++) {              
                num = (int)(cpf.charAt(i) - 48); 
                sm = sm + (num * peso);
                peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)){
                dig10 = '0';
            }
                
            else{
                dig10 = (char)(r + 48);
            }
          
            sm = 0;
            peso = 11;
            
            for(i=0; i<10; i++) {
                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            
            if ((r == 10) || (r == 11)){
                dig11 = '0';
            }
            
            else{
                dig11 = (char)(r + 48);
            }
         
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))){
                return true;
            }
            
            else {
                throw new Exception("CPF Inválido");
            }
        }
    }
    
     public static boolean validaCnpj(String cnpj1) throws Exception{
        String cnpj = cnpj1.replaceAll("[^0-9]", "");
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
            cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
            cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
            cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
            cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
            (cnpj.length() != 14)){
            throw new Exception("CNPJ Inválido");
        }

        else{
            char dig13, dig14;
            int sm, i, r, num, peso;

            sm = 0;
            peso = 2;

            for (i=11; i>=0; i--) {
                num = (int)(cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10){
                    peso = 2;
                }
            }

        
            r = sm % 11;

            if ((r == 0) || (r == 1)){
                dig13 = '0';
            }

            else{
                dig13 = (char)((11-r) + 48);
            }


            sm = 0;
            peso = 2;

            for (i=12; i>=0; i--) {
                num = (int)(cnpj.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10){
                    peso = 2;

                }
            }

            r = sm % 11;

            if ((r == 0) || (r == 1)){
                dig14 = '0';
            }

            else{
                dig14 = (char)((11-r) + 48);
            }

            if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))){
                return(true);
            }
            else{
                throw new Exception("CNPJ Inválido");
            }

        }
    }
     
    public static boolean validaRg(String rg1) throws Exception{
        String rg = rg1.replaceAll("[^0-9]", "");
        for (int i = 0; i < rg.length(); i++) {
          if (Character.isLetter(rg.charAt(i))){
              throw new Exception("RG Inválido");
          }
        }
        return true;
    }
}
   