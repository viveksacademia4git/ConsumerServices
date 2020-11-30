# Docker-Compose SpringBoot Execution

See: [docker-compose.yml](blob/main/docker-compose.yml)


### Gradle Build

- Linux: `sh ./gradlew build`
- Windows: `gradlew build`


### Docker Compose

Execute command: `docker-compose up`

```
Creating network "consumerservices_default" with the default driver
Building springboot-docker-compose-consumer-services-container
Step 1/5 : FROM openjdk:12
 ---> e1e07dfba89c
Step 2/5 : VOLUME /tmp
 ---> Using cache
 ---> e8675b67f337
Step 3/5 : ADD build/libs/ConsumerServices.jar consumer-services.jar
 ---> ee1c81a8c616
Step 4/5 : EXPOSE 8080
 ---> Running in ec52c8c65ac1
Removing intermediate container ec52c8c65ac1
 ---> 45fb3d27a043
Step 5/5 : ENTRYPOINT ["java","-jar", "consumer-services.jar"]
 ---> Running in 4ec50afb1cbb
Removing intermediate container 4ec50afb1cbb
 ---> 275ebaa76aef
Successfully built 275ebaa76aef
Successfully tagged springboot-docker-compose-consumer-services:1
WARNING: Image for service springboot-docker-compose-consumer-services-container was built because it did not already exist. To rebuild this image you must use `docker-compose build` or `docker-compose up --build`.
Creating consumerservices_springboot-docker-compose-consumer-services-container_1 ... done
Attaching to consumerservices_springboot-docker-compose-consumer-services-container_1
springboot-docker-compose-consumer-services-container_1  | 
springboot-docker-compose-consumer-services-container_1  |   .   ____          _            __ _ _
springboot-docker-compose-consumer-services-container_1  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
springboot-docker-compose-consumer-services-container_1  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
springboot-docker-compose-consumer-services-container_1  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
springboot-docker-compose-consumer-services-container_1  |   '  |____| .__|_| |_|_| |_\__, | / / / /
springboot-docker-compose-consumer-services-container_1  |  =========|_|==============|___/=/_/_/_/
springboot-docker-compose-consumer-services-container_1  |  :: Spring Boot ::        (v2.3.2.RELEASE)
springboot-docker-compose-consumer-services-container_1  | 
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:10.420  INFO 1 --- [           main] o.s.Application                          : Starting Application on de794010c242 with PID 1 (/consumer-services.jar started by root in /)
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:10.431  INFO 1 --- [           main] o.s.Application                          : No active profile set, falling back to default profiles: default
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:11.728  INFO 1 --- [           main] o.s.b.w.e.t.TomcatWebServer              : Tomcat initialized with port(s): 8080 (http)
springboot-docker-compose-consumer-services-container_1  | Nov 30, 2020 9:09:11 PM org.apache.coyote.AbstractProtocol init
springboot-docker-compose-consumer-services-container_1  | INFO: Initializing ProtocolHandler ["http-nio-8080"]
springboot-docker-compose-consumer-services-container_1  | Nov 30, 2020 9:09:11 PM org.apache.catalina.core.StandardService startInternal
springboot-docker-compose-consumer-services-container_1  | INFO: Starting service [Tomcat]
springboot-docker-compose-consumer-services-container_1  | Nov 30, 2020 9:09:11 PM org.apache.catalina.core.StandardEngine startInternal
springboot-docker-compose-consumer-services-container_1  | INFO: Starting Servlet engine: [Apache Tomcat/9.0.37]
springboot-docker-compose-consumer-services-container_1  | Nov 30, 2020 9:09:11 PM org.apache.catalina.core.ApplicationContext log
springboot-docker-compose-consumer-services-container_1  | INFO: Initializing Spring embedded WebApplicationContext
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:11.843  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1338 ms
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:12.169  INFO 1 --- [           main] o.s.s.c.ThreadPoolTaskExecutor           : Initializing ExecutorService 'applicationTaskExecutor'
springboot-docker-compose-consumer-services-container_1  | Nov 30, 2020 9:09:12 PM org.apache.coyote.AbstractProtocol start
springboot-docker-compose-consumer-services-container_1  | INFO: Starting ProtocolHandler ["http-nio-8080"]
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:12.338  INFO 1 --- [           main] o.s.b.w.e.t.TomcatWebServer              : Tomcat started on port(s): 8080 (http) with context path ''
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:12.356  INFO 1 --- [           main] o.s.Application                          : Started Application in 2.536 seconds (JVM running for 3.436)
springboot-docker-compose-consumer-services-container_1  | Nov 30, 2020 9:09:35 PM org.apache.catalina.core.ApplicationContext log
springboot-docker-compose-consumer-services-container_1  | INFO: Initializing Spring DispatcherServlet 'dispatcherServlet'
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:35.081  INFO 1 --- [nio-8080-exec-1] o.s.w.s.DispatcherServlet                : Initializing Servlet 'dispatcherServlet'
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:35.091  INFO 1 --- [nio-8080-exec-1] o.s.w.s.DispatcherServlet                : Completed initialization in 8 ms
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:35 INFO  ConsumerServiceImpl:45 - Initializing Consumer Feed Service...
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:35 INFO  ConsumerServiceImpl:68 - Consuming feed from https://xkcd.com/2392/info.0.json
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:35 INFO  ConsumerServiceImpl:68 - Consuming feed from https://xkcd.com/2391/info.0.json
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:36 INFO  ConsumerServiceImpl:68 - Consuming feed from https://xkcd.com/2390/info.0.json
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:36 INFO  ConsumerServiceImpl:68 - Consuming feed from https://xkcd.com/2389/info.0.json
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:36 INFO  ConsumerServiceImpl:68 - Consuming feed from https://xkcd.com/2388/info.0.json
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:36 INFO  ConsumerServiceImpl:68 - Consuming feed from https://xkcd.com/2387/info.0.json
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:36 INFO  ConsumerServiceImpl:68 - Consuming feed from https://xkcd.com/2386/info.0.json
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:37 INFO  ConsumerServiceImpl:68 - Consuming feed from https://xkcd.com/2385/info.0.json
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:37 INFO  ConsumerServiceImpl:68 - Consuming feed from https://xkcd.com/2384/info.0.json
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:37 INFO  ConsumerServiceImpl:68 - Consuming feed from https://xkcd.com/2383/info.0.json
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:37 INFO  ConsumerServiceImpl:83 - Consuming feed from http://feeds.feedburner.com/PoorlyDrawnLines
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:38 INFO  ContentFormatter:66 - Formatted Date ======>>>>>>> Mon Nov 30 00:00:00 GMT 2020
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:38 INFO  ContentFormatter:66 - Formatted Date ======>>>>>>> Mon Nov 23 00:00:00 GMT 2020
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:38 INFO  ContentFormatter:66 - Formatted Date ======>>>>>>> Fri Nov 20 00:00:00 GMT 2020
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:38 INFO  ContentFormatter:66 - Formatted Date ======>>>>>>> Wed Nov 18 00:00:00 GMT 2020
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:38 INFO  ContentFormatter:66 - Formatted Date ======>>>>>>> Tue Nov 17 00:00:00 GMT 2020
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:38 INFO  ContentFormatter:66 - Formatted Date ======>>>>>>> Fri Nov 13 00:00:00 GMT 2020
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:38 INFO  ContentFormatter:66 - Formatted Date ======>>>>>>> Mon Nov 09 00:00:00 GMT 2020
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:38 INFO  ContentFormatter:66 - Formatted Date ======>>>>>>> Fri Nov 06 00:00:00 GMT 2020
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:38 INFO  ContentFormatter:66 - Formatted Date ======>>>>>>> Mon Nov 02 00:00:00 GMT 2020
springboot-docker-compose-consumer-services-container_1  | 2020-11-30 21:09:38 INFO  ContentFormatter:66 - Formatted Date ======>>>>>>> Wed Oct 28 00:00:00 GMT 2020
```
