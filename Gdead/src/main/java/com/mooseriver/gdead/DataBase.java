/**************************************************************************
**
**                            < DataBase.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : DataBase.java
**
**  Author       : Josef Grosch
**                          
**  Date         : 31 May 2012
**
**  Version      : 1.0
**
**  Modification : 31 Jan 2016 - Updated for Java 7
**                 11 Jul 2022 - migrate to connection pools
**
**  Application  : MooseRiver
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
**              (C) Copyright 2002 - 2023 Moose River LLC.
**                       <jgrosch@mooseriver.com>
**
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**************************************************************************
**
**                                 Class
**
**************************************************************************/

/**
 * @author Josef Grosch <jgrosch@gmail.com>
 * @version 1.0
 */

public final class DataBase {
    // org.mariadb.jdbc.Driver

    /**
     *
     */
    private final static String COPYRIGHT = 
        "Copyright (c) 2002 - 2023 Moose River, LLC. All Rights Reserved.";

      /**
     * 
     */
    public static final int XML_CONFIG_FILE = 1;
    
    /**
     * 
     */
    public static final int JSON_CONFIG_FILE = 2;
    /**
     *
     */
    private String  hostName   = "";

    /**
     *
     */
    private String  homeDir    = Params.HOME_DIR;

    /**
     *
     */
    private String  databaseName   = "";

    /**
     *
     */
    private String  DBType     = "";

    /**
     *
     */
    private String  port       = "";

    /**
     *
     */
    private String  userName   = "";

    /**
     *
     */
    private String  password   = "";

    /**
     *
     */
    private String  driverName = "";

    /**
     *
     */
    private String  jdbcStr    = "";

    /**
     *
     */
    private String  configName     = Params.DB_CONFIG_FILE_NAME;

    /**
     *
     */
    private String  configFile     = "";

    /**
     *
     */
    private String  configFileName = "";
    
    /**
     * 
     */
    private String projectName = "";
    
    /**
     * 
     */
    private String projectNumber = "";
    
    /**
     * 
     */
    private String site = "";
    
    /**
     *
     */
    private boolean  databaseLoaded = false;

    /**
     *
     */
    private boolean  changed = false;

    /**
     *
     */
    private boolean  beenChanged = false;

    /**
     *
     */
    private boolean  dbConnected = false;

    /**
     *
     */
    private Connection  conn = null;

    /**
     *
     */
    private Statement   stmt = null;
    
    /**
     *
     */
    //private BasicDataSource ds = null;

    /**
     * 
     */
    private ArrayList al = null;
    
    /**
     * 
     */
    private String cachePrepStmts = "";
       
    /**
     * 
     */
    private String prepStmtCacheSize = "";
       
    /**
     * 
     */
    private String prepStmtCacheSqlLimit = "";
       
    /**
     * 
     */
    private boolean autoCommit = false;
    
    /**
     *
     */
    public DataBase() {
        super();
    }   // End of base constructor

    /**
     * 
     * @param jObj 
     */
    public DataBase(JSONObject jObj) {
        this();
        
        this.hostName              = jObj.get("db_hostname").toString();
        this.databaseName          = jObj.get("db_name").toString();
        this.password              = jObj.get("db_password").toString();
        this.DBType                = jObj.get("db_type").toString();
        this.userName              = jObj.get("db_user").toString();
        this.port                  = jObj.get("port").toString();
        this.projectName           = jObj.get("project_name").toString();
        this.projectNumber         = jObj.get("project_number").toString();
        this.site                  = jObj.get("site").toString();
        this.cachePrepStmts        = jObj.get("cachePrepStmts").toString();
        this.prepStmtCacheSize     = jObj.get("prepStmtCacheSize").toString();
        this.prepStmtCacheSqlLimit = jObj.get("prepStmtCacheSqlLimit").toString();
             
        String tmpValue = jObj.get("autoCommit").toString();
        if (tmpValue.equalsIgnoreCase("true")) {
            this.autoCommit = true;
        } else {
            this.autoCommit = false;
        }
               
        this.setDBType(this.DBType, this.hostName, this.databaseName);
        
        this.databaseLoaded = true;
    }
    
    /**
     * 
     * @param jArr 
     */
    public DataBase(JSONArray jArr) {
        this();

        this.al = new ArrayList();

        Iterator it = jArr.iterator();
        while (it.hasNext()) {
            JSONObject jo = (JSONObject) it.next();
            DataBase db = new DataBase(jo);
            al.add(db);
        }
        
        this.databaseLoaded = true;
    }   // End of constructor - JSONObject
    
