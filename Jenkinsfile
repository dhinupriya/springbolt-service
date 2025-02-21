pipeline {
    agent any
    environment {
        DOCKER_IMAGE = "dhinu1127/springbolt_myapp"
    }
    tools {
        maven 'Maven3'
    }
    stages {
        stage('Checkout') {
            steps {
               git branch: 'main', url: 'https://github.com/dhinupriya/springbolt-service.git'
            }
        }
        stage('Build with Maven') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {  // ✅ Moved outside correctly
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }
        stage('Login to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                sh 'docker push $DOCKER_IMAGE'
            }
        }
        stage('Clean up Docker') {
            steps {
                sh 'docker rmi $DOCKER_IMAGE'
            }
        }
    } // ✅ Closing 'stages' block
} // ✅ Closing 'pipeline' block
