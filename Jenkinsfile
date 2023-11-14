pipeline {
    agent any

    stages {
        stage('GetProject') {
            steps {
                git 'https://github.com/catsfeey/CA1_CatrionaFeehily.git'
            }
        }
        stage('build') {
            steps {
                //Run Maven on an agent on Linux Machine with Maven installed.
                sh 'mvn clean:clean'
                sh 'mvn dependency:copy-dependencies'
                sh 'mvn compiler:compile'
            }
        }
        stage('Package'){
            steps{
                sh 'mvn package'
            }
        }
        stage ('Archive'){
            steps{
                archiveArtifacts (allowEmptyArchive: true, artifacts: 'target/catrionaspetitions.war')
            }
        }
        stage('Deploy'){
            steps{
                sh 'docker build -f Dockerfile -t CA1app . '
            }
        }
    }
}