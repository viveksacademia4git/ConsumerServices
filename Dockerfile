
FROM openjdk:12

ADD build/libs/ConsumerServices.jar ConsumerServices.jar

ENTRYPOINT ["java","-jar", "ConsumerServices.jar"]

EXPOSE 8080