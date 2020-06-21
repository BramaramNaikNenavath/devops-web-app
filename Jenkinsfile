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