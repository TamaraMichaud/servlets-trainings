REM # net stop Tomcat9
REM # xcopy "C:\Users\Rayne\IdeaProjects\servlets-trainings\target\java-servlets-trainings-1.0.war" "%CATALINA_HOME%\webapps\"
REM # net start Tomcat9


C:\Users\tamara.michaud\apache-tomcat-8.5.43\bin\shutdown.bat
xcopy "C:\Users\tamara.michaud\IdeaProjects\javaservletstrainings\target\java-servlets-trainings-1.0.war" "%CATALINA_HOME%\webapps\"
REM # xcopy "C:\Users\Rayne\IdeaProjects\servlets-trainings\target\java-servlets-trainings-1.0.war" "%CATALINA_HOME%\webapps\"
C:\Users\tamara.michaud\apache-tomcat-8.5.43\bin\startup.bat