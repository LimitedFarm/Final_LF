DROP TABLE Customer CASCADE CONSTRAINTS;
DROP TABLE Admin CASCADE CONSTRAINTS;
DROP TABLE seller CASCADE CONSTRAINTS;
DROP TABLE PList CASCADE CONSTRAINTS;
DROP TABLE FAQ CASCADE CONSTRAINTS;
DROP TABLE Answer CASCADE CONSTRAINTS;
DROP TABLE Question CASCADE CONSTRAINTS;
DROP TABLE CReportList CASCADE CONSTRAINTS;
DROP TABLE SReportList CASCADE CONSTRAINTS;
DROP TABLE orderList CASCADE CONSTRAINTS;
DROP TABLE Category CASCADE CONSTRAINTS;
DROP TABLE pAttachment CASCADE CONSTRAINTS;
DROP TABLE Review CASCADE CONSTRAINTS;
DROP TABLE BASKET CASCADE CONSTRAINTS;


DROP SEQUENCE CID_SEQ;
DROP SEQUENCE AID_SEQ;
DROP SEQUENCE ANID_SEQ;
DROP SEQUENCE QID_SEQ;
DROP SEQUENCE FAQ_SEQ;
DROP SEQUENCE SRID_SEQ;
DROP SEQUENCE REID_SEQ;
DROP SEQUENCE SALEID_SEQ;
DROP SEQUENCE PID_SEQ;
DROP SEQUENCE SID_SEQ;
DROP SEQUENCE CATEID_SEQ;
DROP SEQUENCE FID_SEQ;
DROP SEQUENCE CRID_SEQ;
DROP SEQUENCE BASKET_SEQ;

CREATE SEQUENCE CID_SEQ;
CREATE SEQUENCE AID_SEQ;
CREATE SEQUENCE ANID_SEQ;
CREATE SEQUENCE QID_SEQ;
CREATE SEQUENCE FAQ_SEQ;
CREATE SEQUENCE SRID_SEQ;
CREATE SEQUENCE REID_SEQ;
CREATE SEQUENCE SALEID_SEQ;
CREATE SEQUENCE PID_SEQ;
CREATE SEQUENCE SID_SEQ;
CREATE SEQUENCE CATEID_SEQ;
CREATE SEQUENCE FID_SEQ;
CREATE SEQUENCE CRID_SEQ;
CREATE SEQUENCE BASKET_SEQ;

CREATE TABLE FAQ (
	FAQId	NUMBER		NOT NULL,
	FAQTitle	NVARCHAR2(50)		NULL,
	FAQContent	NVARCHAR2(500)		NULL,
	status	CHAR(1) CHECK(status in ('Y', 'N')),
	aId	NUMBER		NOT NULL
);

ALTER TABLE FAQ
MODIFY status DEFAULT 'Y' NOT NULL;

COMMENT ON COLUMN FAQ.FAQId IS 'FAQ번호';

COMMENT ON COLUMN FAQ.FAQTitle IS 'FAQ 제목';

COMMENT ON COLUMN FAQ.FAQContent IS 'FAQ 내용';

COMMENT ON COLUMN FAQ.status IS 'FAQ 상태';

COMMENT ON COLUMN FAQ.aId IS '관리자번호';

CREATE TABLE Review (
	reId	NUMBER		NOT NULL,
	reContent	NVARCHAR2(500)		NOT NULL,
	grade	NUMBER	DEFAULT 5	NOT NULL,
	review_date	DATE	DEFAULT SYSDATE	NOT NULL,
	review_Modify	DATE		NULL,
	status	CHAR(1) CHECK(status in ('Y', 'N')),
	cId	NUMBER		NOT NULL,
	sale_Id	NUMBER		NOT NULL
);

ALTER TABLE Review
MODIFY status DEFAULT 'Y' NOT NULL;

COMMENT ON COLUMN Review.reId IS '리뷰 번호';

COMMENT ON COLUMN Review.reContent IS '리뷰내용';

COMMENT ON COLUMN Review.grade IS '상품 평점';

