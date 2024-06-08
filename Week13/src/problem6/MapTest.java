package problem6;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
    public static void main(String[] args) {
        TreeMap<String,String> teams = new TreeMap
                <String, String>();
        teams.put("San Francisco", "Forty-niners");
        teams.put("Chicago", "Bears");
        teams.put("Denver", "Broncos");
        teams.put("Seattle", "Seahawks");
        teams.put("Miami", "Dolphins");
        teams.put("Detroit", "Lions");

//        System.out.println(teams);
        System.out.println("Number of teams: " + teams.size());
        System.out.println("Chicago team: " + teams.get("Chicago"));

        teams.put("San Francisco", "Niners");
        System.out.println(teams);

        if(teams.containsKey("San Diego")) {
            System.out.println("San Diego has a team.");
        }else{
            System.out.println("San Diego does not have a team");
        }

        teams.remove("Denver");
        System.out.println(teams);

        teams.put("Dallas", "Cowboys");

        for(Map.Entry<String, String> t : teams.entrySet()){
            System.out.printf("%-20s%-20s\n",
            t.getKey(), t.getValue());
        }

        List<Map.Entry<String, String>> list =
                new ArrayList<>(teams.entrySet());
        //list.sort(Map.Entry.comparingByValue());
        list.sort(Map.Entry.
                <String, String>comparingByValue().reversed());
        System.out.println(list);
    }
}
