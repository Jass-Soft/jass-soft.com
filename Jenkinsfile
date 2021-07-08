def params

node('master') {
    stage('Choose') {
            params = load "lib/Parameters.groovy"
            params.setJobName(env.JOB_NAME)
    }
}

pipeline {
    agent any
    stages {
        stage('Load Parameters') {
            steps {
                script{
                    checkout scm
                    
                    vaultName = params.getVaultName()
                    properties([
                        parameters([
                        booleanParam(name: 'ONLY_DRY_RUN', defaultValue: true, description: 'If checked no deployment is perfomed only conneciton is checked'),
                        choice(name: 'DEPLOY_ENVS', choices: params.getEnvironmentType(), description: 'Environment type to deploy to'),
                        choice(choices: params.getEnvironments(), description: 'Environment to deploy', name: 'ENV'),
                        string(name: 'VERSION', description: 'Version to install'),
                        string(name: 'EMAIL_LIST', defaultValue: 'abc@abc.com', description: 'Deployment success / failure email notification')
                        ])
                    ])
                }
            }
        }
        stage('Test Parameters') {
            steps {
                echo vaultName
            }
        }
    }
}