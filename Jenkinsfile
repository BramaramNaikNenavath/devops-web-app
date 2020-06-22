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
        stage('build & SonarQube Scan') {
			steps{
				withSonarQubeEnv('My SonarQube Server') {
  					build job: 'Devops Webapp Sonar build'
				} // SonarQube taskId is automatically attached to the pipeline context
			}
  		}
 
		// No need to occupy a node
		stage("Quality Gate") {
  			steps{
  				timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
	    			def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
	    			if (qg.status != 'OK') {
	      				error "Pipeline aborted due to quality gate failure: ${qg.status}"
	    			}
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