net stop Tomcat9
xcopy "C:\Users\Rayne\IdeaProjects\servlets-trainings\target\java-servlets-trainings-1.0.war" "%CATALINA_HOME%\webapps\"
net start Tomcat9