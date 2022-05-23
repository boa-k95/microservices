pipeline {
    environment{
    registry = "boakurtis/springboot-docker-demo"
    dockerImage = ''
    registryCredential ='DockerHubCredentials'
    }
       agent any
    stages {
        stage('Login') {
            steps {
                // Get some code from a GitHub repository
                git url: 'https://github.com/boa-k95/microservices.git', branch: 'env/svil'
            }
        }
        stage('Build APP') {
            steps {
                // Build maven project
                bat "mvn clean install -Dmaven.test.skip=true"
             }
        }

        stage('Tests') {
            agent any
            steps {
                // Build maven project
                bat "mvn test"
                }
        }
            stage('Sonarqube Control') {
              steps {
                withSonarQubeEnv(installationName: 'sonarConfig') {
                bat "mvn clean  package org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar"
                }
              }
            }

 stage('Docker Image Build') {

      steps{
      script {
      dockerImage = docker.build registry + ":$BUILD_NUMBER"
      echo "DOCKER IMAGE CREATED"
       }
    }
    }

 stage('Deploying Docker Image'){
    steps{
     script {
              docker.withRegistry( '', registryCredential ) {
                dockerImage.push()
              }
            }
     }
 }
}
  }