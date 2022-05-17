def call(Map testMap = [:]){
    if(!testMap.containsKey('region')){
        testMap.region = 'ca-central-1'
    }
    if(!testMap.containsKey('testString')){
        testMap.testString = 'this is a default'
    }
    withEnv(["AWS_DEFAULT_REGION=${testMap.region}"]){
        withCredentials([string(credentialsId: 'SUPER_SECRET', variable: 'THE_SECRET')]){
            sh 'echo $THE_SECRET'
            sh 'echo $AWS_DEFAULT_REGION'
            sh "echo ${testMap.testString}"
        }
    }
}
