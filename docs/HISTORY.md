# History
- 2022/12/30: 프로젝트 생성
  - Heroku를 이용하려 하였으나 무료 서비스 종료로 대안 찾음
  - render를 통해 호스팅 성공(Docker 이용)
  - https://gamerentalmarket.onrender.com
- 2023/01/01: 로고 만들기, 메인화면 페이지, 로그인 페이지 추가
  - 로고 만들기는 Tailor Brands([#](https://www.tailorbrands.com/)) 이용
  - 부트스트랩을 이용하여 기본 구조를 잡음
- 2023/01/02: 회원 가입 페이지 추가(기본 틀 잡기)
- 2023/01/03: 렌탈/중고 구매시의 상품 상세 페이지 추가(기본 틀 잡기)
- 2023/01/04: 상품 구매(렌탈/중고) 페이지 추가
- 2023/01/07: 상품 판매(렌탈/중고) 페이지 추가(기본 틀 잡기)
- 2023/01/09: 마이페이지(판매) 추가(기본 틀 잡기)
- 2023/01/11: 마이페이지(구매) 추가(기본 틀 잡기)
- 2023/01/14: 프로젝트에 사용할 데이터베이스 구조 초안 고민(ERD: [#](/docs/ERD.png))
- 2023/01/16: JDBC, DB관련 라 이브러리 추가 및 DB초기화 SQL문 추가
  - H2 데이터베이스를 임베디드 모드로 사용하되 MYSQL문법 사용
- 2023/01/17 ~ 2023/01/19: DB구조 수정 및 테스트 및 원활한 개발을 위한 더미 데이터 추가
- 2023/01/20 ~ 2023/01/24: 프로모션, 상품, 판매글, 거래글, 유저와 관련된 DTO/Repository 작성, 테스트 코드 추가
- 2023/01/25 ~ 2023/01/26: 서비스 계층 작성 및 테스트 코드 추가
- 2023/01/27: 프로모션, 상품, 판매글 조회 API 추가
- 2023/01/28: 사용자 로그인 기능 추가, DB 저장시 유저 비밀번호 암호화
- 2023/01/31: 회원가입 페이지 입력 폼 구체화
- 2023/02/01: 사용자 회원가입 기능 추가
- 2023/02/02: 테스트용으로 사용할 프로모션/상품 이미지 제작하여 추가
- 2023/02/03: 메인화면에서 프로모션/상품 정보 로드 후 표시 기능 추가
  - 상품이 더 있는 경우 더보기 기능 추가
  - 카테고리별로 상품 확인 기능 추가
- 2023/02/04 ~ 2023/02/06: 컨트롤러에 담은 상품/판매글 정보와 상세 페이지 연결
- 2023/02/07: 컨트롤러와 상품 판매 페이지 연결
- 2023/02/08: 상품 판매 페이지로부터 판매글을 등록할 수 있도록 추가, 판매글 입력 폼 구체화
- 2023/02/09: 컨트롤러와 상품 구매 페이지 연결, 상품 구매 페이지에서 구매글 등록할 수 있도록 추가
- 2023/02/10: 컨트롤러와 마이페이지(판매/구매) 연결, 네비게이션 바 구체화
- 2023/02/11 ~ 2023/02/14: 컨트롤러와 거래글 판매/구매 진행 페이지 연결 및 거래 진행 기능 추가, 판매글/거래글 삭제 기능 추가
- 2023/02/15 ~ 2023/02/16: 상품/프로모션 이미지 및 테스트용 유저/거래 데이터 추가
- 2023/02/17: 기존 내장 H2(MySQL 호환성모드) 데이터베이스를 이용하는 대신 외부 PostgreSQL 기반 DB 서비스를 이용하도록 함. 그에 따라 SQL문 변경 및 외부 서비스와 연결 기능 추가
- 2023/02/18: API 문서 자동화를 위한 Swagger 추가, README.md에 프로젝트 설명 작성
