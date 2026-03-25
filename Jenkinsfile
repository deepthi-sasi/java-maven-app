def gv
pipeline {
    agent any
    tools{
        maven 'maven-3.9'
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
            input{
                message "Select the environment to deploy to"
                ok "Done"
                parameters{
                    choice(name: 'ENV', choices: ['dev', 'staging', 'prod'], description: '')
                }
            }
            steps {
                script {
                    gv.deployApp()
                    echo "deploying to ${ENV}"

                }
            }
        }
    }

}
