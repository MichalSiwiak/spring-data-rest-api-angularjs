package com.example.addressbookdatabase;

class Main2
{
    private static String changeString(String s){
        return s + "World";
    }

    public static void main(String[] args) {
        String s = "Hello";
        String res = changeString(s);
        System.out.println(res);
    }
}