    /**
     * 
     * @param d 
     */
    /*
    public DataBase(Domain d) {
        this();

        String dbFile = d.getDbFile();
        String meta   = d.getMeta();

        StringBuilder sb = new StringBuilder();
        sb.append(Params.BASE_CONFIG_DIR).append("/");
        sb.append(meta).append("/").append(dbFile);
        String fqpFile = sb.toString();

        File f = new File(fqpFile);
        if (f.exists()) {
            try {
                parseDbXmlFile(fqpFile);
                this.databaseLoaded = true;
            }
            catch (FileNotFoundException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   // End of if
    }   // End of constructor
*/
    /**
     *
     * @param config_name
     */
    public DataBase(String config_name) {
            
        this();
       
        loadConfigFile(config_name, DataBaseCommon.JSON_CONFIG_FILE);
       
    }   // End of constructor

    /**
     * 
     * @param config_name
     * @param file_type 
     */
    public DataBase(String config_name, int file_type) {
        this();
        
        loadConfigFile(config_name, file_type); 
    }   // End of constructor


    //
    // Get methods
    //
    
        
    /**
     *
     * @return 
     */
    public String getHostName() { 
        return this.hostName;     
    }

    /**
     *
     * @return 
     */
    public String getHomeDir() { 
        return this.homeDir;       
    }

    /**
     *
     * @return 
     */
    public String getDatabaseName() { 
        return this.databaseName;      
    }

    /**
     *
     * @return 
     */
    public String getDBType() { 
        return this.DBType;         
    }

    /**
     *
     * @return 
     */
    public String getPort() { 
        return this.port;         
    }

    /**
     *
     * @return 
     */
    public String getUserName() { 
        return this.userName;    
    }

    /**
     *
     * @return 
     */
    public String getPassword() { 
        return this.password;    
    }

    /**
     *
     * @return 
     */
    public String getDriverName() { 
        return this.driverName;  
    }

    /**
     *
     * @return 
     */
    public String getJdbcStr() { 
        return this.jdbcStr;      
    }

    /**
     *
     * @return 
     */
    public String getConfigName() { 
        return this.configName; 
    }

    /**
     *
     * @return 
     */
    public String getConfigFileName() { 
        return this.configFileName;
    }

    /**
     *
     * @return 
     */
    public boolean getLoaded() { 
        return this.databaseLoaded;      
    }

    /**
     *
     * @return 
     */
    public boolean getChanged() { 
        return this.changed;     
    }

    /**
     *
     * @return 
     */
    public boolean isConnected() { 
        return this.dbConnected; 
    }

    /**
     *
     * @return 
     */
    public Statement getStatement() { 
        return this.stmt;        
    }

    /**
     *
     * @return 
     */
    public Connection getConnection() { 
        return this.conn;         
    }

    /**
     *
     * @return Database string
     */
    public String getDatabaseString() {
        /*
        jdbc:mysql://" + this.host + ":" + String.valueOf(this.port) + "/"
            + this.database + "?autoReconnect=true&serverTimezone=" + TimeZone
            .getDefault().getID());
        
        String str = getJdbcStr() + getHostName() + ":" 
            + getPort() + "/" + getDatabaseName();
        */
        String timeZone = TimeZone.getDefault().getID();

        String str = getJdbcStr() + getHostName() + ":" 
            + getPort() + "/" + getDatabaseName() +
              "?autoReconnect=true&serverTimezone=" + timeZone;
        
        return str;
    }   // End of getDatabaseString

    /**
     * 
     * @return 
     */
    public String getProjectName() {
        return this.projectName;
    }
    
    /**
     * 
     * @return 
     */
    public String getProjectNumber() {
        return this.projectNumber;
    }
    
    /**
     * 
     * @return 
     */
    public String getSite() {
        return this.site;
    }

    /**
     * 
     * @return 
     */
    public String getCachePrepStmts() {
        return this.cachePrepStmts;
    }

    /**
     * 
     * @return 
     */
    public String getPrepStmtCacheSize() {
        return this.prepStmtCacheSize;
    }

    /**
     * 
     * @return 
     */
    public String getPrepStmtCacheSqlLimit() {
        return this.prepStmtCacheSqlLimit;
    }

    /**
     * 
     * @return 
     */
    public boolean getAutoCommit() {
        return this.autoCommit;
    }

    
    //
    // Set methods
    //

    /**
     *
     * @param ConfigName
     */
    public void setConfigName(String ConfigName) {
        this.configName = ConfigName;

        this.configFileName = this.homeDir + "/" + this.configName;
        beenChanged = true;
    }

