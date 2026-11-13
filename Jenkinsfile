pipeline {
    agent any
tools {
    maven 'maven10'
    jdk 'java25'
}
    stages {
        stage('Compile') {
            steps {
                sh 'java -version; mvn -version'
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
