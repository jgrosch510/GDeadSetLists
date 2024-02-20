/**************************************************************************
**
**                           < Params.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : Params.java
**
**  Author       : Josef Grosch
**                          
**  Date         : 22 Sept 2016
**
**  Version      : 1.0
**
**  Modification : Some
**
**  Application  :
**
**  Functions    :
**
**  Description  :
**
**  Notes        : This one: 
**
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
package com.mooseriver.gdead.Base;


/**************************************************************************
**
**                                Imports
**
**************************************************************************/


/**************************************************************************
**
**                                 Class
**
**************************************************************************/


/**
 * @author Josef C. Grosch <jgrosch@gmail.com>
 * @version 1.0
 */
public class Params {
    // Version

    /**
     *
     */
    public static final String  HOME_DIR = "/usr/local/site/etc";

    /**
     *
     */
    public static final String  DB_CONFIG_FILE_NAME = "redwood-MusicBank-db.json";

    /**
     *
     */
    public static final String  KEYS_FILE_NAME = "aws-keys.json";

    /**
     *
     */
    public static final String  CONFIG_FILE_NAME = "MooseRiverConfig.json";

    /**
     * 
     */
    public static final String MASTER_SITE_CONFIG = "master-site-config.json";
    
    /**
     *
     */
    public static final String  META_HOME = "/usr/local/site/etc/Meta";

    /**
     *
     */
    public static final String  REDIS_HOST = "localhost";

    /**
     *
     */
    public static final Integer REDIS_PORT = 6379;
    
    /**
     * 
     */
    public static final String REDIS_PATH = "http://localhost:6379"; 

    /**
     *
     */
    public static final String  FLEA_DB = "redwood-MooseRiver-db.json";

    
    /**
     * 
     */
    public static final String MOOSE_RIVER_ADMIN_PROPERTY = HOME_DIR + "/MooseRiverAdmin.properties";
    
    /**
     *
     */
    public static final String TOUCHING_FILE = "/usr/local/site/data/touching-states.json";
    
    /**
     * 
     */
    public static final String MASTER_DOMAIN = "mooseriver.com";

    /**
     * 
     */
    public static final String FQP_MASTER_CONFIG = "/usr/local/site/etc/master-config.json";

    /**
     * 
     */
    public static final String DOMAIN_DIR = "/usr/local/site/data";

    /**
     * 
     */
    public static final String MASTER_CONFIG = "/usr/local/site/etc/master-config.json";

    /**
     * 
     */
    public static final String FQP_MASTER_DOMAINS = "/usr/loca;/site/etc/domains.json";

    /**
     * 
     */
    public static final String MASTER_DB_CONFIG = "/usr/local/site/etc/master-db.json";

    /**
     * 
     */
    public static final String ETC_DIR = "/usr/local/site/etc";

    /**
     * 
     */
    public static final String BASE_CONFIG_DIR = "/usr/local/site/etc";

    /**
     * 
     */
    public static final String QUOTE_FILE = "/usr/local/site/etc/quotes.json";
    
    public static final String DATA_DIR = "";
    
    public static final String SEASON_LENGTH = "";
    
    public static final String EVENT_COUNT_FILE = "eventCount.json";
    
}   // End of class Params


/**************************************************************************
**
**                         < end of Params.java >
**
**************************************************************************/
