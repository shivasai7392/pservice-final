CREATE TABLE category
(
    id            BINARY(16) NOT NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE j_instructor
(
    id                 BIGINT NOT NULL,
    current_batch_name VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_j_instructor PRIMARY KEY (id)
);

CREATE TABLE j_mentor
(
    id BIGINT NOT NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_j_mentor PRIMARY KEY (id)
);

CREATE TABLE j_student
(
    id         BIGINT NOT NULL,
    psp DOUBLE NOT NULL,
    batch_name VARCHAR(255) NULL,
    attendance INT    NOT NULL,
    CONSTRAINT pk_j_student PRIMARY KEY (id)
);

CREATE TABLE j_ta
(
    id             BIGINT NOT NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_j_ta PRIMARY KEY (id)
);

CREATE TABLE ms_instructor
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    name               VARCHAR(255) NULL,
    email              VARCHAR(255) NULL,
    current_batch_name VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_ms_instructor PRIMARY KEY (id)
);

CREATE TABLE ms_mentor
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_ms_mentor PRIMARY KEY (id)
);

CREATE TABLE ms_student
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    batch_name VARCHAR(255) NULL,
    attendance INT NOT NULL,
    CONSTRAINT pk_ms_student PRIMARY KEY (id)
);

CREATE TABLE ms_ta
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_ms_ta PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id BINARY(16) NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE orders_products
(
    orders_id   BINARY(16) NOT NULL,
    products_id BINARY(16) NOT NULL
);

CREATE TABLE product
(
    id            BINARY(16) NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    image         VARCHAR(255) NULL,
    category_id   BINARY(16) NOT NULL,
    price DOUBLE NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE sg_user
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    dtype              VARCHAR(31) NULL,
    name               VARCHAR(255) NULL,
    email              VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    batch_name         VARCHAR(255) NULL,
    attendance         INT NOT NULL,
    specialization     VARCHAR(255) NULL,
    current_batch_name VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_sg_user PRIMARY KEY (id)
);

CREATE TABLE tpc_instructor
(
    id                 BIGINT NOT NULL,
    name               VARCHAR(255) NULL,
    email              VARCHAR(255) NULL,
    current_batch_name VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tpc_instructor PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_student
(
    id         BIGINT NOT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    batch_name VARCHAR(255) NULL,
    attendance INT    NOT NULL,
    CONSTRAINT pk_tpc_student PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id             BIGINT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

CREATE TABLE user
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE j_instructor
    ADD CONSTRAINT FK_J_INSTRUCTOR_ON_ID FOREIGN KEY (id) REFERENCES user (id);

ALTER TABLE j_mentor
    ADD CONSTRAINT FK_J_MENTOR_ON_ID FOREIGN KEY (id) REFERENCES user (id);

ALTER TABLE j_student
    ADD CONSTRAINT FK_J_STUDENT_ON_ID FOREIGN KEY (id) REFERENCES user (id);

ALTER TABLE j_ta
    ADD CONSTRAINT FK_J_TA_ON_ID FOREIGN KEY (id) REFERENCES user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE orders_products
    ADD CONSTRAINT fk_ordpro_on_order FOREIGN KEY (orders_id) REFERENCES orders (id);

ALTER TABLE orders_products
    ADD CONSTRAINT fk_ordpro_on_product FOREIGN KEY (products_id) REFERENCES product (id);