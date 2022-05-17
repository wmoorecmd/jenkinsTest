def call(){
    withEnv(['THE_ENV_VAR=thisisavariable']){
        withCredentials([string(credentialsId: 'SUPER_SECRET', variable: 'THE_SECRET')]){
            sh 'echo $THE_SECRET'
            sh 'echo $THE_ENV_VAR'
        }
    }
}
