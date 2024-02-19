/**************************************************************************
**
**                         < ValueOutOfRange.java >
**
**************************************************************************/


/**************************************************************************
**
**  File Name    : ValueOutOfRange.java
**
**  Author       : Josef Grosch
**                          
**  Date         : 26 Feb 2014
**
**  Modification : 10 Feb 2016 - Updating to Java 7
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
**               (C) Copyright 2014 - 2016 Josef C. Grosch
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
**  pub   1024D/2D466121 2003-04-08
**  Key   fingerprint = 1D0C 4B35 9A42 2A05 39CE  7F54 CBCA 6B2D 2D46 6121
**  uid   Josef Grosch (Berkeley, Ca.) <jgrosch@mooseriver.com>
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


public class ValueOutOfRange extends Exception {
    
    /**
     *
     */
    private final static String COPYRIGHT = 
        "Copyright (c) 2009 - 2016 Josef Grosch. All Rights Reserved.";

    /**
     *
     */
    private static final long serialVersionUID = 1963L;

    /**
     *
     */
    public ValueOutOfRange() {
        super();
    }   // End of ValueOutOfRange

    /**
     *
     * @param explanation
     */
    public ValueOutOfRange(String explanation) {
        super(explanation);
    }   // End of ValueOutOfRange
}   // End of ValueOutOfRange class



/**************************************************************************
**
**                      < end of ValueOutOfRange.java >
**
**************************************************************************/
