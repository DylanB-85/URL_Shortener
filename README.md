# How to Run
+ With Docker and docker-compose: 

Note - This is the first time I have used docker, I could not get the docker compose to run locally, but I was not sure if this was just my machine. I have left instructions on how to run the mvn project too. Thank you

```sh
$ git clone https://github.com/DylanB-85/URL_Shortener.git
$ cd UrlShortener
$ docker-compose up 
```

    - Open localhost:8080/

- Without Docker: 
```sh
$ git clone https://github.com/DylanB-85/URL_Shortener.git
```
    - Make sure you have access to local or any MySQL server.
    - Open project in your favorite editor and change application.properties file to point to your MySQL database
    - Build Spring project 
    - Open localhost:8080
