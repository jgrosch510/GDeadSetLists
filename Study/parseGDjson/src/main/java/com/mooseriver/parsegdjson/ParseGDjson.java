/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mooseriver.parsegdjson;

import com.mooseriver.gdead.Tables.SetList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author jgrosch
 */
public class ParseGDjson {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String year   = "";
        String option = "";
                
        if (args.length == 2) {
            option = args[0];
            //year = args[1];
        } 
        if (option.equalsIgnoreCase("--year")) {
            year = args[1];            
        } else {
            year = "1968";
        }
        
        String baseDir = "/usr3/home/jgrosch/Git/MusicBank/Data/Grateful-Dead/json/Cooked";
        String inFile = String.format("%s/%s.FIX.json", baseDir, year);
        
        // "/usr3/home/jgrosch/Git/MusicBank/Data/Grateful-Dead/json/Cooked/1968.FIX.json";
       
        try {
            File inputFile = new File(inFile);  
            if (! inputFile.exists()) {
                System.out.println("File : " + inFile + " Not found");
                System.exit(0);
            }
         
            ArrayList al = new ArrayList();
            boolean debug = true;
            
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(inputFile));
            
            JSONObject jObj = (JSONObject) obj;
            JSONObject dbRest = (JSONObject)jObj.get("db_rest");
            JSONObject FAY = (JSONObject)dbRest.get("fetchArtistYear");
            JSONObject Shows = (JSONObject)FAY.get("shows");
                    
            int showCount = Shows.size();
            for (int index = 0; index < showCount; index++) {
                String key = String.format("key_%d", index);
                if (debug) {
                    String debugMsg = String.format("Working on: %s", key);
                    System.out.println(debugMsg);
                }
                JSONObject s = (JSONObject) Shows.get(key);
                SetList sl = new SetList(s);
                sl.setKeyName(key);
                al.add(sl);
            }
            
            int i = 0;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParseGDjson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(ParseGDjson.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.exit(0);
    }
}
