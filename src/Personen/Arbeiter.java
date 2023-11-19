package Personen;

public class Arbeiter extends Person
{

    /**
     * Konstruktor für die Arbeiter-Klasse.
     *
     * @param einkommen Das Einkommen des Arbeiters.
     * @param Name      Der Name des Arbeiters.
     */
    public Arbeiter(double einkommen, String Name)
    {
        super(einkommen, Name);
    }

    /**
     * {@inheritDoc}
     * Berechnet das zu versteuernde Einkommen spezifisch für Arbeiter.
     */
    public double zuVersteuerndesEinkommen(){
        return einkommen - 2400;
    }
    
    public String getBeruf(){return "Personen.Arbeiter";}
}
