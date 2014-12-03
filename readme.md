# Gradle Multi web application

스프링을 이용한 멀티웹 애플리케이션 기반구조

Branch를 보시면 db-web과 db-none-web 2개의 프로젝트가 있습니다. db-none-web의 경우 
데이터베이스 연동 부분을 제외하고 간단하게 구현한 애플리케이션이고 
db-web의 경우 mysql 데이터베이스를 연동하는 domain 로직을 제공하고 있습니다.

## db-none web application

```cmd
multi-web-demo
|--- commons
|--- domains ( simple hello service, junit test )
|--- public-web ( simple web, junit test (mokito))
```

## db-web application

```cmd
multi-web-demo
|--- commons
|--- domains ( jpa entities, repository, querydsl, service, junit test)
|--- public-web ( simple web, junit test (mokito))
```
