pipeline {
    agent any
    stages {
        stage('Packaging Devops DAO module and Webapp') {
            steps{
                build job: 'Package Devops DAO'
 
            }
            post {
                success {
                    echo "Packaging Devops DAO module and Webapp ..."
                }
            }
        }
        
       stage("build & SonarQube analysis") {
           def mvnHome = tool name : 'localMaven', type : 'maven'
         withSonarQubeEnv('SonarQube') {
                  sh '${mvnHome}/bin/mvn sonar:sonar'
              } 
      }
      
      stage("Quality Gate"){
          timeout(time: 1, unit: 'HOURS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
      }
        
        stage('Deploy in Staging Environment'){
            steps{
                build job: 'Deploy Application to STAGING'
 
            }
            
        }
        stage('Deploy to Production'){
            steps{
                timeout(time:5, unit:'DAYS'){
                    input message:'Approve PRODUCTION Deployment?'
                }
                build job: 'Deploy Application to PROD'
            }
        }
    }
}
