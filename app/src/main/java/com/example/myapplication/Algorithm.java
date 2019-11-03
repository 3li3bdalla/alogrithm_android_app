package com.example.myapplication;


import android.content.Context;

public class Algorithm {

    private int key = 0;

    Context context;
    private static final int LATTER_COUNT = 26;

    private char latters[] = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    Algorithm(int key,Context context)
    {
        this.context = context;
        this.key = key;
    }


    public String decrypt(String cyper_text)
    {
        char[] chars = this.convert_string_to_char_array(cyper_text);
        char[] result = new char[cyper_text.length()];
        for (int i = 0; i < cyper_text.length(); i++) {
            if(Character.isSpaceChar(chars[i]))
            {
                result[i] = ' ';
            }else
            {
                int index = this.findIndex(chars[i]);
                int target = (index - this.key ) % LATTER_COUNT; // 3 - 5 % 23

                if(target<0)
                {
                    target = LATTER_COUNT + target;
                }
                result[i] = this.latters[target];

            }


        }
        return  String.valueOf(result);
    }


    public String encrypt(String plain_text)
    {
        char[] chars = this.convert_string_to_char_array(plain_text);
        char[] result = new char[plain_text.length()];
        for (int i = 0; i < plain_text.length(); i++) {

            if(Character.isSpaceChar(chars[i]))
            {
                result[i] = ' ';
            }else {
                int index = this.findIndex(chars[i]);
                int target = (index + this.key) % LATTER_COUNT;

                result[i] = this.latters[target];
            }

        }
        return  String.valueOf(result);
    }



    private char[] convert_string_to_char_array(String text)
    {
        char[] array = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            array[i] = text.charAt(i);
        }
        return  array;

    }

    private   int findIndex( char t)
    {



        // find length of array
        int len = this.latters.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th element is t
            // then return the index
            if (this.latters[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }


}

