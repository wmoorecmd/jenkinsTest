def call(Map testMap = [region: "ca-central-1", testString: "this is a test"]){
    String region = ""
    if(testMap.containsKey("testKey")){
        region = testMap.testKey
    }
    withEnv(["AWS_DEFAULT_REGION=${region}"]){
        withCredentials([string(credentialsId: 'SUPER_SECRET', variable: 'THE_SECRET')]){
            sh 'echo $THE_SECRET'
            sh 'echo $AWS_DEFAULT_REGION'
            sh "echo ${testMap.testString}"
        }
    }
}
