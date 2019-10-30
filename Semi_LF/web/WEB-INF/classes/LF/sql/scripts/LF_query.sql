INSERT INTO CUSTOMER VALUES(CID_SEQ.NEXTVAL, 'user01', '1234', '홍길동', '123123', '123123123', '123@123123', sysdate, sysdate, default, default);
INSERT INTO CUSTOMER VALUES(CID_SEQ.NEXTVAL, 'user02', '1234', '아몰라', '123123', '123123123', '123@123123', sysdate, sysdate, default, default);
INSERT INTO CUSTOMER VALUES(CID_SEQ.NEXTVAL, 'user03', '1234', '기타', '123123', '123123123', '123@123123', sysdate, sysdate, default, default);
INSERT INTO CUSTOMER VALUES(CID_SEQ.NEXTVAL, 'admin01', '1234', '기타기타', '123123', '123123123', '123@123123', sysdate, sysdate, 3, default);
INSERT INTO CUSTOMER VALUES(CID_SEQ.NEXTVAL, 'seller01', '1234', '모르겠', '123123', '123123123', '123@123123', sysdate, sysdate, 2, default);
INSERT INTO CUSTOMER VALUES(CID_SEQ.NEXTVAL, 'seller02', '1234', '다아씨', '123123', '123123123', '123@123123', sysdate, sysdate, 2, default);
INSERT INTO CUSTOMER VALUES(CID_SEQ.NEXTVAL, 'seller03', '1234', '욕나와', '123123', '123123123', '123@123123', sysdate, sysdate, 2, default);

INSERT INTO ADMIN VALUES(AID_SEQ.NEXTVAL,0, 4);

INSERT INTO SELLER VALUES(SID_SEQ.NEXTVAL, 'Y', '민트초코', '123123', '123123', '123123', '123123', '123123', sysdate, sysdate, 5, NULL); 
INSERT INTO SELLER VALUES(SID_SEQ.NEXTVAL, 'Y', '딸기', '123123', '123123', '123123', '123123', '123123', sysdate, sysdate, 6, NULL); 
INSERT INTO SELLER VALUES(SID_SEQ.NEXTVAL, default, '바나나', '123123', '123123', '123123', '123123', '123123', sysdate, sysdate, 7, NULL);

COMMIT;

select * from customer where userid= 'user01' and userpwd = '1234';

select * from customer;

select * from admin;

select * from seller;