COMMENT ON COLUMN Review.review_date IS '리뷰 날짜';

COMMENT ON COLUMN Review.review_Modify IS '리뷰 수정일';

COMMENT ON COLUMN Review.status IS '리뷰 상태';

COMMENT ON COLUMN Review.cId IS '시퀀스를 통한 회원번호';

COMMENT ON COLUMN Review.sale_Id IS '판매 번호';

CREATE TABLE seller (
	sId	NUMBER		NOT NULL,
	bStatus	CHAR(1) CHECK(bStatus in ('Y', 'N')),
	bName	NVARCHAR2(50)		NOT NULL,
	bNum	NVARCHAR2(20)		NULL,
	cpNum	NVARCHAR2(20)		NULL,
	acNum	NVARCHAR2(20)		NULL,
	acName	NVARCHAR2(10)		NOT NULL,
	bankName	NVARCHAR2(30)		NOT NULL,
	sJoinDate	DATE	DEFAULT SYSDATE	NOT NULL,
	sModifyDate	Date	DEFAULT SYSDATE	NOT NULL,
	cId	NUMBER		NOT NULL,
    fId	NUMBER		NULL
);

ALTER TABLE seller
MODIFY bStatus DEFAULT 'Y' NOT NULL;

COMMENT ON COLUMN seller.sId IS '판매자 회원번호';

COMMENT ON COLUMN seller.bStatus IS '물품판매 권한 승인여부';

COMMENT ON COLUMN seller.bName IS '사업자 이름';

COMMENT ON COLUMN seller.bNum IS '사업자 번호';

COMMENT ON COLUMN seller.cpNum IS '법인번호';

COMMENT ON COLUMN seller.acNum IS '계좌번호';

COMMENT ON COLUMN seller.acName IS '예금주';

COMMENT ON COLUMN seller.bankName IS '계좌 은행 이름';

COMMENT ON COLUMN seller.sJoinDate IS '판매자등록날짜';

COMMENT ON COLUMN seller.sModifyDate IS '정보 수정 날짜';

COMMENT ON COLUMN seller.fId IS '파일 번호';

COMMENT ON COLUMN seller.cId IS '시퀀스를 통한 회원번호';

CREATE TABLE CReportList (
	crId	NUMBER		NOT NULL,
	cId	NUMBER		NOT NULL,
	noContent	NVARCHAR2(500)		NULL,
	report_date	DATE	DEFAULT SYSDATE	NOT NULL,
	status	CHAR(1) CHECK(status in ('Y', 'N')),
	sale_Id	NUMBER		NOT NULL
);

ALTER TABLE CReportList
MODIFY status DEFAULT 'Y' NOT NULL;

COMMENT ON COLUMN CReportList.crId IS '신고번호';

COMMENT ON COLUMN CReportList.cId IS '시퀀스를 통한 회원번호';

COMMENT ON COLUMN CReportList.noContent IS '신고내용';

COMMENT ON COLUMN CReportList.report_date IS '신고 접수 날짜';

COMMENT ON COLUMN CReportList.status IS '신고 내역 상태';

COMMENT ON COLUMN CReportList.sale_Id IS '판매 번호';

CREATE TABLE PList (
	pId	NUMBER		NOT NULL,
	sId	NUMBER		NOT NULL,
	pName	NVARCHAR2(20)		NULL,
	pPrice	NUMBER		NOT NULL,
	pCount	NUMBER		NOT NULL,
	pAddress	NVARCHAR2(50)		NOT NULL,
	pDay	DATE		NULL,
	pPeriod	DATE		NULL,
    pText1 NVARCHAR2(100) NULL,
    pText2 NVARCHAR2(100) NULL,
    pText3 NVARCHAR2(100) NULL,
    pText4 NVARCHAR2(100) NULL,
    pText5 NVARCHAR2(100) NULL,
	createDate	DATE	DEFAULT SYSDATE	NULL,
	pModifyDate	DATE		NULL,
	status	CHAR(1) CHECK(status in ('Y', 'N')),
	cateId	NUMBER		NOT NULL
);

