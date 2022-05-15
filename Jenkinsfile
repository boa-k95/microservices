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
         stages {
            stage('Scan') {
              steps {
                withSonarQubeEnv(installationName: 'jenkins-sonarqubeToken') {
                  sh './mvnw clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
                }
              }
            }
        stage('Docker Build') {
      steps {
       echo 'hello World'
      }
    }
    }
}