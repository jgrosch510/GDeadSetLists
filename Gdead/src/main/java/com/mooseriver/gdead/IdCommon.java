/**************************************************************************
**
**                             < IdCommon.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : IdCommon.java
** 
**  Author       : Josef Grosch
**                          
**  Date         : 25 June 2012
**
**  Version      : 1.1
**
**  Modification : 1.0 - 31 Dec 2017  - Updated
**                 1.1 - 27 Dec 2019  - Consolidated UserId.java into Ids.java. 
**                                      Added missing Ids. Converted to UUID 
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
** pub   4096R/C8FE7E3C 2019-05-07 [expires: 2021-05-06]
** Key   fingerprint = E0BA 2A0F 0830 A58F 6319  FA19 1737 A401 C8FE 7E3C
** uid   Josef Grosch <jgrosch@gmail.com>
** sub   4096R/1BD5EC2E 2019-05-07 [expires: 2021-05-06]
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
import java.util.UUID;


/**
 *
 * @author  Josef Grosch (jgrosch@gmail.com)
 * @see     java.util.UUID
 * @since   MooseRiver1.0
 * @version 1.1
 * 
 */

public final class IdCommon {

    /**
     *
     */
    private final static String COPYRIGHT =
        "Copyright (c) 2012 - 2023 Moose River, LLC. All Rights Reserved.";
    
    /**
     * 
     */
    private final static String VERSION = "1.1";
    
    /**
     *
     */
    public static final int MR_ALBUM_ID         =  0;    // MRALID

    /**
     *
     */
    public static final int MR_ARTIST_ID        =  1;    // MRARID

    /**
     *
     */
    public static final int MR_ARTIST_FAMILY_ID =  2;    // MRAFID

    /**
     *
     */
    public static final int MR_BAND_ID          =  3;    // MRBDID

    /**
     *
     */
    public static final int MR_BAND_MUSICIAN_ID =  4;    // MRBMID

    /**
     *
     */
    public static final int MR_CD_ID            =  5;    // MRCDID

    /**
     *
     */
    public static final int MR_COLLECTION_ID    =  6;    // MRCOID

    /**
     *
     */
    public static final int MR_CONCERT_ID       =  7;    // MRCTID

    /**
     *
     */
    public static final int MR_COVER_ID         =  8;    // MRCVID

    /**
     *
     */
    public static final int MR_DVD_ID           =  9;    // MRDVID

    /**
     *
     */
    public static final int MR_FRIEND_ID        = 10;    // MRFBID

    /**
     *
     */
    public static final int MR_GENRE_ID         = 11;    // MRGEID

    /**
     *
     */
    public static final int MR_GROUP_ID         = 12;    // MRGRID

    /**
     *
     */
    public static final int MR_LABEL_ID         = 13;    // MRLBID

    /**
     * Used to generate a market ID
     */
    public static final int MR_MARKET_ID        = 14;    // MRMAID

    /**
     *
     */
    public static final int MR_MUSICIAN_ID      = 15;    // MRMUID

    /**
     *
     */
    public static final int MR_PICTURE_ID       = 16;    // MRPTID

    /**
     *
     */
    public static final int MR_RECORD_ID        = 17;    // MRRCID

    /**
     *
     */
    public static final int MR_SESSION_ID       = 18;    // MRSEID

    /**
     *
     */
    public static final int MR_SETLIST_ID       = 19;    // MRSLID

    /**
     *
     */
    public static final int MR_TOUR_ID          = 20;    // MRTOID

    /**
     *
     */
    public static final int MR_TRIBE_ID         = 21;    // MRTRID

    /**
     *
     * The field, <b>MR_USER_ID</b>, is used to generate a user id.
     */
    public static final int MR_USER_ID          = 22;    // MRUSID

    /**
     *
     */
    public static final int MR_USER_FRIEND_ID   = 23;    // MRUFID

    /**
     *
     */
    public static final int MR_USER_MISC_ID     = 24;    // MRUMID

    /**
     *
     */
    public static final int MR_USER_PARAMS_ID   = 25;    // MRPAID

    /**
     *
     */
    public static final int MR_USER_PROFILE_ID  = 26;    // MRPRID

    /**
     *
     */
    public static final int MR_USER_STATS_ID    = 27;    // MRUSID

    /**
     *
     * The field, <b>MR_VENUE_ID</b>, is used to generate a venue ID.
     */
    public static final int MR_VENUE_ID         = 28;    // MRVUID

