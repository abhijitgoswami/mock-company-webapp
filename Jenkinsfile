pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // TODO: Add the Gradle build command
                    sh './gradlew assemble'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // TODO: Add the Gradle test command
                    sh './gradlew test'
                }
            }
        }
    }
}