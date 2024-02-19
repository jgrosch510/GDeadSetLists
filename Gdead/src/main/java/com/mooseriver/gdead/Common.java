/**************************************************************************
**
**                           < Common.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : Common.java
**
**  Author       : Josef Grosch
**                          
**  Date         : 17 Feb 2016
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
**  Notes        :
**
**
**************************************************************************/


/**************************************************************************
**
**                               Copyright
**
**              (C) Copyright 2017 - 2023 Moose River LLC.
**                          <jgrosch@gmail.com>
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
** pub   4096R/9FDD3FC7 2012-04-29
** Key   fingerprint = 178C 7996 9292 B705 7067  7084 9EA9 459F 9FDD 3FC7
** uid   Josef Grosch <jgrosch@gmail.com>
** sub   4096R/EEA1791E 2012-04-29
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
//import com.mooseriver.Event.EventCommon;
//import static com.mooseriver.Event.EventCommon.EventTypeNames;
//import com.mooseriver.Exception.ValueOutOfRange;


/**
 * @author Josef C. Grosch <jgrosch@gmail.com>
 * @version 1.0
 */
public class Common {

    // -------------------------------------------------------------------
    //
    // Logical types
    //
    // -------------------------------------------------------------------

    /**
     *
     */
    public static final int OK     = 0;    // True

    /**
     *
     */
    public static final int NOT_OK = 1;    // False

    /**
     *
     */
    public static final int YES    = 1;    // True

    /**
     *
     */
    public static final int NO     = 0;    // False

    /**
     *
     */
    public static final int MATCH_YES = 1; // True

    /**
     *
     */
    public static final int MATCH_NO  = 0; // False

    /**
     *
     */
    public static final int MUST_TEST = 1; //

    /**
     *
     */
    public static final int RESULT    = 2; //


    // -------------------------------------------------------------------
    //
    // Time unit lengths in seconds
    //
    // -------------------------------------------------------------------

    /**
     * <b>ONE_MINUTE</b> - The number of seconds in one minute, 60.
     */
    public static final int ONE_MINUTE  = (60);

    /**
     * <b>ONE_HOUR</b> - The number of seconds in one hour, 3,600.
     */
    public static final int ONE_HOUR    = (60 * 60);

    /**
     * <b>ONE_DAY</b> - The number of seconds in one day, 86,400.
     */
    public static final int ONE_DAY     = (60 * 60 * 24);

    /**
     * <b>ONE_WEEK</b> - The number of seconds in one week, 604,800.
     */
    public static final int ONE_WEEK    = (60 * 60 * 24 * 7);

    /**
     * <b>ONE_MONTH</b> - The number of seconds in one month (30 days), 
     * 2,592,000,
     */
    public static final int ONE_MONTH   = (60 * 60 * 24 * 30);

    /**
     * <b>ONE_YEAR</b> - The number of seconds in one year (365.25 days), 
     * 31,557,600.
     */
    public static final int ONE_YEAR    = (int)(60 * 60 * 24 * 365.25);

    /**
     * <b>WEEK_DAY_COUNT</b> - The number of days in a week.
     */
    public static final int WEEK_DAY_COUNT = 7;
    

    // -------------------------------------------------------------------
    //
    // host file
    //
    // -------------------------------------------------------------------

    /**
     * 
     */
    public static final String THIS_HOST_FILE = "/usr/local/site/etc/this-host.txt";


    // -------------------------------------------------------------------
    //
    // Event and Market types
    //
    // -------------------------------------------------------------------

    /**
     *
     */
    public static final int BONG           =  0;  // Music Bong - stupid

    /**
     *
     */
    //public static final int COUNTY_FAIR    =  1;  // Event - CountyFairFinder

    /**
     *
     */
    public static final int DATING         =  2;  // Dating site - stupid

    /**
     *
     */
    //public static final int ESTATE_SALE    =  3;  // Market - FleaMarketFinder

    /**
     *
     */
    //public static final int COMBINED_FAIR  =  4;  // Event - (County/State)FairFinder

    /**
     *
     */
    //public static final int FLEA_MARKET    =  5;  // Market - FleaMarketFinder