ALTER TABLE PList
MODIFY status DEFAULT 'Y' NOT NULL;

COMMENT ON COLUMN PList.pId IS '상품 번호';

COMMENT ON COLUMN PList.sId IS '판매자 회원번호';

COMMENT ON COLUMN PList.pName IS '상품명';

COMMENT ON COLUMN PList.pPrice IS '상품 가격';

COMMENT ON COLUMN PList.pCount IS '상품 재고량';

COMMENT ON COLUMN PList.pAddress IS '상품 원산지';

COMMENT ON COLUMN PList.pText1 IS '상품설명1';

COMMENT ON COLUMN PList.pText2 IS '상품설명2';

COMMENT ON COLUMN PList.pText3 IS '상품설명3';

COMMENT ON COLUMN PList.pText4 IS '상품설명4';

COMMENT ON COLUMN PList.pText5 IS '상품설명5';

COMMENT ON COLUMN PList.pDay IS '상품 생산일자';

COMMENT ON COLUMN PList.pPeriod IS '상품 유통기한';

COMMENT ON COLUMN PList.createDate IS '물품 등록일';

COMMENT ON COLUMN PList.pModifyDate IS '수정날짜';

COMMENT ON COLUMN PList.status IS '상품 판매 유무';

COMMENT ON COLUMN PList.cateId IS '카테고리 번호';

CREATE TABLE Answer (
	anId	NUMBER		NOT NULL,
	anContent	NVARCHAR2(500)		NULL,
	answer_date	DATE	DEFAULT SYSDATE	NOT NULL,
	status	CHAR(1) CHECK(status in ('Y', 'N')),
	aId	NUMBER		NOT NULL,
	qId	NUMBER		NOT NULL,
	cId	NUMBER		NOT NULL
);

ALTER TABLE Answer
MODIFY status DEFAULT 'Y' NOT NULL;

COMMENT ON COLUMN Answer.anId IS '답변번호';

COMMENT ON COLUMN Answer.anContent IS '답변내용';

COMMENT ON COLUMN Answer.answer_date IS '답변 날짜';

COMMENT ON COLUMN Answer.status IS '답변 상태';

COMMENT ON COLUMN Answer.aId IS '관리자번호';

COMMENT ON COLUMN Answer.qId IS '문의번호';

COMMENT ON COLUMN Answer.cId IS '시퀀스를 통한 회원번호';

CREATE TABLE orderList (
	sale_Id	NUMBER		NOT NULL,
	status	CHAR(1) CHECK(status in ('Y', 'N')),
    pName	NVARCHAR2(20)		NOT NULL,
	sale_date	DATE	DEFAULT SYSDATE	NOT NULL,
	sCount	NUMBER		NOT NULL,
	daName	NVARCHAR2(20)		NOT NULL,
	orPhone	NVARCHAR2(20)		NULL,
	daAddress	NVARCHAR2(50)		NOT NULL,
	daMessage	NVARCHAR2(50)		NULL,
	pId	NUMBER		NOT NULL,
	sId	NUMBER		NOT NULL,
	cId	NUMBER		NOT NULL
);

ALTER TABLE orderList
MODIFY status DEFAULT 'Y' NOT NULL;

COMMENT ON COLUMN orderList.sale_Id IS '판매 번호';

COMMENT ON COLUMN orderList.status IS '판매 상태';

COMMENT ON COLUMN orderList.pName IS '상품명';

COMMENT ON COLUMN orderList.sale_date IS '판매 날짜';

COMMENT ON COLUMN orderList.sCount IS '판매 물품 수량';

COMMENT ON COLUMN orderList.daName IS '주문자 이름';

COMMENT ON COLUMN orderList.orPhone IS '배송지 연락처';

COMMENT ON COLUMN orderList.daAddress IS '배송지 주소';

COMMENT ON COLUMN orderList.daMessage IS '요청 사항';

COMMENT ON COLUMN orderList.pId IS '상품 번호';

COMMENT ON COLUMN orderList.sId IS '판매자 회원번호';

COMMENT ON COLUMN orderList.cId IS '시퀀스를 통한 회원번호';

