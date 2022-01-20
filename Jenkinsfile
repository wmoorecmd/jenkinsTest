@Library('sharedlib@main')_

pipeline{
  agent any
  stages{
    stage('Create PagerDuty Maintenance Window'){
      environment{
        PAGERDUTY_API_KEY = credentials("PAGERDUTY_API_KEY")
      }

      steps{
        script{
          result = createPagerDutyMaintenance(
            token: '$PAGERDUTY_API_KEY',
            minutes: 23,
            hours: 3,
            desc: "Test Description right here"
          )
          if(result){
            error("Failed to create PagerDuty maintenance window")
          }
        }
      }
    }
  }
}
