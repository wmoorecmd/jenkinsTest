@Library('sharedlib@main')_

pipeline{
  agent any
  environment{
        ok = testEnv()
      }
  stages{
    stage('Create PagerDuty Maintenance Window'){
      steps{
        script{
          print(ok)
        }
      }
    }

    stage("Second Stage"){
      steps{
        script{
          print("sleeping for 10 secs")
          sleep(10)
          print(ok)
        }
      }
    }

    stage("Third Stage") {
      steps{
        script{
          print("sleeping for 10 secs")
          sleep(10)
          print(ok)
        }
      }
    }

    stage("Fourth Stage") {
      steps{
        script{
          print("sleeping for 10 secs")
          sleep(10)
          print(ok)
        }
      }
    }
  }
}
