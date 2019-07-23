#@IgnoreInspection BashAddShebang
!#/bin/bash
#set -x (not recognised by cywin...)

rootPath="/cygdrive/c/Program Files (x86)/Apache Software Foundation/Tomcat 9.0/webapps/ROOT"

if [ ! -d "${rootPath}" ] ; then
  echo "WOOPS, couldn't find the tomcat root dir: $rootPath"
  exit 1
fi

"${rootPath}/../..//bin/shutdown.bat"

cp styles.css "${rootPath}"
cp web.xml "${rootPath}/WEB-INF/"
rm "${rootPath}/WEB-INF/classes/"
mkdir "${rootPath}/WEB-INF/classes/"
cp target/classes/* "${rootPath}/WEB-INF/classes"

${rootPath}/bin/startup.bat

echo "done"
