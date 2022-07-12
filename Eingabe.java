import java.util.Scanner;

public class Eingabe {
 static Scanner scanner;

 public Eingabe(Scanner Iscanner) {
  scanner = Iscanner;
 }

 // Note
 public static Integer noteEinlesen() {
  String note = "";
  Integer index = 0;

  while (!Verifizierung.validateNote(note, index++)) {
   System.out.println("[?] Bitte gib die Note ein. (0 - 15)");
   note = scanner.next();
  }

  return Math.abs(Integer.parseInt(note));
 }

 // Datum
 public static String datumEinlesen() {
  String datum = "";
  Integer index = 0;

  while (!Verifizierung.validateDate(datum, index++)) {
   System.out.println("[?] Bitte gib das Datum ein. (Beispiel: 12.03.2022)");
   datum = scanner.next();
  }

  return datum;
 }

 // Name
 public static String nameEinlesen() {
  String name = "";
  Integer index = 0;

  while (!Verifizierung.validateName(name, index++)) {
   System.out.println("[?] Bitte gib einen validen Namen an. (Beispiel: Hans)");
   name = scanner.next();
  }

  return name;
 }

 // Fachname
 public static String fachnameEinlesen() {
  String name = "";
  Integer index = 0;

  while (!Verifizierung.validateFachName(name, index++)) {
   System.out.println("[?] Bitte gib den Namen des Faches ein. (Beispiel: Mathe)");
   name = scanner.next();
  }

  return name;
 }

 // Leiststungskurs
 public static Boolean leistungskursEinlesen() {
  System.out.println("[?] Bitte gib an, ob es sich um einen Leistungskurs handelt. (Ja / Nein)");
  return booleanEinlesen();
 }

 public static Boolean dateiAusgabeEinlesen() {
  System.out.println("[?] Soll das Zeugnis als Datei ausgegeben werden? (Ja / Nein)");
  return booleanEinlesen();
 }

 // Fehltage
 public static Integer fehltageEinlesen() {
  String fehltage = "";
  Integer index = 0;

  while (!Verifizierung.validateNumber(fehltage, index++)) {
   System.out.println("[?] Bitte gib die Anzahl der Fehltage an (Zahl)");
   fehltage = scanner.next();
  }

  return Math.abs(Integer.parseInt(fehltage));
 }

 // entschuldigte Fehltage
 public static Integer entschuldigteEinlesen(Integer fehltage) {
  String entschuldigte = "";
  Integer index = 0;

  while (!Verifizierung.validateEntschuldigte(entschuldigte, index++, fehltage)) {
   System.out.println("[?] Bitte gib die Anzahl der entschuldigten Fehltage an (Zahl)");
   entschuldigte = scanner.next();
  }

  return Math.abs(Integer.parseInt(entschuldigte));
 }

 // General Inputs
 public static Boolean booleanEinlesen() {
  String boolInput = scanner.next();
  Boolean bool = false;

  if (boolInput.toLowerCase().equals("ja")) {
   bool = true;
  }

  return bool;
 }
}
