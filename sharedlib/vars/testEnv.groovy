def call(Map testMap){
    String region = "ca-central-1"
    String testString = "this is a default"

    if(testMap.containsKey('region')){
        region = testMap.region
    }

    if(testMap.containsKey('testString')){
        testString = testMap.testString
    }

    withEnv(["AWS_DEFAULT_REGION=${region}"]){
        withCredentials([string(credentialsId: 'SUPER_SECRET', variable: 'THE_SECRET')]){
            sh 'echo $THE_SECRET'
            sh 'echo $AWS_DEFAULT_REGION'
            sh "echo ${testString}"
        }
    }
}