    /**
     *
     */
    public static final int MR_VERIFY_ID        = 29;    // MRVEID

    /**
     *
     */
    public static final int MR_VIDEO_ID         = 30;    // MRVDID

    /**
     *
     */
    public static final int MR_STORE_ID         = 31;    // MRSTID

    /**
     *
     */
    public static final int MR_ORG_ID           = 32;    // MROGID

    /**
     *
     */
    public static final int MR_NOTIFY_ID        = 33;    // MRNTID

    /**
     *
     * The field, <b>MR_EVENT_ID</b>, is used to generate an event ID.
     */
    public static final int MR_EVENT_ID         = 34;    // MREVID

    /**
     *
     */
    public static final int MR_TICKET_SALE_ID   = 35;    // MRTSID

    /**
     */
    public static final int MR_ALERT_ID         = 36;    // MRATID

    /**
     *
     */
    public static final int MR_OWNER_ID         = 37;    // MROWID
    
    /**
     * 
     */
    public static final int MR_CONTACT_ID       = 38;    // MRCNID
    
    /**
     * 
     */
    public static final int MR_REGION_ID        = 39;    // MRRGID
    
    /**
     * 
     */
    public static final int MR_ADDRESS_ID       = 40;    // MRADID
    
    /**
     * 
     */
    public static final int MR_CLINIC           = 41;    // MRCLNC
    
    /**
     * 
     */
    public static final int MR_EVENT_TIME_ID    = 42;    // MRETID
    
    /**
     * 
     */
    public static final int MR_FILE_ID          = 43;    // MRFLID


    /**
     *
     */
    public static final int ID_TYPE_MIN =  0;

    /**
     *
     */
    public static final int ID_TYPE_MAX = 43;

    /**
     *
     */
    private static final String [] IdTypes = {
        "MRALID",  // MR Album Id         -  0
        "MRARID",  // MR Artist Id        -  1
        "MRAFID",  // MR Artist Family Id -  2
        "MRBDID",  // MR Band Id          -  3
        "MRBMID",  // MR Band Musician Id -  4
        "MRCDID",  // MR CD Id            -  5
        "MRCOID",  // MR Collection Id    -  6
        "MRCTID",  // MR Concert Id       -  7
        "MRCVID",  // MR Cover Id         -  8
        "MRDVID",  // MR DVD Id           -  9
        "MRFBID",  // MR Friend Id        - 10
        "MRGEID",  // MR Genre Id         - 11
        "MRGRID",  // MR Group Id         - 12
        "MRLBID",  // MR Label Id         - 13
        "MRMAID",  // MR Market Id        - 14
        "MRMUID",  // MR Musician Id      - 15
        "MRPTID",  // MR Picture Id       - 16
        "MRRCID",  // MR Record Id        - 17
        "MRSEID",  // MR Session Id       - 18
        "MRSLID",  // MR Setlist          - 19
        "MRTOID",  // MR Tour Id          - 20
        "MRTRID",  // MR Tribe Id         - 21
        "MRUSID",  // MR User Id          - 22
        "MRUFID",  // MR User Friend Id   - 23
        "MRUMID",  // MR User Misc Id     - 24
        "MRPAID",  // MR User Params Id   - 25
        "MRPRID",  // MR User Profile Id  - 26
        "MRUSID",  // MR User Stats Id    - 27
        "MRVUID",  // MR Venue Id         - 28
        "MRVEID",  // MR Verify Id        - 29
        "MRVDID",  // MR Video Id         - 30
        "MRSTID",  // MR Store Id         - 31
        "MROGID",  // MR Org Id           - 32 
        "MRBTID",  // MR Notify Id        - 33
        "MREVID",  // MR Event Id         - 34
        "MRTSID",  // MR Ticket Sale Id   - 35
        "MRATID",  // MR Alert Id         - 36
        "MROWID",  // MR Owner Id         - 37
        "MRCNID",  // MR Contact Id       - 38
        "MRRGID",  // MR Region Id        - 39
        "MRADID",  // MR Address Id       - 40
        "MRCLNC",  // MR Clinic           - 41
        "MRETID",  // MR Event Time Id    - 42
        "MRFLID"   // MR File Id          - 43
    };

