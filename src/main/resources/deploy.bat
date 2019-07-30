net stop Tomcat9
xcopy "C:\Users\tamara.michaud\IdeaProjects\javaservletstrainings\target\java-servlets-trainings-1.0.war" "%CATALINA_HOME%\webapps\"
net start Tomcat9