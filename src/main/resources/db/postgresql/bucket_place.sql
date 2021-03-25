CREATE TABLE `member` (
    id INT AUTO_INCREMENT ,
    email VARCHAR(255) UNIQUE,
    name TEXT,
    created_at DATETIME,
    PRIMARY KEY (id)
);

CREATE TABLE `order` (
    id INT AUTO_INCREMENT,
    member_id INT,
    title TEXT,
    created_at DATETIME,
    PRIMARY KEY (id),
    FOREIGN KEY (member_id) REFERENCES member (id)
);

CREATE TABLE `point` (
    id INT AUTO_INCREMENT ,
    member_id INT,
    point INT,
    reason TEXT,
    used_point INT,
    expired_at DATETIME,
    created_at DATETIME,
    PRIMARY KEY (id),
    FOREIGN KEY (member_id) REFERENCES member (id)
);

CREATE TABLE `option` (
    id INT AUTO_INCREMENT,
    option_name TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE `order_option` (
    id INT AUTO_INCREMENT ,
    order_id INT,
    option_id INT,
    option_name TEXT,
    unit_price DECIMAL,
    qty INT,
    amount DECIMAL,
    created_at DATETIME,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES `order` (id),
    FOREIGN KEY (option_id) REFERENCES `option` (id)
);

CREATE TABLE `payment` (
    id INT AUTO_INCREMENT ,
    order_option_id INT,
    payment_method ENUM('card', 'bank', 'virtual_account', 'point'),
    price INT,
    created_at DATETIME,
    PRIMARY KEY (id),
    FOREIGN KEY (order_option_id) REFERENCES `order_option` (id)
);

INSERT INTO `member` (id, email, name, created_at) VALUES (1, 'hongseok@bucketplace.com','조홍석','2020-12-31 23:59:59');
INSERT INTO `member` (id, email, name, created_at) VALUES (2, 'bucketplace@hongseok.com','버킷플레이스','2021-02-10 22:00:10');
INSERT INTO `member` (id, email, name, created_at) VALUES (3, 'today@house.com','오늘의집','2021-02-11 22:00:10');
INSERT INTO `member` (id, email, name, created_at) VALUES (4, 'everyday@house.com','매일의집','2021-02-12 22:00:10');

INSERT INTO `order` (id, member_id, title, created_at) VALUES (1, 1,'주문입니다','2021-01-20 12:12:12'); /*1*/
INSERT INTO `order` (id, member_id, title, created_at) VALUES (2, 1,'주문이죠','2021-01-31 15:00:59');
INSERT INTO `order` (id, member_id, title, created_at) VALUES (3, 1,'주문이에요','2021-02-11 02:59:59');
INSERT INTO `order` (id, member_id, title, created_at) VALUES (4, 1,'주문-동방신기', '2021-02-13 10:05:29');

INSERT INTO `order` (id, member_id, title, created_at) VALUES (5, 2,'주문입니다','2021-01-20 12:12:12'); /*5*/
INSERT INTO `order` (id, member_id, title, created_at) VALUES (6, 2,'주문이죠','2021-01-31 15:00:59');
INSERT INTO `order` (id, member_id, title, created_at) VALUES (7, 2,'주문이에요','2021-02-11 02:59:59');

INSERT INTO `order` (id, member_id, title, created_at) VALUES (8, 3,'주문입니다','2021-01-20 12:12:12'); /*8*/
INSERT INTO `order` (id, member_id, title, created_at) VALUES (9, 3,'주문이죠','2021-01-31 15:00:59');

INSERT INTO `order` (id, member_id, title, created_at) VALUES (10, 4,'주문입니다','2021-01-20 12:12:12'); /*10*/

INSERT INTO `point` (id, member_id, point, reason, used_point, expired_at, created_at) VALUES (1, 1, 300, '이벤트A 참여', 2000, '2021-01-31 23:59:59', '2021-01-01 23:59:59');
INSERT INTO `point` (id, member_id, point, reason, used_point, expired_at, created_at) VALUES (2, 1, 300, '이벤트A 참여', 0, '2021-02-10 23:59:59', '2021-02-03 23:59:59');
INSERT INTO `point` (id, member_id, point, reason, used_point, expired_at, created_at) VALUES (3, 2, 300, '이벤트B 참여', 0, '2022-01-31 23:59:59', '2021-02-01 23:59:59');
INSERT INTO `point` (id, member_id, point, reason, used_point, expired_at, created_at) VALUES (4, 2, 300, '이벤트C 참여', 0, '2030-02-01 23:59:59', '2021-02-02 23:59:59');

INSERT INTO `option` (id, option_name) VALUES (1, '1번 옵션');
INSERT INTO `option` (id, option_name) VALUES (2, '2번 옵션');
INSERT INTO `option` (id, option_name) VALUES (3, '3번 옵션');
INSERT INTO `option` (id, option_name) VALUES (4, '4번 옵션');
INSERT INTO `option` (id, option_name) VALUES (5, '5번 옵션');
INSERT INTO `option` (id, option_name) VALUES (6, '6번 옵션');

INSERT INTO `order_option` (id, order_id, option_id, option_name, unit_price, qty, amount, created_at)
VALUES (1, 1, 1, '주문 옵션1', 30000, 1, 30000, '2021-01-20 12:12:12');
INSERT INTO `order_option` (id, order_id, option_id, option_name, unit_price, qty, amount, created_at)
VALUES (2, 1, 1, '주문 옵션2', 40000, 2, 80000, '2021-01-20 12:12:12');
INSERT INTO `order_option` (id, order_id, option_id, option_name, unit_price, qty, amount, created_at)
VALUES (3, 2, 1, '주문 옵션3', 900000, 1, 900000, '2021-01-31 15:00:59');
INSERT INTO `order_option` (id, order_id, option_id, option_name, unit_price, qty, amount, created_at)
VALUES (4, 3, 1, '주문 옵션1', 30000, 2, 60000, '2021-02-11 02:59:59');
INSERT INTO `order_option` (id, order_id, option_id, option_name, unit_price, qty, amount, created_at)
VALUES (5, 4, 1, '주문 옵션1', 30000, 2, 60000, '2021-02-13 10:05:29');

INSERT INTO `order_option` (id, order_id, option_id, option_name, unit_price, qty, amount, created_at)
VALUES (6, 5, 1, '주문 옵션1', 250000, 2, 500000, '2021-01-20 12:12:12');
INSERT INTO `order_option` (id, order_id, option_id, option_name, unit_price, qty, amount, created_at)
VALUES (7, 6, 1, '주문 옵션1', 30000, 2, 60000, '2021-01-31 15:00:59');
INSERT INTO `order_option` (id, order_id, option_id, option_name, unit_price, qty, amount, created_at)
VALUES (8, 7, 1, '주문 옵션1', 30000, 2, 60000, '2021-02-11 02:59:59');

INSERT INTO `order_option` (id, order_id, option_id, option_name, unit_price, qty, amount, created_at)
VALUES (9, 8, 1, '주문 옵션2', 130000, 2, 260000, '2021-01-20 12:12:12');
INSERT INTO `order_option` (id, order_id, option_id, option_name, unit_price, qty, amount, created_at)
VALUES (10, 9, 1, '주문 옵션3', 60000, 1, 60000, '2021-01-31 15:00:59');

INSERT INTO `order_option` (id, order_id, option_id, option_name, unit_price, qty, amount, created_at)
VALUES (11, 10, 1, '주문 옵션2', 40000, 2, 80000, '2021-01-20 12:12:12');

INSERT INTO `payment` (id, order_option_id, payment_method, price, created_at) VALUES (1, 1, 'point', 2000, '2021-01-20 12:12:12');
INSERT INTO `payment` (id, order_option_id, payment_method, price, created_at) VALUES (2, 1, 'card', 28000, '2021-01-20 12:12:12');
INSERT INTO `payment` (id, order_option_id, payment_method, price, created_at) VALUES (3, 2, 'card', 80000, '2021-01-20 12:12:12');
INSERT INTO `payment` (id, order_option_id, payment_method, price, created_at) VALUES (4, 3, 'card', 900000, '2021-01-31 15:00:59');
INSERT INTO `payment` (id, order_option_id, payment_method, price, created_at) VALUES (5, 4, 'card', 60000, '2021-02-11 02:59:59');
INSERT INTO `payment` (id, order_option_id, payment_method, price, created_at) VALUES (6, 5, 'card', 60000, '2021-02-13 10:05:29');

INSERT INTO `payment` (id, order_option_id, payment_method, price, created_at) VALUES (7, 6, 'card', 500000, '2021-01-20 12:12:12');
INSERT INTO `payment` (id, order_option_id, payment_method, price, created_at) VALUES (8, 7, 'card', 60000, '2021-01-31 15:00:59');
INSERT INTO `payment` (id, order_option_id, payment_method, price, created_at) VALUES (9, 8, 'card', 60000,  '2021-02-11 02:59:59');

INSERT INTO `payment` (id, order_option_id, payment_method, price, created_at) VALUES (10, 9, 'card', 260000, '2021-01-20 12:12:12');
INSERT INTO `payment` (id, order_option_id, payment_method, price, created_at) VALUES (11, 10, 'card', 60000, '2021-01-31 15:00:59');

INSERT INTO `payment` (id, order_option_id, payment_method, price, created_at) VALUES (12, 11, 'card', 80000, '2021-01-20 12:12:12');

