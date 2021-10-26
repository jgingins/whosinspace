public class Display {
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
}
