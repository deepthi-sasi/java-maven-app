##### Build the project and publishing to Nexus

To build run `mvn package` which creates a jar under `target`.

To publish the build run `mvn deploy`.

Publishing uses the maven-publish plugin which uses the artifact found under target where the version is defined above in the pom.xml file

To publish the artifacts you need to set the credentials in settings.xml under User's .m2 directory(Nexus is running in DigitalOcean). 
