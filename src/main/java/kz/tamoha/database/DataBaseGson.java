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
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DataBaseGson {
    File file = new File("person.json");
    Gson gson = new Gson();

    public void write(DataBaseModel dataBaseModel) {

        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(dataBaseModel, writer);

        } catch (IOException e) {
            System.out.println("Ошибка связано с записью файла");
            e.printStackTrace();
        }
    }

    public DataBaseModel wrapper() {

        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, DataBaseModel.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DataBaseModel(new ArrayList<>());
    }
}