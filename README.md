# strava-java-authenticator

The strava java authenticator is a Spring Boot application which gives the ability for users to get authenticated against the Strava API. 

## Prerequisites

* A [registered application](https://developers.strava.com/docs/getting-started/#account) on Strava. 
* Java 11 JDK

## Getting started 

* Clone the `strava-java-authenticator`.
* Copy the Client ID and Client Secret from your [application](https://www.strava.com/settings/api) and place them in the application.yml. 
* Run `start-app.sh`
* Go to localhost:8080 in your web browser where the user will be redirected to strava and asked to authenticate. 
* After the user has successfully authenticated they will be returned with a json response which includes an access token. This access token can be used to access resources of the Strava api. 