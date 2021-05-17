job('First DSL Job') {
    scm {
        git('git://github.com/chintala-dev/jenkins-samples.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Git User')
            node / gitConfigEmail('user@user.com')
        }
    }
    steps {
        shell("Hello Wrold")
    }
}
