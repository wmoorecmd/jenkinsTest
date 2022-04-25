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

    stage("Second Stage"){
      steps{
        script{
          input(message: "Proceed or abort?")
          print(ok)
        }
      }
    }

    stage("Third Stage") {
      steps{
        script{
          input(message: "Proceed or abort?")
          print(ok)
        }
      }
    }

    stage("Fourth Stage") {
      steps{
        script{
          input(message: "Proceed or abort?")
          print(ok)
        }
      }
    }
  }
}
