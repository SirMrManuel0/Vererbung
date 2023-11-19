package Personen;

public class Koenigin extends Person
{
    
    public Koenigin(double einkommen, String Name)
    {
        super(einkommen, Name);
        super.steuersatz = 0;
    }
    public double zuVersteuerndesEinkommen(){
        return 0;
    }
    
    public double steuer(){
        return 0;
    }
    
    public String getBeruf(){return "Königin";}
}
