/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_convertisseurobjet_barois_bernard;

/**
 *
 * @author Elou
 */


public class Convertisseur {
    int nbConversions;
    
    public Convertisseur () {
        nbConversions = 0 ;
    }

    public double CelciusVersKelvin ( double tempCelcius) {
        // à completer
        double tempKelvin = 0;
        tempKelvin = tempCelcius+(273.15) ;
        nbConversions+=1;
        return (tempKelvin);
    }
    
    public double KelvinVersCelcius ( double tempKelvin) {
        // à completer
        double tempCelcius = 0;
        tempCelcius = (tempKelvin-(273.15)) ;
        nbConversions+=1;
        return (tempCelcius);
    }
    
    public double FarenheitVersCelcius ( double tempFarenheit) {
        // à completer
        double tempCelcius = 0;
        tempCelcius = (tempFarenheit-(32))*(5./9.) ;
        nbConversions+=1;
        return (tempCelcius);
    }
    
    public double CelciusVersFarenheit ( double tempCelcius) {
        // à completer
        double tempFarenheit = 0;
        tempFarenheit = (tempCelcius*(9./5.))+(32) ;
        nbConversions+=1;
        return (tempFarenheit);
    }
    
    public double KelvinVersFarenheit ( double tempKelvin) {
        // à completer
        double tempFarenheit = 0;
        tempFarenheit = (tempKelvin-(273.15)*(9./5.))+(32) ;
        nbConversions+=1;
        return (tempFarenheit);
    }
    
    public double FarenheitVersKelvin ( double tempFarenheit) {
        // à completer
        double tempKelvin = 0;
        tempKelvin = ((tempFarenheit-32)*(5./9.))+(273.15) ;
        nbConversions+=1;
        return (tempKelvin);
    }
    @Override
    public String toString () {
        return "nb de conversions "+ nbConversions;
    }
}
