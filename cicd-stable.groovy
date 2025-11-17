node('linux') {
  stage ('Poll') {
    checkout([
      $class: 'GitSCM', branches: [[name: '*/main']], extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/liboqsport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [
      string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/liboqsport.git'),
      string(name: 'PORT_DESCRIPTION', value: 'a collection of open source implementations of quantum-safe key encapsulation mechanisms (KEMs) and digital signature algorithms'),
      string(name: 'BUILD_LINE', value: 'STABLE')
    ]
  }
}
