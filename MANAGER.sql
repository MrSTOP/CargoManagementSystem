prompt PL/SQL Developer Export User Objects for user MANAGER@47.103.113.9:1521/ORCL
prompt Created by MrST on 2019å¹´8æœˆ28æ—¥
set define off
spool MANAGER.log

prompt
prompt Creating table Administrator
prompt ============================
prompt
create table MANAGER.Administrator
(
  "UserName" VARCHAR2(255) not null,
  "PassWord" VARCHAR2(255) not null
)
tablespace MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER.Administrator
  add primary key (UserName)
  using index 
  tablespace MANAGER
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table Bank
prompt ===================
prompt
create table MANAGER.Bank
(
  "CompanyAccount" NUMBER(8,2) not null
)
tablespace MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table Supplier
prompt =======================
prompt
create table MANAGER.Supplier
(
  "SupplierID"          NUMBER(19) not null,
  "SupplierName"        VARCHAR2(1024) not null,
  "SupplierDescription" VARCHAR2(1024) not null,
  "SupplierAddress"     VARCHAR2(1024) not null,
  "SupplierPhone"       VARCHAR2(255)
)
tablespace MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER.Supplier
  add constraint PK_SUPPLIER primary key (SupplierID)
  using index 
  tablespace MANAGER
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table Product
prompt ======================
prompt
create table MANAGER.Product
(
  "ProductID"          NUMBER(19) not null,
  "SupplierID"         NUMBER(19),
  "ProductName"        VARCHAR2(1024),
  "ProductSalePrice"   NUMBER(8,2),
  "ProductBuyPrice"    NUMBER(8,2),
  "ProductDescription" VARCHAR2(1024)
)
tablespace MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER.Product
  add constraint PK_PRODUCT primary key (ProductID)
  using index 
  tablespace MANAGER
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER.Product
  add constraint FK_PRODUCT_SUPPLIER_SUPPLIER foreign key (SupplierID)
  references MANAGER.Supplier (SupplierID);

prompt
prompt Creating table BuyOrder
prompt =======================
prompt
create table MANAGER.BuyOrder
(
  "SupplierOrderID" NUMBER(19) not null,
  "ProductID"       NUMBER(19) not null,
  "SupplierID"      NUMBER(19) not null,
  "SupplierDate"    TIMESTAMP(6) not null,
  "SupplierStatus"  INTEGER not null,
  "SupplierCount"   INTEGER not null,
  "SupplierPrice"   NUMBER(8,2) not null
)
tablespace MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index MANAGER.Process_FK on MANAGER.BuyOrder (SupplierID)
  tablespace MANAGER
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index MANAGER.Relationship_7_FK on MANAGER.BuyOrder (ProductID)
  tablespace MANAGER
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER.BuyOrder
  add constraint PK_BUYORDER primary key (SupplierOrderID, ProductID, SupplierID)
  using index 
  tablespace MANAGER
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER.BuyOrder
  add constraint FK_BUYORDER_BUYPRODUC_PRODUCT foreign key (ProductID)
  references MANAGER.Product (ProductID);
alter table MANAGER.BuyOrder
  add constraint FK_BUYORDER_PROCESS_SUPPLIER foreign key (SupplierID)
  references MANAGER.Supplier (SupplierID);

prompt
prompt Creating table User
prompt ===================
prompt
create table MANAGER.User
(
  "UserID"   NUMBER(19) not null,
  "UserName" VARCHAR2(1024) not null,
  "Phone"    CHAR(11) not null,
  "Email"    VARCHAR2(1024),
  "Address"  VARCHAR2(1024) not null
)
tablespace MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER.User
  add constraint PK_USER primary key (UserID)
  using index 
  tablespace MANAGER
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table Income
prompt =====================
prompt
create table MANAGER.Income
(
  "UserID"            NUMBER(19) not null,
  "SaleTime"          TIMESTAMP(6) not null,
  "SalePrice"         NUMBER(8,2) not null,
  "SaleIncomeOrderID" NUMBER(19) not null,
  "Description"       VARCHAR2(400) not null
)
tablespace MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER.Income
  add constraint PK_INCOME primary key (SaleIncomeOrderID)
  using index 
  tablespace MANAGER
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER.Income
  add constraint FK_INCOME_INCOME_USER foreign key (UserID)
  references MANAGER.User (UserID);

prompt
prompt Creating table OrderProduct
prompt ===========================
prompt
create table MANAGER.OrderProduct
(
  "SupplierOrderID"    NUMBER(19) not null,
  "SupplierOrderCount" INTEGER
)
tablespace MANAGER
  pctfree 10
  initrans 1
  maxtrans 255;
