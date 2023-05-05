FROM openjdk:17
RUN mkdir /opt/app
COPY app/build/libs/app.jar /opt/app
CMD ["java", "-jar", "/opt/app/app.jar"]
