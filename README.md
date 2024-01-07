# Redis's concept proof

## The objective this project was do a concept proof about the use the bank [REDIS](https://redis.com/)

<p>In applications that have a high volume of accesses, the applications can have a bad performance, causing the response time to requests to be longer than expected, in a lot of cases occur because your  many connection betwen sistems or your databases, resulting in a poor user experience. </p>

<p>For companies to remain competitive and serve users, providing a better experience, it is necessary to optimize systems, and one of the ways to achieve this goal is through the use of caching, in this case Redis.</p>

<p>The objective of this project was to configure and test the use of redis. For this development, docker-compose was used to create a docker container with redis, spring boot, java, h2 database and data persistence with spring data jpa.</p>

![](/image/desenho_solucao.jpg)

## How to use

<p>In the same directory the redis-docker-compose.yml run the following docker command</p>

```
docker-compose -f redis-docker-compose.yml up
```

![](/image/docker-compose.jpeg)

```
docker exec -it redis bash
```
