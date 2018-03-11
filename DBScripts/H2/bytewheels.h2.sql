DROP ALL OBJECTS;

CREATE TABLE CUSTOMER (
  ID           VARCHAR(50),
  EMAIL        VARCHAR(120) NOT NULL,
  FIRSTNAME    VARCHAR(50)  NOT NULL,
  LASTNAME     VARCHAR(50),
  MOBILENUMBER VARCHAR(13)  NOT NULL,
  CREATEDATE   TIMESTAMP    NOT NULL,
  UPDATEDATE   TIMESTAMP    NOT NULL,
  CONSTRAINT CUSTOMER_PK PRIMARY KEY (ID),
  CONSTRAINT CUSTOMER_UK UNIQUE (EMAIL)
);

CREATE TABLE ITEM_CATEGORY (
  ID                  VARCHAR(50),
  NAME                VARCHAR(20)   NOT NULL,
  PRICE NUMERIC(8, 2) NOT NULL,
  CREATEDATE          TIMESTAMP     NOT NULL,
  UPDATEDATE          TIMESTAMP     NOT NULL,
  CONSTRAINT ITEM_CATEGORY_PK PRIMARY KEY (ID),
  CONSTRAINT ITEM_CATEGORY_UK UNIQUE (NAME)
);

CREATE TABLE ITEM (
  ID               VARCHAR(50),
  NAME             VARCHAR(50)  NOT NULL,
  DESCRIPTION      VARCHAR(200) NOT NULL,
  ITEM_CATEGORY_ID VARCHAR(50)  NOT NULL,
  PRICE            NUMERIC(8, 2),
  CREATEDATE       TIMESTAMP    NOT NULL,
  UPDATEDATE       TIMESTAMP    NOT NULL,
  CONSTRAINT ITEM_CATEGORY_FK FOREIGN KEY (ITEM_CATEGORY_ID) REFERENCES ITEM_CATEGORY (ID),
  CONSTRAINT ITEM_UK UNIQUE (NAME),
  CONSTRAINT ITEM_PK PRIMARY KEY (ID)
);

CREATE TABLE ITEM_INVENTORY (
  ID                  VARCHAR(50),
  ITEM_ID             VARCHAR(50) NOT NULL,
  REGISTRATION_NUMBER VARCHAR(50),
  CREATEDATE          TIMESTAMP   NOT NULL,
  UPDATEDATE          TIMESTAMP   NOT NULL,
  CONSTRAINT ITEM_INVENTORY_PK PRIMARY KEY (ID),
  CONSTRAINT ITEM_INVENTORY_UK UNIQUE (REGISTRATION_NUMBER),
  CONSTRAINT ITEM_FK FOREIGN KEY (ITEM_ID) REFERENCES ITEM (ID)
);

CREATE TABLE BOOKING_ORDER (
  ID                VARCHAR(50),
  CUSTOMER_ID       VARCHAR(50)   NOT NULL,
  ITEM_INVENTORY_ID VARCHAR(50)   NOT NULL,
  FROM_DATE         DATE,
  TO_DATE           DATE,
  TOTAL_AMOUNT      NUMERIC(8, 2) NOT NULL,
  CREATEDATE        TIMESTAMP     NOT NULL,
  UPDATEDATE        TIMESTAMP     NOT NULL,
  CONSTRAINT ORDER_PK PRIMARY KEY (ID),
  CONSTRAINT CUSTOMER_FK FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (ID),
  CONSTRAINT ITEM_INVENTORY_FK FOREIGN KEY (ITEM_INVENTORY_ID) REFERENCES ITEM_INVENTORY (ID)
);

INSERT INTO ITEM_CATEGORY VALUES (RANDOM_UUID(),'Compact',20.00,NOW(),NOW());
INSERT INTO ITEM_CATEGORY VALUES (RANDOM_UUID(),'Full',30.00,NOW(),NOW());
INSERT INTO ITEM_CATEGORY VALUES (RANDOM_UUID(),'Large',40.00,NOW(),NOW());
INSERT INTO ITEM_CATEGORY VALUES (RANDOM_UUID(),'Luxury',50.00,NOW(),NOW());

INSERT INTO ITEM VALUES (RANDOM_UUID(), 'Ford Fiesta', 'Most popular Ford Car'
  , (SELECT ID
     FROM ITEM_CATEGORY
     WHERE ITEM_CATEGORY.NAME = 'Compact'), NULL, NOW(), NOW());

