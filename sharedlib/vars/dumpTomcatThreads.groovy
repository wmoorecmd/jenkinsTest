/*
 *  Dumps the the contents of the tomcat thread
 *
 *  Arguments
 *  samples: the number of times to dump the threads (optional: defaults to 3)
 *  logFile: the path to the tomcat log output (optional: defaults to /var/log/tomcat/catalina.out)
 *  output: the name of the output zipfile (optional: default to the name of the first thread dump)
 */

Boolean call(Map dumpTomcatArgs){
    int samples = 0
    String logfile = ""
    String output = ""
    String extras = ""

    if(dumpTomcatArgs.containsKey("samples") && dumpTomcatArgs.samples != 3) {
        samples = dumpTomcatArgs.samples
        extras += "samples=\"-n ${samples}\""
    }

    if(dumpTomcatArgs.containsKey("logfile")) {
        logfile = dumpTomcatArgs.logfile
        extras += " logfile=\"-l ${logfile}\""
    }
    //there will be an issue with having no output value passed in: what to do about this?
    //There is a way to do it in ansible
    if(dumpTomcatArgs.containsKey("output")) {
        output = dumpTomcatArgs.output
        extras += " output=\"-o ${output}\""
    }
    //add e flag, quotes
    extras = "-e '${extras}'"

    //run ansible
    ansiblePlaybook(
            playbook: 'task-dump-tomcat-threads.yml',
            extras: extras
    )
    
    return true
}