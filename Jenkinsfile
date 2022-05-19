pipeline {
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
            stage('Sonarqube Anaylsis Control') {
              steps {
                withSonarQubeEnv(installationName: 'sonarConfig') {
                bat "mvn clean  package org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar"
                }
              }
            }
             stage("Quality Gate"){
               steps{
                      timeout(time: 1, unit: 'HOURS') {
                          def qg = waitForQualityGate()
                          if (qg.status != 'OK') {
                              error "Pipeline aborted due to quality gate failure: ${qg.status}"
                          }
                      }
                  }
            }
        stage('Docker Image Build') {
      steps {
       echo 'hello World'
      }
    }
    }
}