pipeline{

  agent any

  stages{
    stage('Build Jar'){
        steps{
            sh "mvn clean package -DskipTests"
        }
    }

    stage('Build Image'){
        steps{
            sh "docker build -t=aksdet/selenium"

        }
    }
    stage('Push Image'){
        steps{
            sh "docker push aksdet/selenium"
        }

    }

  }


}