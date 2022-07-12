/**
 * Berechnung
 */
public class Berechnung {
 private static double round(double value, int decimalPoints) {
  double d = Math.pow(10, decimalPoints);
  return Math.round(value * d) / d;
 }

 public static double notenBerechnen(Fach[] faecher) {
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

 public static boolean versetzung(Fach[] faecher, Integer fehltage, Integer entschuldigte) {
  int pruefer = 0;
  for (int i = 0; i < 8; i++) {
   if (faecher[i].getNote() < 5) {
    pruefer++;
   }
  }

  if (pruefer > 2 || fehltage - entschuldigte >= 30) {
   return false;
  } else {
   return true;
  }
 }

 public static Fach[] alphabetischeSortierung(Fach[] faecher) {
  for (int i = 1; i < 8; i++) {
   Fach speicher = faecher[i];
   int j = i;
   while (j > 0 && (int) (faecher[j - 1].getName().charAt(1)) > (int) (speicher.getName().charAt(1))) {
    faecher[j] = faecher[j - 1];
    j = j - 1;
   }
   faecher[j] = speicher;
  }
  return faecher;
 }
}
