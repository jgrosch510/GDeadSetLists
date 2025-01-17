#!/usr/bin/env python3

import os, sys
import json

def main():
    baseDir  = '/usr3/home/jgrosch/Git/GDeadSetLists/Data/Study'
    fileName = '1969.json'
    inFile = f"{baseDir}/{fileName}"

    with open(inFile, 'r') as fh:
        xLines = fh.read()

    SL = json.loads(xLines)
    Shows = SL['db_rest']['fetchArtistYear']['shows']

    for key in Shows:
        setDone = False
        show = Shows[key]
        
        set1 = show['set1']
        set2 = show['set2']
        set3 = show['set3']

        set1Len = len(set1)
        set2Len = len(set2)
        set3Len = len(set3)

        if set1Len == 0 and set2Len == 0 and set3Len == 0:
            continue

        if set1Len > 0 and isinstance(set1, list):
            setDone = True

        if set2Len > 0 and isinstance(set2, list):
            setDone = True

        if set3Len > 0 and isinstance(set3, list):
            setDone = True

        if setDone:
            continue

        if set1Len > 0 and isinstance(set1, str):
            set1 = splitLine(set1)
            i = 0

        if set2Len > 0 and isinstance(set2, str):
            set2 = splitLine(set2)
            i = 0

        if set3Len > 0 and isinstance(set3, str):
            set3 = splitLine(set3)
            i = 0
        
        j = 0
        
    i = 0

    sys.exit(0)
    # End of main

def splitLine(setStr):
    outArray = []
    
    tmpStr = setStr.strip()
    tmpStr = tmpStr.replace('\r\n', '\n')
    tmpStr = tmpStr.replace('&gt;', '>')
    
    Bits = tmpStr.split(',')
    if len(Bits) == 1:
        Bits = tmpStr.split('\n')
        if len(Bits) == 1:
            # no \n found
            Bits = tmpStr.split('>')
            if len(Bits) > 1:
                for bit in Bits:
                    bit = bit.strip()
                    bit = f"{bit} ->"
                    BP = 0
            else:
                BP = 0
        else:
            # \n found
            BP = 0
            for bit in Bits:
                tmpBit = bit.strip()
                if '>' in tmpBit:
                    Bits2 = tmpBit.split('>')
                    Bits2Len = len(Bits2)
                    Bits2Len = Bits2Len - 1
                    firstTime = True
                    for bits2 in Bits2:
                        if firstTime:
                            index = 0
                            firstTime = False
                        bits2 = bits2.strip()
                        if index == Bits2Len:
                            outArray.append(bits2)
                        else:
                            bits2 = f"{bits2} ->"
                            outArray.append(bits2)
                        index = index + 1
                        BP = 0
                    BP = 0
                else:
                    tmpBit = tmpBit.strip()
                    outArray.append(tmpBit)
                    BP = 0
                # End of if/else
            BP = 0
            # End of for loop
    else:
        BP = 0
        for count, value in enumerate(Bits):
            value = value.strip()

            if len(value) == 0:
                del Bits[count]
                continue

            if '->' in value:
                BP = 0
                Bits2 = value.split('->')

            if '>' in value:
                BP = 0
                Bits2 = value.split('>')
                
            Bits[count] = value
            
        outArray = Bits
        BP = 0
    BP = 0

    for count, value in enumerate(outArray):
        if len(value) == 0:
            del outArray[count]
        
    return outArray
    # End of splitLine
    
if __name__ == '__main__':
    main()
