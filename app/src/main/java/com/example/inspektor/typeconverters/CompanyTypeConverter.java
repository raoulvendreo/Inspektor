package com.example.inspektor.typeconverters;

import androidx.room.TypeConverter;

import com.example.inspektor.model.Company;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class CompanyTypeConverter {

    @TypeConverter
    public static List<Company> stringToList(String json){
        Type type = new TypeToken<List<Company>>(){}.getType();
        List<Company> companyList = new Gson().fromJson(json, type);
        return companyList;
    }

    @TypeConverter
    public static String listToString(List<Company> nestedCompanyList) {
        return new Gson().toJson(nestedCompanyList);
    }
}
