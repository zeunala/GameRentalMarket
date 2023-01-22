SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `users` CASCADE;
DROP TABLE IF EXISTS `file` CASCADE;
DROP TABLE IF EXISTS `category` CASCADE;
DROP TABLE IF EXISTS `product` CASCADE;
DROP TABLE IF EXISTS `post` CASCADE;
DROP TABLE IF EXISTS `deal` CASCADE;
DROP TABLE IF EXISTS `chat_message` CASCADE;
DROP TABLE IF EXISTS `promotion` CASCADE;
SET foreign_key_checks = 1;

CREATE TABLE IF NOT EXISTS `users` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `nickname` VARCHAR(45) NOT NULL UNIQUE,
    `email` VARCHAR(255) NOT NULL UNIQUE,
    `tel` VARCHAR(45) NOT NULL UNIQUE,
    `home_address` VARCHAR(255) NULL DEFAULT NULL COMMENT '직거래 검색을 위한 주소로 상세주소 필요X',
    `login_id` VARCHAR(255) NOT NULL UNIQUE,
    `login_password` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `file` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `path` VARCHAR(2000) NOT NULL,
    `create_date` DATETIME NOT NULL DEFAULT NOW(),
    `modify_date` DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `category` (
    `id` INT(11) NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `product` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `category_id` INT(11) NOT NULL,
    `title` VARCHAR(255) NOT NULL,
    `description` VARCHAR(2000) NULL,
    `original_price` INT(11) NOT NULL,
    `file_id` INT(11) NULL DEFAULT NULL,
    `create_date` DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`file_id`)
    REFERENCES `file` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `post` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `product_id` INT(11) NOT NULL,
    `seller_users_id` INT(11) NOT NULL,
    `rental_flag` TINYINT(1) NOT NULL COMMENT '렌탈일 경우 1, 직거래일 경우 0',
    `direct_flag` TINYINT(1) NOT NULL COMMENT '직거래일경우 1, 택배거래일 경우 0',
    `price` INT(11) NOT NULL,
    `extension_price` INT(11) NULL DEFAULT NULL COMMENT '3주 초과시 1주당 초과요금',
    `deposit` INT(11) NULL DEFAULT NULL COMMENT '보증금(판매자가 설정가능함)',
    `comment` VARCHAR(2000) NULL DEFAULT NULL,
    `create_date` DATETIME NOT NULL DEFAULT NOW(),
    `status` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '대기물품 0, 거래중 1, 거래종료 2',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`seller_users_id`)
    REFERENCES `users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `deal` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `post_id` INT(11) NOT NULL,
    `buyer_users_id` INT(11) NOT NULL,
    `total_price` INT(11) NOT NULL,
    `create_date` DATETIME NOT NULL DEFAULT NOW(),
    `status` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '예약중(구매자등장) 0, 판매자 인계완료 1, 구매자 인수완료 2, 렌탈중 3(렌탈이 아닌 거래는 바로 거래종료로 이동), 구매자 반환완료 4, 판매자 반환수령 5, 거래종료 6',
    `expiration_date` DATETIME NULL,
    PRIMARY KEY (`id`, `post_id`),
    FOREIGN KEY (`buyer_users_id`)
    REFERENCES `users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`post_id`)
    REFERENCES `post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `chat_message` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `deal_id` INT(11) NOT NULL,
    `deal_post_id` INT(11) NOT NULL,
    `sender` TINYINT(1) NOT NULL COMMENT '판매자가 보내는 메시지 1, 구매자가 보내는 메시지 2',
    `message` VARCHAR(2000) NOT NULL,
    `create_date` DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY (`id`, `deal_id`, `deal_post_id`),
    FOREIGN KEY (`deal_id` , `deal_post_id`)
    REFERENCES `deal` (`id` , `post_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `promotion` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `file_id` INT(11) NOT NULL,
    `url` VARCHAR(2000) NULL COMMENT '프로모션 링크 클릭시 URL',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`file_id`)
    REFERENCES `file` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET=utf8;
