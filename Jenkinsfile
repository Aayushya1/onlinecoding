pipeline {
    environment {
        registry = "abvroot/devopscalculator"
        registryCredential = 'docker-hub'
    }
  agent any
  options {
      skipDefaultCheckout(true)
  }
  stages {
    stage('Clone GIT Repository') {
          steps{
                logstash{
                    git 'https://github.com/Aayushya1/devopscalculator.git'
                }
          }
    }
    stage('Clean') {
        steps{
            logstash{
             sh 'mvn clean'
             echo "clean"
             }
        }
    }

    stage('Compile') {
        steps{
            logstash{
             sh 'mvn package'
             echo "compile"
             }
        }
    }
    stage('Test') {
        steps{
            logstash {
           sh 'mvn test'
           echo "test"
           }
        }
    }

    stage('Deploy Image to Docker Hub') {
        steps{
            logstash{
            script{

               dockerImage = docker.build registry + ":spe"
               docker.withRegistry( '', registryCredential){
                   dockerImage.push()
               }
            }
            }
        }
    }
    stage('Execute Rundeck job') {
             steps {
             logstash{
               script {
                 step([$class: "RundeckNotifier",
                       includeRundeckLogs: true,
                       jobId: "eff9b87e-a8c7-4feb-8031-4f2222f5522f",
                       rundeckInstance: "rundeck",
                       shouldFailTheBuild: true,
                       shouldWaitForRundeckJob: true,
                       tailLog: true])
               }
               }
             }
    }

  }
}