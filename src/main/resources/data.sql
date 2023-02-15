INSERT INTO `category` (id, name) VALUES (1, 'PS5/PS4');
INSERT INTO `category` (id, name) VALUES (2, 'XSX');
INSERT INTO `category` (id, name) VALUES (3, 'SWITCH');
INSERT INTO `category` (id, name) VALUES (4, 'Others');

INSERT INTO `file` (id, name, path) VALUES (1, '사이트 설명 이미지', 'img/promotion/main1.png');
INSERT INTO `file` (id, name, path) VALUES (2, '프로모션 이미지', 'img/promotion/promotion1.png');
INSERT INTO `file` (id, name, path) VALUES (3, '주의사항 이미지', 'img/promotion/notice1.png');
INSERT INTO `file` (id, name, path) VALUES (4, 'PS5 호그와트 레거시 이미지', 'img/product/ps5_호그와트.png');
INSERT INTO `file` (id, name, path) VALUES (5, 'PS5 더 위쳐 3: 와일드 헌트 컴플리트 에디션 이미지', 'img/product/ps5_위쳐3.png');
INSERT INTO `file` (id, name, path) VALUES (6, 'PS5 데드 스페이스 이미지', 'img/product/ps5_데드스페이스.png');
INSERT INTO `file` (id, name, path) VALUES (7, 'PS5 포스포큰 이미지', 'img/product/ps5_포스포큰.png');
INSERT INTO `file` (id, name, path) VALUES (8, 'SWITCH 포켓몬스터 스칼렛 이미지', 'img/product/ns_포켓몬스칼렛.png');
INSERT INTO `file` (id, name, path) VALUES (9, 'SWITCH 포켓몬스터 바이올렛 이미지', 'img/product/ns_포켓몬바이올렛.png');
INSERT INTO `file` (id, name, path) VALUES (10, 'SWITCH 모여봐요 동물의 숲 이미지', 'img/product/ns_동물의숲.png');
INSERT INTO `file` (id, name, path) VALUES (11, 'SWITCH 젤다의 전설 브레스 오브 더 와일드 이미지', 'img/product/ns_젤다의전설.png');
INSERT INTO `file` (id, name, path) VALUES (12, 'XBOX 어쌔신 크리드: 발할라 이미지', 'img/product/xb_어쌔신크리드발할라.png');
INSERT INTO `file` (id, name, path) VALUES (13, 'XBOX One 레드 데드 리뎀션 2', 'img/product/xbo_레드데드리뎀션2.png');
INSERT INTO `file` (id, name, path) VALUES (14, 'PS5 칼리스토 프로토콜 이미지', 'img/product/ps5_칼리스토프로토콜.png');
INSERT INTO `file` (id, name, path) VALUES (15, 'PS4 칼리스토 프로토콜 이미지', 'img/product/ps4_칼리스토프로토콜.png');
INSERT INTO `file` (id, name, path) VALUES (16, 'PS5 갓 오브 워 라그나로크', 'img/product/ps5_갓오브워라그나로크.png');
INSERT INTO `file` (id, name, path) VALUES (17, 'PS4 갓 오브 워 라그나로크', 'img/product/ps4_갓오브워라그나로크.png');
INSERT INTO `file` (id, name, path) VALUES (18, 'PS5 소닉 프론티어 이미지', 'img/product/ps5_소닉프론티어.png');
INSERT INTO `file` (id, name, path) VALUES (19, 'PS4 소닉 프론티어 이미지', 'img/product/ps4_소닉프론티어.png');
INSERT INTO `file` (id, name, path) VALUES (20, 'SWITCH 소닉 프론티어 이미지', 'img/product/ns_소닉프론티어.png');
INSERT INTO `file` (id, name, path) VALUES (21, 'PS5 페르소나5 로열 이미지', 'img/product/ps5_페르소나5로열.png');
INSERT INTO `file` (id, name, path) VALUES (22, 'SWITCH 페르소나5 로열 이미지', 'img/product/ns_페르소나5로열.png');
INSERT INTO `file` (id, name, path) VALUES (23, 'PS5 피파23 이미지', 'img/product/ps5_피파23.png');
INSERT INTO `file` (id, name, path) VALUES (24, 'PS4 피파23 이미지', 'img/product/ps4_피파23.png');
INSERT INTO `file` (id, name, path) VALUES (25, 'SWITCH 스플래툰3 이미지', 'img/product/ns_스플래툰3.png');
INSERT INTO `file` (id, name, path) VALUES (26, 'PS5 그란 투리스모7 이미지', 'img/product/ps5_그란투리스모7.png');
INSERT INTO `file` (id, name, path) VALUES (27, 'PS4 그란 투리스모7 이미지', 'img/product/ps4_그란투리스모7.png');
INSERT INTO `file` (id, name, path) VALUES (28, 'PS5 엘든링 이미지', 'img/product/ps5_엘든링.png');
INSERT INTO `file` (id, name, path) VALUES (29, 'PS4 엘든링 이미지', 'img/product/ps4_엘든링.png');
INSERT INTO `file` (id, name, path) VALUES (30, '3DS 몬스터헌터 4G 이미지', 'img/product/3ds_몬스터헌터4G.png');

