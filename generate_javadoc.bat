@echo off
set CLASSPATH=lib\AbsoluteLayout.jar;lib\codice-fiscale-java-master.jar;lib\gson-2.8.8.jar;lib\jcalendar-1.4.jar;lib\postgresql-42.7.3.jar;.
javadoc -classpath %CLASSPATH% -d docs -sourcepath src classi climate_monitoring climate_monitoring_SERVER
pause
