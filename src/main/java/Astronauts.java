import java.util.ArrayList;
import java.util.HashMap;

public class Astronauts {
  private int number;
  private ArrayList<HashMap<String, String>> people;
  private String message;

  public Astronauts()   {
    this.number = number;
    this.people = people;
    this.message = message;
  }

  public ArrayList<HashMap<String, String>> getPeople() {
    return people;
    }
  public int getNumber() {
    return number;
  }
  public String getMessage() {
    return message;
  }
  public HashMap<String, String> getPersonAndCraft(int index) {
    return people.get(index);
  }
  public String getPersonsCraft(int index) {
    return people.get(index).get("craft");
  }
  public String getPersonsName(int index) {
    return people.get(index).get("name");
  }
  //this was going to take forever so I commented it out :)
//  public String getAstronautJson() {
//    return this.toString();
//  }
//  @Override public String toString() {
//    StringBuilder sb =  new StringBuilder();
//    sb.append("{\n\"number\": " + number +",\n\"people\": []\n}");
//    return sb.toString();
//  }
}
