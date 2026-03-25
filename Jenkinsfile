def gv
pipeline {
    agent any
    tools {
        maven 'maven3.9'
    }
    stages {
        stage("Init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("Build Jar") {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }

        stage("building the image ") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }


        stage("Deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }

}
