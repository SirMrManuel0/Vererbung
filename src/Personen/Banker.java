package Personen;

public class Banker extends Person
{
    
    public Banker(double einkommen, String Name)
    {
        super(einkommen, Name);
    }
    
    public double steuer(){
        return zuVersteuerndesEinkommen() * getSteuersatz() + 1000 + getAbs();
    }
    
    public String getBeruf(){return "Personen.Banker";}
}
