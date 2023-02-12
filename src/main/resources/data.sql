INSERT INTO `category` (id, name) VALUES (1, 'PS5/PS4');
INSERT INTO `category` (id, name) VALUES (2, 'XSX');
INSERT INTO `category` (id, name) VALUES (3, 'SWITCH');
INSERT INTO `category` (id, name) VALUES (4, 'Others');

INSERT INTO `file` (id, name, path) VALUES (1, 'ps5 상품 이미지1', 'img/product/ps5_a.png');
INSERT INTO `file` (id, name, path) VALUES (2, 'ps5 상품 이미지2', 'img/product/ps5_b.png');
INSERT INTO `file` (id, name, path) VALUES (3, 'ps5 상품 이미지3', 'img/product/ps5_c.png');
INSERT INTO `file` (id, name, path) VALUES (4, 'ps5 상품 이미지4', 'img/product/ps5_d.png');
INSERT INTO `file` (id, name, path) VALUES (5, 'ps5 상품 이미지5', 'img/product/ps5_e.png');
INSERT INTO `file` (id, name, path) VALUES (6, 'ps5 상품 이미지6', 'img/product/ps5_f.png');
INSERT INTO `file` (id, name, path) VALUES (7, 'ps4 상품 이미지1', 'img/product/ps4_a.png');
INSERT INTO `file` (id, name, path) VALUES (8, 'ps4 상품 이미지2', 'img/product/ps4_b.png');
INSERT INTO `file` (id, name, path) VALUES (9, 'ps4 상품 이미지3', 'img/product/ps4_c.png');
INSERT INTO `file` (id, name, path) VALUES (10, 'ps4 상품 이미지4', 'img/product/ps4_d.png');
INSERT INTO `file` (id, name, path) VALUES (11, 'ps4 상품 이미지5', 'img/product/ps4_e.png');
INSERT INTO `file` (id, name, path) VALUES (12, 'ps4 상품 이미지6', 'img/product/ps4_f.png');
INSERT INTO `file` (id, name, path) VALUES (13, 'xbox x 상품 이미지1', 'img/product/xbx_a.png');
INSERT INTO `file` (id, name, path) VALUES (14, 'xbox x 상품 이미지2', 'img/product/xbx_b.png');
INSERT INTO `file` (id, name, path) VALUES (15, 'xbox x 상품 이미지3', 'img/product/xbx_c.png');
INSERT INTO `file` (id, name, path) VALUES (16, 'xbox x 상품 이미지4', 'img/product/xbx_d.png');
INSERT INTO `file` (id, name, path) VALUES (17, 'xbox x 상품 이미지5', 'img/product/xbx_e.png');
INSERT INTO `file` (id, name, path) VALUES (18, 'xbox x 상품 이미지6', 'img/product/xbx_f.png');
INSERT INTO `file` (id, name, path) VALUES (19, 'xbox one 상품 이미지1', 'img/product/xbo_a.png');
INSERT INTO `file` (id, name, path) VALUES (20, 'xbox one 상품 이미지2', 'img/product/xbo_b.png');
INSERT INTO `file` (id, name, path) VALUES (21, 'xbox one 상품 이미지3', 'img/product/xbo_c.png');
INSERT INTO `file` (id, name, path) VALUES (22, 'xbox one 상품 이미지4', 'img/product/xbo_d.png');
INSERT INTO `file` (id, name, path) VALUES (23, 'xbox one 상품 이미지5', 'img/product/xbo_e.png');
INSERT INTO `file` (id, name, path) VALUES (24, 'xbox one 상품 이미지6', 'img/product/xbo_f.png');
INSERT INTO `file` (id, name, path) VALUES (25, 'switch 상품 이미지1', 'img/product/ns_a.png');
INSERT INTO `file` (id, name, path) VALUES (26, 'switch 상품 이미지2', 'img/product/ns_b.png');
INSERT INTO `file` (id, name, path) VALUES (27, 'switch 상품 이미지3', 'img/product/ns_c.png');
INSERT INTO `file` (id, name, path) VALUES (28, 'switch 상품 이미지4', 'img/product/ns_d.png');
INSERT INTO `file` (id, name, path) VALUES (29, 'switch 상품 이미지5', 'img/product/ns_e.png');
INSERT INTO `file` (id, name, path) VALUES (30, 'switch 상품 이미지6', 'img/product/ns_f.png');
INSERT INTO `file` (id, name, path) VALUES (31, '기타 상품 이미지1', 'img/product/etc_a.png');
INSERT INTO `file` (id, name, path) VALUES (32, '기타 상품 이미지2', 'img/product/etc_b.png');
INSERT INTO `file` (id, name, path) VALUES (33, '기타 상품 이미지3', 'img/product/etc_c.png');
INSERT INTO `file` (id, name, path) VALUES (34, '기타 상품 이미지4', 'img/product/etc_d.png');
INSERT INTO `file` (id, name, path) VALUES (35, '기타 상품 이미지5', 'img/product/etc_e.png');
INSERT INTO `file` (id, name, path) VALUES (36, '기타 상품 이미지6', 'img/product/etc_f.png');
INSERT INTO `file` (id, name, path) VALUES (37, '프로모션 이미지1', 'img/promotion/a.png');
INSERT INTO `file` (id, name, path) VALUES (38, '프로모션 이미지2', 'img/promotion/b.png');
INSERT INTO `file` (id, name, path) VALUES (39, '프로모션 이미지3', 'img/promotion/c.png');

