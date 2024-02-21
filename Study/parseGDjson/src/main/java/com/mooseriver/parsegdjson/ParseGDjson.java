/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mooseriver.parsegdjson;

import com.mooseriver.gdead.Tables.SetList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        boolean debug = false;
        
        if (args.length == 2) {
            option = args[0];
            //year = args[1];
        } 
        
        if (option.equalsIgnoreCase("--year")) {
            year = args[1];            
        } else {
            year = "1968";
        }
        
        Connection conn = null;  
        ResultSet RS = null;  
        Statement statement = null;
        
        String baseDir = "/usr3/home/jgrosch/Git/MusicBank/Data/Grateful-Dead/json/Cooked";
        String inFile = String.format("%s/%s.FIX.json", baseDir, year);
        String dbFile = "/usr3/home/jgrosch/Git/gdead/Data/GD-Shows.sqlite";
        String connectString = String.format("jdbc:sqlite:%s", dbFile);
        
        // "/usr3/home/jgrosch/Git/MusicBank/Data/Grateful-Dead/json/Cooked/1968.FIX.json";
       
        try {
            conn = DriverManager.getConnection(connectString);
            Statement stmt  = conn.createStatement();
            
            if (debug) {
                ArrayList alTmp = new ArrayList();
                StringBuilder sb = new StringBuilder();
                sb.append("select * from setlists where ");
                sb.append(" show_year = '1965' and ");
                sb.append(" show_month = '03' and ");
                sb.append(" show_day = '11'; ");
                String testQuery = sb.toString();
                ResultSet rs = stmt.executeQuery(testQuery);
                while (rs.next()) {
                    int j = 0;
                    SetList SL = new SetList(rs);
                    alTmp.add(SL);
                }
            }   // End of debug
            
            File inputFile = new File(inFile);  
            if (! inputFile.exists()) {
                System.out.println("File : " + inFile + " Not found");
                System.exit(0);
            }
         
            ArrayList al = new ArrayList();
            
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
                String sql = sl.toInsertString();
                
                RS = stmt.executeQuery(sql);
 
            }   // End of try
            
            int i = 0;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParseGDjson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException | SQLException ex) {
            Logger.getLogger(ParseGDjson.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally {  
            try {  
                RS.close();  
                statement.close();  
                conn.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }   // End of finally  
        
        System.exit(0);
    }   // End of main
    /*
    private static Connection connect() {
        // SQLite connection string
        String dbFile = "/usr3/home/jgrosch/Git/gdead/Data/GD-Shows.sqlite";
        String url = String.format("jdbc:sqlite:%s", dbFile);
        
        //String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
*/
} // End of class
