package Personen;

public class Banker extends Person
{

    /**
     * Konstruktor für die Banker-Klasse.
     *
     * @param einkommen Das Einkommen des Bankers.
     * @param Name      Der Name des Bankers.
     */
    public Banker(double einkommen, String Name)
    {
        super(einkommen, Name);
    }

    /**
     * {@inheritDoc}
     * Berechnet die Steuer für den Banker unter Berücksichtigung spezifischer Regeln.
     */
    public double steuer(){
        return zuVersteuerndesEinkommen() * getSteuersatz() + 1000 + getAbs();
    }
    
    public String getBeruf(){return "Personen.Banker";}
}