INSERT INTO ITEM VALUES (RANDOM_UUID(), 'Ford Focus', 'Most Performing car in this range'
  , (SELECT ID
     FROM ITEM_CATEGORY
     WHERE ITEM_CATEGORY.NAME = 'Compact'), NULL, NOW(), NOW());

INSERT INTO ITEM VALUES (RANDOM_UUID(), 'Chevrolet Malibu', 'It unites a passion for driving with exceptional efficiency.'
  , (SELECT ID
     FROM ITEM_CATEGORY
     WHERE ITEM_CATEGORY.NAME = 'Full'), NULL, NOW(), NOW());

INSERT INTO ITEM VALUES (RANDOM_UUID(), 'Volkswagen Jetta', 'Volkswagen Jetta is as inspiring to look at as it is to drive.'
  , (SELECT ID
     FROM ITEM_CATEGORY
     WHERE ITEM_CATEGORY.NAME = 'Full'), NULL, NOW(), NOW());

INSERT INTO ITEM VALUES (RANDOM_UUID(), 'Ford Egde', 'The Ford Edge is a Midsize crossover SUV that is manufactured by Ford Motor Company.'
  , (SELECT ID
     FROM ITEM_CATEGORY
     WHERE ITEM_CATEGORY.NAME = 'Large'), NULL, NOW(), NOW());

INSERT INTO ITEM VALUES (RANDOM_UUID(), 'Ford Escape', 'The Ford Escape is a compact crossover vehicle sold by Ford since 2000 over three generations.'
  , (SELECT ID
     FROM ITEM_CATEGORY
     WHERE ITEM_CATEGORY.NAME = 'Large'), NULL, NOW(), NOW());

INSERT INTO ITEM VALUES (RANDOM_UUID(), 'BMW 328i', 'The BMW 3 Series is an entry-level luxury car manufactured by the German automaker BMW since May 1975.'
  , (SELECT ID
     FROM ITEM_CATEGORY
     WHERE ITEM_CATEGORY.NAME = 'Luxury'), NULL, NOW(), NOW());

INSERT INTO ITEM VALUES (RANDOM_UUID(), 'BMW X5', 'The BMW X5 is a mid-size luxury SUV produced by BMW.'
  , (SELECT ID
     FROM ITEM_CATEGORY
     WHERE ITEM_CATEGORY.NAME = 'Luxury'), NULL, NOW(), NOW());

INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'Ford Fiesta'), 'MH12AB0001', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'Ford Fiesta'), 'MH12AB0002', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'Ford Focus'), 'MH12CD1111', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'Ford Focus'), 'MH12CD2222', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'Chevrolet Malibu'), 'MH12EF2121', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'Chevrolet Malibu'), 'MH12EF3132', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'Volkswagen Jetta'), 'MH12GH2582', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'Volkswagen Jetta'), 'MH12JB2789', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'Ford Egde'), 'MH12KH1252', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'Ford Egde'), 'MH12KH1572', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'Ford Escape'), 'MH12AG1572', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'Ford Escape'), 'MH12AG1576', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'BMW 328i'), 'MH12PT1572', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'BMW 328i'), 'MH12PT1575', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'BMW X5'), 'MH12JD2020', NOW(), NOW());
INSERT INTO ITEM_INVENTORY VALUES (RANDOM_UUID(), (SELECT ID
                                                   FROM ITEM
                                                   WHERE ITEM.NAME = 'BMW X5'), 'MH12JD3030', NOW(), NOW());

INSERT INTO CUSTOMER VALUES (RANDOM_UUID(), 'naman.gupta810@hotmail.com', 'Naman', 'Gupta', '1234567890', NOW(), NOW());

INSERT INTO BOOKING_ORDER VALUES (RANDOM_UUID(), (SELECT ID
                                                  FROM CUSTOMER
                                                  WHERE EMAIL = 'naman.gupta810@hotmail.com'),
                                  (SELECT ID
                           FROM ITEM_INVENTORY
                           WHERE REGISTRATION_NUMBER = 'MH12JD2020'), CURRENT_DATE() + 2, CURRENT_DATE() + 4, 150.00,
                                  NOW(), NOW());

INSERT INTO BOOKING_ORDER VALUES (RANDOM_UUID(), (SELECT ID
                                                  FROM CUSTOMER
                                                  WHERE EMAIL = 'naman.gupta810@hotmail.com'),
                                  (SELECT ID
                           FROM ITEM_INVENTORY
                           WHERE REGISTRATION_NUMBER = 'MH12JD3030'), CURRENT_DATE() + 5, CURRENT_DATE() + 9, 300.00,
                                  NOW(), NOW());

COMMIT;