    /**
     *
     */
    //public static final int FARMERS_MARKET =  6;  // Market - FarmersMarketFinder

    /**
     *
     */
    public static final int FOG            =  7;  // Stupid

    /**
     *
     */
    public static final int FRIEND         =  8;  // Stupid

    /**
     *
     */
    //public static final int GARAGE_SALE    =  9;  // Market - FleaMarketFinder

    /**
     *
     */
    public static final int GEEK           = 10;  // Stupid

    /**
     *
     */
    public static final int HUMBOLDT       = 11;  //

    /**
     *
     */
    public static final int KINK           = 12;  //

    /**
     *
     */
    public static final int LOCAL_FLEA     = 13;  // FleaMarketFinder

    /**
     *
     */
    public static final int MISC           = 14;  //

    /**
     *
     */
    public static final int MOOSE          = 15;  // Base

    /**
     *
     */
    public static final int MUSIC          = 16;  // MusicBank

    /**
     *
     */
    public static final int MY_ALBUM       = 17;  //

    /**
     *
     */
    public static final int PET            = 18;  // Dead

    /**
     *
     */
    //public static final int SWAP_MEET      = 19;  // Market - FleaMarketFinder

    /**
     *
     */
    public static final int REDWOOD        = 20;  //

    /**
     *
     */
    public static final int REMOTE_FLEA    = 21;  // FleaMarketFinder

    /**
     *
     */
    //public static final int RUMMAGE_SALE   = 22;  // Market - FleaMarketFinder

    /**
     *
     */
    //public static final int STATE_FAIR     = 23;  // Event - StateFairFinder

    /**
     *
     */
    public static final int TMP_FLEA       = 24;  //

    /**
     *
     */
    public static final int URL_SHARE      = 25;  // Stupid

    /**
     *
     */
    //public static final int YARD_SALE      = 26;  // Market - FleaMarketFinder

    /**
     *
     */
    //public static final int CONCERT        = 27;  // Event - Concert

    /**
     *
     */
    //public static final int FLOWER_SHOW    = 28;  // Event - Flower Show

    /**
     *
     */
    //public static final int ORCHARD_SHOW   = 29;  // Event - Orchid Show

    /**
     *
     */
    //public static final int CRAFT_FAIR     = 30;  // Event - Crafts

    /**
     *
     */
    //public static final int GUITAR_SHOW    = 31;  // Event - Guitar Show

    /**
     *
     */
    //public static final int GUN_SHOW       = 32;  // Event - Gun Show

    /**
     *
     */
    //public static final int AUTO_SHOW      = 33;  // Event - Auto Show

    /**
     *
     */
    //public static final int TRADE_SHOW     = 34;  // Event

    /**
     *
     */
    //public static final int RODEO          = 35;  // Event

    /**
     *
     */
    //public static final int COOK_OFF       = 36;  // Event

    /**
     *
     */
    //public static final int OTG            = 37;  // Event - Off The Grid (Food Truck)

    /**
     *
     */
    //public static final int STREET_FAIR    = 38;  // Event

    /**
     *
     */
    //public static final int ART_SHOW       = 39;  // Event

    /**
     *
     */
    //public static final int CARNIVAL       = 40;  // Event

    /**
     *
     */
    //public static final int MARCH          = 41;  // Event

    /**
     *
     */
    //public static final int PARADE         = 42;  // Event

    /**
     *
     */
    //public static final int CAT_SHOW       = 43;  // Event

    /**
     *
     */
    //public static final int DOG_SHOW       = 44;  // Event

    /**
     *
     */
    //public static final int FESTIVAL       = 45;  // Event

    /**
     *
     */
    //public static final int MUSIC_FESTIVAL = 46;  // Event

    /**
     *
     */
    //public static final int PET_SHOW       = 47;  // Event

    /**
     *
     */
    //public static final int PLAY           = 48;  // Event

    /**
     *
     */
    //public static final int ATHLETIC       = 49;  // Event
    
    /**
     * 
     */
    //public static final int THRIFT_STORE   = 50;  // Market - thrift store

    /**
     *
     */
    //public static final int ALL            = 51;  //

