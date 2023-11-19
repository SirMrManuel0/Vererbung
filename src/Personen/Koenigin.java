package Personen;

public class Koenigin extends Person
{

    /**
     * Konstruktor für die Koenigin-Klasse.
     *
     * @param einkommen Das Einkommen der Königin.
     * @param Name      Der Name der Königin.
     */
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
