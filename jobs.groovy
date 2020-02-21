pipelineJob('example') {
    configure { flowdefinition ->
        flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
            'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://gitlab.com/d44/jenkins.git')
                        'credentialsId'('GitUSer')
                    }
                }
                'branches' {
                    'hudson.plugins.git.BranchSpec' {
                        'name'('*/master')
                    }
                }
            }
            'scriptPath'('pipeline-jobs/sample.Jenkinsfile')
            'lightweight'(true)
        }
    }
}
