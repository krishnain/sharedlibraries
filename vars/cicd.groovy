def newGit(repo)
{
  git "${repo}" 
}
def newMaven()
{
   sh 'mvn package'
}
def newDeploy(ip,appname)
{
  sh "scp /home/ubuntu/.jenkins/workspace/DeclarativePipeline/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat9/webapps/${appname}.war"
}
def runSelenium(path)
{
  sh "java -jar ${path}/testing.jar"
}
def newApprovals(name)
{
  input message: 'Waiting for approvals!', submitter: "${name}" 
}





