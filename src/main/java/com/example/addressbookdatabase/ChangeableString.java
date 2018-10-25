package com.example.addressbookdatabase;

public class ChangeableString {
    private String string;

    public ChangeableString(String string) {
        this.string = string;
    }

    public String convert() {
        return string.replace(",", ".");
    }

    public String toString() {
        return string;
    }
}
