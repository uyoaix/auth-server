FROM openjdk:8
VOLUME /tmp
ADD build/libs/auth-service-1.0.0.RELEASE.jar auth-server.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "auth-server.jar"]