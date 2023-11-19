public class Person
{
    protected double einkommen;
    protected double abs;
    protected double steuersatz;
    protected String Name;

    public Person(double einkommen, String Name)
    {
        this.einkommen = einkommen;
        this.Name = Name;
        
        abs = 0;
        steuersatz = 0.25;
        if ( steuer() < 0){
            abs = steuer() * -1;
        }
        if (steuer() > einkommen){
            abs = (steuer() - einkommen) * -1;
        }
    }
    
    public double zuVersteuerndesEinkommen(){
        return einkommen;
    }
    
    public void setSteuersatz(double steuersatz){
        this.steuersatz = steuersatz;
    }
    
    public double getSteuersatz(){
        return steuersatz;
    }
    
    public double getAbs(){
        return abs;
    }
    
    public double getEinkommen(){return einkommen;}
    
    public double steuer(){
        return zuVersteuerndesEinkommen() * steuersatz + abs;
    }
    public String getName(){
        return Name;
    }
    
    public String getBeruf(){return "Arbeitslos";}
}
