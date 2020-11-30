# Docker SpringBoot Execution

See: [Dockerfile](blob/main/Dockerfile)

### Gradle Build

- Linux: `sh ./gradlew build`
- Windows: `gradlew build`


### Docker Build

Execute command: `docker build . -t consumer-services`
```
Sending build context to Docker daemon  26.57MB
Step 1/5 : FROM openjdk:12
 ---> e1e07dfba89c
Step 2/5 : VOLUME /tmp
 ---> Running in a8db1f91852c
Removing intermediate container a8db1f91852c
 ---> e8675b67f337
Step 3/5 : ADD build/libs/ConsumerServices.jar consumer-services.jar
 ---> 2af354a364ff
Step 4/5 : EXPOSE 8080
 ---> Running in 58106472d495
Removing intermediate container 58106472d495
 ---> 27b6577d54a2
Step 5/5 : ENTRYPOINT ["java","-jar", "consumer-services.jar"]
 ---> Running in 657e7ecc4a0a
Removing intermediate container 657e7ecc4a0a
 ---> 8095999e40b1
Successfully built 8095999e40b1
Successfully tagged consumer-services:latest
```


### Docker Run

Execute command: `docker run -p 8080:8080 consumer-services:latest`
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.2.RELEASE)

2020-11-30 21:01:47.637  INFO 1 --- [           main] o.s.Application                          : Starting Application on 190c6389f82e with PID 1 (/consumer-services.jar started by root in /)
2020-11-30 21:01:47.646  INFO 1 --- [           main] o.s.Application                          : No active profile set, falling back to default profiles: default
2020-11-30 21:01:48.861  INFO 1 --- [           main] o.s.b.w.e.t.TomcatWebServer              : Tomcat initialized with port(s): 8080 (http)
Nov 30, 2020 9:01:48 PM org.apache.coyote.AbstractProtocol init
INFO: Initializing ProtocolHandler ["http-nio-8080"]
Nov 30, 2020 9:01:48 PM org.apache.catalina.core.StandardService startInternal
INFO: Starting service [Tomcat]
Nov 30, 2020 9:01:48 PM org.apache.catalina.core.StandardEngine startInternal
INFO: Starting Servlet engine: [Apache Tomcat/9.0.37]
Nov 30, 2020 9:01:48 PM org.apache.catalina.core.ApplicationContext log
INFO: Initializing Spring embedded WebApplicationContext
2020-11-30 21:01:48.955  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1245 ms
2020-11-30 21:01:49.301  INFO 1 --- [           main] o.s.s.c.ThreadPoolTaskExecutor           : Initializing ExecutorService 'applicationTaskExecutor'
Nov 30, 2020 9:01:49 PM org.apache.coyote.AbstractProtocol start
INFO: Starting ProtocolHandler ["http-nio-8080"]
2020-11-30 21:01:49.529  INFO 1 --- [           main] o.s.b.w.e.t.TomcatWebServer              : Tomcat started on port(s): 8080 (http) with context path ''
2020-11-30 21:01:49.544  INFO 1 --- [           main] o.s.Application                          : Started Application in 2.497 seconds (JVM running for 3.421)
```

### Execute REST Endpoint

URL: `http://localhost:8080/`

