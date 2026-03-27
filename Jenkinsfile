#!/user/bin/env groovy
import org.apache.tomcat.jni.Library

@Library('jenkins-shared-library')

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

        stage("building the image ") {
            steps {
                script {
                    buildImage'deepthisasi/demo-app:jma2.3'
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
