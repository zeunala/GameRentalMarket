INSERT INTO "category" (id, name) VALUES (1, 'PS5/PS4');
INSERT INTO "category" (id, name) VALUES (2, 'XSX');
INSERT INTO "category" (id, name) VALUES (3, 'SWITCH');
INSERT INTO "category" (id, name) VALUES (4, 'Others');

INSERT INTO "file" (id, name, path) VALUES (1, '사이트 설명 이미지', 'img/promotion/main1.png');
INSERT INTO "file" (id, name, path) VALUES (2, '프로모션 이미지', 'img/promotion/promotion1.png');
INSERT INTO "file" (id, name, path) VALUES (3, '주의사항 이미지', 'img/promotion/notice1.png');
INSERT INTO "file" (id, name, path) VALUES (4, 'PS5 호그와트 레거시 이미지', 'img/product/ps5_호그와트.png');
INSERT INTO "file" (id, name, path) VALUES (5, 'PS5 더 위쳐 3: 와일드 헌트 컴플리트 에디션 이미지', 'img/product/ps5_위쳐3.png');
INSERT INTO "file" (id, name, path) VALUES (6, 'PS5 데드 스페이스 이미지', 'img/product/ps5_데드스페이스.png');
INSERT INTO "file" (id, name, path) VALUES (7, 'PS5 포스포큰 이미지', 'img/product/ps5_포스포큰.png');
INSERT INTO "file" (id, name, path) VALUES (8, 'SWITCH 포켓몬스터 스칼렛 이미지', 'img/product/ns_포켓몬스칼렛.png');
INSERT INTO "file" (id, name, path) VALUES (9, 'SWITCH 포켓몬스터 바이올렛 이미지', 'img/product/ns_포켓몬바이올렛.png');
INSERT INTO "file" (id, name, path) VALUES (10, 'SWITCH 모여봐요 동물의 숲 이미지', 'img/product/ns_동물의숲.png');
INSERT INTO "file" (id, name, path) VALUES (11, 'SWITCH 젤다의 전설 브레스 오브 더 와일드 이미지', 'img/product/ns_젤다의전설.png');
INSERT INTO "file" (id, name, path) VALUES (12, 'XBOX 어쌔신 크리드: 발할라 이미지', 'img/product/xb_어쌔신크리드발할라.png');
INSERT INTO "file" (id, name, path) VALUES (13, 'XBOX One 레드 데드 리뎀션 2', 'img/product/xbo_레드데드리뎀션2.png');
INSERT INTO "file" (id, name, path) VALUES (14, 'PS5 칼리스토 프로토콜 이미지', 'img/product/ps5_칼리스토프로토콜.png');
INSERT INTO "file" (id, name, path) VALUES (15, 'PS4 칼리스토 프로토콜 이미지', 'img/product/ps4_칼리스토프로토콜.png');
INSERT INTO "file" (id, name, path) VALUES (16, 'PS5 갓 오브 워 라그나로크', 'img/product/ps5_갓오브워라그나로크.png');
INSERT INTO "file" (id, name, path) VALUES (17, 'PS4 갓 오브 워 라그나로크', 'img/product/ps4_갓오브워라그나로크.png');
INSERT INTO "file" (id, name, path) VALUES (18, 'PS5 소닉 프론티어 이미지', 'img/product/ps5_소닉프론티어.png');
INSERT INTO "file" (id, name, path) VALUES (19, 'PS4 소닉 프론티어 이미지', 'img/product/ps4_소닉프론티어.png');
INSERT INTO "file" (id, name, path) VALUES (20, 'SWITCH 소닉 프론티어 이미지', 'img/product/ns_소닉프론티어.png');
INSERT INTO "file" (id, name, path) VALUES (21, 'PS5 페르소나5 로열 이미지', 'img/product/ps5_페르소나5로열.png');
INSERT INTO "file" (id, name, path) VALUES (22, 'SWITCH 페르소나5 로열 이미지', 'img/product/ns_페르소나5로열.png');
INSERT INTO "file" (id, name, path) VALUES (23, 'PS5 피파23 이미지', 'img/product/ps5_피파23.png');
INSERT INTO "file" (id, name, path) VALUES (24, 'PS4 피파23 이미지', 'img/product/ps4_피파23.png');
INSERT INTO "file" (id, name, path) VALUES (25, 'SWITCH 스플래툰3 이미지', 'img/product/ns_스플래툰3.png');
INSERT INTO "file" (id, name, path) VALUES (26, 'PS5 그란 투리스모7 이미지', 'img/product/ps5_그란투리스모7.png');
INSERT INTO "file" (id, name, path) VALUES (27, 'PS4 그란 투리스모7 이미지', 'img/product/ps4_그란투리스모7.png');
INSERT INTO "file" (id, name, path) VALUES (28, 'PS5 엘든링 이미지', 'img/product/ps5_엘든링.png');
INSERT INTO "file" (id, name, path) VALUES (29, 'PS4 엘든링 이미지', 'img/product/ps4_엘든링.png');
INSERT INTO "file" (id, name, path) VALUES (30, '3DS 몬스터헌터 4G 이미지', 'img/product/3ds_몬스터헌터4G.png');

