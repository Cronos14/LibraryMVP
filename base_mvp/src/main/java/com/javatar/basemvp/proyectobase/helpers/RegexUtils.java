package com.javatar.basemvp.proyectobase.helpers;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tadeo Gonzalez on 21/06/2018.
 */

public class RegexUtils {

    public enum REGEX{
        REGEX_LETTERS("[A-zñÑ]"),
        REGEX_LETTERS_ACCENTS("[A-zñÑáéíóúÁÉÍÓÚ]"),
        REGEX_LETTERS_SPACE("[A-zñÑ\\s]"),
        REGEX_LETTERS_ACCENTS_SPACE("[A-zñÑáéíóúÁÉÍÓÚ\\s]"),
        REGEX_LETTERS_DIRECTION("[0-9A-zñÑáéíóúÁÉÍÓÚ\\s,.#]"),
        REGEX_LETTERS_NUMBERS("[0-9]");

        private String regex;

        REGEX(String regex){
            this.regex = regex;
        }

        public String getRegex(){
            return regex;
        }
    }

    private static final List<String> BANNED_WORDS = Arrays.asList("SELECT","DELETE","UPDATE","INSERT","DROP","TRUNCATE","UNION","WHERE","OR","AND",
            "EXEC","XO_CMDSHELL","SCRIPT","AÑERT","FTP","CAT","GET","PUT","NET USER","CMD","TYPE","DIR","MKDIR","DOCUMENT.COOKIE","ADD","ALTER");

    private static final List<String> BANNED_CHARS = Arrays.asList("<",">","'","*","=","/");

    public static final boolean validPattern(REGEX regex, String text){


        if(text!=null){
            String words[] = text.toUpperCase().split("\\s");
            if(words!=null && words.length > 0){

                for(String word : words){

                    for(String banned : BANNED_WORDS){
                        if(word.equalsIgnoreCase(banned))
                            return false;
                    }

                    for(String banned : BANNED_CHARS){
                        if(word.equalsIgnoreCase(banned))
                            return false;
                    }

                }
            } else {

                for(String banned : BANNED_WORDS){
                    if(banned.equalsIgnoreCase(text))
                        return false;
                }

                for(String banned : BANNED_CHARS){
                    if(banned.equalsIgnoreCase(text))
                        return false;
                }
            }

            try{
                if(regex!=null){
                    Pattern pattern = Pattern.compile(regex.getRegex());
                    Matcher matcher = pattern.matcher(text);
                    return matcher.find();
                }else
                    return true;

            }catch (Exception e){
                return false;
            }
        }else
            return false;
    }

    public static final boolean validPattern(REGEX regex, String text, int maxLength){
        if(validPattern(regex,text))
            return text!=null && !(text.length() <= maxLength);
        else
            return false;
    }

    public static final boolean validPattern(String text){
        return validPattern(null,text);
    }
}