alter table MANAGER.OrderProduct
  add constraint PK_ORDERPRODUCT primary key (SupplierOrderID)
  using index 
  tablespace MANAGER
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table Outcome
prompt ======================
prompt
create table MANAGER.Outcome
(
  "SupplierID"    NUMBER(19) not null,
  "OutTime"       TIMESTAMP(6) not null,
  "OutPrice"      NUMBER(8,2) not null,
  "OutSupplierID" NUMBER(19) not null,
  "Description"   VARCHAR2(400) not null
)
tablespace MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER.Outcome
  add constraint PK_OUTCOME primary key (OutSupplierID)
  using index 
  tablespace MANAGER
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER.Outcome
  add constraint FK_OUTCOME_OUTCOME2_SUPPLIER foreign key (SupplierID)
  references MANAGER.Supplier (SupplierID);

prompt
prompt Creating table SaleOrder
prompt ========================
prompt
create table MANAGER.SaleOrder
(
  "SaleOrderID"      NUMBER(19) not null,
  "UserID"           NUMBER(19),
  "ProductID"        NUMBER(19),
  "SaleOrderCount"   INTEGER,
  "SaleDate"         TIMESTAMP(6),
  "SaleProductPrice" NUMBER(8,2),
  "ReceiveStatus"    INTEGER
)
tablespace MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index MANAGER.Relationship_4_FK on MANAGER.SaleOrder (ProductID)
  tablespace MANAGER
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER.SaleOrder
  add constraint PK_SALEORDER primary key (SaleOrderID)
  using index 
  tablespace MANAGER
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER.SaleOrder
  add constraint FK_SALEORDE_OWN_USER foreign key (UserID)
  references MANAGER.User (UserID);
alter table MANAGER.SaleOrder
  add constraint FK_SALEORDE_PRODUCE_PRODUCT foreign key (ProductID)
  references MANAGER.Product (ProductID);

prompt
prompt Creating table Send
prompt ===================
prompt
create table MANAGER.Send
(
  "UserID"            NUMBER(19) not null,
  "SendListID"        NUMBER(19) not null,
  "SendListCount"     INTEGER not null,
  "SendListProductID" NUMBER(19) not null
)
tablespace MANAGER
  pctfree 10
  initrans 1
  maxtrans 255;
alter table MANAGER.Send
  add constraint PK_SEND primary key (SendListID)
  using index 
  tablespace MANAGER
  pctfree 10
  initrans 2
  maxtrans 255;
alter table MANAGER.Send
  add constraint FK_SEND_SEND2_USER foreign key (UserID)
  references MANAGER.User (UserID);

prompt
prompt Creating table Storage
prompt ======================
prompt
create table MANAGER.Storage
(
  "ProductID"    NUMBER(19),
  "ProductCount" INTEGER
)
tablespace MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index MANAGER.Relationship_6_FK on MANAGER.Storage (ProductID)
  tablespace MANAGER
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER.Storage
  add constraint FK_STORAGE_ENTERSTOR_PRODUCT foreign key (ProductID)
  references MANAGER.Product (ProductID);

prompt
prompt Creating sequence BUY_ORDER_ID_SEQ
prompt ==================================
prompt
create sequence MANAGER.BUY_ORDER_ID_SEQ
minvalue 1
maxvalue 9223372036854775807
start with 201
increment by 1
cache 50;

prompt
prompt Creating sequence INCOME_SEQ
prompt ============================
prompt
create sequence MANAGER.INCOME_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence PRODUCT_ID_SEQ
prompt ================================
prompt
create sequence MANAGER.PRODUCT_ID_SEQ
minvalue 1
maxvalue 9223372036854775807
start with 151
increment by 1
cache 50;

prompt
prompt Creating sequence SALE_ORDER_ID_SEQ
prompt ===================================
prompt
create sequence MANAGER.SALE_ORDER_ID_SEQ
minvalue 1
maxvalue 9223372036854775807
start with 151
increment by 1
cache 50;

prompt
prompt Creating sequence SUPPLIER_ID_SEQ
prompt =================================
prompt
create sequence MANAGER.SUPPLIER_ID_SEQ
minvalue 1
maxvalue 9223372036854775807
start with 101
increment by 1
cache 50;

prompt
prompt Creating sequence USER_ID_SEQ
prompt =============================
prompt
create sequence MANAGER.USER_ID_SEQ
minvalue 1
maxvalue 9223372036854775807
start with 101
increment by 1
cache 50;

