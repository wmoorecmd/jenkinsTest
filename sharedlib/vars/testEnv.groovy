def call(){
    withCredentials([string(credentialsId: 'SUPER_SECRET', variable: 'THE_SECRET')]){
        sh 'echo $THE_SECRET'
    }
}
