SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `user` CASCADE;
DROP TABLE IF EXISTS `file` CASCADE;
DROP TABLE IF EXISTS `category` CASCADE;
DROP TABLE IF EXISTS `product` CASCADE;
DROP TABLE IF EXISTS `deal` CASCADE;
DROP TABLE IF EXISTS `chat_message` CASCADE;
DROP TABLE IF EXISTS `promotion` CASCADE;
SET foreign_key_checks = 1;

CREATE TABLE IF NOT EXISTS `user` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `nickname` VARCHAR(45) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `tel` VARCHAR(45) NOT NULL,
    `home_address` VARCHAR(255) NULL DEFAULT NULL COMMENT '직거래 검색을 위한 주소로 상세주소 필요X',
    `login_id` VARCHAR(255) NOT NULL,
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
    `create_date` DATETIME NOT NULL DEFAULT NOW(),
    `modify_date` DATETIME NOT NULL DEFAULT NOW(),
    `file_id` INT(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `file_id`
    FOREIGN KEY (`file_id`)
    REFERENCES `file` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `deal` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `direct_flag` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '직거래일경우 1, 택배거래일 경우 0',
    `rental_flag` TINYINT(1) NOT NULL COMMENT '렌탈일 경우 1, 직거래일 경우 0',
    `seller_user_id` INT(11) NOT NULL,
    `buyer_user_id` INT(11) NULL DEFAULT NULL,
    `status` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '거래대기 0, 예약중(구매자등장) 1, 인계완료(대금받고 구매자에게 전달, 렌탈이 아닌 거래는 바로 거래종료로 이동함) 2, 거래종료(판매자에게 다시 반납) 3, 거래취소 -1',
    `price` INT(11) NOT NULL,
    `extension_price` INT(11) NULL DEFAULT NULL COMMENT '3주 초과시 1주당 초과요금',
    `deposit` INT(11) NOT NULL DEFAULT 0 COMMENT '보증금(판매자가 설정가능함)',
    `product_id` INT(11) NOT NULL,
    `create_date` DATETIME NOT NULL DEFAULT NOW(),
    `comment` VARCHAR(2000) NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `seller_user_id`
    FOREIGN KEY (`seller_user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `buyer_user_id`
    FOREIGN KEY (`buyer_user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `chat_message` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `deal_id` INT(11) NOT NULL,
    `create_date` DATETIME NOT NULL DEFAULT NOW(),
    `message` VARCHAR(2000) NOT NULL,
    `sender` TINYINT(1) NOT NULL COMMENT '판매자가 보내는 메시지 1, 구매자가 보내는 메시지 2',
    PRIMARY KEY (`id`),
    CONSTRAINT `deal_id`
    FOREIGN KEY (`deal_id`)
    REFERENCES `deal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `promotion` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `file_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_promotion_file1`
    FOREIGN KEY (`file_id`)
    REFERENCES `file` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB DEFAULT CHARSET=utf8;