prompt
prompt Creating sequence USER_SEQ
prompt ==========================
prompt
create sequence MANAGER.USER_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 10
increment by 1
nocache;

prompt
prompt Creating procedure SUPPLIER_INSERT
prompt ==================================
prompt
CREATE OR REPLACE PROCEDURE MANAGER.SUPPLIER_INSERT(
SupplierName IN VARCHAR2,
SupplierDescription IN VARCHAR2,
SupplierAddress IN VARCHAR2,
SupplierPhone IN VARCHAR2
)
IS
    BEGIN
        INSERT INTO "Supplier"("SupplierID", "SupplierName", "SupplierDescription", "SupplierAddress", "SupplierPhone")
        VALUES (SUPPLIER_ID_SEQ.nextval, SupplierName, SupplierDescription, SupplierAddress, SupplierPhone);
    END;
/

prompt
prompt Creating trigger AUTO_ADD_BANK_AFTER_SALE
prompt =========================================
prompt
CREATE OR REPLACE TRIGGER MANAGER.AUTO_ADD_BANK_AFTER_SALE
    AFTER INSERT ON "SaleOrder" FOR EACH ROW
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

prompt
prompt Creating trigger AUTO_ADD_PRODUCT_IN_STORAGE
prompt ============================================
prompt
CREATE OR REPLACE TRIGGER MANAGER.AUTO_ADD_PRODUCT_IN_STORAGE
    AFTER UPDATE ON "BuyOrder" FOR EACH ROW
    BEGIN
        IF :NEW."SupplierStatus"=1 THEN
            UPDATE "Storage" SET "ProductCount"="ProductCount"+:NEW."SupplierCount" WHERE "ProductID"=:NEW."ProductID";
        END IF;
    END;
/

prompt
prompt Creating trigger AUTO_ADD_PRODUCT_TO_STORAGE
prompt ============================================
prompt
CREATE OR REPLACE TRIGGER MANAGER.AUTO_ADD_PRODUCT_TO_STORAGE
    AFTER INSERT ON "Product" FOR EACH ROW
    BEGIN
        INSERT INTO "Storage"("ProductID", "ProductCount") VALUES (:NEW."ProductID", 0);
    END;
/

prompt
prompt Creating trigger AUTO_DELETE_PRODUCT_IN_STORAGE
prompt ===============================================
prompt
CREATE OR REPLACE TRIGGER MANAGER.AUTO_DELETE_PRODUCT_IN_STORAGE
    AFTER DELETE ON "Product" FOR EACH ROW
    BEGIN
       DELETE FROM "Storage" WHERE "ProductID"=:OLD."ProductID";
    END;
/

prompt
prompt Creating trigger AUTO_SUB_BANK_AFTER_BUY
prompt ========================================
prompt
CREATE OR REPLACE TRIGGER MANAGER.AUTO_SUB_BANK_AFTER_BUY
    AFTER INSERT ON "BuyOrder" FOR EACH ROW
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

prompt
prompt Creating trigger AUTO_SUB_BANK_AFTER_RETURN
prompt ===========================================
prompt
CREATE OR REPLACE TRIGGER MANAGER.AUTO_SUB_BANK_AFTER_RETURN
    AFTER UPDATE ON "SaleOrder" FOR EACH ROW
DECLARE
ProductPrice NUMBER(8, 2);
SalePrice NUMBER(8, 2);
SaleCount NUMBER;
BEGIN
    IF :NEW."ReceiveStatus" = 2 THEN
        SELECT "ProductSalePrice" INTO ProductPrice FROM "Product" WHERE "Product"."ProductID" = :NEW."ProductID";
        SaleCount := :NEW."SaleOrderCount";
        SalePrice := ProductPrice * SaleCount;
        UPDATE "Bank" SET "CompanyAccount"="CompanyAccount" - SalePrice;
    END IF;
END;
/

prompt
prompt Creating trigger AUTO_SUB_PRODUCT_IN_STORAGE
prompt ============================================
prompt
CREATE OR REPLACE TRIGGER MANAGER.AUTO_SUB_PRODUCT_IN_STORAGE
    AFTER INSERT ON "SaleOrder" FOR EACH ROW
    BEGIN
       UPDATE "Storage" SET "ProductCount"="ProductCount"-:NEW."SaleOrderCount" WHERE "ProductID"=:NEW."ProductID";
    END;
/

prompt
prompt Creating trigger CHECK_PRODUCT_COUNT_IN_STORAGE
prompt ===============================================
prompt
CREATE OR REPLACE TRIGGER MANAGER.CHECK_PRODUCT_COUNT_IN_STORAGE
    BEFORE INSERT ON "SaleOrder" FOR EACH ROW
