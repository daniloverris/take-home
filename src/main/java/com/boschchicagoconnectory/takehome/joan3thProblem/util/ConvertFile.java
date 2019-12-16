package com.boschchicagoconnectory.takehome.joan3thProblem.util;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConvertFile {

    private File file;

    public ConvertFile(MultipartFile file) throws IOException {
        String tDir = System.getProperty("java.io.tmpdir");
        this.file = new File(tDir, file.getOriginalFilename());
        file.transferTo(this.file);

    }

    public JSONArray toJSON() throws IOException {
        Map<Integer, Object> jsonArray = new HashMap<>();
        FileInputStream fis = new FileInputStream(file);

        if (file.getName().toLowerCase().endsWith(".json")) {
            JSONArray jArr = new JSONArray(new JSONTokener(fis));
            new JoinArrays(jsonArray, jArr).join();

        } else if (file.getName().toLowerCase().endsWith(".csv")) {
            JSONArray jArr = CDL.toJSONArray(new JSONTokener(fis));
            new JoinArrays(jsonArray, jArr).join();

        } else if (file.getName().toLowerCase().endsWith(".txt")) {
            BufferedReader bis = new BufferedReader(new InputStreamReader(fis));
            String line = bis.readLine();
            StringBuilder sb = new StringBuilder();
            while (line != null) {
                String newLine = "\"" + line.replaceAll("\t", "\",\"") + "\"\n";
                sb.append(newLine);
                line = bis.readLine();
            }
            JSONArray jArr = CDL.toJSONArray(sb.toString());
            new JoinArrays(jsonArray, jArr).join();
        } else {
            throw new FileNotFoundException("The file args should have the following extensions: '.json', '.csv', '.txt'");
        }

        return new JSONArray(jsonArray.values());
    }
}