CREATE TABLE Customer (
	cId	NUMBER		NOT NULL,
	userId	NVARCHAR2(12)		NOT NULL,
	userPwd	NVARCHAR2(20)		NOT NULL,
	userName	NVARCHAR2(20)		NOT NULL,
	address	NVARCHAR2(50)		NOT NULL,
	phone	NVARCHAR2(11)		NOT NULL,
	email	NVARCHAR2(50)		NOT NULL,
	joinDate	DATE	DEFAULT SYSDATE	NOT NULL,
	modifyDate	DATE	DEFAULT SYSDATE	NOT NULL,
	groupNum	CHAR(1) CHECK(groupNum in('1', '2', '3')),
	status	CHAR(1) CHECK(status in ('Y', 'N'))
);

ALTER TABLE Customer
MODIFY groupNum DEFAULT '1' NOT NULL;

ALTER TABLE Customer
MODIFY status DEFAULT 'Y' NOT NULL;

COMMENT ON COLUMN Customer.cId IS '시퀀스를 통한 회원번호';

COMMENT ON COLUMN Customer.userId IS '회원아이디';

COMMENT ON COLUMN Customer.userPwd IS '회원비밀번호';

COMMENT ON COLUMN Customer.userName IS '유저 이름';

COMMENT ON COLUMN Customer.address IS '회원 주소';

COMMENT ON COLUMN Customer.phone IS '회원 전화번호';

COMMENT ON COLUMN Customer.email IS '회원 이메일';

COMMENT ON COLUMN Customer.joinDate IS '회원가입일자';

COMMENT ON COLUMN Customer.modifyDate IS '정보 수정일자';

COMMENT ON COLUMN Customer.groupNum IS '관리자 3, 판매자 2, 일반 회원 1';

COMMENT ON COLUMN Customer.status IS '회원 상태정보(탈퇴시 N)';

CREATE TABLE Category (
	cateId	NUMBER		NOT NULL,
	category	NVARCHAR2(50)		NOT NULL
);

COMMENT ON COLUMN Category.cateId IS '카테고리 번호';

COMMENT ON COLUMN Category.category IS '카테고리 이름';

CREATE TABLE pAttachment (
	fId	NUMBER		NOT NULL,
	pId	NUMBER		NULL,
	file_name	NVARCHAR2(20)		NOT NULL,
	change_name	NVARCHAR2(100)		NOT NULL,
	file_path	NVARCHAR2(100)		NOT NULL,
	upload_date	DATE	DEFAULT SYSDATE	NOT NULL,
	modify_date	DATE	DEFAULT SYSDATE	NULL,
	status	CHAR(1) CHECK(status in ('Y', 'N'))
);

ALTER TABLE pAttachment
MODIFY status DEFAULT 'Y' NOT NULL;

COMMENT ON COLUMN pAttachment.fId IS '파일 번호';

COMMENT ON COLUMN pAttachment.file_name IS '파일 이름';

COMMENT ON COLUMN pAttachment.change_name IS '수정된 파일 이름';

COMMENT ON COLUMN pAttachment.file_path IS '파일 경로';

COMMENT ON COLUMN pAttachment.upload_date IS '업로드 날짜';

COMMENT ON COLUMN pAttachment.modify_date IS '파일수정날짜';

COMMENT ON COLUMN pAttachment.status IS '파일 상태 여부';

CREATE TABLE Admin (
	aId	NUMBER		NOT NULL,
	admin_Level	NUMBER	DEFAULT 1	NOT NULL,
	cId	NUMBER		NOT NULL
);

COMMENT ON COLUMN Admin.aId IS '관리자번호';

COMMENT ON COLUMN Admin.admin_Level IS '관리자권한 0 또는 1';

COMMENT ON COLUMN Admin.cId IS '시퀀스를 통한 회원번호';

CREATE TABLE SReportList (
	srId	NUMBER		NOT NULL,
	reId	NUMBER		NOT NULL,
	noContent	NVARCHAR2(500)		NULL,
	report_date	DATE	DEFAULT SYSDATE	NOT NULL,
	status	CHAR(1) CHECK(status in ('Y', 'N')),
	sale_Id	NUMBER		NOT NULL,
	sId	NUMBER		NOT NULL
);

