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
        stage('Deploy - Approve to Proceed') {
            steps {
            // Create an Approval Button with a timeout of 15minutes.
                 timeout(time: 15, unit: "MINUTES") {
                 input message: 'Do you want to approve the deployment?', ok: 'Yes'
                }
            }
        }

        stage('Deploy'){
            steps{
                sh 'docker build -f Dockerfile -t catsapp . '
                sh 'docker rm -f "catsappcontainer" || true'
                sh 'sudo docker run --name "catsappcontainer" -p 9090:8080 --detach catsapp:latest'
                //sh 'sudo docker build -f Dockerfile -t catsapp . '
            }
        }
    }
}