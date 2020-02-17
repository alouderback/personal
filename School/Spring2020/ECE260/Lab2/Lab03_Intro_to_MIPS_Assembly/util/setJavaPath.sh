#!/bin/bash -e
#
# call using source and ditch the output: 
#  source ./setJavaPath.sh >/dev/null 2>/dev/null
#
export JAVAHOME=$(cygpath -au "$(./findJava.bat)")
