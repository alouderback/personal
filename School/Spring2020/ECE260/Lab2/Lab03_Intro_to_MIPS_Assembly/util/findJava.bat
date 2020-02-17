@echo off

setlocal

::- newer versions of the JDK have different registry location
set KEY_OLD="HKLM\SOFTWARE\JavaSoft\Java Development Kit"
set KEY_NEW="HKLM\SOFTWARE\JavaSoft\JDK"
set KEY=""

reg query %KEY_OLD% >nul 2>&1
if %errorlevel% equ 0 (
    set KEY=%KEY_OLD%
)
reg query %KEY_NEW% >nul 2>&1
if %errorlevel% equ 0 (
    set KEY=%KEY_NEW%
)

::- Get the JDK Version
set VALUE=CurrentVersion
reg query %KEY% /v %VALUE% >nul 2>&1 || (
    echo JDK not installed 
    exit /b 1
)
set JDK_VERSION=
for /f "tokens=2,*" %%a in ('reg query %KEY% /v %VALUE% ^| findstr %VALUE%') do (
    set JDK_VERSION=%%b
)

::- echo KEY: %KEY%
::- echo JDK VERSION: %JDK_VERSION%

set KEY="%KEY:"=%\%JDK_VERSION:"=%"
::- echo KEY: %KEY%
set VALUE=JavaHome
reg query %KEY% /v %VALUE% >nul 2>&1 || (
    echo JavaHome not installed
    exit /b 1
)

set JAVAHOME=
for /f "tokens=2,*" %%a in ('reg query %KEY% /v %VALUE% ^| findstr %VALUE%') do (
    set JAVAHOME=%%b
)

::- echo JavaHome: %JAVAHOME%

endlocal & (
    set JAVAHOME=%JAVAHOME%
)

echo|set /p=%JAVAHOME%
