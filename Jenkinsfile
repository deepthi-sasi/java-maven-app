def gv

pipeline {
    agent any
    stages {
        stage("test") {
            steps {
                script {
                    echo "tetsing the application"
                    echo "executing pipeline for branch $BRANCH_NAME"
                }
            }
        }
        stage("build") {
            when{
                expression {
                    BRANCH_NAME == "master"
                }
            }
            steps {
                script {
                    echo "building"
                }
            }

        }
        stage("deploy") {
            when{
                expression {
                    BRANCH_NAME == "master"
                }
            }
            steps {
                script {
                    echo "deploying"
                }
            }
        }
    }   
}
