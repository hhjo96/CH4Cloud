# Spring 부트캠프 클라우드 과제

## Lv0. budgets 설정
- 80% 설정되어 있음
![img.png](img.png)
- 이메일 설정되어 있음
![img_1.png](img_1.png)


## Lv1. 인프라 구축 및 애플리케이션 개발
- VPC 및 EC2 생성
![img_3.png](img_3.png)
![img_2.png](img_2.png)

- 애플리케이션 개발
![img_4.png](img_4.png)

- 운영 설정(local, prod 분리)

- 로그 전략
![img_5.png](img_5.png)


- actuator 추가
![img_6.png](img_6.png)

- 서버 실행
![img_7.png](img_7.png)
![img_8.png](img_8.png)
![img_9.png](img_9.png)

### 요구사항
서버 IP 3.39.222.191

## LV2 db분리 및 보안

- 스프링 실행
![img_12.png](img_12.png)

### 요구사항
- 보안 그룹 설정
![img_10.png](img_10.png)

- 엔드포인트 url: http://3.39.222.191:8080/actuator/info
![img_11.png](img_11.png)


## LV3 S3
- 퍼블릭 엑세스 차단
![img_13.png](img_13.png)

- 로컬 파일 업로드, 다운로드 확인
![img_14.png](img_14.png)
![img_15.png](img_15.png)

- 서버 파일 업로드, 다운로드 확인
![img_16.png](img_16.png)
![img_17.png](img_17.png)

- 버켓 확인
![img_18.png](img_18.png)

### 요구사항
url: 
만료: 