def gv
pipeline {
    agent any
    tools {
        maven 'maven3.9'
    }
    stages {
        stage("Build Jar") {
            steps {
                script {
                    echo "building the application.."
                    sh 'mvn package'
                }
            }
        }

        stage("building the image ") {
            steps {
                script {
                    echo "building the docker image.."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')])
                        sh 'docker build -t deepthisasi/demo-app:jma-2.0'
                        sh 'docker login -u $USER --password-stdin'
                        sh 'docker push deepthisasi/demo-app:jma-2.0'
                }
            }
        }

        stage("Deploy") {
            steps {
                script {
                    echo "deploying the app"

                }
            }
        }
    }

}
