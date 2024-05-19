#!/usr/bin/env python3

import os, sys
import json
import argparse

def main():
    argv = sys.argv
    argc = len(argv)

    toolName = argv[0].strip()
    if toolName.startswith('./'):
        toolName = toolName.replace('./', '')
        
    parser = argparse.ArgumentParser()

    parser.add_argument('--year', help='Process year',
                        required=True)

    args = parser.parse_args()

    year = int(args.year)
    if year < 1966 or year > 1995:
        print("Error: year must be between 1965 and 1995")
        sys.exit(1)
        
    dataDir = '../Data/SetLists/byYear'
    year = str(year)
    yearFile = f"{dataDir}/{year}.json"

    if not os.path.exists(yearFile):
        print("Error: {yearFile} NOT found")
        sys.exit(1)
        
    with open(yearFile, 'r') as fh:
        Lines = fh.read()

    jObj = json.loads(Lines)
    Shows = jObj['db_rest']['fetchArtistYear']['shows']

    for key in Shows:
        show = Shows[key]
        #bandName      = show['name']
        #artistKey     = show['artist_key']
        #showKey       = show['shows_key']
        #showDate      = show['showdate']
        venue         = show['venue']
        city          = show['city']
        stateAbbrev   = show['state_abbrev']
        #countryAbbrev = show['country_abbrev']

        #set1          = show['set1']
        #if isinstance(set1, list):
        #    set1 = ', '.join(set1)

        #set2          = show['set2']
        #set3          = show['set3']
        #comment       = show['comment']
        #lastUpdate    = show['lastupdate']
        #showyear      = show['showyear']
        #verifiedBy    = show['verified_by']
        #verifySource  = show['verify_source']
        #shnids        = show['shnids']
        #showUserId    = show['showsuserid']
        
        print(f"Venue: {venue}, {city}, {stateAbbrev}")
        
        j = 0

    i = 0
    
    sys.exit(0)
    #
    # End of main
    #

if __name__ == '__main__':
    main()
    
