import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FootballTeamStats {

    public static String getTeamNameHasSmallestScoreDifference() throws FileNotFoundException {
        HashMap<String, HashMap<String, String>> allRows = readDatFile("football.dat");
        String teamNameHasSmallestScoreDifference = "";
        Integer scoreDifference = 0;
        for(String teamName : allRows.keySet()) {
            HashMap<String, String> teamData = allRows.get(teamName);
            if(teamData.get("F") != null && teamData.get("A") != null) {
                Integer forGoals = Integer.parseInt(teamData.get("F"));
                Integer againstGoals = Integer.parseInt(teamData.get("A"));
                if(scoreDifference == 0) {
                    scoreDifference = forGoals - againstGoals;
                    if(scoreDifference < 0)
                        scoreDifference = scoreDifference * -1;
                }
                else if((forGoals - againstGoals) < 0 ) {
                    if(scoreDifference > (forGoals - againstGoals) * -1) {
                        scoreDifference = forGoals - againstGoals;
                        if (scoreDifference < 0) {
                            scoreDifference = scoreDifference * -1;
                        }
                        teamNameHasSmallestScoreDifference = teamName;
                    }
                } else if(scoreDifference > (forGoals - againstGoals)) {
                    scoreDifference = forGoals - againstGoals;
                    if (scoreDifference < 0) {
                        scoreDifference = scoreDifference * -1;
                    }
                    teamNameHasSmallestScoreDifference = teamName;
                }
            }
        }
        return teamNameHasSmallestScoreDifference;
    }

    private static HashMap<String, HashMap<String, String>> readDatFile(String datFileName) throws FileNotFoundException {
        HashMap<String, HashMap<String, String>> mydata = new HashMap<>();
        // call the file to read
        Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "/src/main/resources/" + datFileName));
        int i = 0;
        HashMap<String, String> rowValues = new HashMap<>();
        List<String> headerNames = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(i == 0) {
                headerNames.add("");
                for(String header : line.split("\\s+")) {
                    headerNames.add(header);
                }
            } else {
                int index = 0;
                String teamName = "";
                line = line.replace("-", "");
                for(String value : line.split("\\s+")) {
                    if(index == 2)
                        teamName = value;
                    else if(index > 2)
                        rowValues.put(headerNames.get(index), value);
                    index++;
                }
                mydata.put(teamName, rowValues);
                rowValues = new HashMap<>();
            }
            i++;
        }
        scanner.close();
        return mydata;
    }
}


