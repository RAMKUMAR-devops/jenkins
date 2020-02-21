pipeline {
  agent any
  environment {
    AWS_DEFAULT_REGION = "us-east-2"
  }
  stages {

    stage('Clone Terraform Repository') {
      steps {
        git credentialsId: 'GitUser1', url: 'https://github.com/RAMKUMAR-devops/jenkins.git'
      }
    }

    stage('Apply Terraform') {
      steps {
        sh '''
          env
          cd PROJECT/ENV/DEV/vpc
          terraform init
          terraform apply -auto-approve
        '''
      }
    }

  } // stages

  post { 
    success { 
      slackSend color: 'good', message: "Build SUCCESS :: BUILD NO = ${BUILD_NUMBER} :: BUILD URL = ${JOB_URL}"
    }
    failure { 
      slackSend color: 'danger', message: "Build FAILURE :: BUILD NO = ${BUILD_NUMBER} :: BUILD URL = ${JOB_URL}"
    }
  } //post

} // pipeline
