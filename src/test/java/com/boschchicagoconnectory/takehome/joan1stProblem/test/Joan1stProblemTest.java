package com.boschchicagoconnectory.takehome.joan1stProblem.test;

import com.boschchicagoconnectory.takehome.joan1stProblem.Joan1stProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


class Joan1stProblemTest {

    @Test
    void whenWrongFileExtension_ThrowsFileException() {
        String[] args = {"file.extension"};
        Assertions.assertThrows(FileNotFoundException.class, ()->Joan1stProblem.main(args));

    }

    @Test
    void whenRightFileExtension_CreateCSVFile() throws IOException {
        String file = getClass().getClassLoader().getResource("books.csv").getFile();
        String[] args = {file};
        Joan1stProblem.main(args);
        Assertions.assertTrue(new File(System.getProperty("user.dir")+"/FinalCSV.csv").exists());
    }


}