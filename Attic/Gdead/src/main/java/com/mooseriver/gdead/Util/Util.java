package com.mooseriver.gdead.Tables;

import java.util.UUID;

public class Util {

    public static String genShowId() {
        String outStr   = ""; 
        String prefix = "GDSHOW";
                
        UUID id = java.util.UUID.randomUUID();
        String idString = id.toString();
     
        outStr = String.format("%s-%s", prefix, idString);
    
        return outStr;
    }   // End of genShowId
}   // End of class Util