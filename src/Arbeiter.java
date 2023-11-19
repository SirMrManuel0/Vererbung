public class Arbeiter extends Person
{
    
    public Arbeiter(double einkommen, String Name)
    {
        super(einkommen, Name);
    }
    
    
    public double zuVersteuerndesEinkommen(){
        return einkommen - 2400;
    }
    
    public String getBeruf(){return "Arbeiter";}
}
