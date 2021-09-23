# commercial-flights-information-manager

This project is a web application which allows us to manage information about commercial flights.

As a user you can log in into the application and choose to see the flights from the curent date on a certain airport or airline.
You can also see informations about a certain airport or airline by checking the airport/airline profile page.

As an admin if you login into the application, you have acces to the dashboard page. There you see all flights(curent or not) and the add/update/delete flight functionality.


## This project was made for ro.siit.national-java-05.

# Instructions

## IntelliJ IDEA

1. Open IntelliJ IDEA and select File > Open....
2. Choose the java-maven-starter-project directory and click OK.
3. Select File > Project Structure... and ensure that the Project SDK and language level are set to use Java 11.
4. Open the Maven view with View > Tool Windows > Maven.
5. In the Maven view, under Plugins > dependency, double-click the dependency:unpack goal. This will unpack the native libraries into $USER_HOME/.arcgis.
6. In the Maven view, run the compile phase under Lifecycle and then the exec:java goal to run the app.


## Command line

1. cd into the project's root directory.
2. Run ./mvnw dependency:unpack on Linux/Mac or mvnw.cmd dependency:unpack on Windows to unpack the native libraries to $USER_HOME/.arcgis.
3. The Spring Boot Maven plugin includes a run goal which can be used to quickly compile and run your application. Applications run in an exploded form just like in your IDE.
$ mvn spring-boot:run

## Set up the database

| Configuration             | Default                                   |
|---------------------------|-------------------------------------------|
| Telnet port               | 8080                                      |
| Url                       | `jdbc:postgresql://localhost:5432/flights`|
| Database names            | `flights`                                 |
| Database hostname         | `localhost`                               |