DECLARE
    StorageProductCount NUMBER;
BEGIN
    SELECT "ProductCount" INTO StorageProductCount FROM "Storage" WHERE "Storage"."ProductID" = :NEW."ProductID";
    IF StorageProductCount < :NEW."SaleOrderCount" THEN
        RAISE_APPLICATION_ERROR(-20001, 'Product count is storage less than order');
    END IF;
END;
/

prompt
prompt Creating trigger INCOME_ADD
prompt ===========================
prompt
create or replace trigger manager.income_add
  after update on "SaleOrder"
  for each row
declare
  P_ID number(19);
  Time_out timestamp(6);
  Price_out number(8,2);
  out_description varchar(400);
  P_name varchar(100);
  Product_name varchar(100);
  P_Count number(19);
begin
  if :NEW."ReceiveStatus" = 1
  then
    SELECT "ProductName" into Product_name from "Product" where "Product"."ProductID" = :OLD."ProductID";
    SELECT "UserName" into P_name from "User" where "User"."UserID" = :OLD."UserID";
    P_ID := :OLD."UserID";
    Time_out := SYSDATE;
    Price_out := :OLD."SaleProductPrice";
    P_Count := :OLD."SaleOrderCount";
    out_description := 'ÔÚ'||to_char(Time_out,'yyyy-mm-dd HH:MI:SS')||'Âô³ö²úÆ·'||Product_name||P_Count||'¼þ'||'ÊÕÈë¹²¼Æ:'||Price_out||'Ôª'||'¿Í»§ÐÕÃûÎª:'||P_name||'¿Í»§IDÎª:'||P_ID;
    insert into "Income"("UserID","SaleTime","SalePrice","Description")values (P_ID,Time_out,Price_out,out_description);
    elsif :NEW."ReceiveStatus" = 2
    then
      SELECT "ProductName" into Product_name from "Product" where "Product"."ProductID" = :OLD."ProductID";
      SELECT "UserName" into P_name from "User" where "User"."UserID" = :OLD."UserID";
      P_ID := :OLD."UserID";
      Time_out := SYSDATE;
      Price_out := :OLD."SaleProductPrice";
      out_description := 'ÔÚ'||to_char(Time_out,'yyyy-mm-dd HH:MI:SS')||'¿Í»§'||P_name||'¿Í»§IDÎª:'||P_ID||'ÍË»Ø²úÆ·'||Product_name||'×Ü¶î¹²¼Æ:'||Price_out||'Ôª';
      insert into "Income"("UserID","SaleTime","SalePrice","Description")values (P_ID,Time_out,Price_out,out_description);
  end if;

end;
/

prompt
prompt Creating trigger OUTCOME_ADD
prompt ============================
prompt
create or replace trigger manager.outcome_add
  after update on "BuyOrder"
  for each row
declare
P_ID number(19);
Time_out timestamp(6);
Price_out number(8,2);
out_description varchar(400);
P_name varchar(100);
Product_name varchar(100);
P_Count number(19);
begin
  if :NEW."SupplierStatus" = 1
    then
      SELECT "ProductName" into Product_name from "Product" where "Product"."ProductID" = :OLD."ProductID";
      SELECT "SupplierName" into P_name from "Supplier" where "SupplierID" = :OLD."SupplierID";
      P_ID := :OLD."SupplierID";
      Time_out := :OLD."SupplierDate";
      Price_out := :OLD."SupplierPrice";
      P_Count := :OLD."SupplierCount";
      out_description := 'ÔÚ'||to_char(Time_out,'yyyy-mm-dd HH:MI:SS')||'ÓÚ¹©Ó¦ÉÌ'||P_name||'´¦'||'¸¶³ö'||Price_out||'Ôª'||'ÂòÈë²úÆ·'||Product_name||P_Count||'¼þ'||'¹©Ó¦ÉÌIDÎª:'||P_ID;
      insert into "Outcome"("SupplierID", "OutTime", "OutPrice",  "Description") values (P_ID,Time_out,Price_out,out_description);
  end if;
end;
/

prompt
prompt Creating trigger TR_INCOME
prompt ==========================
prompt
create or replace trigger manager.tr_income
  before insert on "Income"
  for each row
begin
  select user_seq.nextval into :new."SaleIncomeOrderID" from dual;
end;
/

prompt
prompt Creating trigger TR_OUTCOME
prompt ===========================
prompt
create or replace trigger manager.tr_outcome
  before insert on "Outcome"
  for each row
begin
  select user_seq.nextval into :new."OutSupplierID" from dual;
end;
/


prompt Done
spool off
set define on
