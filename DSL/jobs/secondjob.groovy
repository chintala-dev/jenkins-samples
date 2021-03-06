job('Second DSL Job') {
    scm {
        git('git://github.com/wardviaene/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
//    triggers {
//        scm('H/5 * * * *')
//    }
    steps {
        remoteShell('appadmin@10.200.1.4:22') {
            command('hostname')
            command('ls -lart ansible_projects')
            command(readFileFromWorkspace('DSL/jobs/secondjob.sh'))
        }
    }
}
