#### Mysql UTF-8 한글 인코딩 깨짐 해결

__MYSQL Console__

```
create database mydb default character set utf8 collate utf8_general_ci;

create table board (
​	bno int not null auto_increment,
​	title varchar(200) not null,
​	content varchar(2000) not null,
​	writer varchar(50) not null,
​	regDate datetime not null default current_timestamp,
​	updateDate datetime not null default current_timestamp,
​	isComplete boolean not null default false,
​	primary key(bno)
) default character set utf8 collate utf8_general_ci;
```



__[Spring] application.properties__

```
server.port=8080
spring.devtools.livereload.enabled=true

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&characterEncoding=utf-8
spring.datasource.username=root
spring.datasource.password=root
```



__[Spring] 구조 설계__

```
com.example
demo : 애플리케이션 메인
controller : controller 클래스 보관 패키지
domain : VO, DTO 클래스 보관 패키지
​	VO : Value Object
​	DTO : Data Transfer Object
persistance : Mybatis Mapper 인터페이스 패키지
service : 비즈니스 로직 패키지
```



__[Spring] 개발 환경__

```
com.mysql.cj.jdbc.Driver
mybatis - mapper : annotation
Thymeleaf
spring boot
lombok
```