ALTER TABLE SReportList
MODIFY status DEFAULT 'Y' NOT NULL;

COMMENT ON COLUMN SReportList.srId IS '신고번호';

COMMENT ON COLUMN SReportList.reId IS '리뷰 번호';

COMMENT ON COLUMN SReportList.noContent IS '신고내용';

COMMENT ON COLUMN SReportList.report_date IS '신고 날짜';

COMMENT ON COLUMN SReportList.status IS '판매자 신고 상태';

COMMENT ON COLUMN SReportList.sale_Id IS '판매 번호';

COMMENT ON COLUMN SReportList.sId IS '판매자 회원번호';

CREATE TABLE Question (
	qId	NUMBER		NOT NULL,
	cId	NUMBER		NOT NULL,
	qTitle	NVARCHAR2(50)		NOT NULL,
	qContent	NVARCHAR2(500)		NULL,
	question_date	DATE	DEFAULT SYSDATE	NOT NULL,
	status	CHAR(1) CHECK(status in ('Y', 'N')),
	fId	NUMBER		NOT NULL
);

ALTER TABLE Question
MODIFY status DEFAULT 'Y' NOT NULL;

COMMENT ON COLUMN Question.qId IS '문의번호';

COMMENT ON COLUMN Question.cId IS '시퀀스를 통한 회원번호';

COMMENT ON COLUMN Question.qTitle IS '문의제목';

COMMENT ON COLUMN Question.qContent IS '문의내용';

COMMENT ON COLUMN Question.question_date IS '문의 날짜';

COMMENT ON COLUMN Question.status IS '문의 상태';

COMMENT ON COLUMN Question.fId IS '파일 번호';

CREATE TABLE basket (
	basketId	NUMBER		NOT NULL,
	cId	NUMBER		NOT NULL,
	pId	NUMBER		NOT NULL,
    sid NUMBER      NOT NULL,
	count	NUMBER		NOT NULL
);

COMMENT ON COLUMN basket.basketId IS '장바구니 번호';

COMMENT ON COLUMN basket.cId IS '시퀀스를 통한 회원번호';

COMMENT ON COLUMN basket.pId IS '상품 번호';

COMMENT ON COLUMN basket.sid IS '판매자 회원 번호';

COMMENT ON COLUMN basket.count IS '물품 수량';

ALTER TABLE FAQ ADD CONSTRAINT PK_FAQ PRIMARY KEY (
	FAQId
);

ALTER TABLE Review ADD CONSTRAINT PK_REVIEW PRIMARY KEY (
	reId
);

ALTER TABLE seller ADD CONSTRAINT PK_SELLER PRIMARY KEY (
	sId
);

ALTER TABLE CReportList ADD CONSTRAINT PK_CREPORTLIST PRIMARY KEY (
	crId,
	cId
);

ALTER TABLE PList ADD CONSTRAINT PK_PLIST PRIMARY KEY (
	pId,
	sId
);

ALTER TABLE Answer ADD CONSTRAINT PK_ANSWER PRIMARY KEY (
	anId
);

ALTER TABLE orderList ADD CONSTRAINT PK_ORDERLIST PRIMARY KEY (
	sale_Id
);

ALTER TABLE Customer ADD CONSTRAINT PK_CUSTOMER PRIMARY KEY (
	cId
);

ALTER TABLE Category ADD CONSTRAINT PK_CATEGORY PRIMARY KEY (
	cateId
);

ALTER TABLE pAttachment ADD CONSTRAINT PK_PATTACHMENT PRIMARY KEY (
	fId
);

ALTER TABLE Admin ADD CONSTRAINT PK_ADMIN PRIMARY KEY (
	aId
);

ALTER TABLE SReportList ADD CONSTRAINT PK_SREPORTLIST PRIMARY KEY (
	srId,
	reId
);

ALTER TABLE Question ADD CONSTRAINT PK_QUESTION PRIMARY KEY (
	qId,
	cId
);