    /**
     *
     * @param HostName
     */
    public void setHostName(String HostName) {
        this.hostName = HostName;
        beenChanged = true;
    }

    /**
     *
     * @param HomeDir
     */
    public void setHomeDir(String HomeDir) {
        this.homeDir = HomeDir;
        beenChanged = true;
    }

    /**
     *
     * @param Database
     */
    public void setDatabase(String Database) {
        this.databaseName = Database;
        beenChanged = true;
    }

    /**
     *
     * @param Port
     */
    public void setPort(String Port) {
        this.port = Port;
        beenChanged = true;
    }

    /**
     *
     * @param UserName
     */
    public void setUserName(String UserName) {
        this.userName = UserName;
        beenChanged = true;
    }

    /**
     *
     * @param Password
     */
    public void setPassword(String Password) {
        this.password = Password;
        beenChanged = true;
    }

    /**
     *
     * @param DriverName
     */
    public void setDriverName(String DriverName) {
        this.driverName = DriverName;
        beenChanged = true;
    }

    /**
     *
     * @param JdbcStr
     */
    public void setJdbcStr(String JdbcStr) {
        this.jdbcStr = JdbcStr;
        beenChanged = true;
    }

    /**
     *
     * @param Loaded
     */
    public void setDatabaseLoaded(boolean Loaded) {
        this.databaseLoaded = Loaded;
        beenChanged = true;
    }

    /**
     *
     * @param Changed
     */
    public void setChanged(boolean Changed) {
        this.changed = Changed;
        beenChanged = true;
    }

    /**
     *
     * @param DBType
     */
    public void setDBType(String DBType) {
        this.DBType = DBType;
        
        // jdbc:mysql://gdead.mooseriver.com:3306/MooseRiver

        // MySQL
        if (DBType.compareToIgnoreCase("mysql") == 0) {
            this.setPort("3306");
            this.setDriverName("com.mysql.cj.jdbc.Driver");
            this.jdbcStr = "jdbc:mysql://";
        }
        // PostgreSQL
        else if (DBType.compareToIgnoreCase("postgresql") == 0) {
            this.setPort("5432");
            this.setDriverName("org.postgresql.Driver");
            this.jdbcStr = "jdbc:postgresql://";
        }
        // SQLite
        else if (DBType.compareToIgnoreCase("sqlite") == 0) {
            // this.setPort("5432");
            this.setDriverName("org.sqlite.JDBC");
            this.jdbcStr = "jdbc:sqlite:";
        }

        beenChanged = true;
    }   // End of setDBType