    /**
     * 
     */
    //public static final int TOUR           = 52;  //
    
    /**
     * 
     */
    //public static final int TICKET_SALE    = 53;  //
    
    public static final int LORAX = 54;
    public static final int CHOOSE = 55;

    // -------------------------------------------------------------------
    //
    // Event min and Max
    //
    // -------------------------------------------------------------------
    
    /**
     *
     */
    //public static final int MIN_EVENT_TYPE = 0;

    /**
     *
     */
    //public static final int MAX_EVENT_TYPE = 53;


    // -------------------------------------------------------------------
    //
    // Realms
    //
    // -------------------------------------------------------------------

    /**
     * 
     */
    public static final int REALM_AMAZON     = 0;
    
    /**
     * 
     */
    public static final int REALM_RACK_SPACE = 1;
    
    /**
     * 
     */
    public static final int REALM_GCE        = 2;
    
    /**
     * 
     */
    public static final int REALM_AZURE      = 3;
    
    /**
     * 
     */
    public static final int REALM_MIN = 0;
    
    /**
     * 
     */
    public static final int REALM_MAX = 3;
    
    /**
     *
     */
    public static final int SUGGEST_FORM  = 1;
    
    // -------------------------------------------------------------------
    //
    // Proper week day name defines
    //
    // -------------------------------------------------------------------

    public static final int SUNDAY    = 1;
    public static final int MONDAY    = 2;
    public static final int TUESDAY   = 3;
    public static final int WEDNESDAY = 4;
    public static final int THURSDAY  = 5;
    public static final int FRIDAY    = 6;
    public static final int SATURDAY  = 7;

    /**
     * 
     */
    public static String [] ShortDayNames = {
        "Sun",
        "Mon",
        "Tue",
        "Wed",
        "Thu",
        "Fri",
        "Sat"
    };

    /**
     * 
     */
    public static String [] LongDayNames = {
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday"
    };

    /**
     * 
     */
    public static int MIN_YEAR = 1900;
    
    /**
     * 
     */
    public static int MAX_YEAR = 2030;
    

    // -------------------------------------------------------------------
    //
    // Define debug files
    //
    // -------------------------------------------------------------------

    /**
     *
     */
    public static final String BONG_DEBUG_LOG_FILE     = "/usr/local/site/Debug/MusicBong/bong_debug.log";

    /**
     *
     */
    public static final String ESTATE_DEBUG_LOG_FILE   = "/usr/local/site/Debug/EstateSaleFinder/re_debug.log";

    /**
     *
     */
    public static final String FAIR_DEBUG_LOG_FILE     = "/usr/local/site/Debug/FairFinder/debug.log";

    /**
     *
     */
    public static final String FARM_DEBUG_LOG_FILE     = "/usr/local/site/Debug/FarmersMarketFinder/re_debug.log";

    /**
     *
     */
    public static final String FLEA_DEBUG_LOG_FILE     = "/usr/local/site/Debug/FleaMarketFinder/fmf_debug.log";

    /**
     *
     */
    public static final String FT_DEBUG_LOG_FILE       = "/usr/local/site/Debug/FogTown/ft_debug.log";

    /**
     *
     */
    public static final String GSF_DEBUG_LOG_FILE      = "/usr/local/site/Debug/GarageSaleFinder/gsf_debug.log";

    /**
     *
     */
    public static final String LOCAL_FLEA_DATA_FILE    = "/usr/tmp/Debug/FleaMarketFinder/data.dump";

    /**
     *
     */
    public static final String MR_DEBUG_LOG_FILE       = "/usr/local/site/Debug/MooseRiver/mr_debug.log";

    /**
     *
     */
    public static final String MUSIC_DEBUG_LOG_FILE    = "/usr/local/site/Debug/MusicBank/mub_debug.log";

    /**
     *
     */
    public static final String PET_DEBUG_LOG_FILE      = "/usr/local/site/Debug/LostPetFinder/re_debug.log";

    /**
     *
     */
    public static final String REDWOOD_DEBUG_LOG_FILE  = "/usr/local/site/Debug/RedwoodEmpire/re_debug.log";