ALTER TABLE basket ADD CONSTRAINT PK_BASKET PRIMARY KEY (
	basketId,
	cId
);

ALTER TABLE FAQ ADD CONSTRAINT FK_Admin_TO_FAQ_1 FOREIGN KEY (
	aId
)
REFERENCES Admin (
	aId
);

ALTER TABLE Review ADD CONSTRAINT FK_Customer_TO_Review_1 FOREIGN KEY (
	cId
)
REFERENCES Customer (
	cId
);

ALTER TABLE Review ADD CONSTRAINT FK_orderList_TO_Review_1 FOREIGN KEY (
	sale_Id
)
REFERENCES orderList (
	sale_Id
);

ALTER TABLE seller ADD CONSTRAINT FK_pAttachment_TO_seller_1 FOREIGN KEY (
	fId
)
REFERENCES pAttachment (
	fId
);

ALTER TABLE seller ADD CONSTRAINT FK_Customer_TO_seller_1 FOREIGN KEY (
	cId
)
REFERENCES Customer (
	cId
);

ALTER TABLE CReportList ADD CONSTRAINT FK_Customer_TO_CReportList_1 FOREIGN KEY (
	cId
)
REFERENCES Customer (
	cId
);

ALTER TABLE CReportList ADD CONSTRAINT FK_orderList_TO_CReportList_1 FOREIGN KEY (
	sale_Id
)
REFERENCES orderList (
	sale_Id
);

ALTER TABLE PList ADD CONSTRAINT FK_seller_TO_PList_1 FOREIGN KEY (
	sId
)
REFERENCES seller (
	sId
);

ALTER TABLE PList ADD CONSTRAINT FK_Category_TO_PList_1 FOREIGN KEY (
	cateId
)
REFERENCES Category (
	cateId
);

ALTER TABLE Answer ADD CONSTRAINT FK_Admin_TO_Answer_1 FOREIGN KEY (
	aId
)
REFERENCES Admin (
	aId
);

ALTER TABLE Answer ADD CONSTRAINT FK_Question_TO_Answer_1 FOREIGN KEY (
	qId, cId
)
REFERENCES Question (
	qId, cId
);

ALTER TABLE orderList ADD CONSTRAINT FK_PList_TO_orderList_1 FOREIGN KEY (
	pId, sId
)
REFERENCES PList (
	pId, sId
);

ALTER TABLE orderList ADD CONSTRAINT FK_Customer_TO_orderList_1 FOREIGN KEY (
	cId
)
REFERENCES Customer (
	cId
);

ALTER TABLE Admin ADD CONSTRAINT FK_Customer_TO_Admin_1 FOREIGN KEY (
	cId
)
REFERENCES Customer (
	cId
);

ALTER TABLE SReportList ADD CONSTRAINT FK_Review_TO_SReportList_1 FOREIGN KEY (
	reId
)
REFERENCES Review (
	reId
);

ALTER TABLE SReportList ADD CONSTRAINT FK_orderList_TO_SReportList_1 FOREIGN KEY (
	sale_Id
)
REFERENCES orderList (
	sale_Id
);

ALTER TABLE SReportList ADD CONSTRAINT FK_seller_TO_SReportList_1 FOREIGN KEY (
	sId
)
REFERENCES seller (
	sId
);

ALTER TABLE Question ADD CONSTRAINT FK_Customer_TO_Question_1 FOREIGN KEY (
	cId
)
REFERENCES Customer (
	cId
);

ALTER TABLE Question ADD CONSTRAINT FK_pAttachment_TO_Question_1 FOREIGN KEY (
	fId
)
REFERENCES pAttachment (
	fId
);

ALTER TABLE basket ADD CONSTRAINT FK_Customer_TO_basket_1 FOREIGN KEY (
	cId
)
REFERENCES Customer (
	cId
);

ALTER TABLE basket ADD CONSTRAINT FK_PList_TO_basket_1 FOREIGN KEY (
	pId, sid
)
REFERENCES PList (
	pId, sid
);