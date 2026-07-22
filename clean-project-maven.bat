@echo off
setlocal enabledelayedexpansion

REM ============================================================
REM  jobApply_Naukri
REM    1. delete "target" + clear resources screenshot folder
REM    2. run the Maven project
REM ============================================================

set "PROJECT_DIR=C:\Users\shiva\Maven\jobApply_Naukri"
set "MAVEN_HOME=C:\Users\shiva\Maven\apache-maven-3.9.16"
set "MVN_GOALS=test"

set "PATH=%MAVEN_HOME%\bin;%PATH%"

cd /d "%PROJECT_DIR%" 2>nul
if errorlevel 1 (
    echo [ERROR] Cannot open "%PROJECT_DIR%" - check PROJECT_DIR above.
    pause
    exit /b 1
)
if not exist "pom.xml" (
    echo [ERROR] No pom.xml in "%CD%" - not a Maven project root.
    pause
    exit /b 1
)

echo ============================================================
echo  STEP 1 - CLEAN
echo ============================================================

if exist "target\" (
    rd /s /q "target" 2>nul
    if exist "target\" (
        echo   [FAILED] target locked - close the IDE / stop java.exe
    ) else (
        echo   [OK] target deleted
    )
) else (
    echo   [SKIP] no target folder
)

set "COUNT=0"
for /d /r "%CD%\src" %%D in (screenshot screenshots) do (
    if exist "%%D\" (
        set /a COUNT+=1
        for /d %%S in ("%%D\*") do rd /s /q "%%S" 2>nul
        del /f /q /a "%%D\*" 2>nul
        echo   [OK] emptied %%D
    )
)
if "!COUNT!"=="0" echo   [SKIP] no screenshot folder under src

echo.
echo ============================================================
echo  STEP 2 - RUN MAVEN
echo ============================================================

if not exist "%MAVEN_HOME%\bin\mvn.cmd" (
    echo [ERROR] mvn.cmd not found in "%MAVEN_HOME%\bin"
    pause
    exit /b 1
)
if not defined JAVA_HOME echo [WARN] JAVA_HOME not set - Maven may fail.

echo Running: mvn %MVN_GOALS%
echo.
call mvn %MVN_GOALS%
set "RESULT=%ERRORLEVEL%"

echo.
echo ============================================================
if "%RESULT%"=="0" (
    echo   BUILD OK - tests finished
) else (
    echo   BUILD FAILED - exit code %RESULT%, scroll up for details
)
echo ============================================================
pause
