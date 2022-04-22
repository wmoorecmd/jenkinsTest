@Library('sharedlib@main')_

pipeline{
  agent any
  stages{
    stage('Create PagerDuty Maintenance Window'){
      environment{
        ok = testEnv()
      }

      steps{
        script{
          print(ok)
        }
      }
    }
  }
}
