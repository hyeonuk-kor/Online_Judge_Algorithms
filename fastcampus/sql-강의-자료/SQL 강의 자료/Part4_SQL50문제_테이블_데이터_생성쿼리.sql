--------------------------------------------- 테이블 존재유무 파악 삭제 --------------------------------------------- 
DROP TABLE IF EXISTS tDepartment CASCADE;
DROP TABLE IF EXISTS tRank CASCADE;
DROP TABLE IF EXISTS tReturnReason CASCADE;
DROP TABLE IF EXISTS tItem CASCADE;
DROP TABLE IF EXISTS tCustomer CASCADE;
DROP TABLE IF EXISTS tEmployee CASCADE;
DROP TABLE IF EXISTS tProduction CASCADE;
DROP TABLE IF EXISTS tOrder CASCADE;
DROP TABLE IF EXISTS tReturn CASCADE;

--------------------------------------------- 테이블 생성 --------------------------------------------- 
--부서코드 테이블((UniqueNum(부서코드), 부서명) 
CREATE TABLE tDepartment
(
   DNumber varchar(5) not null
   , DName varchar(10) not null
);

--직급코드 테이블((UniqueNum(직급코드), 직급명) 
CREATE TABLE tRank
(
   RNumber varchar(5) not null
   , RName varchar(2) not null
);

--반품사유코드 테이블(((UniqueNum(직급코드), 사유) 
CREATE TABLE tReturnReason
(
   RRNumber varchar(6) not null
   , RReason varchar(4) not null --불량, 단순변심, 환불, 배송오류
);

--제품 코드 테이블(UniqueNum(제품코드), 제품명[가위,풀,공책, 동물사전,백과사전...], 단가, 등록일)
CREATE TABLE tItem
(
   INumber varchar(5) not null
   , IName varchar(20) not null
   , Price integer not null
   , RegisterDate timestamp with time zone not null
);

--고객 코드 테이블 (UniqueNum(고객코드), 고객명, 고객주소, 계약일)
CREATE TABLE tCustomer
(
   CNumber varchar(5) not null
   , CName varchar(20) not null
   , CAddr varchar(10) not null   
   , ContractDate timestamp with time zone  not null
);

--사원 정보 테이블 (UniqueNum(사원코드), 부서코드(null), 직급코드, 사람명, 주민번호, 주소, 입사일, 퇴사일(null))
CREATE TABLE tEmployee
(
   ENumber varchar(5) not null
   , DNumber varchar(5) null
   , RNumber varchar(5) not null
   , EName varchar(5) not null
   , ERRN varchar(14) not null   
   , EAddr varchar(10) not null
   ,  StartDate timestamp with time zone not null
   , ResignationDate timestamp with time zone null
);

--일별 생산 정보 테이블(UniqueNum(생산코드), 사원코드, 제품코드, 생산수량, 생산일)
CREATE TABLE tProduction
(
   PNumber varchar(5) not null
   , ENumber varchar(5) not null
   , INumber varchar(5) not null
   , PCount integer not null
   , PDate timestamp with time zone not null
);

--주문 정보 테이블(UniqueNum(주문코드), 고객코드, 생산코드, 주문일자)
CREATE TABLE tOrder
(
   ONumber varchar(5) not null
   , CNumber varchar(5) not null
   , PNumber varchar(5) not null
   , ODate timestamp with time zone  not null
);

--반품 정보 테이블(UniqueNum(반품코드), 주문코드, 수량, 반품사유, 반품일)
CREATE TABLE tReturn
(
   RNumber varchar(5) not null
   , ONumber varchar(5) not null
   , RCount integer not null
   , RRNumber varchar(6) not null
   , RDate timestamp with time zone not null
);

--------------------------------------------- 테이블 PK, FK 생성 --------------------------------------------- 
-- Primary Key
ALTER TABLE tDepartment ADD CONSTRAINT PK_tDepartment_DNumber PRIMARY KEY (DNumber);
ALTER TABLE tRank ADD CONSTRAINT PK_tRank_RNumber PRIMARY KEY (RNumber);
ALTER TABLE tReturnReason ADD CONSTRAINT PK_tReturnReason_RRNumber PRIMARY KEY (RRNumber);
ALTER TABLE tItem ADD CONSTRAINT PK_tItem_INumber PRIMARY KEY (INumber);
ALTER TABLE tCustomer ADD CONSTRAINT PK_tCustomer_CNumber PRIMARY KEY (CNumber);
ALTER TABLE tEmployee ADD CONSTRAINT PK_tEmployee_ENumber PRIMARY KEY (ENumber);
ALTER TABLE tProduction ADD CONSTRAINT PK_tProduction_PNumber PRIMARY KEY (PNumber);
ALTER TABLE tOrder ADD CONSTRAINT PK_tOrder_ONumber PRIMARY KEY (ONumber);
ALTER TABLE tReturn ADD CONSTRAINT PK_tReturn_RNumber PRIMARY KEY (RNumber);

-- Foreign Key
ALTER TABLE tEmployee ADD CONSTRAINT FK_tEmployee_DNumber
   FOREIGN KEY (DNumber) REFERENCES tDepartment (DNumber) ON DELETE No Action ON UPDATE No Action;
ALTER TABLE tEmployee ADD CONSTRAINT FK_tEmployee_RNumber
   FOREIGN KEY (RNumber) REFERENCES tRank (RNumber) ON DELETE No Action ON UPDATE No Action;
ALTER TABLE tProduction ADD CONSTRAINT FK_tProduction_ENumber
   FOREIGN KEY (ENumber) REFERENCES tEmployee (ENumber) ON DELETE No Action ON UPDATE No Action;
ALTER TABLE tProduction ADD CONSTRAINT FK_tProduction_INumber
   FOREIGN KEY (INumber) REFERENCES tItem (INumber) ON DELETE No Action ON UPDATE No Action;
ALTER TABLE tOrder ADD CONSTRAINT FK_tOrder_CNumber
   FOREIGN KEY (CNumber) REFERENCES tCustomer (CNumber) ON DELETE No Action ON UPDATE No Action;
ALTER TABLE tOrder ADD CONSTRAINT FK_tOrder_PNumber
   FOREIGN KEY (PNumber) REFERENCES tProduction (PNumber) ON DELETE No Action ON UPDATE No Action;
ALTER TABLE tReturn ADD CONSTRAINT FK_tReturn_ONumber
   FOREIGN KEY (ONumber) REFERENCES tOrder (ONumber) ON DELETE No Action ON UPDATE No Action;
ALTER TABLE tReturn ADD CONSTRAINT FK_tReturn_RRNumber
   FOREIGN KEY (RRNumber) REFERENCES tReturnReason (RRNumber) ON DELETE No Action ON UPDATE No Action;

--------------------------------------------- 테이블 및 컬럼 설명 --------------------------------------------- 
COMMENT ON TABLE tDepartment IS '부서 코드 테이블';
COMMENT ON COLUMN tDepartment.DNumber IS '부서코드';
COMMENT ON COLUMN tDepartment.DName IS '부서명';

COMMENT ON TABLE tRank IS '직급 코드 테이블';
COMMENT ON COLUMN tRank.RNumber IS '직급코드';
COMMENT ON COLUMN tRank.RName IS '직급명';

COMMENT ON TABLE tReturnReason IS '반품사유 코드 테이블';
COMMENT ON COLUMN tReturnReason.RRNumber IS '반품사유코드';
COMMENT ON COLUMN tReturnReason.RReason IS '반품사유';

COMMENT ON TABLE tItem IS '제품 코드 테이블';
COMMENT ON COLUMN tItem.INumber IS '제품코드';
COMMENT ON COLUMN tItem.IName IS '제품명';
COMMENT ON COLUMN tItem.Price IS '제품단가';
COMMENT ON COLUMN tItem.RegisterDate IS '등록일';

COMMENT ON TABLE tCustomer IS '고객 코드 테이블';
COMMENT ON COLUMN tCustomer.CNumber IS '고객코드';
COMMENT ON COLUMN tCustomer.CName IS '고객명';
COMMENT ON COLUMN tCustomer.CAddr IS '고객주소';
COMMENT ON COLUMN tCustomer.ContractDate IS '계약일';

COMMENT ON TABLE tEmployee IS '사원 정보 테이블';
COMMENT ON COLUMN tEmployee.ENumber IS '사원코드';
COMMENT ON COLUMN tEmployee.DNumber IS '부서코드';
COMMENT ON COLUMN tEmployee.RNumber IS '직급코드';
COMMENT ON COLUMN tEmployee.EName IS '사원명';
COMMENT ON COLUMN tEmployee.ERRN IS '주민등록번호';
COMMENT ON COLUMN tEmployee.EAddr IS '주소';
COMMENT ON COLUMN tEmployee.StartDate IS '입사일';
COMMENT ON COLUMN tEmployee.ResignationDate IS '퇴사일';

COMMENT ON TABLE tProduction IS '품목 생산 정보 테이블';
COMMENT ON COLUMN tProduction.PNumber IS '생산코드';
COMMENT ON COLUMN tProduction.ENumber IS '사원코드';
COMMENT ON COLUMN tProduction.INumber IS '제품코드';
COMMENT ON COLUMN tProduction.PCount IS '생산수량';
COMMENT ON COLUMN tProduction.PDate IS '생산일';

COMMENT ON TABLE tOrder IS '주문 정보 테이블';
COMMENT ON COLUMN tOrder.ONumber IS '주문코드';
COMMENT ON COLUMN tOrder.CNumber IS '고객코드';
COMMENT ON COLUMN tOrder.PNumber IS '생산코드';
COMMENT ON COLUMN tOrder.ODate IS '주문일자';

COMMENT ON TABLE tReturn IS '반품 정보 테이블';
COMMENT ON COLUMN tReturn.RNumber IS '반품코드';
COMMENT ON COLUMN tReturn.ONumber IS '주문코드';
COMMENT ON COLUMN tReturn.RCount IS '반품수량';
COMMENT ON COLUMN tReturn.RRNumber IS '반품사유코드';
COMMENT ON COLUMN tReturn.RDate IS '반품일';

--------------------------------------------- 테이블 데이터 생성 --------------------------------------------- 
-- tDepartment(DNumber, DName)
insert into tDepartment values('D1001','문구생산부');
insert into tDepartment values('D2001','가구생산부');
insert into tDepartment values('D3001','악세사리생산부');
insert into tDepartment values('D4001','전자기기생산부');
insert into tDepartment values('D5001','음료생산부');

-- tRank(RNumber, RName)
insert into tRank values('R0001','사원');
insert into tRank values('R0002','주임');
insert into tRank values('R0003','대리');
insert into tRank values('R0004','과장');
insert into tRank values('R0005','차장');
insert into tRank values('R0006','부장');
insert into tRank values('R0007','이사');
insert into tRank values('R0008','상무');
insert into tRank values('R0009','전무');
insert into tRank values('R0010','사장');

-- tReturnReason(RRNumber, RReason)
insert into tReturnReason values('RR0001','불량');
insert into tReturnReason values('RR0002','단순변심');
insert into tReturnReason values('RR0003','환불');
insert into tReturnReason values('RR0004','배송오류');

-- tItem(INumber, IName, Price, RegisterDate)
insert into tItem values('I1001','가위',600,'2019-01-02 14:32:23'); -- 문구
insert into tItem values('I1002','풀',500,'2019-01-13 15:33:23');
insert into tItem values('I1003','공책',1000,'2019-01-23 16:34:23');
insert into tItem values('I1004','볼펜',1500,'2019-02-15 17:26:23');
insert into tItem values('I1005','지우개',300,'2019-02-21 18:19:23');
insert into tItem values('I2001','쇼파',1230000,'2019-03-05 14:22:52'); -- 가구
insert into tItem values('I2002','테이블',625000,'2019-03-17 15:34:17');
insert into tItem values('I2003','장농',470000,'2019-03-21 16:52:11');
insert into tItem values('I2004','침대',2180000,'2019-04-11 17:32:47');
insert into tItem values('I2005','책상',382000,'2019-04-29 18:27:32');
insert into tItem values('I3001','반지',1023000,'2019-05-13 09:34:54'); -- 악세사리
insert into tItem values('I3002','목걸이',1510000,'2019-05-27 11:15:32');
insert into tItem values('I3003','귀걸이',532000,'2019-06-23 15:53:15');
insert into tItem values('I3004','팔찌',320000,'2019-06-26 17:43:14');
insert into tItem values('I3005','브로치',711000,'2019-06-28 20:22:19');
insert into tItem values('I4001','컴퓨터',925000,'2019-07-02 11:32:19'); -- 전자기기
insert into tItem values('I4002','노트북',2150000,'2019-07-15 12:08:02');
insert into tItem values('I4003','모니터',530000,'2019-07-22 15:13:52');
insert into tItem values('I4004','스마트폰',1326000,'2019-08-13 19:32:22');
insert into tItem values('I4005','디지털카메라',1105000,'2019-08-19 21:23:52');
insert into tItem values('I5001','커피',6000,'2019-09-02 13:32:11'); -- 음료
insert into tItem values('I5002','주스',6000,'2019-09-27 15:43:23');
insert into tItem values('I5003','전통차',6000,'2019-10-15 16:14:02');
insert into tItem values('I5004','탄산음료',6000,'2019-11-21 17:06:52');
insert into tItem values('I5005','홍차',6000,'2019-12-22 18:54:32');

-- tCustomer(CNumber, CName, CAddr, CPhone, ContractDate)
insert into tCustomer values('C1001','대한문방구','서울시 강남구','2019-01-23 13:32:12'); -- 문구
insert into tCustomer values('C1002','용호문방구','서울시 용산구','2019-01-27 14:10:01');
insert into tCustomer values('C1003','오랜문방구','울산시 중구','2019-02-03 16:08:06');
insert into tCustomer values('C1004','학교앞문방구','부산시 남구','2019-02-17 18:17:52');
insert into tCustomer values('C1005','최고문방구','부산시 북구','2019-02-25 18:31:32');
insert into tCustomer values('C2001','튼튼가구','서울시 동작구','2019-03-02 10:13:22'); -- 가구
insert into tCustomer values('C2002','동해가구','서울시 송파구','2019-03-13 12:07:11');
insert into tCustomer values('C2003','그린가구','서울시 강남구','2019-03-21 17:52:34');
insert into tCustomer values('C2004','소나무가구','부산시 진구','2019-04-03 17:56:22');
insert into tCustomer values('C2005','조경가구','부산시 남구','2019-04-22 18:07:56');
insert into tCustomer values('C3001','패션악세사리','서울시 광진구','2019-05-07 15:32:11'); -- 악세사리
insert into tCustomer values('C3002','반짝악세사리','부산시 남구','2019-05-13 15:55:23');
insert into tCustomer values('C3003','대연악세사리','부산시 진구','2019-05-22 17:21:45');
insert into tCustomer values('C3004','강남악세사리','서울시 강남구','2019-06-02 18:13:42');
insert into tCustomer values('C3005','달빛악세사리','서울시 영등포구','2019-06-21 19:25:23');
insert into tCustomer values('C4001','남한전자상가','서울시 송파구','2019-07-21 11:32:12'); -- 전자기기
insert into tCustomer values('C4002','보라매전자상가','서울시 동작구','2019-07-22 15:52:23');
insert into tCustomer values('C4003','다있다전자상가','부산시 남구','2019-08-02 16:21:11');
insert into tCustomer values('C4004','그린전자상가','대전시 중구','2019-08-08 16:32:57');
insert into tCustomer values('C4005','블루전자상가','대전시 서구','2019-08-25 19:13:51');
insert into tCustomer values('C5001','블루음료','서울시 강남구','2019-09-13 12:32:12'); -- 음료
insert into tCustomer values('C5002','시원한음료','울산시 동구','2019-09-24 15:27:09');
insert into tCustomer values('C5003','달달음료','부산시 북구','2019-10-01 16:13:51');
insert into tCustomer values('C5004','세븐음료','서울시 강동구','2019-11-23 17:34:52');
insert into tCustomer values('C5005','더함음료','서울시 도봉구','2019-12-15 18:31:37');

-- tEmployee(ENumber, DNumber(null), RNumber, EName, ERRN, EAddr,  StartDate, ResignationDate(null))
insert into tEmployee values('E0001',null,'R0001','김이수','850726-1118323','서울시 강남구','2018-01-02 09:00:00',null); -- 부서없는애들
insert into tEmployee values('E0002',null,'R0001','김사원','900513-1136345','부산시 북구','2018-01-02 09:00:00',null);
insert into tEmployee values('E0003',null,'R0002','이길동','890206-1112632','대전시 서구','2018-01-02 09:00:00',null);
insert into tEmployee values('E0004',null,'R0002','서준수','880816-1116234','서울시 동구','2018-01-02 09:00:00',null);
insert into tEmployee values('E0005',null,'R0003','이기영','920322-2114233','울산시 동구','2018-01-02 09:00:00',null);
insert into tEmployee values('E1001','D1001','R0001','박하나','760312-2127522','서울시 강남구','2016-01-02 09:00:00',null); -- 문구
insert into tEmployee values('E1002','D1001','R0002','김문구','830622-1152643','부산시 남구','2014-03-05 09:00:00',null);
insert into tEmployee values('E1003','D1001','R0003','이과장','790312-1117865','부산시 중구','2010-02-03 09:00:00',null);
insert into tEmployee values('E1004','D1001','R0003','이해오','800312-1112346','서울시 도봉구','2010-05-06 09:00:00',null);
insert into tEmployee values('E1005','D1001','R0006','박총괄','670107-1116244','서울시 광진구','2002-02-06 09:00:00',null);
insert into tEmployee values('E1006','D1001','R0001','김이해','870721-1113245','부산시 북구','2016-05-02 09:00:00','2021-02-25 23:59:59');
insert into tEmployee values('E1007','D1001','R0002','박지원','910513-2112432','울산시 동구','2015-12-11 09:00:00','2021-01-13 23:59:59');
insert into tEmployee values('E1008','D1001','R0001','정정인','951215-2712012','부산시 중구','2019-10-17 09:00:00',null);
insert into tEmployee values('E1009','D1001','R0001','김지오','941011-1744283','울산시 남구','2019-04-30 09:00:00',null);
insert into tEmployee values('E1010','D1001','R0001','권종인','910720-1123478','부산시 부산진구','2019-12-27 09:00:00',null);
insert into tEmployee values('E1011','D1001','R0002','최예라','960505-2156213','부산시 중구','2016-03-21 09:00:00',null);
insert into tEmployee values('E2001','D2001','R0001','김구성','921107-1111235','울산시 동구','2018-02-07 09:00:00',null); -- 가구
insert into tEmployee values('E2002','D2001','R0001','박가구','930303-1116543','서울시 영등포구','2018-03-03 09:00:00',null);
insert into tEmployee values('E2003','D2001','R0002','김혜영','870309-2117522','부산시 남구','2016-09-02 09:00:00',null);
insert into tEmployee values('E2004','D2001','R0003','이은혜','850505-2112754','부산시 남구','2014-03-05 09:00:00',null);
insert into tEmployee values('E2005','D2001','R0006','박천이','681207-1111523','울산시 중구','2001-03-13 09:00:00',null);
insert into tEmployee values('E2006','D2001','R0003','이혜연','850301-2114352','부산시 남구','2013-10-09 09:00:00','2021-03-15 23:59:59');
insert into tEmployee values('E2007','D2001','R0002','정선생','930119-2531132','부산시 금정구','2013-10-09 09:00:00',null);
insert into tEmployee values('E2008','D2001','R0001','최황락','950221-1131111','부산시 북구','2019-04-01 09:00:00',null);
insert into tEmployee values('E2009','D2001','R0001','김효식','970520-1147832','부산시 동래구','2019-02-02 09:00:00',null);
insert into tEmployee values('E2010','D2001','R0001','신하늘','940118-2321621','부산시 연제구','2019-06-01 09:00:00',null);
insert into tEmployee values('E3001','D3001','R0001','이빛나','920122-2112532','서울시 강남구','2018-01-06 09:00:00',null); -- 악세사리
insert into tEmployee values('E3002','D3001','R0001','김화사','930205-2117353','서울시 강남구','2018-01-06 09:00:00',null);
insert into tEmployee values('E3003','D3001','R0003','박은혜','890709-2114253','서울시 동작구','2014-03-09 09:00:00',null);
insert into tEmployee values('E3004','D3001','R0005','서이진','750122-2112532','서울시 강남구','2006-03-15 09:00:00',null);
insert into tEmployee values('E3005','D3001','R0006','류이연','690722-2114231','부산시 남구','2003-02-21 09:00:00',null);
insert into tEmployee values('E3006','D3001','R0005','박수혜','740617-2112135','서울시 강남구','2006-02-07 09:00:00','2021-02-19 23:59:59');
insert into tEmployee values('E3007','D3001','R0001','최양','941111-1465123','부산시 해운대구','2019-09-09 09:00:00',null);
insert into tEmployee values('E3008','D3001','R0001','박해린','950915-2354918','부산시 서구','2019-06-07 09:00:00',null);
insert into tEmployee values('E3009','D3001','R0001','이지수','960724-1735498','부산시 강서구','2019-01-25 09:00:00',null);
insert into tEmployee values('E3010','D3001','R0002','이지효','971230-2435651','부산시 사하구','2015-11-07 09:00:00',null);
insert into tEmployee values('E4001','D4001','R0001','김전자','850523-1113452','서울시 용산구','2018-07-23 09:00:00',null); -- 전자기기
insert into tEmployee values('E4002','D4001','R0001','박기술','861105-1118654','서울시 강남구','2018-03-09 09:00:00',null);
insert into tEmployee values('E4003','D4001','R0003','이정보','810503-1111244','부산시 북구','2013-05-01 09:00:00',null);
insert into tEmployee values('E4004','D4001','R0004','민서윤','770283-2112643','대전시 중구','2010-03-02 09:00:00',null);
insert into tEmployee values('E4005','D4001','R0006','정재훈','701012-1115232','대전시 서구','2001-06-18 09:00:00',null);
insert into tEmployee values('E4006','D4001','R0003','이승진','800301-1112352','서울시 용산구','2012-05-17 09:00:00','2021-01-21 23:59:59');
insert into tEmployee values('E4007','D4001','R0004','박호승','760717-2111233','부산시 진구','2009-06-22 09:00:00','2021-02-03 23:59:59');
insert into tEmployee values('E4008','D4001','R0002','하선영','890216-2121456','부산시 동구','2016-02-02 09:00:00',null);
insert into tEmployee values('E4009','D4001','R0001','류승환','980808-1324564','부산시 영도구','2019-08-22 09:00:00',null);
insert into tEmployee values('E4010','D4001','R0001','남궁수영','990909-113208','부산시 남구','2019-11-11 09:00:00',null);
insert into tEmployee values('E4011','D4001','R0001','최미리','941001-2121312','부산시 사상구','2019-06-18 09:00:00',null);
insert into tEmployee values('E5001','D5001','R0001','허재인','840517-2112352','서울시 강남구','2018-02-03 09:00:00',null); -- 음료
insert into tEmployee values('E5002','D5001','R0002','박수인','821106-2113214','부산시 북구','2016-03-06 09:00:00',null);
insert into tEmployee values('E5003','D5001','R0003','이경희','810823-2111345','부산시 남구','2013-03-02 09:00:00',null);
insert into tEmployee values('E5004','D5001','R0005','김대한','760117-1115431','대전시 서구','2006-05-21 09:00:00',null);
insert into tEmployee values('E5005','D5001','R0007','박원선','630527-1111325','서울시 송파구','2001-01-03 09:00:00',null);
insert into tEmployee values('E5006','D5001','R0003','박기원','801107-1113462','서울시 강남구','2012-06-01 09:00:00','2021-03-17 23:59:59');
insert into tEmployee values('E5007','D5001','R0001','김장기','950212-1701231','부산시 금정구','2019-08-01 09:00:00',null);
insert into tEmployee values('E5008','D5001','R0001','황선달','931004-1805621','부산시 중구','2019-10-05 09:00:00',null);
insert into tEmployee values('E5009','D5001','R0001','김실약','961010-1945674','부산시 동구','2019-04-07 09:00:00',null);
insert into tEmployee values('E5010','D5001','R0001','이장미','991107-2307896','부산시 서구','2019-05-18 09:00:00',null);

-- tProduction(PNumber, ENumber, INumber, PCount, PDate)
insert into tProduction values('P1001','E1001','I1001',620,'2020-01-03 11:32:22'); -- 문구
insert into tProduction values('P1002','E1002','I1002',32,'2020-02-16 09:11:07');
insert into tProduction values('P1003','E1003','I1003',363,'2020-02-21 10:07:35');
insert into tProduction values('P1004','E1004','I1004',122,'2020-02-25 15:32:11');
insert into tProduction values('P1005','E1005','I1005',210,'2020-03-03 11:17:08');
insert into tProduction values('P1006','E1006','I1001',1020,'2020-03-06 09:03:56');
insert into tProduction values('P1007','E1007','I1002',923,'2020-03-12 10:07:32');
insert into tProduction values('P1008','E1001','I1003',700,'2020-03-15 17:21:44');
insert into tProduction values('P1009','E1003','I1004',720,'2020-03-17 16:44:36');
insert into tProduction values('P1010','E1005','I1002',352,'2020-03-29 17:02:57');
insert into tProduction values('P1011','E1007','I1001',100,'2020-04-09 15:17:09');
insert into tProduction values('P1012','E1008','I1003',511,'2020-11-09 16:44:37');
insert into tProduction values('P1013','E1009','I1004',1077,'2020-02-09 17:00:09');
insert into tProduction values('P1014','E1010','I1005',441,'2020-10-09 18:00:08');
insert into tProduction values('P1015','E1003','I1003',694,'2020-12-09 17:48:58');
insert into tProduction values('P1016','E1005','I1005',410,'2020-07-02 15:24:46');
insert into tProduction values('P1017','E1007','I1002',754,'2020-05-07 13:18:06');
insert into tProduction values('P1018','E1009','I1004',432,'2020-03-28 14:27:08');
insert into tProduction values('P1019','E1002','I1001',782,'2020-11-11 17:19:24');
insert into tProduction values('P1020','E1004','I1005',1004,'2020-09-14 16:20:24');
insert into tProduction values('P2001','E2001','I2001',52,'2020-01-02 09:23:17'); -- 가구
insert into tProduction values('P2002','E2002','I2002',73,'2020-01-07 10:34:53');
insert into tProduction values('P2003','E2003','I2003',22,'2020-01-13 13:08:33');
insert into tProduction values('P2004','E2004','I2004',457,'2020-01-22 09:07:32');
insert into tProduction values('P2005','E2005','I2005',343,'2020-02-02 10:13:34');
insert into tProduction values('P2006','E2006','I2001',110,'2020-02-08 11:26:55');
insert into tProduction values('P2007','E2002','I2003',22,'2020-02-19 13:35:17');
insert into tProduction values('P2008','E2005','I2002',65,'2020-02-23 09:23:48');
insert into tProduction values('P2009','E2001','I2004',90,'2020-03-07 11:37:56');
insert into tProduction values('P2010','E2004','I2005',121,'2020-03-09 14:19:47');
insert into tProduction values('P2011','E2007','I2001',17,'2020-11-09 17:16:17');
insert into tProduction values('P2012','E2008','I2004',9,'2020-06-01 16:19:47');
insert into tProduction values('P2013','E2009','I2002',26,'2020-10-10 13:00:47');
insert into tProduction values('P2014','E2010','I2003',11,'2020-12-22 10:55:43');
insert into tProduction values('P2015','E2003','I2001',113,'2020-04-13 17:07:43');
insert into tProduction values('P2016','E2007','I2003',42,'2020-05-27 16:40:43');
insert into tProduction values('P2017','E2001','I2005',174,'2020-06-04 15:04:43');
insert into tProduction values('P2018','E2004','I2002',432,'2020-07-22 10:45:43');
insert into tProduction values('P2019','E2009','I2004',124,'2020-08-10 18:00:43');
insert into tProduction values('P2020','E2010','I2003',543,'2020-09-05 14:04:43');
insert into tProduction values('P3001','E3001','I3001',325,'2020-01-03 09:07:12'); -- 악세사리
insert into tProduction values('P3002','E3002','I3002',632,'2020-01-07 10:32:52');
insert into tProduction values('P3003','E3003','I3003',923,'2020-01-22 10:26:52');
insert into tProduction values('P3004','E3004','I3004',384,'2020-02-06 15:32:11');
insert into tProduction values('P3005','E3005','I3005',234,'2020-02-11 09:32:12');
insert into tProduction values('P3006','E3006','I3001',62,'2020-02-15 13:23:07');
insert into tProduction values('P3007','E3003','I3001',210,'2020-02-17 10:58:11');
insert into tProduction values('P3008','E3001','I3003',540,'2020-02-21 16:34:26');
insert into tProduction values('P3009','E3005','I3004',190,'2020-02-25 12:25:05');
insert into tProduction values('P3010','E3004','I3002',330,'2020-02-28 17:46:52');
insert into tProduction values('P3011','E3007','I3001',602,'2020-04-29 16:44:35');
insert into tProduction values('P3012','E3008','I3002',471,'2020-11-28 17:43:43');
insert into tProduction values('P3013','E3009','I3003',222,'2020-12-24 17:04:08');
insert into tProduction values('P3014','E3010','I3004',604,'2020-12-15 16:57:04');
insert into tProduction values('P3015','E3002','I3001',453,'2020-03-07 17:14:44');
insert into tProduction values('P3016','E3007','I3002',705,'2020-05-10 11:55:12');
insert into tProduction values('P3017','E3009','I3003',40,'2020-06-15 10:42:14');
insert into tProduction values('P3018','E3005','I3004',134,'2020-07-25 15:24:12');
insert into tProduction values('P3019','E3004','I3005',908,'2020-08-14 16:42:04');
insert into tProduction values('P3020','E3001','I3001',104,'2020-09-27 17:42:13');
insert into tProduction values('P4001','E4001','I4001',325,'2020-01-11 14:11:07'); -- 전자기기
insert into tProduction values('P4002','E4002','I4002',232,'2020-01-16 09:32:13');
insert into tProduction values('P4003','E4003','I4003',110,'2020-01-23 11:08:23');
insert into tProduction values('P4004','E4004','I4004',235,'2020-02-01 10:03:32');
insert into tProduction values('P4005','E4005','I4005',93,'2020-02-03 16:23:52');
insert into tProduction values('P4006','E4006','I4001',288,'2020-02-16 15:32:18');
insert into tProduction values('P4007','E4007','I4002',373,'2020-02-23 17:52:15');
insert into tProduction values('P4008','E4005','I4003',90,'2020-02-28 10:25:41');
insert into tProduction values('P4009','E4003','I4001',140,'2020-03-05 16:33:25');
insert into tProduction values('P4010','E4004','I4005',70,'2020-03-09 14:52:23');
insert into tProduction values('P4011','E4005','I4002',150,'2020-03-14 13:46:45');
insert into tProduction values('P4012','E4008','I4001',768,'2020-08-12 18:01:45');
insert into tProduction values('P4013','E4009','I4002',436,'2020-07-07 17:46:18');
insert into tProduction values('P4014','E4010','I4003',75,'2020-06-06 17:11:23');
insert into tProduction values('P4015','E4011','I4004',570,'2020-05-22 17:27:37');
insert into tProduction values('P4016','E4001','I4002',432,'2020-09-14 14:12:24');
insert into tProduction values('P4017','E4004','I4001',124,'2020-10-01 15:48:47');
insert into tProduction values('P4018','E4007','I4003',837,'2020-11-17 16:53:30');
insert into tProduction values('P4019','E4011','I4005',210,'2020-12-15 17:39:23');
insert into tProduction values('P4020','E4010','I4004',730,'2020-04-04 10:01:35');
insert into tProduction values('P5001','E5001','I5001',1215,'2020-01-11 09:10:32'); -- 음료
insert into tProduction values('P5002','E5002','I5002',2323,'2020-01-15 14:21:52');
insert into tProduction values('P5003','E5003','I5003',872,'2020-01-16 15:32:11');
insert into tProduction values('P5004','E5004','I5004',1212,'2020-02-08 09:52:27');
insert into tProduction values('P5005','E5005','I5005',111,'2020-02-11 10:03:29');
insert into tProduction values('P5006','E5006','I5001',631,'2020-02-17 13:07:42');
insert into tProduction values('P5007','E5007','I5004',1200,'2020-02-17 15:26:11');
insert into tProduction values('P5008','E5008','I5001',900,'2020-02-20 16:32:41');
insert into tProduction values('P5009','E5009','I5005',320,'2020-02-28 09:29:18');
insert into tProduction values('P5010','E5010','I5002',4610,'2020-03-06 15:31:42');
insert into tProduction values('P5011','E5002','I5004',4310,'2020-05-10 11:24:02');
insert into tProduction values('P5012','E5004','I5003',1431,'2020-07-04 10:17:24');
insert into tProduction values('P5013','E5006','I5001',2712,'2020-09-13 18:00:42');
insert into tProduction values('P5014','E5008','I5005',3753,'2020-10-28 17:45:12');
insert into tProduction values('P5015','E5009','I5001',1070,'2020-04-28 14:40:57');
insert into tProduction values('P5016','E5010','I5003',8724,'2020-06-28 15:03:42');
insert into tProduction values('P5017','E5001','I5005',1342,'2020-08-28 13:12:13');
insert into tProduction values('P5018','E5004','I5004',2437,'2020-11-28 16:22:38');
insert into tProduction values('P5019','E5002','I5001',6701,'2020-12-28 17:43:52');
insert into tProduction values('P5020','E5005','I5002',7310,'2020-07-28 18:00:12');

-- tOrder(ONumber, CNumber, PNumber, ODate)
insert into tOrder values('O1001','C1001','P1001','2021-01-07 09:08:32'); -- 문구
insert into tOrder values('O1002','C1002','P1002','2021-01-08 10:31:27');
insert into tOrder values('O1003','C1003','P1004','2021-01-12 09:43:31');
insert into tOrder values('O1004','C1004','P1006','2021-01-21 15:05:17');
insert into tOrder values('O1005','C1005','P1007','2021-01-27 11:13:08');
insert into tOrder values('O1006','C1002','P1009','2021-01-31 14:31:22');
insert into tOrder values('O1007','C1003','P1008','2021-02-06 16:42:16');
insert into tOrder values('O1008','C1005','P1011','2021-02-23 13:27:53');
insert into tOrder values('O1009','C1001','P1017','2021-02-25 14:29:08');
insert into tOrder values('O1010','C1003','P1018','2021-03-04 11:13:04');
insert into tOrder values('O1011','C1005','P1016','2021-03-12 17:57:11');
insert into tOrder values('O1012','C1002','P1015','2021-05-25 14:34:57');
insert into tOrder values('O1013','C1004','P1014','2021-07-08 13:27:13');
insert into tOrder values('O2001','C2001','P2001','2021-01-27 09:15:54'); -- 가구
insert into tOrder values('O2002','C2002','P2003','2021-01-12 09:32:11');
insert into tOrder values('O2003','C2003','P2002','2021-01-15 10:13:08');
insert into tOrder values('O2004','C2004','P2005','2021-01-17 11:23:18');
insert into tOrder values('O2005','C2005','P2006','2021-01-21 09:03:52');
insert into tOrder values('O2006','C2003','P2010','2021-02-03 10:52:13');
insert into tOrder values('O2007','C2002','P2008','2021-02-04 15:21:31');
insert into tOrder values('O2008','C2003','P2004','2021-02-10 09:26:57');
insert into tOrder values('O2009','C2001','P2009','2021-02-13 14:24:45');
insert into tOrder values('O2010','C2002','P2014','2021-03-01 10:12:10');
insert into tOrder values('O2011','C2002','P2013','2021-03-01 10:15:42');
insert into tOrder values('O2012','C2003','P2012','2021-05-24 14:13:24');
insert into tOrder values('O2013','C2004','P2011','2021-07-14 17:31:43');
insert into tOrder values('O3001','C3001','P3001','2021-01-16 09:42:18'); -- 악세사리
insert into tOrder values('O3002','C3002','P3003','2021-01-18 10:52:32');
insert into tOrder values('O3003','C3003','P3005','2021-01-21 11:42:57');
insert into tOrder values('O3004','C3004','P3006','2021-02-08 09:07:32');
insert into tOrder values('O3005','C3005','P3004','2021-02-09 09:17:27');
insert into tOrder values('O3006','C3005','P3009','2021-02-11 12:17:23');
insert into tOrder values('O3007','C3001','P3002','2021-02-15 16:43:51');
insert into tOrder values('O3008','C3004','P3007','2021-02-17 10:39:52');
insert into tOrder values('O3009','C3002','P3010','2021-02-23 09:14:37');
insert into tOrder values('O3010','C3001','P3011','2021-03-15 12:00:37');
insert into tOrder values('O3011','C3003','P3012','2021-05-25 20:44:58');
insert into tOrder values('O3012','C3004','P3013','2021-07-13 10:58:13');
insert into tOrder values('O3013','C3005','P3014','2021-04-04 09:50:42');
insert into tOrder values('O4001','C4001','P4002','2021-01-07 09:07:31'); -- 전자기기
insert into tOrder values('O4002','C4002','P4005','2021-01-12 13:52:11');
insert into tOrder values('O4003','C4003','P4003','2021-01-15 09:32:11');
insert into tOrder values('O4004','C4004','P4007','2021-01-19 10:51:32');
insert into tOrder values('O4005','C4005','P4006','2021-01-21 09:27:07');
insert into tOrder values('O4006','C4002','P4011','2021-02-10 13:26:38');
insert into tOrder values('O4007','C4001','P4001','2021-02-25 11:11:27');
insert into tOrder values('O4008','C4004','P4008','2021-03-01 10:54:57');
insert into tOrder values('O4009','C4005','P4004','2021-03-09 15:16:03');
insert into tOrder values('O4010','C4003','P4015','2021-03-27 14:17:13');
insert into tOrder values('O4011','C4002','P4014','2021-04-04 17:16:03');
insert into tOrder values('O4012','C4001','P4013','2021-05-13 12:59:03');
insert into tOrder values('O4013','C4005','P4012','2021-07-24 11:17:03');
insert into tOrder values('O5001','C5001','P5001','2021-01-03 09:02:17'); -- 음료
insert into tOrder values('O5002','C5002','P5002','2021-01-08 09:27:32');
insert into tOrder values('O5003','C5003','P5003','2021-01-12 10:32:17');
insert into tOrder values('O5004','C5004','P5004','2021-01-15 17:21:52');
insert into tOrder values('O5005','C5005','P5006','2021-01-23 11:53:39');
insert into tOrder values('O5006','C5003','P5008','2021-01-29 13:43:00');
insert into tOrder values('O5007','C5002','P5009','2021-02-01 09:51:17');
insert into tOrder values('O5008','C5001','P5005','2021-02-08 17:11:59');
insert into tOrder values('O5009','C5004','P5007','2021-02-09 12:53:33');
insert into tOrder values('O5010','C5001','P5014','2021-03-07 10:01:20');
insert into tOrder values('O5011','C5002','P5013','2021-03-18 14:55:10');
insert into tOrder values('O5012','C5003','P5012','2021-05-27 17:24:10');
insert into tOrder values('O5013','C5004','P5011','2021-07-07 18:10:43');

-- tReturn(RNumber, ONumber, RCount, RRNumber, RDate)
insert into tReturn values('R1001','O1002',5,'RR0001','2022-01-03 13:32:07'); -- 문구
insert into tReturn values('R1002','O1007',700,'RR0004','2022-01-03 15:17:47'); -- 문구
insert into tReturn values('R1003','O1009',754,'RR0002','2022-01-03 16:22:16'); -- 문구
insert into tReturn values('R2001','O2001',10,'RR0001','2022-01-05 09:07:13'); -- 가구
insert into tReturn values('R2002','O2007',65,'RR0002','2022-01-24 14:06:45'); -- 가구
insert into tReturn values('R3001','O3001',18,'RR0001','2022-01-06 09:13:52'); -- 악세사리
insert into tReturn values('R3002','O3004',62,'RR0003','2022-01-07 14:03:31'); -- 악세사리
insert into tReturn values('R3003','O3008',210,'RR0002','2022-01-10 10:15:34'); -- 악세사리
insert into tReturn values('R3004','O3007',632,'RR0002','2022-01-20 09:45:33'); -- 악세사리
insert into tReturn values('R4001','O4003',110,'RR0003','2022-01-02 09:27:11'); -- 전자기기
insert into tReturn values('R4002','O4005',20,'RR0001','2022-01-07 11:29:55'); -- 전자기기
insert into tReturn values('R4003','O4001',11,'RR0001','2022-01-08 16:09:20'); -- 전자기기
insert into tReturn values('R4004','O4002',9,'RR0001','2022-01-13 13:25:53'); -- 전자기기
insert into tReturn values('R5001','O5002',5,'RR0001','2022-01-07 10:53:05'); -- 음료
insert into tReturn values('R5002','O5003',872,'RR0004','2022-01-20 10:53:05'); -- 음료
insert into tReturn values('R5003','O5004',1212,'RR0002','2022-01-29 10:53:05'); -- 음료