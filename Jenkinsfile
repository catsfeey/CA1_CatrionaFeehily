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

        stage('Deploy - Approve to Proceed') {
            steps {
            // Create an Approval Button with a timeout of 15minutes.
            	  timeout(time: 15, unit: "MINUTES") {
            	  input message: 'Do you want to approve the deployment?', ok: 'Yes'
                }
            }
        }

        stage('Exec') {
            steps {
                sh 'mvn spring-boot:run'
            }
        }

    }
}