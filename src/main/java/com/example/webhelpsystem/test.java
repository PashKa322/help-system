package com.example.webhelpsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class test {
    public static void main(String[] args) throws IOException {
        URL oracle = new URL("http://localhost:8080/getAllFood");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine); //Можно   накапливать в StringBuilder а потом присвоить перемной String результат накопления
        in.close();
    }
}

