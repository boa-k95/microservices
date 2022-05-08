pipeline {
    agent any
    stages {
        stage('Login') {
            steps {
                // Get some code from a GitHub repository
                git url: 'https://github.com/boa-k95/microservices.git', branch: 'env/svil'
            }
        }
        stage('Build') {
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
        stage('Docker Build') {
      steps {
       echo 'hello World'
      }
    }
    }
}