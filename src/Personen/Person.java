package Personen;

public class Person {
    // Attribute einer Person
    protected double einkommen;
    protected double abs;
    protected double steuersatz;
    protected String Name;

    /**
     * Konstruktor für die Person-Klasse.
     *
     * @param einkommen Das Einkommen der Person.
     * @param Name      Der Name der Person.
     */
    public Person(double einkommen, String Name) {
        this.einkommen = einkommen;
        this.Name = Name;

        abs = 0;
        steuersatz = 0.25;

        if (steuer() < 0) {
            abs = steuer() * -1;
        }
        if (steuer() > einkommen) {
            abs = (steuer() - einkommen) * -1;
        }
    }

    public double zuVersteuerndesEinkommen() {
        return einkommen;
    }

    public void setSteuersatz(double steuersatz) {
        this.steuersatz = steuersatz;
    }

    public double getSteuersatz() {
        return steuersatz;
    }

    public double getAbs() {
        return abs;
    }

    public double getEinkommen() {
        return einkommen;
    }

    /**
     * Berechnet die Steuer für die Person.
     *
     * @return Die berechnete Steuer.
     */
    public double steuer() {
        return zuVersteuerndesEinkommen() * steuersatz + abs;
    }

    public String getName() {
        return Name;
    }

    public String getBeruf() {
        return "Arbeitslos";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName() + '\'' +
                ", beruf='" + getBeruf() + '\'' +
                ", einkommen=" + einkommen +
                ", steuer=" + steuer() +
                '}';
    }
}
