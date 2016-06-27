package util;

import com.google.gson.Gson;
import model.Card;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by chinta on 6/26/2016.
 */
public class FileUtils {
    private final static String dataFile = "src/main/resources/storage/cards.json";

    public static void saveData(LinkedHashMap<String, Card> data)
    {
        String json = new Gson().toJson(data);

        File file = new File(dataFile);

        try {

            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(json);
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public static LinkedHashMap<String, Card> getData(){

        LinkedHashMap<String, Card> cardHolder = new LinkedHashMap<String, Card>();

        try {
            String json = new Scanner(new File(dataFile)).useDelimiter("\\Z").next();
            cardHolder = new Gson().fromJson(json, cardHolder.getClass());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return cardHolder;

    }



}