INSERT INTO `promotion` (id, file_id, url) VALUES (1, 1, NULL);
INSERT INTO `promotion` (id, file_id, url) VALUES (2, 2, '/detail/1');
INSERT INTO `promotion` (id, file_id, url) VALUES (3, 3, NULL);

INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (1, 1, 'PS5 호그와트 레거시', '플레이스테이션 액션 RPG 게임', 79800,  4);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (2, 1, 'PS5 더 위쳐 3: 와일드 헌트 컴플리트 에디션', '플레이스테이션 RPG 게임', 54800,  5);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (3, 1, 'PS5 데드 스페이스', '플레이스테이션 어드벤처 게임', 83000,  6);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (4, 1, 'PS5 포스포큰', '플레이스테이션 액션 RPG 게임', 79800,  7);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (5, 3, 'SWITCH 포켓몬스터 스칼렛', '닌텐도 스위치 RPG 게임', 64800,  8);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (6, 3, 'SWITCH 포켓몬스터 바이올렛', '닌텐도 스위치 RPG 게임', 64800,  9);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (7, 3, 'SWITCH 모여봐요 동물의 숲', '닌텐도 스위치 커뮤니케이션 게임', 64000,  10);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (8, 3, 'SWITCH 젤다의 전설 브레스 오브 더 와일드', '플레이스테이션 RPG 게임', 74800,  11);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (9, 2, 'XBOX 어쌔신 크리드: 발할라', '엑스박스 액션 RPG 게임', 65900,  12);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (10, 2, 'XBOX One 레드 데드 리뎀션 2', '엑스박스 오픈월드 어드벤처 게임', 66000,  13);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (11, 1, 'PS5 칼리스토 프로토콜', '플레이스테이션 서바이벌 호러 게임', 77800,  14);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (12, 1, 'PS4 칼리스토 프로토콜', '플레이스테이션 서바이벌 호러 게임', 64800,  15);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (13, 1, 'PS5 갓 오브 워 라그나로크', '플레이스테이션 액션 어드벤처 게임', 79800,  16);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (14, 1, 'PS4 갓 오브 워 라그나로크', '플레이스테이션 액션 어드벤처 게임', 69800,  17);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (15, 1, 'PS5 소닉 프론티어', '플레이스테이션 액션 어드벤처 게임', 49800,  18);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (16, 1, 'PS4 소닉 프론티어', '플레이스테이션 액션 어드벤처 게임', 49800,  19);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (17, 3, 'SWITCH 소닉 프론티어', '닌텐도 스위치 RPG 게임', 49800,  20);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (18, 1, 'PS5 페르소나5 로열', '플레이스테이션 RPG 게임', 69800,  21);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (19, 3, 'SWITCH 페르소나5 로열', '닌텐도 스위치 RPG 게임', 69800,  22);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (20, 1, 'PS5 피파23', '플레이스테이션 스포츠 게임', 83000,  23);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (21, 1, 'PS4 피파23', '플레이스테이션 스포츠 게임', 72000,  24);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (22, 3, 'SWITCH 스플래툰3', '닌텐도 스위치 슈팅액션 게임', 64800,  25);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (23, 1, 'PS5 그란 투리스모7', '플레이스테이션 레이싱 게임', 79800,  26);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (24, 1, 'PS4 그란 투리스모7', '플레이스테이션 RPG 게임', 69800,  27);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (25, 1, 'PS5 엘든링', '플레이스테이션 RPG 게임', 64800,  28);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (26, 1, 'PS4 엘든링', '플레이스테이션 RPG 게임', 64800,  29);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (27, 4, '3DS 몬스터헌터 4G', '닌텐도 스위치 헌터 액션 게임', 49000,  30);

