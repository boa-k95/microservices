pipeline {
    agent any
    enviornment{
    registry = "YourDockerhubAccount/YourRepository"
    registryCredential = ''
    dockerImage = ''
    }
    stages {
        stage('Login') {
            steps {
                // Get some code from a GitHub repository
                git url: 'https://github.com/boa-k95/microservices.git', branch: 'env/svil'
            }
        }
        stage("CheckOut"){
          steps{
                    checkout scm
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
      }
    }
    }
}