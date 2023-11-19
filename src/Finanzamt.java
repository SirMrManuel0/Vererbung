import Personen.Person;

import java.text.DecimalFormat;

public class Finanzamt
{
    
    private DecimalFormat meinFormat;
    private Person[] Menschen;
    
    
    public Finanzamt()
    {
        meinFormat = new DecimalFormat("###,###,##0.00");
    }

    public double berechneSteuer(Person[] Menschen){
        double alleSteuern = 0;
        
        this.Menschen = Menschen;
        
        for (Person Mensch : Menschen){
            alleSteuern += Mensch.steuer();
        }
        
        
        
        return alleSteuern;
    }
    
    public void Ausgabe() throws Exception {
        
        try{
            
            Person Temp = Menschen[0];
            
        } catch (Exception e){
            throw new Exception("Keine Personen gegeben. Benutze zuerst berechneSteuer(Personen.Person[]).");
        }
        
        
        DecimalFormat loopFormat = meinFormat;
        for (Person Mensch : Menschen){
            // Sklave.steuer()
            
            
            System.out.println();
            System.out.println();
            System.out.println("---------- " + Mensch.getBeruf() + ": " + Mensch.getName() + " ----------");
            System.out.println();
            System.out.println("Einkommen: " + loopFormat.format(Mensch.getEinkommen()));
            System.out.println("Steuersatz: " + Mensch.getSteuersatz() + "%");
            System.out.println("Steuern: " + loopFormat.format(Mensch.steuer()) + " €");
            System.out.println("Einkommen nach Steuern: " + loopFormat.format(Mensch.getEinkommen()-Mensch.steuer()) + " €");
            
            
            
        }
    }
}
