import java.text.DecimalFormat;

public class Finanzamt
{
    
    private DecimalFormat meinFormat;
    private Person[] Sklaven;
    
    
    public Finanzamt()
    {
        meinFormat = new DecimalFormat("###,###,##0.00");
    }

    public double berechneSteuer(Person[] Sklaven){
        double alleSteuern = 0;
        
        this.Sklaven = Sklaven;
        
        for (Person Sklave : Sklaven){
            alleSteuern += Sklave.steuer();
        }
        
        
        
        return alleSteuern;
    }
    
    public void Ausgabe() throws Exception {
        
        try{
            
            Person Temp = Sklaven[0];
            
        } catch (Exception e){
            throw new Exception("Keine Personen gegeben. Benutze zuerst berechneSteuer(Person[]).");
        }
        
        
        DecimalFormat loopFormat = meinFormat;
        for (Person Sklave : Sklaven){
            // Sklave.steuer()
            
            
            System.out.println();
            System.out.println();
            System.out.println("---------- " + Sklave.getBeruf() + ": " + Sklave.getName() + " ----------");
            System.out.println();
            System.out.println("Einkommen: " + loopFormat.format(Sklave.getEinkommen()));
            System.out.println("Steuersatz: " + Sklave.getSteuersatz() + "%");
            System.out.println("Steuern: " + loopFormat.format(Sklave.steuer()) + " €");
            System.out.println("Einkommen nach Steuern: " + loopFormat.format(Sklave.getEinkommen()-Sklave.steuer()) + " €");
            
            
            
        }
    }
}
