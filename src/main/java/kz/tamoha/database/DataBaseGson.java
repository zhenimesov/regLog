package kz.tamoha.database;

import com.google.gson.Gson;
import kz.tamoha.basic.model.DataBaseModel;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.io.*;
import java.util.ArrayList;


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