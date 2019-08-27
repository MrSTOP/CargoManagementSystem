/*
 Navicat Premium Data Transfer

 Source Server         : Manager
 Source Server Type    : Oracle
 Source Server Version : 110200
 Source Host           : 47.103.113.9:1521
 Source Schema         : MANAGER

 Target Server Type    : Oracle
 Target Server Version : 110200
 File Encoding         : 65001

 Date: 27/08/2019 17:48:54
*/


-- ----------------------------
-- Table structure for Administrator
-- ----------------------------
DROP TABLE "MANAGER"."Administrator";
CREATE TABLE "MANAGER"."Administrator" (
  "UserName" VARCHAR2(255 BYTE) NOT NULL ,
  "PassWord" VARCHAR2(255 BYTE) NOT NULL 
)
TABLESPACE "MANAGER"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of Administrator
-- ----------------------------
INSERT INTO "MANAGER"."Administrator" VALUES ('admini', '4QrcOUm6Wau+VuBX8g+IPg==');

-- ----------------------------
-- Table structure for Bank
-- ----------------------------
DROP TABLE "MANAGER"."Bank";
CREATE TABLE "MANAGER"."Bank" (
  "CompanyAccount" NUMBER(8,2) NOT NULL 
)
TABLESPACE "MANAGER"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of Bank
-- ----------------------------
INSERT INTO "MANAGER"."Bank" VALUES ('499747.44');

