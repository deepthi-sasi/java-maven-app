#!/user/bin/env groovy
import org.apache.tomcat.jni.Library

library identifier: 'jenkins-shared-library@main', retriever: modernSCM(
        [$class: 'GitSCMSource',
         remote: 'https://github.com/deepthi-sasi/jenkins-shared-library.git',
         credentialsId:'ba7d5282-250d-4453-8267-b1a5fb20dbad' ])

def gv
pipeline {
    agent any
    tools {
        maven 'maven3.9'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("Build Jar") {
            steps {
                script {
                    buildJar()
                }
            }
        }

        stage("Build and push the image") {
            steps {
                script {

                    buildImage 'deepthisasi/demo-app:jma2.4'
                    dockerLogin()
                    dockerImagePush 'deepthisasi/demo-app:jma2.4'
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
