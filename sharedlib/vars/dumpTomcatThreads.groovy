/*
 *  Dumps the the contents of the tomcat thread
 *
 *  Arguments
 *  hostname: the host to run 
 */

Boolean call(Map dumpTomcatArgs){
    String hostname = ""
    String extras = ""

    if(dumpTomcatArgs.containsKey("hostname")) hostname = dumpTomcatArgs.hostname

    //run ansible
    ansiblePlaybook(
            playbook: 'task-dump-tomcat-threads.yml',
            inventory: "${hostname},"
    )
    
    return true
}