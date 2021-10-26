import java.util.ArrayList;
import java.util.HashMap;

public class AstronautsInSpace {

    public static void main(String args[]) {

        HttpClient myClient = new HttpClient("http://api.open-notify.org/astros.json");
        Astronauts astronauts = myClient.getAstronauts();

        int nameWidth = findWidest(astronauts, "name");
        int craftWidth = findWidest(astronauts, "craft");
        printAstronauts(astronauts,nameWidth, craftWidth);

    }
    private static void printAstronauts(Astronauts astronauts, int nameWidth, int craftWidth) {

        System.out.print("Name");
        for (int innerCount = 4; innerCount < nameWidth; innerCount++) {
            System.out.print(" ");
        }
        System.out.print("| ");
        System.out.print("Craft");
        for (int innerCount = 5; innerCount < nameWidth; innerCount++) {
            System.out.print(" ");
        }
        System.out.print("\n");


        //print top bar
        for (int count =0; count<nameWidth; count++) {
            System.out.print("-");
        }
        System.out.print("|");
        for (int count =0; count<craftWidth; count++) {
            System.out.print("-");
        }
        System.out.print("| ");


        //print name and craft
        for (int count =0; count<astronauts.getNumber(); count++) {
            System.out.print("\n"+astronauts.getPersonsName(count));
            for (int innerCount = astronauts.getPersonsName(count).length(); innerCount < nameWidth; innerCount++) {
                System.out.print(" ");
            }
            System.out.print("| ");
            System.out.print(astronauts.getPersonsCraft(count));

        }
        System.out.print("\n");
        //print bottom bar
        for (int count =0; count<nameWidth; count++) {
            System.out.print("-");
        }
        System.out.print("|");
        for (int count =0; count<craftWidth; count++) {
            System.out.print("-");
        }
        System.out.print("|");
        System.out.print("\n");


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
        // + 3 so the tab doesn't move it over
        return biggestLength+3;
    }

}