-- ----------------------------
-- Table structure for BuyOrder
-- ----------------------------
DROP TABLE "MANAGER"."BuyOrder";
CREATE TABLE "MANAGER"."BuyOrder" (
  "SupplierOrderID" NUMBER(19) NOT NULL ,
  "ProductID" NUMBER(19) NOT NULL ,
  "SupplierID" NUMBER(19) NOT NULL ,
  "SupplierDate" TIMESTAMP(6) NOT NULL ,
  "SupplierStatus" NUMBER NOT NULL ,
  "SupplierCount" NUMBER NOT NULL ,
  "SupplierPrice" NUMBER(8,2) NOT NULL 
)
TABLESPACE "MANAGER"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of BuyOrder
-- ----------------------------
INSERT INTO "MANAGER"."BuyOrder" VALUES ('53', '11', '1', TO_TIMESTAMP('2019-08-26 10:23:35.893000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '1', '5', '645.7');
INSERT INTO "MANAGER"."BuyOrder" VALUES ('53', '12', '1', TO_TIMESTAMP('2019-08-26 10:23:35.924000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '1', '1', '645.7');
INSERT INTO "MANAGER"."BuyOrder" VALUES ('102', '11', '1', TO_TIMESTAMP('2019-08-26 22:28:31.137000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '1', '1', '243.14');
INSERT INTO "MANAGER"."BuyOrder" VALUES ('102', '12', '1', TO_TIMESTAMP('2019-08-26 22:28:31.164000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '0', '1', '243.14');
INSERT INTO "MANAGER"."BuyOrder" VALUES ('102', '51', '1', TO_TIMESTAMP('2019-08-26 22:28:31.183000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '0', '1', '243.14');
INSERT INTO "MANAGER"."BuyOrder" VALUES ('101', '52', '1', TO_TIMESTAMP('2019-08-26 22:20:26.876000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '1', '1', '90');
INSERT INTO "MANAGER"."BuyOrder" VALUES ('52', '11', '1', TO_TIMESTAMP('2019-08-25 21:55:56.971000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '1', '10', '2493.9');
INSERT INTO "MANAGER"."BuyOrder" VALUES ('55', '51', '1', TO_TIMESTAMP('2019-08-26 11:54:38.979000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '1', '1', '40');
INSERT INTO "MANAGER"."BuyOrder" VALUES ('52', '12', '1', TO_TIMESTAMP('2019-08-25 21:55:57.002000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '1', '15', '2493.9');

-- ----------------------------
-- Table structure for Income
-- ----------------------------
DROP TABLE "MANAGER"."Income";
CREATE TABLE "MANAGER"."Income" (
  "UserID" NUMBER(19) NOT NULL ,
  "SaleTime" TIMESTAMP(6) NOT NULL ,
  "SalePrice" NUMBER(8,2) NOT NULL ,
  "SaleIncomeOrderID" NUMBER(19) NOT NULL ,
  "Description" VARCHAR2(400 BYTE) NOT NULL 
)
TABLESPACE "MANAGER"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for OrderProduct
-- ----------------------------
DROP TABLE "MANAGER"."OrderProduct";
CREATE TABLE "MANAGER"."OrderProduct" (
  "SupplierOrderID" NUMBER(19) NOT NULL ,
  "SupplierOrderCount" NUMBER 
)
TABLESPACE "MANAGER"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for Outcome
-- ----------------------------
DROP TABLE "MANAGER"."Outcome";
CREATE TABLE "MANAGER"."Outcome" (
  "SupplierID" NUMBER(19) NOT NULL ,
  "OutTime" TIMESTAMP(6) NOT NULL ,
  "OutPrice" NUMBER(8,2) NOT NULL ,
  "OutSupplierID" NUMBER(19) NOT NULL ,
  "Description" VARCHAR2(400 BYTE) NOT NULL 
)
TABLESPACE "MANAGER"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of Outcome
-- ----------------------------
INSERT INTO "MANAGER"."Outcome" VALUES ('1', TO_TIMESTAMP('2019-08-26 22:28:31.137000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '243.14', '2', '在2019-08-26 10:28:31支出243.14元于供应商TEST供应商ID为:1');
INSERT INTO "MANAGER"."Outcome" VALUES ('1', TO_TIMESTAMP('2019-08-26 22:20:26.876000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '90', '1', '在26-8月 -19 10.20.26.876000 下午支出90元于供应商TEST供应商ID为:1');

-- ----------------------------
-- Table structure for Product
-- ----------------------------
DROP TABLE "MANAGER"."Product";
CREATE TABLE "MANAGER"."Product" (
  "ProductID" NUMBER(19) NOT NULL ,
  "SupplierID" NUMBER(19) ,
  "ProductName" VARCHAR2(1024 BYTE) ,
  "ProductSalePrice" NUMBER(8,2) ,
  "ProductBuyPrice" NUMBER(8,2) ,
  "ProductDescription" VARCHAR2(1024 BYTE) 
)
TABLESPACE "MANAGER"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of Product
-- ----------------------------
INSERT INTO "MANAGER"."Product" VALUES ('51', '1', 'Java2', '50', '40', 'JJJJJJJJJJJJJ');
INSERT INTO "MANAGER"."Product" VALUES ('11', '1', 'Java', '120.58', '110.64', 'Java');
INSERT INTO "MANAGER"."Product" VALUES ('12', '1', 'CPP', '100', '92.5', 'CPP');
INSERT INTO "MANAGER"."Product" VALUES ('52', '1', 'CPPP', '100', '90', NULL);

-- ----------------------------
-- Table structure for SaleOrder
-- ----------------------------
DROP TABLE "MANAGER"."SaleOrder";
CREATE TABLE "MANAGER"."SaleOrder" (
  "SaleOrderID" NUMBER(19) NOT NULL ,
  "UserID" NUMBER(19) ,
  "ProductID" NUMBER(19) ,
  "SaleOrderCount" NUMBER ,
  "SaleDate" TIMESTAMP(6) ,
  "SaleProductPrice" NUMBER(8,2) ,
  "ReceiveStatus" NUMBER 
)
TABLESPACE "MANAGER"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of SaleOrder
-- ----------------------------
INSERT INTO "MANAGER"."SaleOrder" VALUES ('5', '1', '11', '1', TO_TIMESTAMP('2019-08-26 12:38:45.347000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '120.58', '0');
INSERT INTO "MANAGER"."SaleOrder" VALUES ('1', '1', '52', '100', TO_TIMESTAMP('2019-08-26 12:13:01.544000', 'SYYYY-MM-DD HH24:MI:SS:FF6'), '10000', '0');

-- ----------------------------
-- Table structure for Send
-- ----------------------------
DROP TABLE "MANAGER"."Send";
CREATE TABLE "MANAGER"."Send" (
  "UserID" NUMBER(19) NOT NULL ,
  "SendListID" NUMBER(19) NOT NULL ,
  "SendListCount" NUMBER NOT NULL ,
  "SendListProductID" NUMBER(19) NOT NULL 
)
TABLESPACE "MANAGER"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for Storage
-- ----------------------------
DROP TABLE "MANAGER"."Storage";
CREATE TABLE "MANAGER"."Storage" (
  "ProductID" NUMBER(19) ,
  "ProductCount" NUMBER 
)
TABLESPACE "MANAGER"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of Storage
-- ----------------------------
INSERT INTO "MANAGER"."Storage" VALUES ('51', '1');
INSERT INTO "MANAGER"."Storage" VALUES ('11', '15');
INSERT INTO "MANAGER"."Storage" VALUES ('12', '16');
INSERT INTO "MANAGER"."Storage" VALUES ('52', '-99');

-- ----------------------------
-- Table structure for Supplier
-- ----------------------------
DROP TABLE "MANAGER"."Supplier";
CREATE TABLE "MANAGER"."Supplier" (
  "SupplierID" NUMBER(19) NOT NULL ,
  "SupplierName" VARCHAR2(1024 BYTE) NOT NULL ,
  "SupplierDescription" VARCHAR2(1024 BYTE) NOT NULL ,
  "SupplierAddress" VARCHAR2(1024 BYTE) NOT NULL ,
  "SupplierPhone" VARCHAR2(255 BYTE) ,
  "SUPPLIERPHONE" NUMBER(11) 
)
TABLESPACE "MANAGER"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of Supplier
-- ----------------------------
INSERT INTO "MANAGER"."Supplier" VALUES ('1', 'woy Green', 'ass', '南昌', '17370837202', NULL);
INSERT INTO "MANAGER"."Supplier" VALUES ('2', 'aaa', 'aaa', 'aaa', NULL, NULL);

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE "MANAGER"."User";
CREATE TABLE "MANAGER"."User" (
  "UserID" NUMBER(19) NOT NULL ,
  "UserName" VARCHAR2(1024 BYTE) NOT NULL ,
  "Phone" CHAR(11 BYTE) NOT NULL ,
  "Email" VARCHAR2(1024 BYTE) ,
  "Address" VARCHAR2(1024 BYTE) NOT NULL 
)
TABLESPACE "MANAGER"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of User
-- ----------------------------
INSERT INTO "MANAGER"."User" VALUES ('3333', '3333333', '33333333333', 'as@kl.cc', 'dfg');
INSERT INTO "MANAGER"."User" VALUES ('1', 'Test', '12345678901', 'test@test.com', 'TEST');

-- ----------------------------
-- Function structure for SUPPLIER_INSERT
-- ----------------------------
CREATE OR REPLACE
PROCEDURE "MANAGER"."SUPPLIER_INSERT" AS
BEGIN
        INSERT INTO "Supplier"("SupplierID", "SupplierName", "SupplierDescription", "SupplierAddress")
        VALUES (SUPPLIER_ID_SEQ.nextval, SupplierName, SupplierDescription, SupplierAddress);
    END;
/

-- ----------------------------
-- Sequence structure for BUY_ORDER_ID_SEQ
-- ----------------------------
DROP SEQUENCE "MANAGER"."BUY_ORDER_ID_SEQ";
CREATE SEQUENCE "MANAGER"."BUY_ORDER_ID_SEQ" MINVALUE 1 MAXVALUE 9223372036854775807 INCREMENT BY 1 CACHE 50;

-- ----------------------------
-- Sequence structure for INCOME_SEQ
-- ----------------------------
DROP SEQUENCE "MANAGER"."INCOME_SEQ";
CREATE SEQUENCE "MANAGER"."INCOME_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 NOCACHE;

-- ----------------------------
-- Sequence structure for PRODUCT_ID_SEQ
-- ----------------------------
DROP SEQUENCE "MANAGER"."PRODUCT_ID_SEQ";
CREATE SEQUENCE "MANAGER"."PRODUCT_ID_SEQ" MINVALUE 1 MAXVALUE 9223372036854775807 INCREMENT BY 1 CACHE 50;

-- ----------------------------
-- Sequence structure for SALE_ORDER_ID_SEQ
-- ----------------------------
DROP SEQUENCE "MANAGER"."SALE_ORDER_ID_SEQ";
CREATE SEQUENCE "MANAGER"."SALE_ORDER_ID_SEQ" MINVALUE 1 MAXVALUE 9223372036854775807 INCREMENT BY 1 CACHE 50;

-- ----------------------------
-- Sequence structure for SUPPLIER_ID_SEQ
-- ----------------------------
DROP SEQUENCE "MANAGER"."SUPPLIER_ID_SEQ";
CREATE SEQUENCE "MANAGER"."SUPPLIER_ID_SEQ" MINVALUE 1 MAXVALUE 9223372036854775807 INCREMENT BY 1 CACHE 50;

-- ----------------------------
-- Sequence structure for USER_SEQ
-- ----------------------------
DROP SEQUENCE "MANAGER"."USER_SEQ";
CREATE SEQUENCE "MANAGER"."USER_SEQ" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 NOCACHE;

-- ----------------------------
-- Primary Key structure for table Administrator
-- ----------------------------
ALTER TABLE "MANAGER"."Administrator" ADD CONSTRAINT "SYS_C0011750" PRIMARY KEY ("UserName");

-- ----------------------------
-- Checks structure for table Administrator
-- ----------------------------
ALTER TABLE "MANAGER"."Administrator" ADD CONSTRAINT "SYS_C0011749" CHECK ("PassWord" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Checks structure for table Bank
-- ----------------------------
ALTER TABLE "MANAGER"."Bank" ADD CONSTRAINT "SYS_C0011053" CHECK ("CompanyAccount" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table BuyOrder
-- ----------------------------
ALTER TABLE "MANAGER"."BuyOrder" ADD CONSTRAINT "PK_BUYORDER" PRIMARY KEY ("SupplierOrderID", "ProductID", "SupplierID");

-- ----------------------------
-- Checks structure for table BuyOrder
-- ----------------------------
ALTER TABLE "MANAGER"."BuyOrder" ADD CONSTRAINT "SYS_C0011054" CHECK ("SupplierOrderID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."BuyOrder" ADD CONSTRAINT "SYS_C0011055" CHECK ("SupplierDate" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."BuyOrder" ADD CONSTRAINT "SYS_C0011056" CHECK ("SupplierStatus" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."BuyOrder" ADD CONSTRAINT "SYS_C0011057" CHECK ("SupplierCount" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."BuyOrder" ADD CONSTRAINT "SYS_C0011058" CHECK ("SupplierPrice" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table BuyOrder
-- ----------------------------
CREATE INDEX "MANAGER"."Process_FK"
  ON "MANAGER"."BuyOrder" ("SupplierID" ASC)
  LOGGING
  TABLESPACE "MANAGER"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
);
CREATE INDEX "MANAGER"."Relationship_7_FK"
  ON "MANAGER"."BuyOrder" ("ProductID" ASC)
  LOGGING
  TABLESPACE "MANAGER"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
);

-- ----------------------------
-- Triggers structure for table BuyOrder
-- ----------------------------
CREATE TRIGGER "MANAGER"."AUTO_ADD_PRODUCT_IN_STORAGE" AFTER UPDATE ON "MANAGER"."BuyOrder" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
BEGIN
        IF :NEW."SupplierStatus"=1 THEN
            UPDATE "Storage" SET "ProductCount"="ProductCount"+:NEW."SupplierCount" WHERE "ProductID"=:NEW."ProductID";
        END IF;
    END;
/
CREATE TRIGGER "MANAGER"."AUTO_SUB_BANK_AFTER_BUY" AFTER INSERT ON "MANAGER"."BuyOrder" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
DECLARE
    ProductPrice    NUMBER(8, 2);
    CurrentProductPrice    NUMBER(8, 2);
    BuyProductCount NUMBER;
BEGIN
    SELECT "ProductBuyPrice" INTO ProductPrice FROM "Product" WHERE "Product"."ProductID" = :NEW."ProductID";
    BuyProductCount := :NEW."SupplierCount";
    CurrentProductPrice := (ProductPrice * BuyProductCount);
    UPDATE "Bank" SET "CompanyAccount"="CompanyAccount"-CurrentProductPrice;
END;
/
CREATE TRIGGER "MANAGER"."OUTCOME_ADD" AFTER UPDATE ON "MANAGER"."BuyOrder" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
declare
P_ID number(19);
Time_out timestamp(6);
Price_out number(8,2);
out_description varchar(400);
P_name varchar(100);
begin
  if :NEW."SupplierStatus" = 1
    then
      SELECT "SupplierName" into P_name from "Supplier" where "SupplierID" = :OLD."SupplierID";
      P_ID := :OLD."SupplierID";
      Time_out := :OLD."SupplierDate";
      Price_out := :OLD."SupplierPrice";
      out_description := '在'||to_char(Time_out,'yyyy-mm-dd HH:MI:SS')||'支出'||Price_out||'元'||'于供应商'||P_name||'供应商ID为:'||P_ID;
      insert into "Outcome"("SupplierID", "OutTime", "OutPrice",  "Description") values (P_ID,Time_out,Price_out,out_description);
  end if;
end;
/

-- ----------------------------
-- Primary Key structure for table Income
-- ----------------------------
ALTER TABLE "MANAGER"."Income" ADD CONSTRAINT "PK_INCOME" PRIMARY KEY ("SaleIncomeOrderID");

-- ----------------------------
-- Checks structure for table Income
-- ----------------------------
ALTER TABLE "MANAGER"."Income" ADD CONSTRAINT "SYS_C0011060" CHECK ("UserID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Income" ADD CONSTRAINT "SYS_C0011061" CHECK ("SaleTime" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Income" ADD CONSTRAINT "SYS_C0011062" CHECK ("SalePrice" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Income" ADD CONSTRAINT "SYS_C0011063" CHECK ("SaleIncomeOrderID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Income" ADD CONSTRAINT "SYS_C0011614" CHECK ("Description" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Triggers structure for table Income
-- ----------------------------
CREATE TRIGGER "MANAGER"."TR_INCOME" BEFORE INSERT ON "MANAGER"."Income" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
begin
  select user_seq.nextval into :new."SaleIncomeOrderID" from dual;
end;
/

-- ----------------------------
-- Primary Key structure for table OrderProduct
-- ----------------------------
ALTER TABLE "MANAGER"."OrderProduct" ADD CONSTRAINT "PK_ORDERPRODUCT" PRIMARY KEY ("SupplierOrderID");

-- ----------------------------
-- Checks structure for table OrderProduct
-- ----------------------------
ALTER TABLE "MANAGER"."OrderProduct" ADD CONSTRAINT "SYS_C0011695" CHECK ("SupplierOrderID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table Outcome
-- ----------------------------
ALTER TABLE "MANAGER"."Outcome" ADD CONSTRAINT "PK_OUTCOME" PRIMARY KEY ("OutSupplierID");

-- ----------------------------
-- Checks structure for table Outcome
-- ----------------------------
ALTER TABLE "MANAGER"."Outcome" ADD CONSTRAINT "SYS_C0011067" CHECK ("SupplierID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Outcome" ADD CONSTRAINT "SYS_C0011068" CHECK ("OutTime" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Outcome" ADD CONSTRAINT "SYS_C0011069" CHECK ("OutPrice" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Outcome" ADD CONSTRAINT "SYS_C0011070" CHECK ("OutSupplierID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Outcome" ADD CONSTRAINT "SYS_C0011615" CHECK ("Description" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Triggers structure for table Outcome
-- ----------------------------
CREATE TRIGGER "MANAGER"."TR_OUTCOME" BEFORE INSERT ON "MANAGER"."Outcome" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
begin
  select user_seq.nextval into :new."OutSupplierID" from dual;
end;
/

-- ----------------------------
-- Primary Key structure for table Product
-- ----------------------------
ALTER TABLE "MANAGER"."Product" ADD CONSTRAINT "PK_PRODUCT" PRIMARY KEY ("ProductID");

-- ----------------------------
-- Checks structure for table Product
-- ----------------------------
ALTER TABLE "MANAGER"."Product" ADD CONSTRAINT "SYS_C0011072" CHECK ("ProductID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Triggers structure for table Product
-- ----------------------------
CREATE TRIGGER "MANAGER"."AUTO_ADD_PRODUCT_TO_STORAGE" AFTER INSERT ON "MANAGER"."Product" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
BEGIN
        INSERT INTO "Storage"("ProductID", "ProductCount") VALUES (:NEW."ProductID", 0);
    END;
/
CREATE TRIGGER "MANAGER"."AUTO_DELETE_PRODUCT_IN_STORAGE" AFTER DELETE ON "MANAGER"."Product" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
BEGIN
       DELETE FROM "Storage" WHERE "ProductID"=:OLD."ProductID";
    END;
/

-- ----------------------------
-- Primary Key structure for table SaleOrder
-- ----------------------------
ALTER TABLE "MANAGER"."SaleOrder" ADD CONSTRAINT "PK_SALEORDER" PRIMARY KEY ("SaleOrderID");

-- ----------------------------
-- Checks structure for table SaleOrder
-- ----------------------------
ALTER TABLE "MANAGER"."SaleOrder" ADD CONSTRAINT "SYS_C0011074" CHECK ("SaleOrderID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table SaleOrder
-- ----------------------------
CREATE INDEX "MANAGER"."Relationship_4_FK"
  ON "MANAGER"."SaleOrder" ("ProductID" ASC)
  LOGGING
  TABLESPACE "MANAGER"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
);

-- ----------------------------
-- Triggers structure for table SaleOrder
-- ----------------------------
CREATE TRIGGER "MANAGER"."AUTO_ADD_BANK_AFTER_SALE" AFTER INSERT ON "MANAGER"."SaleOrder" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
DECLARE
    ProductPrice NUMBER(8, 2);
    SalePrice NUMBER(8, 2);
    SaleCount NUMBER;
BEGIN
    SELECT "ProductSalePrice" INTO ProductPrice FROM "Product" WHERE "Product"."ProductID" = :NEW."ProductID";
    SaleCount := :NEW."SaleOrderCount";
    SalePrice := ProductPrice * SaleCount;
    UPDATE "Bank" SET "CompanyAccount"="CompanyAccount"+SalePrice;
END ;
/
CREATE TRIGGER "MANAGER"."AUTO_SUB_PRODUCT_IN_STORAGE" AFTER INSERT ON "MANAGER"."SaleOrder" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
BEGIN
       UPDATE "Storage" SET "ProductCount"="ProductCount"-:NEW."SaleOrderCount" WHERE "ProductID"=:NEW."ProductID";
    END;
/
CREATE TRIGGER "MANAGER"."CHECK_PRODUCT_COUNT_IN_STORAGE" BEFORE INSERT ON "MANAGER"."SaleOrder" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
DECLARE
    StorageProductCount NUMBER;
BEGIN
    SELECT "ProductCount" INTO StorageProductCount FROM "Storage" WHERE "Storage"."ProductID" = :NEW."ProductID";
    IF StorageProductCount < :NEW."SaleOrderCount" THEN
        RAISE_APPLICATION_ERROR(-20001, 'Product count is storage less than order');
    END IF;
END;
/
CREATE TRIGGER "MANAGER"."INCOME_ADD" AFTER UPDATE ON "MANAGER"."SaleOrder" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW 
declare
  P_ID number(19);
  Time_out timestamp(6);
  Price_out number(8,2);
  out_description varchar(400);
  P_name varchar(100);
  Product_name varchar(100);
begin
  if :NEW."ReceiveStatus" = 1
  then
    SELECT "ProductName" into Product_name from "Product" where "Product"."ProductID" = :OLD."ProductID";
    SELECT "UserName" into P_name from "User" where "User"."UserID" = :OLD."UserID";
    P_ID := :OLD."UserID";
    Time_out := :OLD."SaleDate";
    Price_out := :OLD."SaleProductPrice";
    out_description := '在'||to_char(Time_out,'yyyy-mm-dd HH:MI:SS')||'卖出产品'||Product_name||'共计:'||Price_out||'元'||'于客户'||P_name||'客户ID为:'||P_ID;
    insert into "Income"("UserID","SaleTime","SalePrice","Description")values (P_ID,Time_out,Price_out,out_description);
  end if;
end;
/

-- ----------------------------
-- Primary Key structure for table Send
-- ----------------------------
ALTER TABLE "MANAGER"."Send" ADD CONSTRAINT "PK_SEND" PRIMARY KEY ("SendListID");

-- ----------------------------
-- Checks structure for table Send
-- ----------------------------
ALTER TABLE "MANAGER"."Send" ADD CONSTRAINT "SYS_C0011076" CHECK ("UserID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Send" ADD CONSTRAINT "SYS_C0011077" CHECK ("SendListID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Send" ADD CONSTRAINT "SYS_C0011078" CHECK ("SendListCount" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Send" ADD CONSTRAINT "SYS_C0011079" CHECK ("SendListProductID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table Storage
-- ----------------------------
CREATE INDEX "MANAGER"."Relationship_6_FK"
  ON "MANAGER"."Storage" ("ProductID" ASC)
  LOGGING
  TABLESPACE "MANAGER"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
);

-- ----------------------------
-- Primary Key structure for table Supplier
-- ----------------------------
ALTER TABLE "MANAGER"."Supplier" ADD CONSTRAINT "PK_SUPPLIER" PRIMARY KEY ("SupplierID");

-- ----------------------------
-- Checks structure for table Supplier
-- ----------------------------
ALTER TABLE "MANAGER"."Supplier" ADD CONSTRAINT "SYS_C0011081" CHECK ("SupplierID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Supplier" ADD CONSTRAINT "SYS_C0011082" CHECK ("SupplierName" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Supplier" ADD CONSTRAINT "SYS_C0011083" CHECK ("SupplierAddress" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Supplier" ADD CONSTRAINT "SYS_C0011752" CHECK ("SupplierDescription" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."Supplier" ADD CONSTRAINT "SYS_C0011753" CHECK (
         length(SupplierPhone) =11 and SupplierPhone like'[0-9][0-9][0-9]_[0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
      ) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table User
-- ----------------------------
ALTER TABLE "MANAGER"."User" ADD CONSTRAINT "PK_USER" PRIMARY KEY ("UserID");

-- ----------------------------
-- Checks structure for table User
-- ----------------------------
ALTER TABLE "MANAGER"."User" ADD CONSTRAINT "SYS_C0011085" CHECK ("UserID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."User" ADD CONSTRAINT "SYS_C0011086" CHECK ("UserName" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."User" ADD CONSTRAINT "SYS_C0011087" CHECK ("Phone" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."User" ADD CONSTRAINT "SYS_C0011088" CHECK ("Address" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table BuyOrder
-- ----------------------------
ALTER TABLE "MANAGER"."BuyOrder" ADD CONSTRAINT "FK_BUYORDER_BUYPRODUC_PRODUCT" FOREIGN KEY ("ProductID") REFERENCES "MANAGER"."Product" ("ProductID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."BuyOrder" ADD CONSTRAINT "FK_BUYORDER_PROCESS_SUPPLIER" FOREIGN KEY ("SupplierID") REFERENCES "MANAGER"."Supplier" ("SupplierID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table Income
-- ----------------------------
ALTER TABLE "MANAGER"."Income" ADD CONSTRAINT "FK_INCOME_INCOME_USER" FOREIGN KEY ("UserID") REFERENCES "MANAGER"."User" ("UserID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table Outcome
-- ----------------------------
ALTER TABLE "MANAGER"."Outcome" ADD CONSTRAINT "FK_OUTCOME_OUTCOME2_SUPPLIER" FOREIGN KEY ("SupplierID") REFERENCES "MANAGER"."Supplier" ("SupplierID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table Product
-- ----------------------------
ALTER TABLE "MANAGER"."Product" ADD CONSTRAINT "FK_PRODUCT_SUPPLIER_SUPPLIER" FOREIGN KEY ("SupplierID") REFERENCES "MANAGER"."Supplier" ("SupplierID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table SaleOrder
-- ----------------------------
ALTER TABLE "MANAGER"."SaleOrder" ADD CONSTRAINT "FK_SALEORDE_OWN_USER" FOREIGN KEY ("UserID") REFERENCES "MANAGER"."User" ("UserID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "MANAGER"."SaleOrder" ADD CONSTRAINT "FK_SALEORDE_PRODUCE_PRODUCT" FOREIGN KEY ("ProductID") REFERENCES "MANAGER"."Product" ("ProductID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table Send
-- ----------------------------
ALTER TABLE "MANAGER"."Send" ADD CONSTRAINT "FK_SEND_SEND2_USER" FOREIGN KEY ("UserID") REFERENCES "MANAGER"."User" ("UserID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Foreign Keys structure for table Storage
-- ----------------------------
ALTER TABLE "MANAGER"."Storage" ADD CONSTRAINT "FK_STORAGE_ENTERSTOR_PRODUCT" FOREIGN KEY ("ProductID") REFERENCES "MANAGER"."Product" ("ProductID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
