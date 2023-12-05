package com.example.inspektor.typeconverters;

import androidx.room.TypeConverter;

import com.example.inspektor.model.Estates;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class EstatesTypeConverter {

    @TypeConverter
    public static List<Estates> stringToList(String json){
        Type type = new TypeToken<List<Estates>>(){}.getType();
        List<Estates> estatesList = new Gson().fromJson(json, type);
        return estatesList;
    }

    @TypeConverter
    public static String listToString(List<Estates> nestedEstatesList) {
        return new Gson().toJson(nestedEstatesList);
    }
}
