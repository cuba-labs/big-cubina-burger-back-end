alter table BURGER_MENU_ITEM add constraint FK_BURGER_MENU_ITEM_IMAGE foreign key (IMAGE_ID) references SYS_FILE(ID);
create index IDX_BURGER_MENU_ITEM_IMAGE on BURGER_MENU_ITEM (IMAGE_ID);
