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
 *  -----Urspr�ngliche Nachricht-----
Von: Cornelius, Koepp 
Gesendet: Donnerstag, 16. Oktober 2014 14:29
[...]
Betreff: AW: FFM / Verwendungszweck zur eindeutigen Zuordnung von f�r �berweisungen

1) Den Namensbestandteil sollten wir vor allem aus historischen Gr�nden mitziehen, bzw. damit die Franzosen auf deren Geld das Konto eingeht noch eine Chance zur Zuordnung haben.

2) Codierung auf Basis36 finde ich grunds�tzliche eine gute Idee. Den Offset k�nnten wir ggf. vorher noch abziehen. Ggf. sollten wir allerdings noch dar�ber nachdenken den Zeichenvorrat zu reduzieren um Zeichen die sich leicht verwechseln lassen auszuschlie�en. Z.B. 0/O, 1/I, 5/S

3) Um dem potentiellen L�ngenproblem (@Alexander: K�nnten es nicht vielleicht auch 2x27 Zeichen sein? Fr�her gab es zumindest immer zwei Zeilen; @HJvM: M�glicherweise unterst�tzen das aber mal wieder nicht alle Banken) entgegen zu wirken k�nnten wir den Code nach vorne ziehen:

FG-FFM2015-PA2D-T4S6-VONMETTE-HANSJRG

FG-DB-AE-T4S6-VONMETTE-HANSJRG
FG-DB-AF-T4S6-VONMETTE-HANSJRG

4) Key bei der Anzeige in der DB abzulegen h�rt sich sinnvoll an. Dann k�nnten wir auf dieser Basis (Optional) ggf. auch sp�ter noch den Zahlungseingang erfassen und bei Bedarf eine simple Liste der erfolgten Zahlungen f�r den User ausgeben.

Gru�
Cornelius

[...]

-----Urspr�ngliche Nachricht-----
Von: Jakobi, Alexander 
Gesendet: Donnerstag, 16. Oktober 2014 13:11
An: Cornelius, Koepp
Cc: fundboiler.reporting_extern
Betreff: AW: FFM / Verwendungszweck zur eindeutigen Zuordnung von f�r �berweisungen

- Von der Idee, Namensbestandteile im Verwendungszweck einer �berweisung zu speichern, m�sst ihr mich erst �berzeugen.
- Ich w�rde die Zahlungseing�nge tats�chlich in einer Tabelle speichern.
- Die UserId ist in Liferay eine bislang 5 bis 6stellige Nummer, die allerdings mit einem Offset beginnt. Mit 3stelligen alphanumerischen Kombinationen (0-9A-Z) {3} lassen sich 46TSD Kombinationen erzeugen (bei �berlauf wieder mit 0 anfangen)

- Besser w�re es, bei Anzeige der �berweisungsdaten gleich einen Record mit Key zu erzeugen, der im Verwendungszweck auftaucht, und dessen Zahlungseingang genau in diesem Record (in der neuen Tabelle) eingetragen wird.



-----Urspr�ngliche Nachricht-----
Von: Cornelius, Koepp 
Gesendet: Donnerstag, 16. Oktober 2014 12:58
An: fundboiler.reporting_extern
Cc: Jakobi, Alexander
Betreff: AW: FFM / Verwendungszweck zur eindeutigen Zuordnung von f�r �berweisungen

Alternativer und erg�nzender Vorschlag:

Pr�fziffern w�rden uns nur helfen wenn wir eine zus�tzliche Redundanz bekommen. 

FG-FFM2015-PA2D-VONMETTE-HANSJRG-999

* Reihenfolge ge�ndert, damit alle betragsgleichen Zahlungen ein identisches Pr�fix haben
* Vornamen reduziert auf 8 Buchstaben und nur lateinische Buchstaben um Probleme mit h�ufigen Nachnamen auszuschlie�en.
* 999 interne User-ID in unserem System (@Alexander: haben wir eine kurze und pr�gnante ID in Liferay?)

F�r die Paper-DB dann analog

FG-DB-AE-VONMETTE-HANSJRG-999 
FG-DB-AF-VONMETTE-HANSJRG-999

Wieder mit A/N f�r (non)academic + E/F f�r erstmaliges/folgendes Abo

@Alexander: Vielleicht ist es auch sinnvoll wenn wir die eine Tabelle mit den Spalten User(ID+Company),Verwendungszweck,Zahlungseingang erstellen oder das zumindest in ein Log wegschreiben. Dann ist eine nachtr�gliche Zuordnung problemlos m�glich. Lohnt sich aber nur wenn wir dadurch z.B. Vorteile bei der Abo-Abwicklung h�tten und wird uns die M�glichkeit offen halten die Struktur sp�ter noch f�r andere Zahlungssysteme zu nutzen...

Gru�
Cornelius

[...]

-----Urspr�ngliche Nachricht-----
Von: Hans-J�rg von Mettenheim [...] 
Gesendet: Donnerstag, 16. Oktober 2014 12:24
An: Cornelius, Koepp
Betreff: FFM

Konferenz:

FG-FFM2015-VONMETTENPA2D-XZ-9

Bestandteile:

FG f�r FundGourmets
FFM2015 f�r die Konferenz
Die ersten acht Buchstaben des Nachnahmens (Leer- und Sonderzeichen ggf. 
entfernen. Falls Nachname k�rzer, so �bernehmen)

P (oder N) f�r Presenter bzw. non-presenter A (oder N) f�r Academic bzw. non-academic 2D (f�r 2 mal Dinner, oder sonst eben 0D, 1D)

XZ ein alphanumerischer Zufallscode, um Namensdoppelungen zu verhindern

9 Ein Hash-Zeichen, das ggf. einfache �berpr�fungen erm�glicht. (Welches Verfahren daf�r genau geeignet ist, wei� ich nicht. Bei der ISBN wird das ja auch so gemacht, vielleicht etwas �hnliches.)

Viele Gr��e,
Hans-J�rg
</pre>

 * @author ckoepp
 * @version 1.1
 */
public interface IVerwendungszweckGenerator {

	public String verwendungszweckFfm(int year, boolean academic, boolean presenter, int dinner, int userid, String givenName, String familyName);

	public String verwendungszweckPaperDB(boolean first, boolean academic, int userid, String givenName, String familyName);
	
}