    /**
     * 
     */
    private static final String [] IdTypesDesc = {
        "MR Album Id",
        "MR Artist Id",
        "MR Artist Family Id",
        "MR Band Id",
        "MR Band Musician Id",
        "MR CD Id",
        "MR Collection Id",
        "MR Concert Id",
        "MR Cover Id",
        "MR DVD Id",
        "MR Friend Id",
        "MR Genre Id",
        "MR Group Id",
        "MR Label Id",
        "MR Market Id",
        "MR Musician Id",
        "MR Picture Id",
        "MR Record Id",
        "MR Session Id",
        "MR Setlist",
        "MR Tour Id",
        "MR Tribe Id",
        "MR User Id",
        "MR User Friend Id",
        "MR User Misc Id",
        "MR User Params Id",
        "MR User Profile Id",
        "MR User Stats Id",
        "MR Venue Id",
        "MR Verify Id",
        "MR Vid",
        "MR Store Id",
        "MR Org Id",
        "MR Notify Id",
        "MR Event Id",
        "MR Ticket Sale Id",  // 
        "MR Alert Id",
        "MR Owner Id",
        "MR Contact Id",
        "MR Region Id",
        "MR Address Id",
        "MR Clinic",
        "MR Event Time Id"
    };

    /**
     *
     */
    private final static int PID_MIN       = 0;

    /**
     *
     */
    public  final static int PID_MUSICBANK = 0;

    /**
     *
     */
    public  final static int PID_FLEA      = 1;

    /**
     *
     */
    public  final static int PID_FARM      = 2;

    /**
     *
     */
    public  final static int PID_FAIR      = 3;
    
    /**
     * 
     */
    public final static int PID_ECAL       = 4;
    
    /**
     * 
     */
    public final static int PID_LORAX      = 5;
    
    /**
     *
     */
    private final static int PID_MAX       = 5;

    /**
     *
     */
    private static final String [] projectName = {
        "MusicBank",
        "FleaMarketFinder",
        "FarmersMarketFinder",
        "FairFinder",
        "eCalendar",
        "Lorax"
    };

    /**
     *
     */
    public IdCommon() {
        super();    
    }

    /**
     *
     * @param index
     * @return
     */
    public static String getProjectTitle(int index) {
        String returnString = "";
        
        if ((index >= IdCommon.PID_MIN) && (index <= IdCommon.PID_MAX)) {
            returnString = projectName[index];
        } else {
            throw new IllegalArgumentException("Project index out of range.");
        }

        return returnString;
    }   // End of getProjectTitle
    /**
     *
     * @param index
     * @return 
     */
    public static String getIdTypeName(int index) {
        String returnString = "";
        
        if ((index >= IdCommon.ID_TYPE_MIN) && 
            (index <= IdCommon.ID_TYPE_MAX)) {
            returnString = IdTypes[index];
        } else {
            throw new IndexOutOfBoundsException("ID type out of bounds.");
        }

        return returnString;
    }   // End of getIdTypeName

    /**
     * 
     * @param idType
     * @return 
     */
    public static String genIdByType(int idType) {
        String outStr   = ""; 

        if ((idType >= IdCommon.ID_TYPE_MIN) &&
            (idType <= IdCommon.ID_TYPE_MAX)) {
            String prefix = getIdTypeName(idType);
            UUID id = java.util.UUID.randomUUID();
            String idString = id.toString();

            /*
             * The IDs MR_VERIFY_ID and MR_SESSION_ID do not recieve an ID
             * prefix. These IDs are either sent in an email to verify a 
             * transaction or it is used as a cookie. Either way only those
             * IdCommon that are internal receive an ID prefix.
             */
            if ((idType == IdCommon.MR_VERIFY_ID) ||
                (idType == IdCommon.MR_SESSION_ID)) {
                outStr = String.format("%s", idString);
            } else {
                outStr = String.format("%s-%s", prefix, idString);
            }
        } else {   // End of if idType
            throw new IndexOutOfBoundsException("ID type out of bounds.");
        }
        
        return outStr;
    }   // End of genIdByType
    
    /**
     * 
     * @param idType
     * @return 
     */
    public static String getIdTypeDesc(int idType) {
        String returnStr = "";
        
        if ((idType >= IdCommon.ID_TYPE_MIN) && (idType <= IdCommon.ID_TYPE_MAX)) {
            returnStr = IdTypesDesc[idType];
        } else {
            throw new IndexOutOfBoundsException("ID type out of bounds");
        }
        
        return returnStr;
    }   // End of getIdTypeDesc
}   // End of IdCommon

/**************************************************************************
**
**                          < end of IdCommon.java >
**
**************************************************************************/
