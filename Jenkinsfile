pipeline {
    agent any

    stages {

        stage('Checkout') {
    steps {
        git branch: 'main', url: 'https://github.com/ArunprasathGit/JenkinSecondAppProject.git'
    }
}

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Install') {
            steps {
                bat 'mvn clean install'
            }
        }
    }
}