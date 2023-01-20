INSERT INTO `category` (id, name) VALUES (1, 'PS5/PS4');
INSERT INTO `category` (id, name) VALUES (2, 'XSX');
INSERT INTO `category` (id, name) VALUES (3, 'SWITCH');
INSERT INTO `category` (id, name) VALUES (4, 'PC');
INSERT INTO `category` (id, name) VALUES (5, 'MOBILE');
INSERT INTO `category` (id, name) VALUES (6, 'VR');

INSERT INTO `file` (id, name, path) VALUES (1, '이미지1', 'img/img1');
INSERT INTO `file` (id, name, path) VALUES (2, '이미지2', 'img/img2');
INSERT INTO `file` (id, name, path) VALUES (3, '이미지3', 'img/img3');
INSERT INTO `file` (id, name, path) VALUES (4, '이미지4', 'img/img4');
INSERT INTO `file` (id, name, path) VALUES (5, '이미지5', 'img/img5');
INSERT INTO `file` (id, name, path) VALUES (6, '이미지6', 'img/img6');
INSERT INTO `file` (id, name, path) VALUES (7, '이미지7', 'img/img7');
INSERT INTO `file` (id, name, path) VALUES (8, '이미지8', 'img/img8');
INSERT INTO `file` (id, name, path) VALUES (9, '이미지9', 'img/img9');
INSERT INTO `file` (id, name, path) VALUES (10, '프로모션 이미지1', 'img/promotionImg1');
INSERT INTO `file` (id, name, path) VALUES (11, '프로모션 이미지2', 'img/promotionImg2');
INSERT INTO `file` (id, name, path) VALUES (12, '프로모션 이미지3', 'img/promotionImg3');

INSERT INTO `promotion` (id, file_id, url) VALUES (1, 10, '/main');
INSERT INTO `promotion` (id, file_id, url) VALUES (2, 11, NULL);
INSERT INTO `promotion` (id, file_id, url) VALUES (3, 12, NULL);

INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (1, 1, 'PlayStation title A', '플레이스테이션 타이틀 A', 59000,  1);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (2, 1, 'PlayStation title B', '플레이스테이션 타이틀 B', 69000,  2);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (3, 1, 'PlayStation title C', '플레이스테이션 타이틀 C', 64000,  3);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (4, 2, 'XBOX title D', '엑스박스 타이틀 D', 49000,  4);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (5, 2, 'XBOX title E', '엑스박스 타이틀 E', 59000,  5);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (6, 2, 'XBOX title F', '엑스박스 타이틀 F', 79000,  6);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (7, 3, 'SWITCH title G', '스위치 타이틀 G', 38000,  7);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (8, 3, 'SWITCH title H', '스위치 타이틀 H', 64000,  8);
INSERT INTO `product` (id, category_id, title, description, original_price, file_id) VALUES (9, 4, 'PC title I', 'PC 타이틀 I', 70000,  9);

INSERT INTO `user` (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (1, '갑', 'AAA', 'AAA@gmail.com', '010-1111-1111', '서울', 'AAA123', '1234');
INSERT INTO `user` (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (2, '을', 'BBB', 'BBB@gmail.com', '010-2222-2222', '인천', 'BBB456', '4567');
INSERT INTO `user` (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (3, '병', 'CCC', 'CCC@gmail.com', '010-3333-3333', '경기', 'CCC789', '7890');
INSERT INTO `user` (id, name, nickname, email, tel, home_address, login_id, login_password) VALUES (4, '정', 'DDD', 'DDD@gmail.com', '010-4444-4444', '부산', 'DDD369', '3690');

-- 갑이 렌탈/직거래로 물건 등록만 한 상황
INSERT INTO `post` (id, product_id, seller_user_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (1, 1, 1, 1, 1, 6900, 1500, 20000, '싸게 거래합니다', 0);
-- 을이 렌탈/택배로 물건 등록만 한 상황
INSERT INTO `post` (id, product_id, seller_user_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (2, 1, 2, 1, 0, 7900, 1500, NULL, '빠르게 빌려드립니다', 0);
-- 병이 렌탈/직거래로 물건 등록하고 정이 구매신청을 한 상황
INSERT INTO `post` (id, product_id, seller_user_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (3, 1, 3, 1, 1, 6000, 1500, NULL, '물건 빌려드립니다', 1);
INSERT INTO `deal` (id, post_id, buyer_user_id, total_price, status, expiration_date) VALUES (1, 3, 4, 6000, 0, NULL);
-- 갑이 중고/직거래로 물건을 등록하고 정과 거래를 완료한 상황
INSERT INTO `post` (id, product_id, seller_user_id, rental_flag, direct_flag, price, extension_price, deposit, comment, status) VALUES (4, 1, 1, 0, 0, 20000, NULL, NULL, '중고로 싸게 팝니다', 2);
INSERT INTO `deal` (id, post_id, buyer_user_id, total_price, status, expiration_date) VALUES (2, 4, 4, 20000, 0, NULL);

INSERT INTO `chat_message` (id, deal_id, deal_post_id, sender, message) VALUES (1, 1, 3, 1, '안녕하세요');
