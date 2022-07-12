public class Fach {
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
