# SpringCloud MSA - User Service
> 스프링클라우드를 통한 MSA 구축 - 회원 서비스

<br/>

## ⚙️ 개발 환경
- JDK 17
- Spring Boot 3.2.1
- Spring Cloud Eureka Client 4.1.3
- Spring Date JPA
- Spring Security
- Lombok
- H2 DB
- Gradle 8.10
- MapStruct

<br/>

## 📌 서비스 설명

### 프로파일
> `test`
- VM Option = `-Dspring.profiles.active={profile}`

### 엔드포인트

#### 회원가입 - (POST)  /franc/api/users
#### 회원조회 - (GET)   /franc/api/users/{userId}
#### 회원전체조회 - (GET)   /franc/api/users
#### 헬스체크 - (GET)   /franc/api/users/health_check


