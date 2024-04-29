package kz.tamoha.database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import kz.tamoha.basic.model.DataBaseModel;
import kz.tamoha.basic.model.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataBaseGson {
    File theFile = new File("person.json");
    final Gson gson = new Gson();


    private void checkDelete() {
        if (!theFile.delete())
            theFile = new File("person.json");
    }

    public void write(DataBaseModel dataBaseModel) {
        checkDelete();

        try (FileWriter writer = new FileWriter(theFile)) {
            gson.toJson(dataBaseModel, writer);
        } catch (IOException e) {
            System.out.println("Ошибка связано с записью файла");
            e.printStackTrace();
        }
    }

    public DataBaseModel wrapper() {
        try (FileReader reader = new FileReader(theFile)) {
            return gson.fromJson(reader, DataBaseModel.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DataBaseModel(new ArrayList<>());
    }
}