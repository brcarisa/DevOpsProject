pipeline {
    agent any

    environment {
        // Определяем переменные окружения
        DOCKER_REGISTRY = 'your-docker-registry.com'
        DOCKER_IMAGE = "${DOCKER_REGISTRY}/your-app:${env.BUILD_NUMBER}"
        K8S_NAMESPACE = 'test-namespace'
    }

    stages {
        stage{
            echo DOCKER_IMAGE
            println("ANTYHYPE")
        }

        stage
    }

    post {
        always {
            // Очистка рабочих файлов и остановка контейнеров после выполнения пайплайна
            cleanWs()
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}