INSERT INTO `promotion` (id, file_id, url) VALUES (1, 37, '/main');
INSERT INTO `promotion` (id, file_id, url) VALUES (2, 38, NULL);
INSERT INTO `promotion` (id, file_id, url) VALUES (3, 39, NULL);

INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (1, 1, 'PS5 타이틀 1번', '플레이스테이션 타이틀', 54000,  1);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (2, 1, 'PS5 타이틀 2번', '플레이스테이션 타이틀', 59000,  2);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (3, 1, 'PS5 타이틀 3번', '플레이스테이션 타이틀', 69000,  3);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (4, 1, 'PS5 타이틀 4번', '플레이스테이션 타이틀', 64000,  4);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (5, 1, 'PS5 타이틀 5번', '플레이스테이션 타이틀', 39000,  5);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (6, 1, 'PS5 타이틀 6번', '플레이스테이션 타이틀', 30000,  6);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (7, 1, 'PS5 타이틀 7번', '플레이스테이션 타이틀', 29000,  1);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (8, 1, 'PS5 타이틀 8번', '플레이스테이션 타이틀', 49000,  2);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (9, 1, 'PS5 타이틀 9번', '플레이스테이션 타이틀', 59000,  3);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (10, 1, 'PS5 타이틀 10번', '플레이스테이션 타이틀', 79000,  4);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (11, 1, 'PS5 타이틀 11번', '플레이스테이션 타이틀', 69000,  5);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (12, 1, 'PS5 타이틀 12번', '플레이스테이션 타이틀', 89000,  6);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (13, 1, 'PS4 타이틀 1번', '플레이스테이션 타이틀', 54000,  7);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (14, 1, 'PS4 타이틀 2번', '플레이스테이션 타이틀', 59000,  8);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (15, 1, 'PS4 타이틀 3번', '플레이스테이션 타이틀', 69000,  9);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (16, 1, 'PS4 타이틀 4번', '플레이스테이션 타이틀', 64000,  10);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (17, 1, 'PS4 타이틀 5번', '플레이스테이션 타이틀', 39000,  11);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (18, 1, 'PS4 타이틀 6번', '플레이스테이션 타이틀', 30000,  12);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (19, 2, 'XBOX X 타이틀 1번', '엑스박스 타이틀', 64000,  13);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (20, 2, 'XBOX X 타이틀 2번', '엑스박스 타이틀', 69000,  14);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (21, 2, 'XBOX X 타이틀 3번', '엑스박스 타이틀', 79000,  15);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (22, 2, 'XBOX X 타이틀 4번', '엑스박스 타이틀', 74000,  16);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (23, 2, 'XBOX X 타이틀 5번', '엑스박스 타이틀', 35000,  17);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (24, 2, 'XBOX X 타이틀 6번', '엑스박스 타이틀', 37000,  18);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (25, 2, 'XBOX One 타이틀 1번', '엑스박스 타이틀', 54000,  19);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (26, 2, 'XBOX One 타이틀 2번', '엑스박스 타이틀', 59000,  20);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (27, 2, 'XBOX One 타이틀 3번', '엑스박스 타이틀', 69000,  21);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (28, 2, 'XBOX One 타이틀 4번', '엑스박스 타이틀', 64000,  22);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (29, 2, 'XBOX One 타이틀 5번', '엑스박스 타이틀', 25000,  23);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (30, 2, 'XBOX One 타이틀 6번', '엑스박스 타이틀', 29000,  24);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (31, 3, 'SWITCH 타이틀 1번', '스위치 타이틀', 64000,  25);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (32, 3, 'SWITCH 타이틀 2번', '스위치 타이틀', 69000,  26);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (33, 3, 'SWITCH 타이틀 3번', '스위치 타이틀', 79000,  27);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (34, 3, 'SWITCH 타이틀 4번', '스위치 타이틀', 67000,  28);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (35, 3, 'SWITCH 타이틀 5번', '스위치 타이틀', 34000,  29);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (36, 3, 'SWITCH 타이틀 6번', '스위치 타이틀', 39000,  30);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (37, 4, '기타 타이틀 1번', '기타 타이틀', 24000,  31);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (38, 4, '기타 타이틀 2번', '기타 타이틀', 29000,  32);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (39, 4, '기타 타이틀 3번', '기타 타이틀', 39000,  33);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (40, 4, '기타 타이틀 4번', '기타 타이틀', 37000,  34);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (41, 4, '기타 타이틀 5번', '기타 타이틀', 24000,  35);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (42, 4, '기타 타이틀 6번', '기타 타이틀', 29000,  36);

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
