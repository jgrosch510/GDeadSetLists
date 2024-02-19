/**************************************************************************
**
**                           < LocalDB.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : LocalDB
**
**  Author       : Josef Grosch
**                          
**  Date         : 14 Sept 03
**
**  Version      : 1.0
**
**  Modification : 10 Feb 2016 - Updated to Java 7
**
**  Application  :
**
**  Functions    :
**
**  Description  :
**
**  Notes        :
**
**************************************************************************/


/**************************************************************************
**
**                               Copyright
**
**              (C) Copyright 2002 - 2023 Moose River, LLC.
**                          All Rights Reserved
**
**                Deadicated to my brother Jerry Garcia,
**             who passed from this life on August 9, 1995.
**                      Happy trails to you, Jerry
**
**************************************************************************/


/**************************************************************************
**
**                                GPG Key
**
** pub 4096R/2C38BBFA 2016-05-21 [expires: 2017-05-21]
** Key fingerprint = A855 3BF0 544B 3B4E F06D  2B90 8DDC FDDA 2C38 BBFA
** uid Josef Grosch <jgrosch@gmail.com>
** sub 4096R/CC2D1F80 2016-05-21 [expires: 2017-05-21]
**
**
**************************************************************************/


/**************************************************************************
**
**                          Contact Information
**
**                           Moose River LLC.
**                             P.O. Box 9403
**                          Berkeley, Ca. 94709
**
**                       http://www.mooseriver.com
**
**************************************************************************/


/**************************************************************************
**
**                                Package
**
**************************************************************************/
package com.mooseriver.gdead;


/**************************************************************************
**
**                                Imports
**
**************************************************************************/
//import com.mooseriver.gdead.IdCommon;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**************************************************************************
**
**                                 Class
**
**************************************************************************/

