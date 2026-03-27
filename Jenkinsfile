#!/user/bin/env groovy
import org.apache.tomcat.jni.Library

@Library('jenkins-shared-library')

def gv
pipeline {
    agent any
    tools {
        maven 'maven3.9'
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
                    buildImage()
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