INSERT INTO `users` (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (1, '갑', 'AAA', 'AAA@gmail.com', '010-1111-1111', '서울특별시 강남구', 'AAA123', '$2a$10$95xF27wD7B7s.TGeUt5UtuNdUJaXzvkG1PV/lNxxjV1u7cWqmNxFW'); -- rawPassword: 1234
INSERT INTO `users` (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (2, '을', 'BBB', 'BBB@gmail.com', '010-2222-2222', '인천광역시 계양구', 'BBB456', '$2a$10$NRM1oFA87EbebfULTqrgB.6wqLM1zZq6QhvRhLXefzwAlqd7lCBDe'); -- rawPassword: 4567
INSERT INTO `users` (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (3, '병', 'CCC', 'CCC@gmail.com', '010-3333-3333', '경기도 수원시 장안구', 'CCC789', '$2a$10$0IyuMKgSPUQimls5hzDLROKanwuv0Efgh/lunkhRKfnTLglkPcTbS'); -- rawPassword: 7890
INSERT INTO `users` (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (4, '정', 'DDD', 'DDD@gmail.com', '010-4444-4444', '부산광역시 강서구', 'DDD369', '$2a$10$mKZ1m4hUDYsWIAN/IvIjQO3v9Zl8LdKLt4xKkGmmLGRdBSDhbI5cW'); -- rawPassword: 3690
INSERT INTO `users` (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (5, '무', 'EEE', 'EEE@gmail.com', '010-1111-1111', '대전광역시 대덕구', 'EEE123', '$2a$10$95xF27wD7B7s.TGeUt5UtuNdUJaXzvkG1PV/lNxxjV1u7cWqmNxFW'); -- rawPassword: 1234
INSERT INTO `users` (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (6, '기', 'FFF', 'FFF@gmail.com', '010-2222-2222', '광주광역시 광산구', 'FFF456', '$2a$10$NRM1oFA87EbebfULTqrgB.6wqLM1zZq6QhvRhLXefzwAlqd7lCBDe'); -- rawPassword: 4567
INSERT INTO `users` (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (7, '경', 'GGG', 'GGG@gmail.com', '010-3333-3333', '울산광역시 남구', 'GGG789', '$2a$10$0IyuMKgSPUQimls5hzDLROKanwuv0Efgh/lunkhRKfnTLglkPcTbS'); -- rawPassword: 7890
INSERT INTO `users` (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (8, '신', 'HHH', 'HHH@gmail.com', '010-4444-4444', '대구광역시 남구', 'HHH369', '$2a$10$mKZ1m4hUDYsWIAN/IvIjQO3v9Zl8LdKLt4xKkGmmLGRdBSDhbI5cW'); -- rawPassword: 3690

-- 갑이 렌탈/직거래로 물건 등록만 한 상황
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (1, 1, 1, 1, 1, 6900, 1500, 20000, '싸게 거래합니다', 0);
-- 을이 렌탈/택배로 물건 등록만 한 상황
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (2, 1, 2, 1, 0, 7900, 1500, NULL, '빠르게 빌려드립니다', 0);

-- 갑이 렌탈/택배로 물건 등록, 을이 구매신청, 현재 입금대기 상태
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (3, 1, 1, 1, 0, 6000, 1500, NULL, '물건 빌려드려요', 1);
INSERT INTO `deal` (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (1, 3, 2, 6000, 0, NULL);
-- 갑이 렌탈/택배로 물건 등록, 병이 구매신청, 현재 구매자입금 상태
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (4, 1, 1, 1, 0, 7000, 2000, NULL, '물건 빌려드려요!', 1);
INSERT INTO `deal` (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (2, 4, 3, 9000, 1, NULL);
-- 갑이 렌탈/택배로 물건 등록, 정이 구매신청, 현재 렌탈중 상태
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (5, 1, 1, 1, 0, 8000, 2500, 10000, '물건 빌려드려요@', 1);
INSERT INTO `deal` (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (3, 5, 4, 18000, 2, NULL);
-- 갑이 렌탈/택배로 물건 등록, 무가 구매신청, 현재 종료예정 상태
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (6, 1, 1, 1, 0, 9000, 3000, 20000, '물건 빌려드려요~', 1);
INSERT INTO `deal` (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (4, 6, 5, 29000, 3, NULL);
-- 갑이 렌탈/택배로 물건 등록, 기가 구매신청, 현재 거래종료 상태
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (7, 1, 1, 1, 0, 10000, 4000, 3000, '물건 빌려드려요!!', 2);
INSERT INTO `deal` (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (5, 7, 6, 17000, 4, NULL);
-- 갑이 렌탈/직거래로 물건 등록, 경이 구매신청, 현재 거래전 상태
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (8, 1, 1, 1, 1, 6500, 1500, NULL, '물건 빌려드려요@@', 1);
INSERT INTO `deal` (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (6, 8, 7, 8000, 0, NULL);
-- 갑이 렌탈/직거래로 물건 등록, 신이 구매신청, 현재 렌탈중 상태
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (9, 1, 1, 1, 1, 7500, 2500, 10000, '물건 빌려드려요~~', 1);
INSERT INTO `deal` (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (7, 9, 8, 20000, 2, NULL);
-- 갑이 렌탈/직거래로 물건 등록, 을이 구매신청, 현재 거래종료 상태
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (10, 1, 1, 1, 1, 8500, 3500, 20000, '물건 빌려드려요!!!', 2);
INSERT INTO `deal` (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (8, 10, 2, 28500, 4, NULL);
-- 갑이 중고/택배로 물건 등록, 병이 구매신청, 현재 거래전 상태
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (11, 1, 1, 0, 0, 30000, NULL, NULL, '물건 팝니다', 1);
INSERT INTO `deal` (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (9, 11, 3, 30000, 0, NULL);
-- 갑이 중고/택배로 물건 등록, 정이 구매신청, 현재 구매자입금 상태
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (12, 1, 1, 0, 0, 35000, NULL, NULL, '물건 팝니다!', 1);
INSERT INTO `deal` (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (10, 12, 4, 35000, 1, NULL);
-- 갑이 중고/택배로 물건 등록, 무가 구매신청, 현재 거래종료 상태
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (13, 1, 1, 0, 0, 40000, NULL, NULL, '물건 팝니다~', 2);
INSERT INTO `deal` (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (11, 13, 5, 40000, 4, NULL);
-- 갑이 중고/직거래로 물건 등록, 기가 구매신청, 현재 거래전 상태
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (14, 1, 1, 0, 1, 22000, NULL, NULL, '물건 팝니다!!', 1);
INSERT INTO `deal` (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (12, 14, 6, 22000, 0, NULL);
-- 갑이 중고/직거래로 물건 등록, 경이 구매신청, 현재 거래종료 상태
INSERT INTO `post` (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (15, 1, 1, 0, 1, 32000, NULL, NULL, '물건 팝니다~~', 2);
INSERT INTO `deal` (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (13, 15, 7, 32000, 4, NULL);

INSERT INTO `chat_message` (id, deal_id, deal_post_id, sender, message) VALUES (1, 1, 3, 1, '안녕하세요');
