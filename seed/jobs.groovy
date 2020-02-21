
// Terraform Folder
folder('Terraform') {
    displayName('Terraform')
    description('Folder for Terraform Jobs')
}

folder('Terraform/ENV') {
    displayName('ENV')
    description('Folder for Terraform Jobs for ENV')
}

folder('Terraform/ENV/DEV') {
    displayName('DEV')
    description('Folder for Terraform Jobs for DEV ENV')
}

pipelineJob('Terraform/ENV/DEV/VPC') {
    configure { flowdefinition ->
        flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
            'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://github.com/RAMKUMAR-devops/jenkins.git')
                        'credentialsId'('GitUser1')
                    }
                }
                'branches' {
                    'hudson.plugins.git.BranchSpec' {
                        'name'('*/master')
                    }
                }
            }
            'scriptPath'('pipeline-jobs/terraform/env/dev/vpc.Jenkinsfile')
            'lightweight'(true)
        }
    }
}