```
{
    "status": "success",
    "message": "Number of feed: 20",
    "data": [
        {
            "title": "Thank Me Later",
            "date": "2020-11-30T00:00:00.000+00:00",
            "browserviewlink": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/32VgwKUfr2o/",
            "picturelink": "http://www.poorlydrawnlines.com/wp-content/uploads/2020/11/Thank_Me_Later2.png"
        },
        {
            "title": "Cyber Cafe",
            "date": "2020-11-30T00:00:00.000+00:00",
            "browserviewlink": "https://xkcd.com/2392/info.0.json",
            "picturelink": "https://imgs.xkcd.com/comics/cyber_cafe.png"
        },
        {
            "title": "Life Before the Pandemic",
            "date": "2020-11-27T00:00:00.000+00:00",
            "browserviewlink": "https://xkcd.com/2391/info.0.json",
            "picturelink": "https://imgs.xkcd.com/comics/life_before_the_pandemic.png"
        },
        {
            "title": "Linguists",
            "date": "2020-11-25T00:00:00.000+00:00",
            "browserviewlink": "https://xkcd.com/2390/info.0.json",
            "picturelink": "https://imgs.xkcd.com/comics/linguists.png"
        },
        {
            "title": "Business Shorts",
            "date": "2020-11-23T00:00:00.000+00:00",
            "browserviewlink": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/bn7cSaaRN-0/",
            "picturelink": "http://www.poorlydrawnlines.com/wp-content/uploads/2020/11/Business-shorts.png"
        },
        {
            "title": "Unread",
            "date": "2020-11-23T00:00:00.000+00:00",
            "browserviewlink": "https://xkcd.com/2389/info.0.json",
            "picturelink": "https://imgs.xkcd.com/comics/unread.png"
        },
        {
            "title": "On the Horse",
            "date": "2020-11-20T00:00:00.000+00:00",
            "browserviewlink": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/0pzxCOTbtD8/",
            "picturelink": "http://www.poorlydrawnlines.com/wp-content/uploads/2020/11/on_the_horse.png"
        },
        {
            "title": "Viral Quiz Identity Theft",
            "date": "2020-11-20T00:00:00.000+00:00",
            "browserviewlink": "https://xkcd.com/2388/info.0.json",
            "picturelink": "https://imgs.xkcd.com/comics/viral_quiz_identity_theft.png"
        },
        {
            "title": "Through a Lot",
            "date": "2020-11-18T00:00:00.000+00:00",
            "browserviewlink": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/bbQs6DxQ8ik/",
            "picturelink": "http://www.poorlydrawnlines.com/wp-content/uploads/2020/11/through_a_lot2.png"
        },
        {
            "title": "Blair Witch",
            "date": "2020-11-18T00:00:00.000+00:00",
            "browserviewlink": "https://xkcd.com/2387/info.0.json",
            "picturelink": "https://imgs.xkcd.com/comics/blair_witch.png"
        },
        {
            "title": "City Monster: A Graphic Novel",
            "date": "2020-11-17T00:00:00.000+00:00",
            "browserviewlink": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/-LUWyHAnink/",
            "picturelink": "http://www.poorlydrawnlines.com/wp-content/uploads/2020/11/CityMonster-SocialShares-Skyline_v2-1024x1024.jpg"
        },
        {
            "title": "Ten Years",
            "date": "2020-11-16T00:00:00.000+00:00",
            "browserviewlink": "https://xkcd.com/2386/info.0.json",
            "picturelink": "https://imgs.xkcd.com/comics/ten_years.png"
        },
        {
            "title": "Everything Changes",
            "date": "2020-11-13T00:00:00.000+00:00",
            "browserviewlink": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/G9tknt5FqZk/",
            "picturelink": "http://www.poorlydrawnlines.com/wp-content/uploads/2020/11/everything_changes_2.png"
        },
        {
            "title": "Final Exam",
            "date": "2020-11-13T00:00:00.000+00:00",
            "browserviewlink": "https://xkcd.com/2385/info.0.json",
            "picturelink": "https://imgs.xkcd.com/comics/final_exam.png"
        },
        {
            "title": "Set in the Present",
            "date": "2020-11-11T00:00:00.000+00:00",
            "browserviewlink": "https://xkcd.com/2384/info.0.json",
            "picturelink": "https://imgs.xkcd.com/comics/set_in_the_present.png"
        },
        {
            "title": "No Free Time",
            "date": "2020-11-09T00:00:00.000+00:00",
            "browserviewlink": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/UFFv5ZtO7ng/",
            "picturelink": "http://www.poorlydrawnlines.com/wp-content/uploads/2020/11/No_Free_Time.png"
        },
        {
            "title": "Electoral Precedent 2020",
            "date": "2020-11-09T00:00:00.000+00:00",
            "browserviewlink": "https://xkcd.com/2383/info.0.json",
            "picturelink": "https://imgs.xkcd.com/comics/electoral_precedent_2020.png"
        },
        {
            "title": "Busy Day",
            "date": "2020-11-06T00:00:00.000+00:00",
            "browserviewlink": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/aYMUW3Lhy-U/",
            "picturelink": "http://www.poorlydrawnlines.com/wp-content/uploads/2020/11/busy-day.png"
        },
        {
            "title": "Time is Moving",
            "date": "2020-11-02T00:00:00.000+00:00",
            "browserviewlink": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/tSC6q8oVlpw/",
            "picturelink": "http://www.poorlydrawnlines.com/wp-content/uploads/2020/11/Time-is-moving.png"
        },
        {
            "title": "Hard Truths",
            "date": "2020-10-28T00:00:00.000+00:00",
            "browserviewlink": "http://feedproxy.google.com/~r/PoorlyDrawnLines/~3/-rEcCIWq6bk/",
            "picturelink": "http://www.poorlydrawnlines.com/wp-content/uploads/2020/10/hard_truths.png"
        }
    ]
}
```
