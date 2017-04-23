# MavenMultiModuleTask
# Apache Maven multi-module task

–	Build multi-module Java application consisting of

    •	service client module

    •	service implementation module

    •	service war module

 Note: you can use application implemented during Web Services training.
In some causes there is a sense to decouple service API module and share it between client and service modules (not required).
–	Integrate dependencyManagement section to parent POM and share common used artifacts.

–	Define dependency exclusions where it can be suitable.

–	Store all versions of artifacts in properties.

–	Integrate 

    •	Maven Checkstyle plugin (phase – compile, goal check)
  
    •	Maven PMD plugin
  
–	Integrate 2 profiles

    •	dev-build - active by default

    •	test-build – must include execution of report-plugins
  
–	Provide *.bat files for

    •	invocation of build with profiles
  
    •	invocation of PMD plugin
  
Make sure that plugins generate reports.