    /**
     *
     */
    public static final String REMOTE_FLEA_DATA_FILE   = "/usr/local/site/Debug/FleaMarketFinder/data.dump";

    /**
     *
     */
    public static final String RUMMAGE_DEBUG_LOG_FILE  = "/usr/local/site/Debug/RummageSaleFinder/re_debug.log";

    /**
     *
     */
    public static final String SWAP_DEBUG_LOG_FILE     = "/usr/local/site/Debug/SwapMeetFinder/re_debug.log";

    /**
     *
     */
    public static final String TMP_FLEA_DEBUG_LOG_FILE = "/usr/tmp/Debug/FleaMarketFinder/fmf_debug.log";

    /**
     *
     */
    public static final String URL_DEBUG_LOG_FILE      = "/usr/local/site/Debug/URLShare/url_share.log";

    /**
     * 
     */
    
    public static final String STATE_DATA_FILE = "/usr/local/site/etc/state-data.json";
    /**
     *
     */
    
    /*
    private static final String [] SiteTypeNames = {
        "Bong",            //  0       
        "County Fair",     //  1 -- Event 
        "Dating",          //  2     
        "Estate Sale",     //  3 -- Market
        "Fair",            //  4 -- Event
        "Flea Market",     //  5 -- Market
        "Farmers Market",  //  6 -- Market
        "Fog",             //  7
        "Friend",          //  8
        "Garage Sale",     //  9 -- Market
        "Geek",            // 10
        "Humboldt",        // 11
        "Kink",            // 12 
        "Local Flea",      // 13 -- Market (Testing only)
        "Misc",            // 14 
        "Moose",           // 15
        "Music",           // 16
        "My Album",        // 17
        "Pet",             // 18
        "Swap Meet",       // 19 -- Market
        "Redwood",         // 20 --
        "Remote Flea",     // 21 -- Market (Testing only)
        "Rummage Sale",    // 22 -- Market
        "State Fair",      // 23 -- Event
        "Tmp Flea",        // 24 -- Market (Testing only)
        "Url Share",       // 25 -- Shit idea
        "Yard Sale",       // 26 -- Market
        "Concert",         // 27 -- Event
        "Flower Show",     // 28 -- Event
        "Orchard Show",    // 29 -- Event
        "Craft Fair",      // 30 -- Event
        "Guitar Show",     // 31 -- Event
        "Gun Show",        // 32 -- Event
        "Auto Show",       // 33 -- Event
        "Trade Show",      // 34 -- Event
        "Rodeo",           // 35 -- Event
        "Cook Off",        // 36 -- Event
        "OTG",             // 37 -- Event (Off The Grid)
        "Street Fair",     // 38 -- Event
        "Art Show",        // 39 -- Event
        "Carnival",        // 40 -- Event
        "March",           // 41 -- Event
        "Parade",          // 42 -- Event
        "Tour",            // 43 -- Event
        "Ticket Sale"      // 44 -- Event
    };
    */
    /**
     *
     */
    private static String [] RepeatValues = {
        "Every",           //  0
        "First",           //  1
        "Second",          //  2
        "Third",           //  3
        "Fourth",          //  4
        "Every Other",     //  5
        "Last",            //  6
        "Check Website",   //  7
        "Contact Owner",   //  8
        "First & Second",  //  9
        "First & Third",   // 10
        "First & Fourth",  // 11
        "Second & Third",  // 12
        "Second & Fourth", // 13
    };

    public static final int REPEAT_EVERY             =  0;
    public static final int REPEAT_FIRST             =  1;
    public static final int REPEAT_SECOND            =  2;
    public static final int REPEAT_THIRD             =  3;
    public static final int REPEAT_FOURTH            =  4;
    public static final int REPEAT_EVERY_OTHER       =  5;
    public static final int REPEAT_LAST              =  6;
    public static final int REPEAT_CHECK_WEBSITE     =  7;
    public static final int REPEAT_CONTACT_OWNER     =  8;
    public static final int REPEAT_FIRST_AND_SECOND  =  9;
    public static final int REPEAT_FIRST_AND_THIRD   = 10;
    public static final int REPEAT_FIRST_AND_FOURTH  = 11;
    public static final int REPEAT_SECOND_AND_THIRD  = 12;
    public static final int REPEAT_SECOND_AND_FOURTH = 13;

