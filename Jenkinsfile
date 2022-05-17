@Library('sharedlib@main')_

pipeline{
  agent any
  environment{
        ok = "testEnv()"
      }
  stages{
    stage('Create PagerDuty Maintenance Window'){
      steps{
        script{
          testEnv()
          testEnv(testString: "string here")
          testEnv(testString: "not a string", region: "us-east-1")
          print(ok)
        }
      }
    }
  }
}
