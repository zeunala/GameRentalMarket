DROP TABLE IF EXISTS "users" CASCADE;
DROP TABLE IF EXISTS "file" CASCADE;
DROP TABLE IF EXISTS "category" CASCADE;
DROP TABLE IF EXISTS "product" CASCADE;
DROP TABLE IF EXISTS "post" CASCADE;
DROP TABLE IF EXISTS "deal" CASCADE;
DROP TABLE IF EXISTS "chat_message" CASCADE;
DROP TABLE IF EXISTS "promotion" CASCADE;

CREATE TABLE IF NOT EXISTS "users"
(
    "id"             SERIAL PRIMARY KEY,
    "name"           VARCHAR(45)  NOT NULL,
    "nickname"       VARCHAR(45)  NOT NULL UNIQUE,
    "email"          VARCHAR(255) NOT NULL UNIQUE,
    "tel"            VARCHAR(45)  NOT NULL,
    "home_address"   VARCHAR(255) DEFAULT NULL,
    "login_id"       VARCHAR(255) NOT NULL UNIQUE,
    "login_password" VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS "file"
(
    "id"          SERIAL PRIMARY KEY,
    "name"        VARCHAR(255)  NOT NULL,
    "path"        VARCHAR(2000) NOT NULL,
    "create_date" TIMESTAMP     NOT NULL DEFAULT NOW(),
    "modify_date" TIMESTAMP     NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS "category"
(
    "id"   INT PRIMARY KEY NOT NULL,
    "name" VARCHAR(45)     NOT NULL
);

CREATE TABLE IF NOT EXISTS "product"
(
    "id"             SERIAL PRIMARY KEY,
    "category_id"    INT          NOT NULL,
    "title"          VARCHAR(255) NOT NULL,
    "description"    VARCHAR(2000),
    "original_price" INT          NOT NULL,
    "file_id"        INT,
    "create_date"    TIMESTAMP    NOT NULL DEFAULT NOW(),
    FOREIGN KEY (file_id) REFERENCES "file" (id) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY (category_id) REFERENCES "category" (id) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS "post"
(
    "id"              SERIAL PRIMARY KEY,
    "product_id"      INT       NOT NULL,
    "seller_users_id" INT       NOT NULL,
    "rental_flag"     SMALLINT  NOT NULL CHECK ("rental_flag" IN (0, 1)),
    "direct_flag"     SMALLINT  NOT NULL CHECK ("direct_flag" IN (0, 1)),
    "price"           INT       NOT NULL,
    "extension_price" INT,
    "deposit"         INT,
    "comment"         VARCHAR(2000),
    "create_date"     TIMESTAMP NOT NULL DEFAULT NOW(),
    "status"          INT       NOT NULL DEFAULT 0,
    FOREIGN KEY (seller_users_id) REFERENCES "users" (id) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY (product_id) REFERENCES "product" (id) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS "deal"
(
    "id"              SERIAL PRIMARY KEY,
    "post_id"         INT      NOT NULL,
    "buyer_users_id"  INT      NOT NULL,
    "total_price"     INT      NOT NULL,
    "create_date"     TIMESTAMP         DEFAULT NOW(),
    "status"          SMALLINT NOT NULL DEFAULT 0,
    "expiration_date" TIMESTAMP,
    FOREIGN KEY (buyer_users_id) REFERENCES "users" (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (post_id) REFERENCES "post" (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    UNIQUE (id, post_id)
);

CREATE TABLE IF NOT EXISTS "chat_message"
(
    "id"           SERIAL PRIMARY KEY,
    "deal_id"      INT           NOT NULL,
    "deal_post_id" INT           NOT NULL,
    "sender"       SMALLINT      NOT NULL CHECK (sender IN (1, 2)),
    "message"      VARCHAR(2000) NOT NULL,
    "create_date"  TIMESTAMP     NOT NULL DEFAULT NOW(),
    FOREIGN KEY (deal_id, deal_post_id) REFERENCES "deal" (id, post_id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS "promotion"
(
    id      SERIAL PRIMARY KEY,
    file_id INT NOT NULL,
    url     VARCHAR(2000),
    FOREIGN KEY (file_id) REFERENCES "file" (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

ALTER DATABASE gwemxavt SET timezone TO 'Asia/Seoul'
