def call(){
    withEnv(['AWS_DEFAULT_REGION=ca-central-1']){
        withCredentials([string(credentialsId: 'SUPER_SECRET', variable: 'THE_SECRET')]){
            sh 'echo $THE_SECRET'
            sh 'echo $AWS_DEFAULT_REGION'
        }
    }
}
