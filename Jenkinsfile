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
          ok = testEnv()
          print(ok)
        }
      }
    }
  }
}
