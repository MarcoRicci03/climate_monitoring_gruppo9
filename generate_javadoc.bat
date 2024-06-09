@echo off
set CLASSPATH=lib\AbsoluteLayout.jar;lib\codice-fiscale-java-master.jar;lib\gson-2.8.8.jar;lib\jcalendar-1.4.jar;lib\postgresql-42.7.3.jar;.
javadoc -d javadoc -sourcepath .\classi\src\main\java;.\client\src\main\java;.\server\src\main\java -classpath .\libs\* -subpackages classi:org.climate_monitoring_CLIENT:org.climate_monitoring_SERVER
pause
