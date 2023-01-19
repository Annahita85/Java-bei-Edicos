/**
 * implement this interface with a class called "[yourGivenName]VerwendungszweckGenerator"
<p>Remark: initially created with package name de.edicos.azubi.sascha.fundgourmet.zahlung</p>
 */
package de.edicos.azubi.aufgabe6;

/**
 * Erstellt einen codierten Verwendungszweck.
 * 
 * <p>Anforderungen und Konzept sind im nachfolgenden Mailverkehr dokumentiert:</p>
 * <pre>
 *  -----Ursprüngliche Nachricht-----
Von: Cornelius, Koepp 
Gesendet: Donnerstag, 16. Oktober 2014 14:29
[...]
Betreff: AW: FFM / Verwendungszweck zur eindeutigen Zuordnung von für Überweisungen

1) Den Namensbestandteil sollten wir vor allem aus historischen Gründen mitziehen, bzw. damit die Franzosen auf deren Geld das Konto eingeht noch eine Chance zur Zuordnung haben.

2) Codierung auf Basis36 finde ich grundsätzliche eine gute Idee. Den Offset könnten wir ggf. vorher noch abziehen. Ggf. sollten wir allerdings noch darüber nachdenken den Zeichenvorrat zu reduzieren um Zeichen die sich leicht verwechseln lassen auszuschließen. Z.B. 0/O, 1/I, 5/S

3) Um dem potentiellen Längenproblem (@Alexander: Könnten es nicht vielleicht auch 2x27 Zeichen sein? Früher gab es zumindest immer zwei Zeilen; @HJvM: Möglicherweise unterstützen das aber mal wieder nicht alle Banken) entgegen zu wirken könnten wir den Code nach vorne ziehen:

FG-FFM2015-PA2D-T4S6-VONMETTE-HANSJRG

FG-DB-AE-T4S6-VONMETTE-HANSJRG
FG-DB-AF-T4S6-VONMETTE-HANSJRG

4) Key bei der Anzeige in der DB abzulegen hört sich sinnvoll an. Dann könnten wir auf dieser Basis (Optional) ggf. auch später noch den Zahlungseingang erfassen und bei Bedarf eine simple Liste der erfolgten Zahlungen für den User ausgeben.

Gruß
Cornelius

[...]

-----Ursprüngliche Nachricht-----
Von: Jakobi, Alexander 
Gesendet: Donnerstag, 16. Oktober 2014 13:11
An: Cornelius, Koepp
Cc: fundboiler.reporting_extern
Betreff: AW: FFM / Verwendungszweck zur eindeutigen Zuordnung von für Überweisungen

- Von der Idee, Namensbestandteile im Verwendungszweck einer Überweisung zu speichern, müsst ihr mich erst überzeugen.
- Ich würde die Zahlungseingänge tatsächlich in einer Tabelle speichern.
- Die UserId ist in Liferay eine bislang 5 bis 6stellige Nummer, die allerdings mit einem Offset beginnt. Mit 3stelligen alphanumerischen Kombinationen (0-9A-Z) {3} lassen sich 46TSD Kombinationen erzeugen (bei Überlauf wieder mit 0 anfangen)

- Besser wäre es, bei Anzeige der Überweisungsdaten gleich einen Record mit Key zu erzeugen, der im Verwendungszweck auftaucht, und dessen Zahlungseingang genau in diesem Record (in der neuen Tabelle) eingetragen wird.



-----Ursprüngliche Nachricht-----
Von: Cornelius, Koepp 
Gesendet: Donnerstag, 16. Oktober 2014 12:58
An: fundboiler.reporting_extern
Cc: Jakobi, Alexander
Betreff: AW: FFM / Verwendungszweck zur eindeutigen Zuordnung von für Überweisungen

Alternativer und ergänzender Vorschlag:

Prüfziffern würden uns nur helfen wenn wir eine zusätzliche Redundanz bekommen. 

FG-FFM2015-PA2D-VONMETTE-HANSJRG-999

* Reihenfolge geändert, damit alle betragsgleichen Zahlungen ein identisches Präfix haben
* Vornamen reduziert auf 8 Buchstaben und nur lateinische Buchstaben um Probleme mit häufigen Nachnamen auszuschließen.
* 999 interne User-ID in unserem System (@Alexander: haben wir eine kurze und prägnante ID in Liferay?)

Für die Paper-DB dann analog

FG-DB-AE-VONMETTE-HANSJRG-999 
FG-DB-AF-VONMETTE-HANSJRG-999

Wieder mit A/N für (non)academic + E/F für erstmaliges/folgendes Abo

@Alexander: Vielleicht ist es auch sinnvoll wenn wir die eine Tabelle mit den Spalten User(ID+Company),Verwendungszweck,Zahlungseingang erstellen oder das zumindest in ein Log wegschreiben. Dann ist eine nachträgliche Zuordnung problemlos möglich. Lohnt sich aber nur wenn wir dadurch z.B. Vorteile bei der Abo-Abwicklung hätten und wird uns die Möglichkeit offen halten die Struktur später noch für andere Zahlungssysteme zu nutzen...

Gruß
Cornelius

[...]

-----Ursprüngliche Nachricht-----
Von: Hans-Jörg von Mettenheim [...] 
Gesendet: Donnerstag, 16. Oktober 2014 12:24
An: Cornelius, Koepp
Betreff: FFM

Konferenz:

FG-FFM2015-VONMETTENPA2D-XZ-9

Bestandteile:

FG für FundGourmets
FFM2015 für die Konferenz
Die ersten acht Buchstaben des Nachnahmens (Leer- und Sonderzeichen ggf. 
entfernen. Falls Nachname kürzer, so übernehmen)

P (oder N) für Presenter bzw. non-presenter A (oder N) für Academic bzw. non-academic 2D (für 2 mal Dinner, oder sonst eben 0D, 1D)

XZ ein alphanumerischer Zufallscode, um Namensdoppelungen zu verhindern

9 Ein Hash-Zeichen, das ggf. einfache Überprüfungen ermöglicht. (Welches Verfahren dafür genau geeignet ist, weiß ich nicht. Bei der ISBN wird das ja auch so gemacht, vielleicht etwas Ähnliches.)

Viele Grüße,
Hans-Jörg
</pre>

 * @author ckoepp
 * @version 1.1
 */
public interface IVerwendungszweckGenerator {

	public String verwendungszweckFfm(int year, boolean academic, boolean presenter, int dinner, int userid, String givenName, String familyName);

	public String verwendungszweckPaperDB(boolean first, boolean academic, int userid, String givenName, String familyName);
	
}
