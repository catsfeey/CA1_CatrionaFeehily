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
        stage('Exec') {
            steps {
                sh 'mvn spring-boot:run'
            }
        }
    }
}