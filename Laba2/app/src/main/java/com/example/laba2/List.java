package com.example.laba2;

import java.util.ArrayList;

public class List
{
    private static ArrayList<JsonFile> techList = new ArrayList<>();

    public static void filling(ArrayList<JsonFile> arrayList)
    {
        techList.addAll(arrayList);
        techList.remove(0);
    }
    public static JsonFile get(int index)
    {
        return techList.get(index);
    }
    public static int getSize()
    {
        return techList.size();
    }

    public static void fill(ArrayList<JsonFile> arrayList) {
    }
}

