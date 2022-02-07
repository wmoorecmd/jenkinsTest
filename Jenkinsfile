@Library('sharedlib@main')_

pipeline{
  agent any
  options{
    // skipDefaultCheckout(true)
  }
  stages{
    stage('Create PagerDuty Maintenance Window'){
      environment{
        PAGERDUTY_API_KEY = credentials("PAGERDUTY_API_KEY")
      }

      steps{
        //clean before build
        // cleanWs()
        script{
          ok = createPagerDutyMaintenance(
            token: '$PAGERDUTY_API_KEY',
            env: 'dev',
            desc: "Test Description right here"
          )
          if(!ok){
            error("Failed to create PagerDuty maintenance window")
          }
        }
      }
    }
  }
}
