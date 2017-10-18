-- begin BURGER_MENU_ITEM
create table BURGER_MENU_ITEM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    IMAGE_ID varchar(36),
    NAME varchar(255) not null,
    WEIGHT integer not null,
    PRICE integer not null,
    --
    primary key (ID)
)^
-- end BURGER_MENU_ITEM
-- begin BURGER_ORDER_ITEM
create table BURGER_ORDER_ITEM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    MENU_ITEM_ID varchar(36) not null,
    QUANTITY integer not null,
    ORDER_ID varchar(36),
    --
    primary key (ID)
)^
-- end BURGER_ORDER_ITEM
-- begin BURGER_ORDER
create table BURGER_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36) not null,
    STATUS integer,
    --
    primary key (ID)
)^
-- end BURGER_ORDER
