
FROM openjdk:12

VOLUME /tmp

ADD build/libs/ConsumerServices.jar consumer-services.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar", "consumer-services.jar"]
