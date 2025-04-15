## 프로젝트 설명

### 사전 준비
+ redis를 실행하기 위해 docker 컴포즈를 이용합니다.

```kotlin
docker-compose up -d
```

+ localhost:8080/api/v1/random/suffle (GET)
+ 설명 : 더미 데이터를 넣는 API입니다.

## 1. API SPEC

### 1-0 토큰 생성 API
+ URL : localhost:8080/api/v1/random/token

+ Response
+ 설명 : 아래 API들을 실행하기 위한 토큰을 발급합니다. 아래 API의 Header의 키로 Authroization, value로 Bearer + token 정보를 기입합니다.
```kotlin
{
    "grantType": "Bearer",
    "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiYXV0aCI6IlJPTEVfVVNFUiIsImlhdCI6MTc0NDczNjA2NCwiZXhwIjoxNzQ0NzM3ODY0fQ.FGgmgznzTcCnrnDitcPuMhULhBDrX6PPoE3Q-JzDGH4"
}
```

### 1-1 작품 조회 이력 API
+ URL : localhost:8080/api/v1/webtoon/{webtoonId}/history (GET)
+ Content-Type: application/json
+ Header : Authorization
+ Response

```kotlin
{
    "content": [
        {
            "id": 1,
            "webtoonId": 1,
            "userId": 101,
            "createdAt": "2025-04-16T01:54:22.057733",
            "updatedAt": "2025-04-16T01:54:22.057733"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "size": 10,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "last": true,
    "numberOfElements": 1,
    "empty": false
}
```


### 1-2 인기 작품 조회 API
+ URL : localhost:8080/api/v1/webtoon/purchased/popular (GET)
+ Content-Type: application/json
+ Header : Authorization
  
+ response
```kotlin
[
  {
     "rank" : 1,
     "id" : "1",
     "name" : "1",
     "createdAt" : "",
     "updatedAt" : ""
  }
]
```

### 1-3 작품 구매 API
+ URL : localhost:8080/api/v1/webtoon/{webtoonId}/purchase (POST)
+ Content-Type: application/json
+ Header : Authorization

### 1-4 구매 인기 작품 조회 API

+ URL : localhost:8080/api/v1/webtoon/purchased/popular (GET)
+ Content-Type: application/json
+ Header : Authorization


### 1-5 작품 및 이력 삭제 API
+ URL : localhost:8080/api/v1/webtoon/{webtoonId} (DELETE)
+ Content-Type: application/json
+ Header : Authorization

프로젝트 구조
+ auth : 인증과 관련된 모듈이 모여있는 영역 입니다.
+ common : 예외처리가 존재하는 영역입니다. aop나 argumentReosolver가 위치할 수도 있습니다.
+ config : 환경 설정이 등록되는 부분들이 모이는 영역 입니다.
+ domain : 순수 도메인 엔티티들이 존재하는 영역 입니다.
+ feature
  - controller :애플리케이션 영역이며 클라이언트와 통신하는 영역입니다.
  - service : 애플리케이션 비즈니스 로직 처리
+ infrastruce : 저수준의 모듈이 존재하는 영역 입니다. 도메인 엔티티와 연결고리가 되는 영역입니다.
+ test
  - controller : 컨트롤러 영역을 테스트 합니다.
  - domain : 순수 도메인 엔티티에 대한 도메인 로직을 테스트 하는 영역입니다.
 
## 구현 고려 사항
+ 도메인 엔티티와 jpa엔티티를 분리하여 설계 하였습니다.
  - 순수 도메인에 비즈니스 로직이 존재하도록 하여 소형 테스트를 쉽게 할 수 있도록 설계 하였습니다.

+ PaymentType(유료, 무료)의 경우 별도의 converter없이 변수 그대로 DB에 저장하도록 설계 하였습니다.
  - @Enumerated(EnumType.STRING)

+ 인증은 최소한의 설정만 진행하여 토큰 발급 API를 제외한 나머지 API에 토큰을 실어야만 실행가능하도록 하였습니다.

+ 작품 이력 조회는 데이터량이 많아질것을 고려하여 slice로 조회하도록 설계 하였습니다.
  - 추후에 더많은 데이터 조회시에 빅쿼리나 RedShift에 적재하여 조회하는게 좋을것 같습니다.
 
+ 시간 관계상 유저 까지 만들 수 없어 테스트 계정을 등록하여 임시 토큰을 발급 받아서 사용하였습니다.

+ 인기 작품 조회 API / 구매 인기 작품 API는 성능을 고려하여 redis의 sorted set을 이용하였습니다.
  - redis는 빠른 실행을 위해 도커 환경에서 구동가능하도록 docker-compose를 이용하여 실행하였습니다.

+ 작품 이력 삭제 API에서 특정 작품을 삭제할떄 조회 이력도 모두 삭제하는 API를 개발 하였습니다.
  - jdbc template을 이용하였습니다.
    - jdbc template 주의 사항 : rewriteBatchedStatements옵션 활성화 필요
    
## 아쉬운 점
+ 테스트 코드를 많이 작성하지 못한점이 아쉽습니다.
+ 적절한 부분에 인덱스가 추가되면 좋을것 같습니다.
+ 유저 정보까지 추가 되었으면 더 좋았을 것 같습니다.
