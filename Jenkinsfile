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

    stage {
      steps{
        script{
          print("sleeping for 10 secs")
          sleep(10)
          print(ok)
        }
      }
    }

    stage {
      steps{
        script{
          print("sleeping for 10 secs")
          sleep(10)
          print(ok)
        }
      }
    }

    stage {
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