    public static final int REPEAT_MIN =  0;
    public static final int REPEAT_MAX = 13;

        private static String [] TermValues = {
            "Year",
            "Month",
            "Day",
            "Week",
            "Weekend",
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday"
        };
        
    public static final int TERM_YEAR      =  0;
    public static final int TERM_MONTH     =  1;
    public static final int TERM_DAY       =  2; 
    public static final int TERM_WEEK      =  3;
    public static final int TERM_WEEKEND   =  4;
    public static final int TERM_SUNDAY    =  5;
    public static final int TERM_MONDAY    =  6;
    public static final int TERM_TUESDAY   =  7;
    public static final int TERM_WEDNESDAY =  8;
    public static final int TERM_THURSDAY  =  9;
    public static final int TERM_FRIDAY    = 10;
    public static final int TERM_SATURDAY  = 11;
    
    public static final int TERM_MIN =  0;
    public static final int TERM_MAX = 11;

    
    // -------------------------------------------------------------------
    //
    // Projects
    //
    // -------------------------------------------------------------------
    
    public static final int PROJECT_GENERAL        =  0;
    public static final int PROJECT_CHOOSE         =  1;
    public static final int PROJECT_ECALENDAR      =  2;
    public static final int PROJECT_LORAX          =  3;
    public static final int PROJECT_MOOSERIVER     =  4;
    public static final int PROJECT_MUSICBANK      =  5;
    public static final int PROJECT_REDWOODEMPIRE  =  6;
    public static final int PROJECT_BERKELEYGUY    =  7;
    public static final int PROJECT_LORAX_AWS      =  8;
    
    public static final int PROJECT_MIN = 0;
    public static final int PROJECT_MAX = 8;

    public static String [] ProjectNames = {
        "General",         // 0
        "Choose",          // 1
        "ECalendar",       // 2
        "Lorax",           // 3
        "MooseRiver",      // 4
        "MusicBank",       // 5
        "RedwoodEmpire",   // 6
        "BerkeleyGuy",     // 7
        "Lorax-AWS"        // 8
    };
    
    public static final int SELECT_PROJECT = 0;
    public static final int SELECT_DOMAIN  = 1;
    
    // -------------------------------------------------------------------
    //
    // Web Map contstants
    //
    // -------------------------------------------------------------------
    
    public static final String FROM_PROJECTION = "EPSG:4326";
    public static final String TO_PROJECTION   = "EPSG:900913";
    public static final String ZOOM_FACTOR     = "13";
    
    /**
     * 
     * @param index
     * @return
     * @throws ValueOutOfRange 
     */
    public static String getRepeatValues(int index) throws ValueOutOfRange {
        String returnValue = "";

        if (index >= Common.REPEAT_MIN && index <= Common.REPEAT_MAX) {
            returnValue = RepeatValues[index];
        } else {
            throw new ValueOutOfRange("Repeat value out of range"); 
        }
        
        return returnValue;
    }   // End of getRepeatValues

    /**
     *
     * @param index
     * @return 
     * @throws com.mooseriver.Exception.ValueOutOfRange 
     */
    /*
    public static String getSiteTypeName(int index) 
            throws ValueOutOfRange {
        if ((index < EventCommon.EVENT_MIN) || (index > EventCommon.EVENT_MAX)) {
            throw new ValueOutOfRange("index incorrect");
        }

        return EventTypeNames[index];
    }   // End of getSiteTypeName
    */
    /**
     * 
     * @param type
     * @param min
     * @param max
     * @param arr
     * @return
     * @throws ValueOutOfRange 
     */
    public static String getGenericTypeName(int type, 
                                            int min, 
                                            int max, 
                                            String [] arr) 
            throws ValueOutOfRange {
        if ((type < min) || (type > max)) {
            throw new ValueOutOfRange("Select type out of range");
        }
        
        String str = arr[type];
        
        return str;
    }   // End of getGenericTypeName 
                
}   // End of Common


/**************************************************************************
**
**                         < end of Common.java >
**
**************************************************************************/
