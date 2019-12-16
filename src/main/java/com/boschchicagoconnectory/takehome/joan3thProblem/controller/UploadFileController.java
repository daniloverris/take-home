package com.boschchicagoconnectory.takehome.joan3thProblem.controller;

import com.boschchicagoconnectory.takehome.joan3thProblem.dao.BookDao;
import com.boschchicagoconnectory.takehome.joan3thProblem.model.Book;
import com.boschchicagoconnectory.takehome.joan3thProblem.util.ConvertFile;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/uploadfile")
public class UploadFileController {

    @Autowired
    private BookDao bookDao;

    @PostMapping
    public void upload(@RequestParam MultipartFile file) throws IOException {
        JSONArray jsonArray = new ConvertFile(file).toJSON();
        for(Object json: jsonArray){
            JSONObject jsonObj = (JSONObject)json;
            Book book = new Book(
                    jsonObj.getString("Title"),
                    jsonObj.getString("Description"),
                    jsonObj.getBigInteger("ISBN"),
                    jsonObj.getString("Author"),
                    jsonObj.getString("Genre"),
                    jsonObj.getInt("Pages"),
                    jsonObj.getString("Age Range"),
                    Float.parseFloat(jsonObj.getString("Price").replace("$","")),
                    jsonObj.getInt("Qty."));

            bookDao.save(book);
        }
    }
}