# Vererbung in Java - Schülerprojekt

## Projektbeschreibung

Dieses Repository wurde als Teil eines Schülerprojekts für die 11. Klasse erstellt, um grundlegende Konzepte der Vererbung in der Programmiersprache Java zu vertiefen. Es dient als Ressource für Lernende, um verschiedene Klassen und Vererbungsbeispiele zu untersuchen.

## Vererbung in Java

Die Vererbung ist ein Kernkonzept in der objektorientierten Programmierung (OOP), das es ermöglicht, Code zu organisieren und wiederzuverwenden, indem Klassen von anderen Klassen erben.

## Klassen im Repository

### Personen-Paket
1. **Person.java:** Basisklasse, die grundlegende Informationen über eine Person enthält. Standardsteuerregel: 25% des Einkommens.

2. **Arbeiter.java:** Erbt von Person und repräsentiert eine Arbeitsperson. Steuerregel: 25% des Einkommens abzüglich eines Freibetrags von 2400 Euro.

3. **Banker.java:** Erbt von Person und stellt eine Person im Bankwesen dar. Steuerregel: 25% des Einkommens plus 1000 Euro und eventuelle Abschläge.

4. **Koenigin.java:** Erbt von Person und stellt eine Königin dar. Steuerregel: Keine Steuern.

### Weitere Klassen
5. **Finanzamt.java:** Klasse, die die Berechnung und Ausgabe von Steuerinformationen für eine Gruppe von Personen durchführt.

## Aufgaben für die 11. Klasse

Als Schüler der 11. Klasse sind hier einige empfohlene Aufgaben, um Ihr Verständnis der Vererbung zu vertiefen:

1. **Informationsausgabe:** Erweitern Sie die Klasse `Person` um eine Methode, die die Informationen einer Person ausgibt.

2. **Neue Klasse erstellen:** Erstellen Sie eine weitere Klasse, z.B. `Staff`, die von der Klasse `Person` erbt und spezifische Attribute für Mitarbeiter hinzufügt.

3. **Instanzen erstellen:** In der `Main`-Klasse erstellen Sie Instanzen der neuen Klasse `Staff`, rufen Sie die Methoden auf und stellen Sie sicher, dass die Vererbung korrekt funktioniert.

## Hinweis: GUI-Integration (in Arbeit)

In Zukunft wird ein grafisches Benutzeroberfläche (GUI) hinzugefügt, um die Vererbungskonzepte visuell darzustellen. Schauen Sie regelmäßig vorbei!

---

**Lizenz**

Dieses Projekt ist unter der [MIT-Lizenz](LICENSE.md) lizenziert. Copyright © 2023 SirMrManuel0
