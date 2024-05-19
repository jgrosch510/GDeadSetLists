#!/usr/bin/bash

set -x

BASE_DIR="/usr3/home/jgrosch/Git/GDeadSetLists/Data/SetLists/byYear"

HERE=$PWD

FILES="1966  1967  1968  1969  1970  
       1971  1972  1973  1974  1975  
       1976  1977  1978  1979  1980  
       1981  1982  1983  1984  1985  
       1986  1987  1988	 1989  1990  
       1991  1992  1993  1994  1995"

#cd $BASE_DIR
for f in $FILES
do
    #${HERE}/loadGdData.py --year ${f} | sort | uniq > venue.${f}.txt
    ${HERE}/loadGdData.py --year ${f} | sort | uniq >> venue.txt
done

