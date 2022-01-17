pipeline{
  agent any
  stages{
    stage("Create PagerDuty Maintenance Window"){
      steps{
        sh "echo Before Ansible"
        ansiColor('xterm'){
          ansiblePlaybook(
            playbook: 'task-pagerduty-maintenance.yml'
          )
        }
      }
    }
  }
}
