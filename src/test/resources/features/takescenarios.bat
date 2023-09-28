@echo off
setlocal enabledelayedexpansion

set "searchPattern=Scenario"
set "outputFile=output.txt"

if exist "%outputFile%" del "%outputFile%"

for /r %%f in (*) do (
    set "fileMatched="
    for /f "delims=" %%a in ('findstr /i "%searchPattern%" "%%f"') do (
        set "fileMatched=true"
        set "line=%%a"
        echo Found in "%%~nxf":
        echo !line! >> "%outputFile%"
    )
    if defined fileMatched (
        echo. >> "%outputFile%"
    )
)

echo Extraction completed.
pause
