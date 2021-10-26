import java.util.ArrayList;
import java.util.HashMap;

public class main {

    public static void main(String args[]) {

        HttpClient myClient = new HttpClient("http://api.open-notify.org/astros.json");
        Astronauts astronauts = myClient.getAstronauts();
        ArrayList<HashMap<String, String>> people = myClient.getAstronauts().getPeople();

        int nameWidth = findWidest(astronauts, "name");
        int craftWidth = findWidest(astronauts, "craft");
        printAstronauts(astronauts,nameWidth, craftWidth);

    }

    private static void printAstronauts(Astronauts astronauts, int nameWidth, int craftWidth) {
        System.out.println("hello "+ astronauts.getPersonsName(0)+" " +nameWidth);
        for (int count =0; count<nameWidth; count++) {
            System.out.print("-");
        }
        System.out.print("|");
        for (int count =0; count<craftWidth; count++) {
            System.out.print("-");
        }
        System.out.print("|");
    }
    private static int findWidestName(Astronauts astronauts) {
    //I wanted to do a binary sort but I was taking too long and just did bubble sort

        int biggestNameLength = 0;
        String curName;
        int curNameLength;

        for(int num = 0; num < astronauts.getPeople().size(); num++)
        {
            curName = astronauts.getPersonsName(num);
            curNameLength = curName.length();
            if (curNameLength > biggestNameLength) {
                biggestNameLength = curNameLength;
            }
        }
        return biggestNameLength;
    }
    private static int findWidest(Astronauts astronauts, String field) {

        int biggestLength = 0;
        String cur = "";
        int curLength;

        for(int num = 0; num < astronauts.getPeople().size(); num++)
        {
            if (field.equals("name")){
            cur = astronauts.getPersonsName(num);
            }
            else if (field.equals("craft")){
                cur = astronauts.getPersonsCraft(num);
            }
            curLength = cur.length();
            if (curLength > biggestLength) {
                biggestLength = curLength;
            }
        }
        return biggestLength;
    }
}