    /**
     * 
     * @param projectName 
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    /**
     * 
     * @param projectNumber 
     */
    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }
    
    /**
     * 
     * @param site 
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * 
     * @param cachePrepStmts 
     */
    public void setCachePrepStmts(String cachePrepStmts) {
        this.cachePrepStmts = cachePrepStmts;
    }

    /**
     * 
     * @param prepStmtCacheSize 
     */
    public void setPrepStmtCacheSize(String prepStmtCacheSize) {
        this.prepStmtCacheSize = prepStmtCacheSize;
    }

    /**
     * 
     * @param prepStmtCacheSqlLimit 
     */
    public void setPrepStmtCacheSqlLimit(String prepStmtCacheSqlLimit) {
        this.prepStmtCacheSqlLimit = prepStmtCacheSqlLimit;
    }

    /**
     * 
     * @param autoCommit 
     */
    public void setAutoCommit(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    
    /**
     * 
     * @param config_name
     * @param file_type 
     */
    private void loadConfigFile(String config_name, int file_type) {
        if (config_name.length() > 0) {
            setConfigName(config_name);
            
            try {
                if (file_type == DataBaseCommon.XML_CONFIG_FILE) {
                    parseDbXmlFile(config_name);
                } else if (file_type == DataBaseCommon.JSON_CONFIG_FILE) {
                    parseDbJsonFile(config_name);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   // End of if
    }   // End of loadConfigFile

    /**
     *
     * @param xml_name
     * @throws java.io.FileNotFoundException
     */
    private void parseDbXmlFile(String xml_name) throws FileNotFoundException {

        String db_name  = "";
        String hostname = "";
        String user     = "";
        String password = "";
        String db_type  = "";
        Document doc = null;

        File f = new File(xml_name);
        if (!f.exists()) {
            throw new FileNotFoundException("File not found : " + xml_name);
        }
             
        File fXmlFile = new File(xml_name);
        if ((fXmlFile.exists()) && (fXmlFile.isFile())) {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            try {
                dBuilder = dbFactory.newDocumentBuilder();
                
                doc = dBuilder.parse(fXmlFile);
                
                doc.getDocumentElement().normalize();
                NodeList nList = doc.getElementsByTagName("DATA");
                
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        
                        Element eElement = (Element) nNode;
                        
                        db_name = eElement.getElementsByTagName("DB_NAME").item(0).getTextContent();
                        hostname = eElement.getElementsByTagName("HOSTNAME").item(0).getTextContent();
                        user = eElement.getElementsByTagName("USER").item(0).getTextContent();
                        password = eElement.getElementsByTagName("PASSWORD").item(0).getTextContent();
                        db_type = eElement.getElementsByTagName("DB_TYPE").item(0).getTextContent();
                        
                        setDatabase(db_name);
                        setHostName(hostname);
                        setUserName(user);
                        setPassword(password);   
                        setDBType(db_type);
                    
                    }   // End of if block
                }   // End of for loop
            }   // End of try block
            catch (ParserConfigurationException | SAXException | IOException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   // End of if
    }   // End of base constructor


    /**
     *
     */
    public void Connect() {
        try {
            String driver_name = getDriverName();
            Class.forName(driver_name);
            String db_str = getDatabaseString();

            conn = DriverManager.getConnection(db_str, 
                                               getUserName(),
                                               getPassword());
            stmt = conn.createStatement();
            dbConnected = true;
        }

        catch (ClassNotFoundException | SQLException exc) {
            System.err.println("Exception caught.\n" + exc);
            
            System.exit(1);
        }
    }   // End of Connect
    
    
    /**
     *
     */
    public void destroy() {
        try {
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();  
            }  
        }
        
        catch (SQLException exc) {
            System.err.println("Exception  #5 caught.\n" + exc);
            
        }
    }   // End of destroy  

    /**
     *
     */
    public void disconnect() {
        this.destroy();
    }

    /**
     * 
     */
    public void close() {
        this.destroy();
    }

   /**
    * 
    * @param config_name 
    */
    private void parseDbJsonFile(String config_name) {
        int i = 0;
    }

    /**
     * 
     * @param index
     * @return
     * @throws ValueOutOfRange 
     */
    /*
    public DataBase selectProject(int index) throws ValueOutOfRange {
        int i = 0;
           if ((index < Common.PROJECT_MIN) || (index > Common.PROJECT_MAX)) {
            throw new ValueOutOfRange("Index out of range");
        } else {
            Iterator it = this.al.iterator();
            while (it.hasNext()) {
                DataBase d = (DataBase) it.next();
                int projectNumber = Integer.valueOf(d.getProjectNumber());
                if (projectNumber == index) {
                    /*
                    "db_hostname": "gdead.mooseriver.com",
                    "db_name": "Choose",
                    "db_password": "chujbpt3",
                    "db_type": "mysql",
                    "db_user": "bdobbs",
                    "port": "3306",
                    "project_name": "Choose",
                    "project_number": "1",
                    "site": "local"
                    */
                   /*
                    this.projectName = Common.getGenericTypeName(
                            projectNumber,
                            Common.PROJECT_MIN,
                            Common.PROJECT_MAX,
                            Common.ProjectNames);
                    
                    this.projectNumber = String.valueOf(projectNumber);
                    this.hostName      = d.getHostName();
                    this.databaseName  = d.getDatabaseName();
                    this.password      = d.getPassword();
                    this.DBType        = d.getDBType();
                    this.userName      = d.getUserName();
                    this.port          = d.getPort();
                    this.site          = d.getSite();
                    
                    if (this.jdbcStr.isEmpty() || this.jdbcStr.isBlank()) {
                        // DB string here
                        this.setDBType(this.DBType, this.hostName, this.databaseName);
                    } else {
                    }
                    
                    this.prepStmtCacheSize     = d.getPrepStmtCacheSize();
                    this.prepStmtCacheSqlLimit = d.getPrepStmtCacheSqlLimit();
                    
                    this.databaseLoaded = true;
                    break;
                }   // End of if
            }   // End of while loop
        }   // End of else
        
        return this;
    }
*/
    /**
     * 
     * @param DBType
     * @param hostName
     * @param databaseName 
     */
    public void setDBType(String DBType, 
                           String hostName, 
                           String databaseName) {
        //"jdbc:mysql://localhost:3306/simpsons");
        
        String tmpDBType = this.DBType;

        String tmpStr = String.format("jdbc:%s://%s:%s/%s", tmpDBType, hostName, this.port, databaseName);
        
        this.jdbcStr = tmpStr;
    }   // End of setDBType

}   // End of class DataBase


/**************************************************************************
**
**                        < End of DataBase.java >
**
**************************************************************************/

