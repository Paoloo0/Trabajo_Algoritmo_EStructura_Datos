@echo off
title Sistema Minimarket El Ahorro
cd /d "%~dp0"
echo ===================================================
echo     MINIMARKET EL AHORRO - SISTEMA DE CAJA
echo ===================================================
echo Iniciando aplicacion con Java...
if exist "C:\Program Files\Apache NetBeans\jdk\bin\java.exe" (
    "C:\Program Files\Apache NetBeans\jdk\bin\java.exe" -Dfile.encoding=UTF-8 -cp "build\classes" Modelo.Main
) else (
    java -Dfile.encoding=UTF-8 -cp "build\classes" Modelo.Main
)
pause
