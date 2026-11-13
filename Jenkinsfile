pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                sh 'mvn -B -DskipTests compile'
            }
        }
        stage('Unit Tests') {
            steps {
                sh 'mvn -B test'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn -B -DskipTests package'
                archiveArtifacts artifacts: 'target/*.war', fingerprint: true
            }
        }
    }
}
