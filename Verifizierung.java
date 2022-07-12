public class Verifizierung {
 public static Boolean validateNote(String input, Integer index) {
  try {
   Integer note = Integer.parseInt(input);
   if (note < 0 || note > 15) {
    throw new NumberFormatException();
   }
   return true;
  } catch (NumberFormatException ex) {
   if (index != 0) {
    System.out.println("[!] Die Note muss im angegebenen Bereich liegen (0-15)");
   }
   return false;
  }
 }

 public static Boolean validateDate(String input, Integer index) {
  if (!input.matches("([0-9]{2}).([0-9]{2}).([0-9]{4})")) {
   if (index != 0) {
    System.out.println("[!] Das Datum muss in dem Format DD.MM.YYYY vorliegen");
   }
   return false;
  }
  return true;
 }

 public static Boolean validateName(String input, Integer index) {
  if (!input.matches("^[A-Za-z\\s-]+$")) {
   if (index != 0) {
    System.out.println("[!] Der Name darf nur aus Buchstaben, Leerzeichen und Bindestrichen bestehen");
   }
   return false;
  }
  return true;
 }

 public static Boolean validateFachName(String input, Integer index) {
  if (input.length() > 20 || !input.matches("^[A-Za-z]+$")) {
   if (index != 0) {
    System.out.println("[!] Der Name darf nur aus Buchstaben bestehen und höchstens 20 Zeichen lang sein");
   }
   return false;
  }
  return true;
 }

 public static Boolean validateEntschuldigte(String input, Integer index, Integer fehltage) {
  try {
   Integer entschuldigte = Integer.parseInt(input);
   if (entschuldigte > fehltage) {
    throw new NumberFormatException();
   }
   return true;
  } catch (NumberFormatException ex) {
   if (index != 0) {
    System.out
      .println("[!] Es darf nicht mehr entschuldigte Fehltage als Fehltage geben und die Eingabe muss eine Zahl sein");
   }

   return false;
  }
 }

 public static Boolean validateNumber(String input, Integer index) {
  try {
   Integer note = Integer.parseInt(input);
   return true;
  } catch (NumberFormatException ex) {
   if (index != 0) {
    System.out.println("[!] Die Eingabe muss eine Nummer sein");
   }
   return false;
  }
 }
}
