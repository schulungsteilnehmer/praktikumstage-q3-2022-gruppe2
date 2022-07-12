import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Zeugnis
 */

public class Zeugnis {
  static String schueler;
  static String datum;
  static Fach[] faecher;
  static Scanner scanner;
  static Eingabe eingabe;
  static Integer fehltage;
  static Integer entschuldigte;

  public static void main(String[] args) throws FileNotFoundException {
    faecher = new Fach[8];
    scanner = new Scanner(System.in);
    eingabe = new Eingabe(scanner);

    System.out.println("\n--------------------- Meta Daten ---------------------");
    metadatenEinlesen();

    System.out.println("\n----------------------- Fächer -----------------------");
    faecherEinlesen();

    faecher = Berechnung.alphabetischeSortierung(faecher);

    String fächerAusgabe = "";
    for (int i = 0; i < 8; i++) {
      fächerAusgabe = fächerAusgabe + "[Fach] " + faecher[i].getName() + (faecher[i]
          .getLeistungskurs() ? " (LK)" : "") + " - "
          + faecher[i].getNote() + ((i != 8) ? "\n" : "");
    }

    String ausgabe = "--------------------- Zeugnis ---------------------\n" +
        "[Name] " + schueler + "\n" +
        "[Datum] " + datum + "\n" +
        "[Versetzt] " + (Berechnung.versetzung(faecher, fehltage, entschuldigte) ? "Ja" : "Nein") + "\n" +
        "[Durchschnitt] " + Berechnung.notenBerechnen(faecher) + "\n" +
        "[Fehltage] " + fehltage + " davon unentschuldigt " + (fehltage - entschuldigte) + "\n" +
        "------------------------------------------------------" + "\n" +
        fächerAusgabe +
        "------------------------------------------------------";

    System.out.println(ausgabe);

    if (eingabe.dateiAusgabeEinlesen()) {
      try (PrintWriter out = new PrintWriter("zeugnis.txt")) {
        out.println(ausgabe);
      }
    }

    scanner.close();
  }

  /**
   * Einlesen
   */

  public static void metadatenEinlesen() {
    schueler = eingabe.nameEinlesen();
    datum = eingabe.datumEinlesen();
    fehltage = eingabe.fehltageEinlesen();
    entschuldigte = eingabe.entschuldigteEinlesen(fehltage);
  }

  public static void faecherEinlesen() {
    for (int i = 0; i < 8; i++) {
      fachEinlesen(i);
    }
  }

  public static void fachEinlesen(Integer index) {
    String fachname;
    Integer note;
    Boolean leitungkurs;

    while (scanner.hasNextLine()) {
      fachname = eingabe.fachnameEinlesen();
      note = eingabe.noteEinlesen();
      leitungkurs = eingabe.leistungskursEinlesen();

      Fach fach = new Fach(fachname, note, leitungkurs);
      faecher[index] = fach;

      System.out.println("[+] Fach hinzugefügt\n");
      break;
    }
  }
}