/**
 *
 * <b>LocalDB</b> is an abstract super class that represents the required
 * methods and common methods of a database class, that is a class 
 * that represents a table in a database.
 *
 * @author  Josef Grosch (jgrosch@gmail.com)
 * @since   MooseRiver1.0
 * @version 1.0
 */
    public abstract class LocalDB {    

    /**
     *
     * <b>COPYRIGHT</b> is a string that contains the copyright statement.
     */
    private final static String COPYRIGHT = 
        "Copyright (c) 2002 - 2023 Moose River, LLC. All Rights Reserved.";

    /**
     *
     * <b>VERSION</b> is a string that contains the version of the class.
     */
    private final static String VERSION = "1.0"; 

    /**
     *
     * <b>beenChanged</b> is a boolean that indicates whether the 
     * database record, represeted by this object, has changed since
     * the record was loaded into this class.
     */
    protected boolean beenChanged    = false;  //

    /**
     *
     * <b>recordLoaded</b> is a boolean that indicates whether a 
     * database record has been loaded into an object of this class.
     */
    protected boolean recordLoaded   = false;  //

    /**
     *
     * <b>tableName</b> is a String that names the database table that
     * this record came from.
     */
    protected String  tableName      = "";   //

    /**
     *
     * <b>debug</b> is a boolean that controls whether instructions within
     * a debug block are excuted or not.
     */
    protected boolean debug          = false;  //

    /**
     *
     * <b>recNum</b> is the serial number of the current record in 
     * the database.
     */
    protected int     recNum         = 0;      //
    
    /**
     *
     * <b>recId</b> is the ID of the current record in the database.
     */
    protected String  recId          = "";   //
    
    /**
     *
     * <b>insertTime</b> is the time, expressed in epoch, that the 
     * current record was inserted into the database.
     */
    protected String  insertTime     = "";   //
    
    /**
     *
     * <b>lasrUpdateTime</b> is the time, express in epoch, that the 
     * current record was updated in the database.
     */
    protected String  lastUpdateTime = "";   //
    
    /**
     *
     * <b>active</b> is a boolean that indicates whether the current 
     * record is active in the database. 
     */
    protected boolean active         = false;  //
    
    /**
     *
     * <b>recStatus</b> is a generic field that can contain a status 
     * string about the current record.
     */
    protected String  recStatus      = "";   //
    
    /**
     *
     * <b>recVersion</b> is a serial number that indicates the version of the 
     * current record in the database. There may be more than one version of
     * a record in the database but only one will be active and that record
     * will have the highest value.
     */
    protected int     recVersion     = 0;      //
    
    /**
     *
     * <b>toInsertString</b> is an abstract method that the derivied class
     * must include. This method returns a String class that contain
     * an SQL statement to insert the contents of the object into it's 
     * respective database table.
     * 
     * @return insert_string
     */
    public abstract String toInsertString();

    /**
     *
     * <b>toUpdateString</b> is an abstract method that the derivied class
     * must include. This method returns a String class that contain
     * an SQL statement to update the database record with the contents of 
     * the object.
     * 
     * @return update_string
     */
    public abstract String toUpdateString();

    /**
     *
     * <b>toXML</b> is an abstract method that the derivied class
     * must include. This method returns a String class that contain
     * an SQL statement to insert the contents of the class into it's 
     * respective database table.
     * 
     * @return Object contents formatted as XML
     */
    //public abstract String toXML();

    /**
     *
     * <b>toJSON</b> is an abstract method that the derivied class
     * must include. This method returns a String class that contain
     * an SQL statement to insert the contents of the class into it's 
     * respective database table.
     * 
     * @return Object contents formatted as JSON
     */
    public abstract String toJSON();

    /**
     *
     * <b>toSQL</b> is an abstract method that the derivied class
     * must include. This method returns a String class that contain
     * an SQL statement to insert the contents of the class into it's 
     * respective database table.
     * 
     * @return SQL to create table
     */
    public abstract String toSQL();

    /**
     *
     * <b>dumpDbRecord</b> is an abstract method that the derived class
     * must include. This method returns a string which represents the 
     * contents of the DB record the class instance represents.
     * 
     * @return 
     */
    public abstract String dumpDbRecord();

    /**
     *
     * <b>searchBy</b> is an abstract method the the derived class
     * must implement. This method return a string that is an SQL
     * statement that will query the DB table represented by the
     * implementing class using the <b>QueryControl</b> class.
     * 
     * @param qc
     * @return 
     */
    //public abstract ArrayList searchBy(QueryControl qc);

    /**
     *
     * <b>dumpToJson</b> is an abstract method the derived class 
     * must implement. This method returns a string that is the 
     * fields of the final class in the form of a json string.
     * 
     * @return 
     */
    //public abstract String dumpToJson();
    //public abstract String dumpToJson();
    
    //
    // Get Methods
    //
    
    /**
     *
     * @return 
     */
    public boolean getBeenChanged() {
        return this.beenChanged;
    }

    /**
     *
     * @return 
     */
    public boolean getRecordLoaded() {
        return this.recordLoaded;
    }

    /**
     *
     * <b>getCopyRight</b> is an abstract method that the derivied class
     * must include. This class returns a String class that contain
     * an SQL statement to insert the contents of the class into it's 
     * respective database table.
     * 
     * @return Class copyright string
     */
    public String getCopyRight() { 
        return LocalDB.COPYRIGHT; 
    }

    /**
     *
     * <b>getTableName</b> This method returns a String class that 
     * contain the database table name that the class represents.
     * 
     * @return DB table name
     */
    public String getTableName() { 
        return this.tableName; 
    }

    /**
     *
     * <b>getRecNum</b> This method returns the instance record number.
     * 
     * @return 
     */
    public int getRecNum() { 
        return this.recNum; 
    }

    /**
     *
     * @return 
     */
    public String getRecId() { 
        return this.recId; 
    }

    /**
     *
     * @return 
     */
    public String getInsertTime() { 
        return this.insertTime; 
    }

    /**
     *
     * @return 
     */
    public String getLastUpdateTime() { 
        return this.lastUpdateTime; 
    }

    /**
     *
     * @return 
     */
    public boolean getActive() { 
        return this.active; 
    }

    /**
     *
     * @return 
     */
    public String getRecStatus() { 
        return this.recStatus; 
    }

    /**
     *
     * @return 
     */
    public int getRecVersion() { 
        return this.recVersion; 
    }

    /**
     *
     * Returns the current Epoch date as a long
     * 
     * @return 
     */
    public long getCurrentEpoch() {
        return System.currentTimeMillis()/1000;
    }   // End of getCurrentEpoch

    //
    // Set Methods
    //

    /**
     *
     * @param been_changed
     */
    public void setBeenChanged(boolean been_changed) {
        this.beenChanged = been_changed;
    }

    /**
     *
     * @param record_loaded
     */
    public void setRecordLoaded(boolean record_loaded) {
        this.recordLoaded = record_loaded;
    }

    /**
     *
     * <b>setTableName</b> This method set the protected variable, 
     * tableName, with the database table name that the class represents. 
     * This method must be called in the base consturctor.
     * 
     * @param name - The name of the table the object represents
     */
    public void setTableName(String name) {
        this.tableName = name;
    }

    /**
     *
     * @param rec_id
     */
    public void setRecId(String rec_id) {
        this.recId = rec_id;
        this.beenChanged = true;
    }

    /**
     * 
     */
    public void setRecId() {
        IdCommon id = new IdCommon();
        String eventIdLocal = id.genIdByType(IdCommon.MR_RECORD_ID);
        setRecId(eventIdLocal); 
    }
    
    /**
     *
     * @param rec_num
     */
    public void setRecNum(int rec_num) {
        this.recNum = rec_num;
        this.beenChanged = true;
    }

    /**
     *
     * @param insert_time
     */
    public void setInsertTime(String insert_time) {
        this.insertTime = insert_time;
        beenChanged = true;
    }

    /**
     *
     */
    public void setInsertTime() {
        this.insertTime = String.valueOf(System.currentTimeMillis()/1000);

        beenChanged = true;
    }

    /**
     *
     * @param last_update_time
     */
    public void setLastUpdateTime(String last_update_time) {
        this.lastUpdateTime = last_update_time;
        beenChanged = true;
    }

    /**
     *
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
        beenChanged = true;
    }

    /**
     *
     * @param rec_status
     */
    public void setRecStatus(String rec_status) {
        this.recStatus = rec_status;
        beenChanged = true;
    }

    /**
     *
     * @param rec_version
     */
    public void setRecVersion(int rec_version) {
        this.recVersion = rec_version;
        beenChanged = true;
    }

    //
    // To Methods
    //

    /**
     *
     * <b>toFindRecondString</b> is an abstract method that the derivied class
     * must include. This class returns a String class that contain
     * an SQL statement to insert the contents of the class into it's 
     * respective database table.
     * 
     * @return 
     */
    public String toFindRecordString() {
        String rec_id = getRecId();

        return toFindRecordString(rec_id);
    }

    /**
     *
     * @param rec_id
     * @return 
     */
    public String toFindRecordString(String rec_id) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("SELECT * FROM ").append(getTableName());
        sb.append(" WHERE rec_id = ").append(rec_id).append(" ; ");

        String query = sb.toString();
        
        return query;
    }

    /**
     *
     * @return 
     */
    public String toDeleteString() {
        int rec_num = getRecNum();
        String query = toDeleteString(String.valueOf(rec_num));

        return query;
    }   // End of toDeleteString

    /**
     *
     * @param rec_num
     * @return 
     */
    public String toDeleteString(String rec_num) {
        StringBuilder sb = new StringBuilder();

        sb.append("DELETE FROM ").append(getTableName()); 
        sb.append(" WHERE rec_num = ").append(rec_num).append(" ;");
        
        String query = sb.toString();

        return query;
    }   // End of toDeleteString

    //
    // Database Methods
    //

    /**
     *
     * @param db
     * @param query
     * @return 
     */
    public int updateTable(Connection db, String query) {        
        int rows_updated = 0;

        try {
            PreparedStatement st = db.prepareStatement(query);
            rows_updated = st.executeUpdate();
            st.close();
        }
        
        catch (SQLException exc) {
            System.err.println("Exception caught.\n" + exc);
        }  

        return rows_updated;
    }   // End of updateTable

    /**
     *
     * @param db
     * @param query
     * @return 
     */
    public int insertIntoTable(Connection db, String query) {
        return updateTable(db, query);
    }   // End of insertIntoTable

    /**
     *
     * @param db
     * @param query
     * @return 
     */
    public int deleteFromTable(Connection db, String query) {
        return updateTable(db, query);
    }   // End of deleteFromTable


    /**
     *
     * @param db
     * @return 
     */
    public int updateRecord(Connection db) {
        int rows_updated = 0;

        if (beenChanged == true) {
            String query = this.toUpdateString();
            rows_updated = this.updateTable(db, query);
            beenChanged = false;
        }

        return rows_updated;
    }   // End of commitChanges

    /**
     * 
     * @return 
     * @throws java.io.FileNotFoundException 
     */
    public int updateRecord() throws FileNotFoundException {
        Connection conn = null;
        
        String db_file_name = Params.DB_CONFIG_FILE_NAME; // End of updateRecord // End of updateRecord
        DataBase dbu = new DataBase(db_file_name);
        dbu.Connect();
        conn = dbu.getConnection();
        
        return updateRecord(conn);
    }
    
    /**
     *
     * @return 
     * @throws java.io.FileNotFoundException 
     */
    public int insertRecord() throws FileNotFoundException {
        Connection conn = null;
        String db_file_name = Params.DB_CONFIG_FILE_NAME;
        DataBase dbu = new DataBase(db_file_name);
        dbu.Connect();
        conn = dbu.getConnection();
        return updateRecord(conn);
    }

    /**
     *
     * @param db
     * @return 
     */
    public int insertRecord(Connection db) {
        int rows_updated = 0;

        if ((recordLoaded == true) || (beenChanged == true)) {
           String query = this.toInsertString();
            rows_updated = this.insertIntoTable(db, query);
            beenChanged = false;
        }

        return rows_updated;
    }   // End of insertRecord

    /**
     *
     * @param db
     * @return 
     */
    public int deleteRecord(Connection db) {
        int rows_updated = 0;

        if ((recordLoaded == true) || (beenChanged == true)) {
            String query = this.toDeleteString();
            rows_updated = this.insertIntoTable(db, query);
            beenChanged = false;
        }

        return rows_updated;
    }   // End of deleteRecord

    /**
     *
     * @param db
     * @param table
     * @return 
     */
    public int countOfRows(Connection db, String table) {
        int row_count = 0;
        StringBuilder sb = new StringBuilder();
        
        try {
            Statement stmt = db.createStatement();
            sb.append("SELECT COUNT(*) FROM ").append(table).append(" ;");
            String query = sb.toString();
            ResultSet rs = stmt.executeQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    row_count = Integer.parseInt(rs.getString(1));
                }
            }

            if (stmt != null) {
                stmt.close();
            }
            
            if (rs != null) {
                rs.close();
            }
        }   // End of try block

        catch (java.sql.SQLException e) {
            System.err.println("Exception caught.\n" + e);
        }

        return row_count;
    }   // End of countOfRows

    //
    // Time Methods
    //

    /**
     *
     * Return the current Epoch data as a String
     * 
     * @return 
     */
    protected String currentInsertTime() {
        return String.valueOf(getCurrentEpoch());
    }   // End of currentInsertTime

    /**
     *
     * Return the current Epoch data as a String
     * @return 
     */
    protected String currentTimeAsString() {
        return String.valueOf(getCurrentEpoch());
    }   // End of currentTimeAsString

}   // End of class LocalDB


/**************************************************************************
**
**                        < end of LocalDB.java >
**
**************************************************************************/
