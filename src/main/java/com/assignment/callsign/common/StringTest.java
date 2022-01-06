package com.assignment.callsign.common;


public class StringTest {
    public static void main(String[] args) {
        String str = "Abc def";
        StringBuilder sb = new StringBuilder();
        int strLength = str.length();
        for(int i=str.length();i!=0;i--) {
            sb.append(str.charAt(i-1));
        }

        System.out.print("reversed string " +sb.toString());
    }
}
