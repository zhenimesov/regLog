package kz.tamoha;

import com.google.gson.Gson;
import kz.tamoha.auth.AuthOrReg;
import kz.tamoha.basic.model.DataBaseModel;
import kz.tamoha.basic.model.User;
import kz.tamoha.database.DataBaseGson;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    AuthOrReg authOrReg = new AuthOrReg();
    authOrReg.getAuth();



        System.out.println();
    }
}
