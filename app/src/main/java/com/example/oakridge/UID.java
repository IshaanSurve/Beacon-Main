package com.example.oakridge;

public class UID {
    public static String uid;

    public static void set(String id){
        uid = id;
    }


    public static String getId(){
        return uid;
    }
}
