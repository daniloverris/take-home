package com.boschchicagoconnectory.takehome.joan1stProblem;

import com.boschchicagoconnectory.takehome.joan1stProblem.util.JoinArrays;
import org.json.*;

import java.io.*;
import java.util.*;

public class Joan1stProblem {
    public static void main(String[] args) throws IOException {
        Map<Integer, Object> jsonArray = new HashMap<>();

        for(String file: args) {
            FileInputStream fis = new FileInputStream(file);

            if(file.toLowerCase().endsWith(".json")) {
                JSONArray jArr = new JSONArray(new JSONTokener(fis));
                new JoinArrays(jsonArray, jArr).join();

            }else if(file.toLowerCase().endsWith(".csv")){
                JSONArray jArr = CDL.toJSONArray(new JSONTokener(fis));
                new JoinArrays(jsonArray, jArr).join();

            }else if(file.toLowerCase().endsWith(".txt")){
                BufferedReader bis = new BufferedReader(new InputStreamReader(fis));
                String line = bis.readLine();
                StringBuilder sb = new StringBuilder();
                while (line != null){
                    String newLine = "\""+line.replaceAll("\t", "\",\"")+"\"\n";
                    sb.append(newLine);
                    line = bis.readLine();
                }
                JSONArray jArr = CDL.toJSONArray(sb.toString());
                new JoinArrays(jsonArray, jArr).join();
            }else{
                throw new FileNotFoundException("The file args should have the following extensions: '.json', '.csv', '.txt'");
            }

            fis.close();
        }
        List jsonArrayList = new ArrayList<>(jsonArray.values());
        Collections.sort(jsonArrayList, new Comparator<JSONObject>() {

            @Override
            public int compare(JSONObject jsonObjectA, JSONObject jsonObjectB) {
                int compare;
                String genreA = jsonObjectA.getString("Genre");
                String genreB = jsonObjectB.getString("Genre");
                compare = genreA.compareTo(genreB);
                if(compare == 0){
                    String authorA = jsonObjectA.getString("Author").split(" ")[1];
                    String authorB = jsonObjectB.getString("Author").split(" ")[1];
                    compare = authorA.compareTo(authorB);
                }
                if(compare == 0){
                    String authorA = jsonObjectA.getString("Author").split(" ")[0];
                    String authorB = jsonObjectB.getString("Author").split(" ")[0];
                    compare = authorA.compareTo(authorB);
                }

                return compare;
            }
        });

        String csv = CDL.toString(new JSONArray(jsonArrayList));
        FileWriter output = new FileWriter("FinalCSV.csv");
        output.write(csv);
        output.close();

    }
}
