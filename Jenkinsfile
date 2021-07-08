def params

pipeline {
    agent any
    stages {
        stage('Load Parameters') {
            steps {
                script{
                    checkout scm
                    params = load "Parameters.jenkinsfile"
                    params.setJobName(env.JOB_NAME)
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
    }
}