INSERT INTO "promotion" (id, file_id, url) VALUES (1, 1, NULL);
INSERT INTO "promotion" (id, file_id, url) VALUES (2, 2, '/detail/1');
INSERT INTO "promotion" (id, file_id, url) VALUES (3, 3, NULL);

INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (1, 1, 'PS5 호그와트 레거시', '플레이스테이션 액션 RPG 게임', 79800,  4);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (2, 1, 'PS5 더 위쳐 3: 와일드 헌트 컴플리트 에디션', '플레이스테이션 RPG 게임', 54800,  5);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (3, 1, 'PS5 데드 스페이스', '플레이스테이션 어드벤처 게임', 83000,  6);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (4, 1, 'PS5 포스포큰', '플레이스테이션 액션 RPG 게임', 79800,  7);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (5, 3, 'SWITCH 포켓몬스터 스칼렛', '닌텐도 스위치 RPG 게임', 64800,  8);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (6, 3, 'SWITCH 포켓몬스터 바이올렛', '닌텐도 스위치 RPG 게임', 64800,  9);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (7, 3, 'SWITCH 모여봐요 동물의 숲', '닌텐도 스위치 커뮤니케이션 게임', 64000,  10);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (8, 3, 'SWITCH 젤다의 전설 브레스 오브 더 와일드', '플레이스테이션 RPG 게임', 74800,  11);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (9, 2, 'XBOX 어쌔신 크리드: 발할라', '엑스박스 액션 RPG 게임', 65900,  12);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (10, 2, 'XBOX One 레드 데드 리뎀션 2', '엑스박스 오픈월드 어드벤처 게임', 66000,  13);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (11, 1, 'PS5 칼리스토 프로토콜', '플레이스테이션 서바이벌 호러 게임', 77800,  14);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (12, 1, 'PS4 칼리스토 프로토콜', '플레이스테이션 서바이벌 호러 게임', 64800,  15);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (13, 1, 'PS5 갓 오브 워 라그나로크', '플레이스테이션 액션 어드벤처 게임', 79800,  16);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (14, 1, 'PS4 갓 오브 워 라그나로크', '플레이스테이션 액션 어드벤처 게임', 69800,  17);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (15, 1, 'PS5 소닉 프론티어', '플레이스테이션 액션 어드벤처 게임', 49800,  18);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (16, 1, 'PS4 소닉 프론티어', '플레이스테이션 액션 어드벤처 게임', 49800,  19);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (17, 3, 'SWITCH 소닉 프론티어', '닌텐도 스위치 RPG 게임', 49800,  20);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (18, 1, 'PS5 페르소나5 로열', '플레이스테이션 RPG 게임', 69800,  21);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (19, 3, 'SWITCH 페르소나5 로열', '닌텐도 스위치 RPG 게임', 69800,  22);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (20, 1, 'PS5 피파23', '플레이스테이션 스포츠 게임', 83000,  23);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (21, 1, 'PS4 피파23', '플레이스테이션 스포츠 게임', 72000,  24);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (22, 3, 'SWITCH 스플래툰3', '닌텐도 스위치 슈팅액션 게임', 64800,  25);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (23, 1, 'PS5 그란 투리스모7', '플레이스테이션 레이싱 게임', 79800,  26);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (24, 1, 'PS4 그란 투리스모7', '플레이스테이션 RPG 게임', 69800,  27);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (25, 1, 'PS5 엘든링', '플레이스테이션 RPG 게임', 64800,  28);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (26, 1, 'PS4 엘든링', '플레이스테이션 RPG 게임', 64800,  29);
INSERT INTO "product" (id, category_id, title, description, original_price, file_id) VALUES (27, 4, '3DS 몬스터헌터 4G', '닌텐도 스위치 헌터 액션 게임', 49000,  30);

INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (1, '김주원', '테스트_망고', 'test1@gamerental.com', '010-0000-0001', '서울특별시 강남구', 'test1', '$2a$10$iMSgSUC1ip/pnBK6Zh0jdOtkAtl2OfFXaaJQtsTusLVvtUPFIoRVO');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (2, '김하은', '테스트_라면', 'test2@gamerental.com', '010-0000-0002', '서울특별시 강동구', 'test2', '$2a$10$JqarIz51uOm9p2XbL3nG3.dBvP0D9PNNVLko5LoRTGtGlzfJyIDWi');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (3, '박지호', '테스트_도시', 'test3@gamerental.com', '010-0000-0003', '서울특별시 강북구', 'test3', '$2a$10$vfPDGz9ousB9A/jCbxTTFO17Z3HQAeo.UpSB9PWKvHCsBwrGmowH2');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (4, '김서진', '테스트_치킨', 'test4@gamerental.com', '010-0000-0004', '서울특별시 강서구', 'test4', '$2a$10$M6xkxt4dNxF/mjOTk.5KHumctWMG48PqQ0Pld4uc6CCOl/u/phRqS');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (5, '김도현', '테스트_소신', 'test5@gamerental.com', '010-0000-0005', '서울특별시 관악구', 'test5', '$2a$10$lkVoAz5v64Cq9JDCQg6nMeqbzwGC9MOLX6Xsd6XN2GHyMWPeipYS2');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (6, '김수아', '테스트_하늘', 'test6@gamerental.com', '010-0000-0006', '서울특별시 광진구', 'test6', '$2a$10$PhujrjoMsL5g9QbfuczjZuKGAVS1EgQPx8.Vm6VxKx4e3kolw8y2S');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (7, '박선우', '테스트_구름', 'test7@gamerental.com', '010-0000-0007', '서울특별시 구로구', 'test7', '$2a$10$QNje1Kz/jzTibuwb4VAkd.mAJ5Y62PVtvFblzUZvjWvq87eBUZYhy');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (8, '김우진', '테스트_왕관', 'test8@gamerental.com', '010-0000-0008', '서울특별시 금천구', 'test8', '$2a$10$f6vMHXZqUjq4.wocs3lpheKip2W8vJZxPgGB02oSiOjkpnOk419Ni');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (9, '김우진', '테스트_태양', 'test9@gamerental.com', '010-0000-0009', '서울특별시 노원구', 'test9', '$2a$10$wXSnD/wfQdRa0Og8ZPSEyeG9P5JWAJvhMHrYJmW4Y/gjanl9sdQdi');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (10, '김민지', '테스트_마술', 'test10@gamerental.com', '010-0000-0010', '서울특별시 도봉구', 'test10', '$2a$10$gJ9ACev/mJKGGvet.Jc6MOhpnKSj2CdDf7k3c52hgYIz/kbFJm6bS');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (11, '박준혁', '테스트_푸딩', 'test11@gamerental.com', '010-0000-0011', '서울특별시 동대문구', 'test11', '$2a$10$ook1z.FaeCvGq1d57rIc1eIzAPrq59UFl1QFwBeT0l4pTu9D/HU9e');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (12, '박시온', '테스트_초코', 'test12@gamerental.com', '010-0000-0012', '서울특별시 동작구', 'test12', '$2a$10$mBBtcv5VKgNOuOkoJVmWDebt3cLI0txFXsgfF6Y8/UWW7amOpvX2y');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (13, '박준영', '테스트_딸기', 'test13@gamerental.com', '010-0000-0013', '서울특별시 마포구', 'test13', '$2a$10$6lfBw3RdBRUhJVJoSYZgR.dMXIsFFFphqGvbB7Sa.5SGA0TQvpOP2');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (14, '김서은', '테스트_레몬', 'test14@gamerental.com', '010-0000-0014', '인천광역시 계양구', 'test14', '$2a$10$CqYkJqXraS4D6SfOYOD1meqW046pdxVkMgiE8faoPiC.CD08sDXTK');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (15, '김다현', '테스트_쿠션', 'test15@gamerental.com', '010-0000-0015', '경기도 수원시 장안구', 'test15', '$2a$10$gkf8tQEbph7wlD3pf1mMvuIwxIwcwwZDeWRW8YuV4po3/yRwNhQsG');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (16, '박하늘', '테스트_행운', 'test16@gamerental.com', '010-0000-0016', '부산광역시 강서구', 'test16', '$2a$10$WJ0QQRQUOPUA7sHsfV90uOIgL6AomzmxNHFGRtREDmsmRl9glKxV2');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (17, '김성민', '테스트_하프', 'test17@gamerental.com', '010-0000-0017', '대전광역시 대덕구', 'test17', '$2a$10$PIe1CgWOvPj9P6.wggo91uJwpQn.X1d53mZmlrVW9GqNMKHdexlDa');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (18, '박민호', '테스트_감자', 'test18@gamerental.com', '010-0000-0018', '광주광역시 광산구', 'test18', '$2a$10$oDmiXpkimWNrdQjF8U4SS.o12sp4i4v7bT9edPEfz.tg/i5ENSWES');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (19, '박민석', '테스트_돌풍', 'test19@gamerental.com', '010-0000-0019', '울산광역시 남구', 'test19', '$2a$10$Cq883Ri3IxxMG/XQlwSp4.U1e46G3js9J9Iei93tDLv5hJX7C1dSO');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (20, '박민석', '테스트_라떼', 'test20@gamerental.com', '010-0000-0020', '대구광역시 남구', 'test20', '$2a$10$mKZ1m4hUDYsWIAN/IvIjQO3v9Zl8LdKLt4xKkGmmLGRdBSDhbI5cW');
INSERT INTO "users" (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (21, '테스트', '테스트_개발', 'test@gamerental.com', '010-0000-0000', '서울특별시 강남구', 'test', '$2a$10$w6z/si3SB30v2p/YQBcZkOlNtK.Bl1nw3E8qdFzrqB5tpTBserScu');

-- 1번이 렌탈/직거래로 물건 등록만 한 상황
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (1, 1, 1, 1, 1, 6900, 1500, 20000, '[테스트] 싸게 거래합니다', 0);
-- 2번이 렌탈/직거래로 물건 등록만 한 상황
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (2, 1, 2, 1, 1, 7900, 1500, NULL, '[테스트] 빠르게 빌려드립니다', 0);

-- 1번이 렌탈/택배로 물건 등록, 2번이 구매신청, 현재 입금대기 상태
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (3, 1, 1, 1, 0, 6000, 1500, NULL, '물건 빌려드려요', 1);
INSERT INTO "deal" (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (1, 3, 2, 6000, 0, NULL);
-- 1번이 렌탈/택배로 물건 등록, 3번이 구매신청, 현재 구매자입금 상태
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (4, 1, 1, 1, 0, 7000, 2000, NULL, '물건 빌려드려요!', 1);
INSERT INTO "deal" (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (2, 4, 3, 9000, 1, NULL);
-- 1번이 렌탈/택배로 물건 등록, 4번이 구매신청, 현재 렌탈중 상태
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (5, 1, 1, 1, 0, 8000, 2500, 10000, '물건 빌려드려요@', 1);
INSERT INTO "deal" (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (3, 5, 4, 18000, 2, NULL);
-- 1번이 렌탈/택배로 물건 등록, 5번이 구매신청, 현재 종료예정 상태
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (6, 1, 1, 1, 0, 9000, 3000, 20000, '물건 빌려드려요~', 1);
INSERT INTO "deal" (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (4, 6, 5, 29000, 3, NULL);
-- 1번이 렌탈/택배로 물건 등록, 6번이 구매신청, 현재 거래종료 상태
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (7, 1, 1, 1, 0, 10000, 4000, 3000, '물건 빌려드려요!!', 2);
INSERT INTO "deal" (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (5, 7, 6, 17000, 4, NULL);
-- 1번이 렌탈/직거래로 물건 등록, 7번이 구매신청, 현재 거래전 상태
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (8, 1, 1, 1, 1, 6500, 1500, NULL, '물건 빌려드려요@@', 1);
INSERT INTO "deal" (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (6, 8, 7, 8000, 0, NULL);
-- 1번이 렌탈/직거래로 물건 등록, 8번이 구매신청, 현재 렌탈중 상태
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (9, 1, 1, 1, 1, 7500, 2500, 10000, '물건 빌려드려요~~', 1);
INSERT INTO "deal" (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (7, 9, 8, 20000, 2, NULL);
-- 1번이 렌탈/직거래로 물건 등록, 9번이 구매신청, 현재 거래종료 상태
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (10, 1, 1, 1, 1, 8500, 3500, 20000, '물건 빌려드려요!!!', 2);
INSERT INTO "deal" (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (8, 10, 9, 28500, 4, NULL);
-- 1번이 중고/택배로 물건 등록, 10번이 구매신청, 현재 거래전 상태
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (11, 1, 1, 0, 0, 30000, NULL, NULL, '물건 팝니다', 1);
INSERT INTO "deal" (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (9, 11, 10, 30000, 0, NULL);
-- 1번이 중고/택배로 물건 등록, 11번이 구매신청, 현재 구매자입금 상태
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (12, 1, 1, 0, 0, 35000, NULL, NULL, '물건 팝니다!', 1);
INSERT INTO "deal" (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (10, 12, 11, 35000, 1, NULL);
-- 1번이 중고/택배로 물건 등록, 12번이 구매신청, 현재 거래종료 상태
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (13, 1, 1, 0, 0, 40000, NULL, NULL, '물건 팝니다~', 2);
INSERT INTO "deal" (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (11, 13, 12, 40000, 4, NULL);
-- 1번이 중고/직거래로 물건 등록, 13번이 구매신청, 현재 거래전 상태
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (14, 1, 1, 0, 1, 22000, NULL, NULL, '물건 팝니다!!', 1);
INSERT INTO "deal" (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (12, 14, 13, 22000, 0, NULL);
-- 1번이 중고/직거래로 물건 등록, 14번이 구매신청, 현재 거래종료 상태
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (15, 1, 1, 0, 1, 32000, NULL, NULL, '물건 팝니다~~', 2);
INSERT INTO "deal" (id, post_id, buyer_users_id, total_price, status, expiration_date) VALUES (13, 15, 14, 32000, 4, NULL);

-- 여러 경로로 서로 다른 사람이 물건 등록
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (16, 1, 5, 1, 1, 8000, 2500, 20000, '[테스트] 빠른 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (17, 1, 6, 1, 1, 9000, 2000, 15000, '[테스트] 빠르게 직거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (18, 1, 7, 1, 1, 10000, NULL, NULL, '[테스트] 즉시 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (19, 1, 8, 1, 1, 11000, 1000, NULL, '[테스트] 빠르게 합니다!!', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (20, 1, 9, 1, 0, 12000, NULL, NULL, '[테스트] 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (21, 1, 10, 1, 0, 12500, 1000, NULL, '[테스트] 빨리 보냅니다!', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (22, 1, 11, 0, 1, 40000, NULL, NULL, '[테스트] 중고로 싸게 팔아요~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (23, 1, 12, 0, 1, 42000, NULL, NULL, '[테스트] 급하게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (24, 1, 13, 0, 0, 45000, NULL, NULL, '[테스트] 중고 택포 싸게 팝니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (25, 1, 14, 0, 0, 47000, NULL, NULL, '[테스트] 중고로 싸게 팝니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (26, 2, 1, 1, 1, 5000, 2500, 30000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (27, 2, 2, 1, 1, 8000, 2000, 20000, '[테스트] 빠른 직거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (28, 2, 3, 1, 1, 8500, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (29, 2, 4, 1, 1, 9000, 1000, NULL, '[테스트] 빠르게 렌탈합니다!!', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (30, 2, 5, 1, 0, 10000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (31, 2, 6, 1, 0, 11500, 1000, NULL, '[테스트] 빠르게 보냅니다!', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (32, 2, 7, 0, 1, 30000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (33, 2, 8, 0, 1, 35000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (34, 2, 9, 0, 0, 42000, NULL, NULL, '[테스트] 택배로 싸게 팝니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (35, 2, 10, 0, 0, 45000, NULL, NULL, '[테스트] 중고로 싸게 매각합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (36, 3, 11, 1, 1, 7000, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (37, 3, 12, 1, 0, 8500, 2000, 15000, '[테스트] 빠른 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (38, 3, 13, 1, 0, 10000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (39, 3, 14, 1, 0, 11500, 1000, NULL, '[테스트] 빠르게 보냅니다!', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (40, 3, 15, 0, 1, 34000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (41, 3, 16, 0, 0, 38000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (42, 3, 17, 0, 0, 42000, NULL, NULL, '[테스트] 택배로 싸게 팝니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (43, 3, 18, 0, 0, 45000, NULL, NULL, '[테스트] 중고로 싸게 매각합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (44, 4, 11, 1, 1, 6500, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (45, 4, 12, 1, 0, 8000, 2000, 15000, '[테스트] 빠른 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (46, 4, 13, 1, 0, 10000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (47, 4, 14, 1, 0, 11500, 1000, NULL, '[테스트] 빠르게 보냅니다!', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (48, 4, 15, 0, 1, 44000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (49, 4, 16, 0, 0, 49000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (50, 4, 17, 0, 0, 52000, NULL, NULL, '[테스트] 택배로 싸게 팝니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (51, 4, 18, 0, 0, 55000, NULL, NULL, '[테스트] 중고로 싸게 매각합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (52, 5, 11, 1, 1, 7200, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (53, 5, 12, 1, 0, 8500, 2000, 15000, '[테스트] 빠른 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (54, 5, 13, 1, 0, 10000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (55, 5, 14, 1, 0, 11500, 1000, NULL, '[테스트] 빠르게 보냅니다!', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (56, 5, 15, 0, 1, 37000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (57, 5, 16, 0, 0, 38000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (58, 5, 17, 0, 0, 42000, NULL, NULL, '[테스트] 택배로 싸게 팝니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (59, 5, 18, 0, 0, 45000, NULL, NULL, '[테스트] 중고로 싸게 매각합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (60, 6, 11, 1, 1, 8000, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (61, 6, 12, 1, 0, 8500, 2000, 15000, '[테스트] 빠른 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (62, 6, 13, 1, 0, 10000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (63, 6, 14, 1, 0, 11500, 1000, NULL, '[테스트] 빠르게 보냅니다!', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (64, 6, 15, 0, 1, 29000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (65, 6, 16, 0, 0, 38000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (66, 6, 17, 0, 0, 42000, NULL, NULL, '[테스트] 택배로 싸게 팝니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (67, 6, 18, 0, 0, 45000, NULL, NULL, '[테스트] 중고로 싸게 매각합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (68, 7, 1, 1, 1, 7000, 2500, 30000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (69, 7, 2, 1, 1, 8000, 2000, 20000, '[테스트] 빠른 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (70, 7, 3, 1, 1, 9000, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (71, 7, 4, 1, 1, 10000, 1000, NULL, '[테스트] 빠르게 렌탈합니다!!', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (72, 7, 5, 1, 0, 11000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (73, 7, 6, 1, 0, 11000, 1000, NULL, '[테스트] 빠르게 보냅니다!', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (74, 8, 7, 0, 1, 40000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (75, 8, 8, 0, 1, 42000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (76, 8, 9, 0, 0, 43000, NULL, NULL, '[테스트] 택배로 싸게 팝니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (77, 8, 10, 0, 0, 45000, NULL, NULL, '[테스트] 중고로 싸게 매각합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (78, 9, 11, 1, 1, 7200, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (79, 9, 12, 1, 1, 8400, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (80, 9, 13, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (81, 9, 14, 0, 1, 30000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (82, 9, 15, 0, 0, 36000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (83, 10, 1, 1, 1, 7500, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (84, 10, 2, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (85, 10, 3, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (86, 10, 4, 0, 1, 40000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (87, 10, 5, 0, 0, 42000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (88, 11, 6, 1, 1, 7900, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (89, 11, 7, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (90, 11, 8, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (91, 11, 9, 0, 1, 34000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (92, 11, 10, 0, 0, 36000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (93, 12, 11, 1, 1, 7200, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (94, 12, 12, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (95, 12, 13, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (96, 12, 14, 0, 1, 35000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (97, 12, 15, 0, 0, 36000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (98, 13, 16, 1, 1, 7500, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (99, 13, 17, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (100, 13, 18, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (101, 13, 19, 0, 1, 33000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (102, 13, 20, 0, 0, 36000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (103, 14, 1, 1, 1, 6500, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (104, 14, 2, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (105, 14, 3, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (106, 14, 4, 0, 1, 29000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (107, 14, 5, 0, 0, 36000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (108, 15, 6, 1, 1, 7200, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (109, 15, 7, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (110, 15, 8, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (111, 15, 9, 0, 1, 38000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (112, 15, 10, 0, 0, 41000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (113, 16, 11, 1, 1, 7000, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (114, 16, 12, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (115, 16, 13, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (116, 16, 14, 0, 1, 30000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (117, 16, 15, 0, 0, 36000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (118, 17, 16, 1, 1, 7000, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (119, 17, 17, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (120, 17, 18, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (121, 17, 19, 0, 1, 31000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (122, 17, 20, 0, 0, 36000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (123, 18, 1, 1, 1, 8500, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (124, 18, 2, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (125, 18, 3, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (126, 18, 4, 0, 1, 33000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (127, 18, 5, 0, 0, 36000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (128, 19, 6, 1, 1, 7400, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (129, 19, 7, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (130, 19, 8, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (131, 19, 9, 0, 1, 32000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (132, 19, 10, 0, 0, 36000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (133, 20, 11, 1, 1, 6500, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (134, 20, 12, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (135, 20, 13, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (136, 20, 14, 0, 1, 33000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (137, 20, 15, 0, 0, 36000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (138, 21, 16, 1, 1, 8500, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (139, 21, 17, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (140, 21, 18, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (141, 21, 19, 0, 1, 30000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (142, 21, 20, 0, 0, 36000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (143, 22, 1, 1, 1, 6500, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (144, 22, 2, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (145, 22, 3, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (146, 22, 4, 0, 1, 28500, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (147, 22, 5, 0, 0, 36000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (148, 23, 6, 1, 1, 8500, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (149, 23, 7, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (150, 23, 8, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (151, 23, 9, 0, 1, 30000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (152, 23, 10, 0, 0, 36000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (153, 24, 11, 1, 1, 7400, 2500, 20000, '[테스트] 빠르게 거래합니다.', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (154, 24, 12, 1, 1, 8800, NULL, 10000, '[테스트] 즉시 바로 거래합니다~', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (155, 24, 13, 1, 0, 9000, NULL, NULL, '[테스트] 빠른 택배로 거래합니다~', 0);

INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (156, 25, 14, 0, 1, 30000, NULL, NULL, '[테스트] 중고로 싸게 팝니다', 0);
INSERT INTO "post" (id, product_id, seller_users_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (157, 25, 15, 0, 0, 36000, NULL, NULL, '[테스트] 급하게 쳐분합니다.', 0);

INSERT INTO "chat_message" (id, deal_id, deal_post_id, sender, message) VALUES (1, 1, 3, 1, '안녕하세요');
