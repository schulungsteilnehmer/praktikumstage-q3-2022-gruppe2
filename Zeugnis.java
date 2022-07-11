
import java.util.Scanner;

/**
 * Fach
 */
class Fach {
    private String name;
    private Integer note;
    private Boolean leistungskurs;

    public Fach(String Iname, Integer Inote, Boolean Ileistungskurs) {
        this.name = Iname;
        this.note = Inote;
        this.leistungskurs = Ileistungskurs;
    }

    public Integer getNote() {
        return note;
    }

    public Boolean getLeistungskurs() {
        return leistungskurs;
    }

    public String getName() {
        return name;
    }

}

/**
 * Zeugnis
 */

public class Zeugnis {
    static String schueler;
    static String datum;
    static Fach[] faecher;
    static Scanner scanner;

    public static void main(String[] args) {
        faecher = new Fach[8];
        scanner = new Scanner(System.in);

        metaEinlesen();
        System.out.println("Fächer");

        // 8 Fächer
        for (int i = 0; i <= 8; i++) {
            fachEinlesen(i);
        }

        scanner.close();
    }

    /*
     ** Main Funktionen
     */

    public void ausgabe() {

    }

    /**
     * Einlesen
     */

    public static void fachEinlesen(Integer index) {
        String fachname;
        Integer note;
        String leitungkurs;

        while (scanner.hasNextLine()) {

            System.out.println("Bitte gib den Namen des Faches ein. (Beispiel: Mathe)");
            fachname = scanner.next();

            note = noteEinlesen();

            System.out.println("Bitte gib an, ob es sich um einen Leitungskurs handelt. (Ja / Nein)");
            leitungkurs = scanner.next();
            Boolean leitungkursBool = false;

            if (leitungkurs == "Ja") {
                leitungkursBool = true;
            }

            Fach fach = new Fach(fachname, note, leitungkursBool);

            faecher[index] = fach;

            System.out.println("Fach definiert.");
            break;
        }
    }

    public static Integer noteEinlesen() {
        System.out.println("Bitte gib die Note ein. (0 - 15)");
        Integer note;

        note = scanner.nextInt();

        // try {
        // note = scanner.nextInt();
        // } catch (Exception e) {
        // note = noteEinlesen();
        // }

        return note;
    }

    public static void metaEinlesen() {
        System.out.println("Bitte gib den Namen des Schülers ein. (Beispiel: Hans)");
        schueler = scanner.next();

        System.out.println("Bitte gib das Datum ein. (Beispiel: 12.03.22)");
        datum = scanner.next();
    }

    private double round(double value, int decimalPoints) {
        double d = Math.pow(10, decimalPoints);
        return Math.round(value * d) / d;
    }

    public double notenBerechnen() {
        double durchschnitt = 0;

        for (int i = 0; i < 8; i++) {
            if (faecher[i].getLeistungskurs()) {
                durchschnitt += (2 * faecher[i].getNote());
            } else {
                durchschnitt += faecher[i].getNote();
            }
        }
        durchschnitt = durchschnitt / 10;
        durchschnitt = (17 - durchschnitt) / 3;
        durchschnitt = round(durchschnitt, 1);
        return durchschnitt;

    }
}
