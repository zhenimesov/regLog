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
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    private void checkDelete() {
        if (!theFile.delete())
            theFile = new File("person.json");
    }

    public void write(DataBaseModel dataBaseModel) {
        checkDelete();

        String json = gson.toJson(dataBaseModel);

        try (FileWriter writer = new FileWriter(theFile)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Ошибка связано с записью файла");
        }
    }

    public List<User> wrapper() {
        List<User> users = new ArrayList<>();
        try (FileReader reader = new FileReader(theFile)) {
            Type userListType = new TypeToken<DataBaseModel>() {
            }.getType();
            DataBaseModel wrapperList = gson.fromJson(reader, userListType);
            if (wrapperList != null && wrapperList.getUsers() != null) {
                users.addAll(wrapperList.getUsers());
            }
        } catch (IOException e) {
            System.out.println("Ошибка связано с инициализацией файла");
        }
        return users;
    }
    }



