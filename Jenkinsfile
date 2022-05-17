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
          testEnv("string here")
          testEnv("not a string", region: "us-east-1")
          print(ok)
        }
      }
    }
  }
}
