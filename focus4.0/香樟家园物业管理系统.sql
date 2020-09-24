CREATE DATABASE IF NOT EXISTS focusdb  CHARACTER SET 'utf8';
USE focusdb;

#部门表
CREATE TABLE dept
(
    deptNo VARCHAR(10) NOT NULL PRIMARY KEY,#部门编号
    deptName VARCHAR(10) NOT NULL,#部门名称
    empNo VARCHAR(10) NOT NULL ,#部门负责人
    empCount INT(5) NOT NULL   #在编人数
); 
INSERT INTO dept() VALUES("xz","行政部","xz-001",3);
INSERT INTO dept() VALUES("kf","客服部","kf-001",2);
INSERT INTO dept() VALUES("gc","工程部","gc-001",2);
INSERT INTO dept() VALUES("cw","财务部","cw-001",2);
INSERT INTO dept() VALUES("ba","保安部","ba-001",2);

#员工表
CREATE TABLE emp
(
    empNo VARCHAR(10) NOT NULL PRIMARY KEY,#员工编号
    empName VARCHAR(10) NOT NULL,#姓名
    empSex VARCHAR(4) NOT NULL,#性别
    empTelphone VARCHAR(12) NOT NULL,#电话
    empIdcard VARCHAR(20) NOT NULL,#身份证
    hireDate DATE NOT NULL,#入职日期
    resignationDate DATE, #离职日期
    salary DECIMAL(8,2) NOT NULL,#工资
    commision DECIMAL(8,2),#补贴
    deptNo VARCHAR(10) NOT NULL,#部门
    manager VARCHAR(10)#领导
);
INSERT INTO emp VALUES("100001","唐志国","男","15274873286","43082119790627601X","2017-05-21","2099-12-31",32000,0,"xz",NULL);
INSERT INTO emp VALUES("xz-001","俞倩","女","15173256815","431102198605170025","2017-06-30","2099-12-31",15000,2000,"xz","100001");
INSERT INTO emp VALUES("xz-002","郭梦青","女","13875986671","430602199307013022","2018-02-28","2099-12-31",7000,300,"xz","xz-001");
INSERT INTO emp VALUES("kf-001","邓超","男","13517348468","430404198405200514","2017-07-13","2099-12-31",13000,1800,"kf","100001");
INSERT INTO emp VALUES("kf-002","陶小宁","女","15211087410","430124199608308969","2018-03-15","2099-12-31",6300,500,"kf","kf-001");
INSERT INTO emp VALUES("gc-001","何杰","男","13873114275","430111196908182690","2017-05-28","2099-12-31",16500,1000,"gc","100001");
INSERT INTO emp VALUES("gc-002","张宪","男","13974448686","430802198111080684","2018-06-05","2099-12-31",8300,300,"gc","gc-001");
INSERT INTO emp VALUES("cw-001","李传青","女","18711143774","430281198504077729","2017-06-28","2099-12-31",13500,1000,"cw","100001");
INSERT INTO emp VALUES("cw-002","刘小玲","女","15988036803","332527198904192220","2018-07-30","2099-12-31",6200,600,"cw","cw-001");
INSERT INTO emp VALUES("ba-001","申凯松","男","18711032254","430281197504077729","2017-08-16","2099-12-31",14200,300,"ba","100001");
INSERT INTO emp VALUES("ba-002","刘建军","男","15616450008","430103198311264631","2018-03-20","2099-12-31",6300,400,"ba","ba-001");

#后台管理人员登录(information)表
CREATE TABLE information(
backId VARCHAR(10) NOT NULL PRIMARY KEY,	#-- 后台登录账号
backPwd	VARCHAR(20)NOT NULL,			#-- 密码
empName	VARCHAR(10)NOT NULL,			#-- 姓名
backPost VARCHAR(20)NOT NULL		        #-- 职位
);
INSERT INTO information VALUES("100001","123456","唐志国","项目经理");
INSERT INTO information VALUES("xz-001","123456","俞倩","行政主管");
INSERT INTO information VALUES("xz-002","123456","郭梦青","行政");
INSERT INTO information VALUES("kf-001","123456","邓超","客服主管");
INSERT INTO information VALUES("kf-002","123456","陶小宁","客服");
INSERT INTO information VALUES("gc-001","123456","何杰","工程主管");
INSERT INTO information VALUES("gc-002","123456","张宪","工程师");
INSERT INTO information VALUES("cw-001","123456","李传青","财务主管");
INSERT INTO information VALUES("cw-002","123456","刘小玲","财务");
INSERT INTO information VALUES("ba-001","123456","申凯松","保安主管");
INSERT INTO information VALUES("ba-002","123456","刘建军","保安");

#房屋信息表
CREATE TABLE houseinformation(
houseId VARCHAR (10)NOT NULL PRIMARY KEY,#房号
ownerName VARCHAR (8),#业主
houseType VARCHAR (20),#户型
houseArea DECIMAL (5,2)NOT NULL,#面积
houseNature VARCHAR (6)NOT NULL,#性质
houseState VARCHAR (12)NOT NULL,#状态
houseAddress VARCHAR (50)NOT NULL#房屋地址
);
INSERT INTO houseInformation() VALUES('1-0201','李伶俐','一室一厅','49.88','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0202','候翰博','二室一厅','70.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0203',NULL,'二室一厅','72.18','住宅','未售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0204','张耀来','一室一厅','49.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0301','张铁强','一室一厅','50.18','住宅','出租','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0302','陈利媛','二室一厅','71.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0303','石爱华','二室一厅','69.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0304','陈方','一室一厅','48.98','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0401','李泽仲','一室一厅','51.02','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0402','柳婷婷','二室一厅','69.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0403','刘雄健','二室一厅','70.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0404','吴亦锟','一室一厅','50.63','住宅','出租','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0501','邓万明','一室一厅','49.24','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0502','周树斌','二室一厅','71.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0503','刘谦','二室一厅','70.18','住宅','出租','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0504','夏珊琴','一室一厅','50.42','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0601','王勇','一室一厅','49.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0602','舒芳华','二室一厅','70.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0603','刘雄文','二室一厅','70.18','住宅','出租','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0604',NULL,'一室一厅','49.26','住宅','未售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0701','朱紫妍','一室一厅','50.17','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0702','柳晴翠','二室一厅','69.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0703',NULL,'二室一厅','71.18','住宅','未售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('1-0704','李华轶','一室一厅','48.99','住宅','已售','长沙市雨花区香樟家园');

INSERT INTO houseInformation() VALUES('2-0201','罗志辉','三室两厅','98.24','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0202',NULL,'三室两厅','99.55','住宅','未售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0203','肖洋','三室两厅','100.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0301','张剑铃','三室两厅','98.24','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0302','方茜云','三室两厅','99.55','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0303','杨平利','三室两厅','100.18','住宅','出租','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0401','王小英','三室两厅','98.24','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0402','李蓉','三室两厅','99.55','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0403',NULL,'三室两厅','100.18','住宅','未售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0501','万彬','三室两厅','98.24','住宅','出租','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0502','张梅香','三室两厅','99.55','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0503','杨腊梅','三室两厅','100.18','住宅','出租','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0601',NULL,'三室两厅','98.24','住宅','未售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0602','舒芬','三室两厅','99.55','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0603','彭红艳','三室两厅','100.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0701','曾美萍','三室两厅','98.24','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0702',NULL,'三室两厅','99.55','住宅','未售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('2-0703','王丕喜','三室两厅','100.18','住宅','已售','长沙市雨花区香樟家园');

INSERT INTO houseInformation() VALUES('3-0201','袁运华','四室两厅','124.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('3-0202',NULL,'四室两厅','123.69','住宅','未售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('3-0301',NULL,'四室两厅','124.18','住宅','未售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('3-0302','罗举','四室两厅','123.69','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('3-0401',NULL,'四室两厅','124.18','住宅','未售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('3-0402','谭玮','四室两厅','123.69','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('3-0501','刘莎','四室两厅','124.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('3-0502','候云芳','四室两厅','123.69','住宅','出租','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('3-0601','龙雪静','四室两厅','124.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('3-0602',NULL,'四室两厅','123.69','住宅','未售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('3-0701','刘楚云','四室两厅','124.18','住宅','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('3-0702','马婷','四室两厅','123.69','住宅','出租','长沙市雨花区香樟家园');

INSERT INTO houseInformation() VALUES('S-001','黄艳',NULL,'70.88 ','商铺','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('S-002','谭青桂',NULL,'60.03','商铺','出租','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('S-003',NULL,NULL,'49.71','商铺','未售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('S-004','饶晴',NULL,'70.88 ','商铺','出租','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('S-005','胡迎',NULL,'60.03','商铺','出租','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('S-006','孔明珍',NULL,'49.71','商铺','出租','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('S-007','刘丹虹',NULL,'70.88 ','商铺','已售','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('S-008','武岚',NULL,'60.03','商铺','出租','长沙市雨花区香樟家园');
INSERT INTO houseInformation() VALUES('S-009','邹红樱',NULL,'49.71','商铺','出租','长沙市雨花区香樟家园');


#业主信息表
CREATE TABLE ownerInformation
(
    ownerId VARCHAR(10) NOT NULL PRIMARY KEY,#编号
    houseId VARCHAR(10) NOT NULL,#房号
    ownerName VARCHAR(10) NOT NULL,#名字
    ownerSex VARCHAR(4) NOT NULL,#性别
    ownerIdcard VARCHAR(20) NOT NULL,#身份证
    ownerTelphone VARCHAR(12) NOT NULL,#电话
    ownerEmail VARCHAR(30) NOT NULL,#邮箱
    ownerAddress VARCHAR(100) NOT NULL #邮寄地址
);
INSERT INTO ownerInformation() VALUES("xz0001","1-0201","李伶俐","女","410725198303151227","13517476757","13517476757@qq.com","长沙市望城区雷锋大道433号");
INSERT INTO ownerInformation() VALUES("xz0002","1-0202","候翰博","男","430102199712312512","15343313312","15343313312@qq.com","浏阳市普集镇碧桂园3-A-1704");
INSERT INTO ownerInformation() VALUES("xz0003","1-0204","张耀来","男","430722198903285610","15274520022","15274520022@qq.com","湖南省岳阳市华容县");
INSERT INTO ownerInformation() VALUES("xz0004","1-0301","张铁强","男","430111196407012516","13875991858","13875991858@qq.com","长沙市香樟路华润翡翠府6-2-3206");
INSERT INTO ownerInformation() VALUES("xz0005","1-0302","陈利媛","女","430103195612081022","13487490839","13487490839@qq.com","长沙市雨花区融科东南海前海天地12-B-1302");
INSERT INTO ownerInformation() VALUES("xz0006","1-0303","石爱华","女","430103196006141042","18874044571","18874044571@qq.com","长沙市望城区雷锋大道433号");
INSERT INTO ownerInformation() VALUES("xz0007","1-0304","陈方","男","430103198002104518","13973162902","13973162902@qq.com","浏阳市普集镇碧桂园3-A-1704");
INSERT INTO ownerInformation() VALUES("xz0008","1-0401","李泽仲","男","430103196504084511","18574318169","18574318169@qq.com","湖南省岳阳市华容县");
INSERT INTO ownerInformation() VALUES("xz0009","1-0402","柳婷婷","男","430105199008112524","13786198854","13786198854@qq.com","长沙市香樟路华润翡翠府6-2-3206");
INSERT INTO ownerInformation() VALUES("xz0010","1-0403","刘雄健","女","430281199006084314","15675353629","15675353629@qq.com","长沙市雨花区融科东南海前海天地12-B-1302");
INSERT INTO ownerInformation() VALUES("xz0011","1-0404","吴亦锟","女","43011119860304216x","13755086486","13755086486@qq.com","长沙市望城区雷锋大道433号");
INSERT INTO ownerInformation() VALUES("xz0012","1-0501","邓万明","男","43012219720221031x","13257319857","13257319857@qq.com","浏阳市普集镇碧桂园3-A-1704");
INSERT INTO ownerInformation() VALUES("xz0013","1-0502","周树斌","男","430381198909260818","13973271968","13973271968@qq.com","湖南省岳阳市华容县");
INSERT INTO ownerInformation() VALUES("xz0014","1-0503","刘谦","男","430621199108026110","18673192474","18673192474@qq.com","长沙市香樟路华润翡翠府6-2-3206");
INSERT INTO ownerInformation() VALUES("xz0015","1-0504","夏珊琴","女","43092319870602446x","18397575237","18397575237@qq.com","长沙市雨花区融科东南海前海天地12-B-1302");
INSERT INTO ownerInformation() VALUES("xz0016","1-0601","王勇","女","43062619900424801x","18682032050","18682032050@qq.com","长沙市望城区雷锋大道433号");
INSERT INTO ownerInformation() VALUES("xz0017","1-0602","舒芳华","男","431226198606110047","15618512588","15618512588@qq.com","浏阳市普集镇碧桂园3-A-1704");
INSERT INTO ownerInformation() VALUES("xz0018","1-0603","刘雄文","男","431028198911121633","15207492544","15207492544@qq.com","湖南省岳阳市华容县");
INSERT INTO ownerInformation() VALUES("xz0019","1-0701","朱紫妍","男","430922199304294625","13250556702","13250556702@qq.com","长沙市香樟路华润翡翠府6-2-3206");
INSERT INTO ownerInformation() VALUES("xz0020","1-0702","柳晴翠","女","430181199102160027","13548966786","13548966786@qq.com","长沙市雨花区融科东南海前海天地12-B-1302");
INSERT INTO ownerInformation() VALUES("xz0021","1-0704","李华轶","女","430105199001200011","15116427088","15116427088@qq.com","长沙市望城区雷锋大道433号");
INSERT INTO ownerInformation() VALUES("xz0022","2-0201","罗志辉","男","430424198510202729","13975451682","13975451682@qq.com","浏阳市普集镇碧桂园3-A-1704");
INSERT INTO ownerInformation() VALUES("xz0023","2-0203","肖洋","男","430482199106260660","14789750816","14789750816@qq.com","湖南省岳阳市华容县");
INSERT INTO ownerInformation() VALUES("xz0024","2-0301","张剑铃","男","430103196407181037","18974935371","18974935371@qq.com","长沙市香樟路华润翡翠府6-2-3206");
INSERT INTO ownerInformation() VALUES("xz0025","2-0302","方茜云","女","430602198806145025","15116178910","15116178910@qq.com","长沙市雨花区融科东南海前海天地12-B-1302");
INSERT INTO ownerInformation() VALUES("xz0026","2-0303","杨平利","女","432924196402020629","13298698159","13298698159@qq.com","长沙市望城区雷锋大道433号");
INSERT INTO ownerInformation() VALUES("xz0028","2-0401","王小英","男","430103196304041082","18973134028","18973134028@qq.com","湖南省岳阳市华容县");
INSERT INTO ownerInformation() VALUES("xz0029","2-0402","李蓉","男","430104196912192024","13928021812","13928021812@qq.com","长沙市香樟路华润翡翠府6-2-3206");
INSERT INTO ownerInformation() VALUES("xz0030","2-0501","万彬","女","431103198606080925","18570664410","18570664410@qq.com","长沙市雨花区融科东南海前海天地12-B-1302");
INSERT INTO ownerInformation() VALUES("xz0031","2-0502","张梅香","女","43010319630818104x","18873078613","18873078613@qq.com","长沙市韶山南路湘林小区A9-205");
INSERT INTO ownerInformation() VALUES("xz0032","2-0503","杨腊梅","男","430981196611140323","13698911012","13698911012@qq.com","浏阳市普集镇碧桂园3-A-1704");
INSERT INTO ownerInformation() VALUES("xz0033","2-0602","舒芬","男","430407197812190021","13875655888","13875655888@qq.com","湖南省岳阳市华容县");
INSERT INTO ownerInformation() VALUES("xz0034","2-0603","彭红艳","男","430581198706020516","18974475209","804950237@qq.com","长沙市香樟路华润翡翠府6-2-3206");
INSERT INTO ownerInformation() VALUES("xz0035","2-0701","曾美萍","女","430111196204126927","13873115438","13873115438@qq.com","长沙市雨花区融科东南海前海天地12-B-1302");
INSERT INTO ownerInformation() VALUES("xz0036","2-0703","王丕喜","女","410725198303151227","13517476757","13517476757@qq.com","长沙市望城区雷锋大道433号");

INSERT INTO ownerInformation() VALUES("xz0037","3-0201","袁运华","男","362221197610080318","15084871599","15084871599@qq.com","浏阳市普集镇碧桂园3-A-1704");
INSERT INTO ownerInformation() VALUES("xz0038","3-0302","罗举","男","430111198410180755","13908471578","13908471578@qq.com","湖南省岳阳市华容县");
INSERT INTO ownerInformation() VALUES("xz0039","3-0402","谭玮","男","432503198212270024","18874014333","18874014333@qq.com","长沙市香樟路华润翡翠府6-2-3206");
INSERT INTO ownerInformation() VALUES("xz0040","3-0501","刘莎","女","430922198512217128","15874927048","15874927048@qq.com","长沙市雨花区融科东南海前海天地12-B-1302");
INSERT INTO ownerInformation() VALUES("xz0041","3-0502","候云芳","女","431021198808137448","13787278092","13787278092@qq.com","长沙市望城区雷锋大道433号");
INSERT INTO ownerInformation() VALUES("xz0042","3-0601","龙雪静","男","433125199012117924","13802441017","13802441017@qq.com","浏阳市普集镇碧桂园3-A-1704");
INSERT INTO ownerInformation() VALUES("xz0043","3-0701","刘楚云","男","43102219910720002","15874240640","15874240640@qq.com","湖南省岳阳市华容县");
INSERT INTO ownerInformation() VALUES("xz0044","3-0702","马婷","男","430902199308120520","18874192488","18874192488@qq.com","长沙市香樟路华润翡翠府6-2-3206");

INSERT INTO ownerInformation() VALUES("xz0045","S-001","黄艳","女","432325196501280024","13511135910","258834150@qq.com","长沙市雨花区融科东南海前海天地12-B-1302");
INSERT INTO ownerInformation() VALUES("xz0046","s-002","谭青桂","女","410725198303151227","13517476757","596836143@qq.com","长沙市望城区雷锋大道433号");
INSERT INTO ownerInformation() VALUES("xz0047","s-004","饶晴","男","430722198903285610","18473780205","1356091757@qq.com","浏阳市普集镇碧桂园3-A-1704");
INSERT INTO ownerInformation() VALUES("xz0048","s-005","胡迎","男","430102199712312512","15343313312","2533654272@qq.com","湖南省岳阳市华容县");
INSERT INTO ownerInformation() VALUES("xz0049","s-007","孔明珍","男","43080219911012001X","18974475209","804950237@qq.com","长沙市香樟路华润翡翠府6-2-3206");
INSERT INTO ownerInformation() VALUES("xz0050","S-008","刘丹虹","女","432325196501280024","13511135910","258834150@qq.com","长沙市雨花区融科东南海前海天地12-B-1302");
INSERT INTO ownerInformation() VALUES("xz0051","S-009","邹红樱","女","432325196501280024","13511135910","258834150@qq.com","长沙市雨花区融科东南海前海天地12-B-1302");



#租户信息表
CREATE  TABLE lesseeInformation
(
 leaseContractId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,#编号
 houseId VARCHAR (10) NOT NULL,#房号
 lesseeName VARCHAR (10) NOT NULL,#名字
 lesseeGender VARCHAR (4) NOT NULL,#性别
 lesseeIdcard VARCHAR (18) NOT NULL,#身份证
 lesseeTelphone   VARCHAR (12) NOT NULL,#电话
 startTime  DATE NOT NULL,#起租时间
 endTime  DATE 	#合同到期时间
);
INSERT INTO lesseeInformation() VALUES(DEFAULT,"1-0301","吴正正","男","430103194405171047","18670312030","2019-3-2","2020-3-2");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"1-0501","彭丽君","女","430103197211234568","13974842801","2018-12-27","2019-12-31");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"1-0503","彭水兵","男","430321197807161543","13627495450","2018-12-27","2019-12-31");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"2-0303","谢娟","女","430103197902014521","13367310976","2018-12-27","2019-12-31");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"2-0501","张桂辉","男","430105195609050527","18684840300","2018-12-27","2019-12-31");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"2-0503","王巍","男","430502197408172562","15111261978","2018-12-27","2019-12-31");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"1-0603","宋永红","女","430121197006030067","13787128099","2018-12-27","2019-12-31");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"1-0404","魏伯文","女","430103197302244518","15575955537","2018-12-27","2019-12-31");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"3-0702","黄善","女","430124198812021222","18073196896","2018-12-27","2019-12-31");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"3-0502","冯旭辉","男","430311196904073521","18075158117","2018-12-27","2019-12-31");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"S-002","陈保世","男","430422198607192114","13457986060","2018-12-27","2021-12-31");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"S-004","张涵","女","430111198908312110","18684874899","2017-12-27","2020-12-31");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"S-005","邵芳","女","430111198308122129","15173139603","2016-12-27","2021-12-31");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"S-006","魏丹","女","430103198901161524","15773146516","2015-12-27","2019-12-31");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"S-008","杨和成","男","432823194909290029","13467519656","2019-12-27","2021-12-31");
INSERT INTO lesseeInformation() VALUES(DEFAULT,"S-009","孙妮","女","432401197311173067","13974843311","2019-12-27","2023-12-31");

#投诉纪录表
CREATE TABLE complain(
 comId INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,#受理编号
 ownerName VARCHAR(10) NOT NULL,#投诉人(业主姓名)
 comText VARCHAR(255) NOT NULL,#投诉内容
 comTime DATETIME NOT NULL,#投诉时间
 empName VARCHAR(10) NOT NULL,#受理人（客服部门人员）
 comResult VARCHAR(50) NOT NULL,#处理结果
 comEndTime DATETIME
);
INSERT INTO complain VALUES(DEFAULT,'李伶俐','车位被占用','2019-10-03 11:11:21','陶小宁','已处理','2019-10-05 11:10:21');
INSERT INTO complain VALUES(DEFAULT,'罗志辉','墙壁脱落','2019-10-03 11:11:21','陶小宁','已处理','2019-10-08 12:11:21');

#报修记录表
CREATE TABLE repairs(
 repId INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,#受理编号
 ownerName VARCHAR(10) NOT NULL,#报修人（业主姓名）
 repText VARCHAR(255) NOT NULL,#报修内容
 repTime DATETIME NOT NULL,#报修时间
 empName VARCHAR(10) NOT NULL,#受理人（工程管理部门人员）
 repResult VARCHAR(50) NOT NULL,#处理结果
 repEndTime DATETIME#完成时间
);
INSERT INTO repairs VALUES(DEFAULT,'李伶俐','水管爆裂','2019-10-03 11:11:21','张宪','已处理','2019-10-03 11:41:21');
INSERT INTO repairs VALUES(DEFAULT,'罗志辉','线路问题','2019-10-13 11:11:21','张宪','已处理','2019-10-13 11:41:21');

#公告表
CREATE TABLE regulatory(
fileId VARCHAR(10) NOT NULL PRIMARY KEY,#文件编号
fileTitle VARCHAR(50) NOT NULL,#标题
fileTheme VARCHAR(5) NOT NULL,#主题
fileState VARCHAR(5)NOT NULL,#状态
executionTime DATETIME NOT NULL#执行时间
);
INSERT INTO regulatory VALUES('12011','小区运动会','提倡大家锻炼身体','准备中','2019-11-05');
INSERT INTO regulatory VALUES('12012','多读书，多看报','提高文化水平，增强小区素质','开展中','2019-9-05');
INSERT INTO regulatory VALUES('12013','人口调查','配合政府人口普查','配合中','2019-03-10');
INSERT INTO regulatory VALUES('12014','绘画作品征集','绘画作品征集大赛，奖品多多','准备中','2019-11-05');

#设备基本信息表
CREATE TABLE EquipmentInformation(
 eqId VARCHAR(20) NOT NULL PRIMARY KEY,#设备编号
 eqName VARCHAR(20) NOT NULL,#设备名称
 eqPurpose VARCHAR(20) NOT NULL,#用途
 manufacturer VARCHAR(30) NOT NULL,#生产厂家
 producedDate DATETIME NOT NULL,#生产日期
 eqNum INT,#数量
 usePosition VARCHAR(20),#位置
 eqStatus VARCHAR(10)#状态
);
INSERT INTO EquipmentInformation() VALUES("001","发电机","发电备用","三菱","2015-10-01",3,"发电机房","正常");
INSERT INTO EquipmentInformation() VALUES("002","路灯","照明设备","美的","2015-11-02",20,"公共区域","正常");
INSERT INTO EquipmentInformation() VALUES("003","监控","安全设备","海康威视","2016-01-01",30,"公共区域","正常");
INSERT INTO EquipmentInformation() VALUES("004","抽水机","安全设备","一海","2016-01-01",6,"水泵房","正常");
INSERT INTO EquipmentInformation() VALUES("005","电梯","安全设备","通力","2016-01-01",6,"电梯间","正常");
INSERT INTO EquipmentInformation() VALUES("006","道闸","安全设备","明城","2016-01-01",4,"小区出入口","正常");
INSERT INTO EquipmentInformation() VALUES("007","充电桩","电动车充电","格力","2016-01-01",20,"小区车库","正常");
INSERT INTO EquipmentInformation() VALUES("008","消防栓","安全设备","海格消防","2016-01-01",80,"公共区域","正常");
INSERT INTO EquipmentInformation() VALUES("009","闭路电视","安全设备","三星","2016-01-01",6,"中控室","正常");
INSERT INTO EquipmentInformation() VALUES("010","配电柜","电力设施","五矿电讯","2016-01-01",3,"配电房","正常");
INSERT INTO EquipmentInformation() VALUES("011","对讲机","通讯设备","康佳","2016-01-01",12,"随身携带","正常");

#设备巡检表
CREATE TABLE eqCheck(
checkId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,#巡检编号
eqId  VARCHAR(10) NOT NULL,#设备编号
checkStatues VARCHAR(10) NOT NULL,#巡检结果
checkDate DATETIME NOT NULL,#日期
empNo VARCHAR(10) NOT NULL#巡检人
);
INSERT INTO eqcheck VALUES(DEFAULT,"001","损坏","2019-09-04","gc-002");
INSERT INTO eqcheck VALUES(DEFAULT,"003","正常","2019-09-04","gc-002");
INSERT INTO eqcheck VALUES(DEFAULT,"002","损坏","2019-09-04","gc-002");
INSERT INTO eqcheck VALUES(DEFAULT,"002","正常","2019-10-04","gc-001");
INSERT INTO eqcheck VALUES(DEFAULT,"001","正常","2019-10-04","gc-002");
INSERT INTO eqcheck VALUES(DEFAULT,"003","正常","2019-10-04","gc-001");

#设备维护表
CREATE TABLE eqMaintain(
maintainId VARCHAR(10) PRIMARY KEY NOT NULL,#维护编号
eqId VARCHAR(10) NOT NULL,#设备编号
maintainStatues VARCHAR(10) NOT NULL,#维护结果
maintainDate DATETIME NOT NULL,#日期
consumable VARCHAR(20),#耗材
consumNum INT,#材料数量
checkCost DECIMAL(8,2),#费用
empNo VARCHAR(10)#维护人
);
INSERT INTO eqMaintain VALUES('2019001','001','正常','2019-03-05','机油',20,300,'gc-002');
INSERT INTO eqMaintain VALUES('2019002','002','正常','2019-04-05','灯泡',10,50,'gc-002');
INSERT INTO eqMaintain VALUES('2019003','003','正常','2019-05-15','摄像头',2,400,'gc-002');
INSERT INTO eqMaintain VALUES('2019004','002','正常','2019-07-05','灯泡',5,25,'gc-002');
INSERT INTO eqMaintain VALUES('2019005','003','正常','2019-09-15','电线',5,25,'gc-002');
INSERT INTO eqMaintain VALUES('2019006','002','正常','2019-10-15','灯泡',2,10,'gc-001');

#车位信息表
CREATE TABLE parkingInformation(
parkId VARCHAR(10) PRIMARY KEY NOT NULL,#编号
parkStatus VARCHAR(10) NOT NULL,#状态
parkMoney DECIMAL(8,2),#费用
houseId VARCHAR(10) NOT NULL#房号
);
INSERT INTO parkinginformation() VALUES("A-001","已购",30,"2-0602");
INSERT INTO parkinginformation() VALUES("C-001","已购",30,"1-0201");
INSERT INTO parkinginformation() VALUES("B-100","出租",300,"1-1503");
INSERT INTO parkinginformation() VALUES("A-063","临时",NULL,"S-008");
INSERT INTO parkinginformation() VALUES("A-081","临时",NULL,"S-003");
INSERT INTO parkinginformation() VALUES("A-099","临时",NULL,"S-005");

#车辆信息表
CREATE TABLE carInformation
(
  carId VARCHAR(10) PRIMARY KEY  NOT NULL,#车牌号
  carName VARCHAR(10),#姓名
  carTelphone VARCHAR(12) NOT NULL,#电话
  carportId VARCHAR(10) NOT NULL#车位编号
);
INSERT INTO carInformation()  VALUES('湘A12354','李煜坤','13021235255','A-003');
INSERT INTO carInformation()  VALUES('湘A65854','刘荣','15896354785','B-003');
INSERT INTO carInformation()  VALUES('湘B45875','饶晴','15632587412','C-003');
INSERT INTO carInformation()  VALUES('湘C45852',NULL,'14568548548','A-054');
INSERT INTO carInformation()  VALUES('湘A65848',NULL,'13554464684','B-056');
INSERT INTO carInformation()  VALUES('湘B88888',NULL,'15888886666','C-062');

#临时停车
CREATE TABLE carTime
(
  Nub INT UNSIGNED AUTO_INCREMENT PRIMARY KEY  NOT NULL,#编号
  carId VARCHAR(10) NOT NULL,#车牌
  goTime DATETIME NOT NULL,#进入时间
  toTime DATETIME NOT NULL,#离开时间
  Money DECIMAL(10,2) NOT NULL,#停车费
  empNo VARCHAR(10) NOT NULL #值班人
);
INSERT INTO cartime() VALUES(DEFAULT,"湘J8Z120","2019-10-27 10:31:02","2019-10-27 14:27:00",10,"ba-001");
INSERT INTO cartime() VALUES(DEFAULT,"湘F8Z120","2019-10-27 17:11:43","2019-10-27 19:49:07",15,"ba-002");

#来访登记表
CREATE TABLE visitorRegister(
visitorId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,#来访编号
visitorName VARCHAR(10) NOT NULL,#姓名
visitorGender VARCHAR(4) NOT NULL,#性别
visitorIdNum VARCHAR(20) NOT NULL,#身份证
visitorTelphone VARCHAR(12)NOT NULL,#电话
vistiAddress VARCHAR (10)NOT NULL,#到访地点
vistiReason VARCHAR (50)NOT NULL,#到访事由
cometime DATETIME NOT NULL,#到访时间
leaveTime DATETIME ,#离开时间
empNo VARCHAR(10)NOT NULL#值班员
);
INSERT INTO visitorregister VALUES(DEFAULT,'吴根喜','男','432822196212250513','13204918114','2-1201','走亲戚','2019-10-1 8:05:00','2019-10-1 18:25:12','ba-002');
INSERT INTO visitorregister VALUES(DEFAULT,'石恬恬','男','430302199409273283','18670075259','3-1302','应聘','2019-10-1 09:35:15','2019-10-1 11:50:45','ba-002');
INSERT INTO visitorregister VALUES(DEFAULT,'吴亚娟','男','432503199008213182','15197181559','1-1402','送外卖','2019-10-2 11:40:15','2019-10-2 15:30:30','ba-002');
INSERT INTO visitorregister VALUES(DEFAULT,'陈佳妮','女','430102198407260029','13974853736','4-1303','走亲戚','2019-10-2 09:15:15','2019-10-2 17:25:12','ba-002');
INSERT INTO visitorregister VALUES(DEFAULT,'汤露','女','430121199102012028','15874251146','2-1501','送快递','2019-10-3 08:20:15','2019-10-3 20:25:12','ba-002');
INSERT INTO visitorregister VALUES(DEFAULT,'吴沧媚','女','432503199210232045','18670386573','3-1402','应聘','2019-10-4 10:25:15','2019-10-4 13:25:12','ba-002');
INSERT INTO visitorregister VALUES(DEFAULT,'黄娟','女','430181198905037423','18673173220','5-1202','走亲戚','2019-10-5 09:29:15','2019-10-5 22:25:12','ba-002');



#工资表
 CREATE TABLE wage(
 wageid VARCHAR(12) NOT NULL PRIMARY KEY, #编号
 empName VARCHAR(10) NOT NULL, #员工姓名
 salary DECIMAL(8,2) NOT NULL, #工资
 commision DECIMAL(8,2) NOT NULL, #补贴
 withhold DECIMAL(8,2) NOT NULL, #扣款
 playMoney DECIMAL(8,2) NOT NULL, #实发金额
 wageMonth VARCHAR(15) NOT NULL #月份
 );
INSERT INTO wage VALUES("100001","唐志国",32000,0,0,32000,"2019-10-15");
INSERT INTO wage VALUES("xz-001","俞倩",15000,2000,1500,15500,"2019-10-15");
INSERT INTO wage VALUES("kf-001","邓超",13000,1800,0,14800,"2019-10-15");
INSERT INTO wage VALUES("gc-001","何杰",16500,1000,300,17200,"2019-10-15");
INSERT INTO wage VALUES("cw-001","李传青",13500,1000,0,14500,"2019-10-15");
INSERT INTO wage VALUES("ba-001","申凯松",14200,300,0,14500,"2019-10-15");
INSERT INTO wage VALUES("xz-002","郭梦青",7000,300,0,7300,"2019-10-15");
INSERT INTO wage VALUES("kf-002","陶小宁",6300,500,0,6800,"2019-10-15");
INSERT INTO wage VALUES("gc-002","张宪",8300,300,500,8100,"2019-10-15");
INSERT INTO wage VALUES("cw-002","刘小玲",6200,600,0,6800,"2019-10-15");
INSERT INTO wage VALUES("ba-002","刘建军",6300,400,0,6700,"2019-10-15");

#收入表
CREATE TABLE income
(
    incomeId INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    source VARCHAR(20) NOT NULL,
    money DECIMAL(8,2) NOT NULL,
    source_date DATETIME NOT NULL
);
INSERT INTO income VALUES(DEFAULT,"物业收费",270,"2019-10-18 10:30:15");
INSERT INTO income VALUES(DEFAULT,"临时停车收费",40,"2019-10-18 10:31:32");
INSERT INTO income VALUES(DEFAULT,"物业收费",230,"2019-10-18 10:31:42");

#支出表
CREATE TABLE expense
(
    expenseId INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    expenseItem VARCHAR(20) NOT NULL,
    expenseMoney DECIMAL(8,2) NOT NULL,
    expense_date DATETIME NOT NULL
);
INSERT INTO expense VALUES(DEFAULT,"采购支出",280,"2019-10-21 9:20:15");

#物业费欠费表
CREATE TABLE arrearage(
houseId VARCHAR(10) PRIMARY KEY  NOT NULL,#房号
ownerName VARCHAR(10) NOT NULL,#姓名
ownerTelphone VARCHAR(12) NOT NULL,#电话
state VARCHAR(10) ,#状态
arrearageMoney DECIMAL(8,2),#金额
arrearageDate DATETIME#缴费时间
);
INSERT INTO arrearage() VALUES("1-0201","李伶俐","13517476757","欠费",732.48,"2019-06-01");
INSERT INTO arrearage() VALUES("1-0202","候翰博","15343313312","欠费",620.9,"2019-04-19");
INSERT INTO arrearage() VALUES("1-0204","张耀来","15274520022","已交清",NULL,"2019-10-20");
INSERT INTO arrearage() VALUES("1-0301","张铁强","13875991858","已交清",NULL,"2019-10-25");
INSERT INTO arrearage() VALUES("1-0302","陈利媛","13487490839","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0303","石爱华","18874044571","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0304","陈方","13973162902","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0401","李泽仲","18574318169","欠费",732.48,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0402","柳婷婷","13786198854","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0403","刘雄健","15675353629","欠费",732.48,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0404","吴亦锟","13755086486","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0501","邓万明","13257319857","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0502","周树斌","13973271968","欠费",732.48,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0503","刘谦","18673192474","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0504","夏珊琴","18397575237","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0601","王勇","18682032050","欠费",732.48,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0602","舒芳华","15618512588","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0603","刘雄文","15207492544","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0701","朱紫妍","13250556702","欠费",732.48,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0702","柳晴翠","13548966786","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("1-0704","李华轶","15116427088","欠费",732.48,"2019-10-27");
INSERT INTO arrearage() VALUES("2-0201","罗志辉","13975451682","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("2-0203","肖洋","14789750816","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("2-0301","张剑铃","18974935371","欠费",732.48,"2019-10-27");
INSERT INTO arrearage() VALUES("2-0302","方茜云","15116178910","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("2-0303","杨平利","13298698159","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("2-0401","王小英","18973134028","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("2-0402","李蓉","13928021812","欠费",732.48,"2019-10-27");
INSERT INTO arrearage() VALUES("2-0501","万彬","18570664410","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("2-0502","张梅香","18873078613","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("2-0503","杨腊梅","13698911012","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("2-0602","舒芬","13875655888","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("2-0603","彭红艳","18974475209","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("2-0701","曾美萍","13873115438","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("2-0703","王丕喜","13517476757","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("3-0201","袁运华","15084871599","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("3-0302","罗举","13908471578","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("3-0402","谭玮","18874014333","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("3-0501","刘莎","15874927048","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("3-0502","候云芳","13787278092","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("3-0601","龙雪静","13802441017","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("3-0701","刘楚云","15874240640","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("3-0702","马婷","18874192488","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("S-001","黄艳","13511135910","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("s-002","谭青桂","13517476757","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("s-004","饶晴","18473780205","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("s-005","胡迎","15343313312","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("s-007","孔明珍","18974475209","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("S-008","刘丹虹","13511135910","已交清",NULL,"2019-10-27");
INSERT INTO arrearage() VALUES("S-009","邹红樱","13511135910","已交清",NULL,"2019-10-27");


#固定车位欠费表
CREATE TABLE carArrearage
(
    parkId VARCHAR(10) NOT NULL PRIMARY KEY,#车位编号
    ownerName VARCHAR(10) NOT NULL, #业主姓名
    ownerTelphone VARCHAR(12) NOT NULL, #业主电话
    parkStatus VARCHAR(10) ,#欠费状态
    carMoney DECIMAL(8,2),#欠费金额
    carDate DATETIME #上次缴费时间
);
INSERT INTO carArrearage() VALUES("C-001","李伶俐","13517476757","欠费",60,"2019-8-16");
INSERT INTO carArrearage() VALUES("A-001","舒芬","13875655888","欠费",60,"2019-8-16");



#缴费明细表
CREATE TABLE record
(
    recordId INT PRIMARY KEY AUTO_INCREMENT NOT NULL,#编号
    ownerName VARCHAR(20) NOT NULL,#姓名
    ownerTelphone VARCHAR(12) NOT NULL,#电话
    recordType VARCHAR(20) NOT NULL,#费用类型
    recordMoney DECIMAL(8,2) NOT NULL,#缴费金额
    recordDate DATETIME #缴费时间
);
INSERT INTO record() VALUES(DEFAULT,"李伶俐","13517476757","物业费","310.45","2019-8-16");
INSERT INTO record() VALUES(DEFAULT,"李伶俐","13517476757","停车费","30","2019-8-16");
INSERT INTO record() VALUES(DEFAULT,"李伶俐","13517476757","物业费","310.45","2019-7-16");
INSERT INTO record() VALUES(DEFAULT,"李伶俐","13517476757","停车费","30","2019-7-16");


#采购表
CREATE TABLE procurement(
proId	VARCHAR(20) NOT NULL PRIMARY KEY,#-- 记录编号
proName	VARCHAR(20) NOT NULL,		#-- 采购人
goodsName VARCHAR(20) NOT NULL,		#-- 物品名称
proTime	DATETIME NOT NULL,		#-- 时间
proNum INT NOT NULL,			#-- 数量
proPrice DECIMAL(10,2) NOT NULL,	#-- 单价
proTolal DECIMAL(10,2) NOT NULL	        #-- 总价
);
INSERT INTO procurement VALUES('cg-001','俞倩','水管','2019-08-02',200,14.00,2800.00);
INSERT INTO procurement VALUES('cg-002','俞倩','笔','2019-08-12',300,2.00,600.00);
INSERT INTO procurement VALUES('cg-003','俞倩','笔记本','2019-08-22',100,5.00,500.00);
INSERT INTO procurement VALUES('cg-004','俞倩','台式电脑','2019-09-02',20,2000.00,40000.00);
INSERT INTO procurement VALUES('cg-005','俞倩','办公桌','2019-09-02',30,100.00,3000.00);
INSERT INTO procurement VALUES('cg-006','郭梦青','办公椅','2019-09-08',20,50.00,1000.00);
INSERT INTO procurement VALUES('cg-007','郭梦青','灯泡','2019-09-09',40,4.0,80.00);
INSERT INTO procurement VALUES('cg-008','郭梦青','水龙头','2019-09-12',50,5.00,250.00);
INSERT INTO procurement VALUES('cg-009','郭梦青','风扇','2019-06-21',4,200.00,800.00);
INSERT INTO procurement VALUES('cg-010','郭梦青','空调','2019-8-02',4,2000.0,8000.00);



#库存表	stock
CREATE TABLE stock(
stockId	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,	#-- 物品编号
goodsName VARCHAR(10) NOT NULL,		        #-- 物品名称
stockNum INT NOT NULL		               # -- 库存量
);
INSERT INTO stock VALUES(DEFAULT,'水管',180);
INSERT INTO stock VALUES(DEFAULT,'笔',200);
INSERT INTO stock VALUES(DEFAULT,'笔记本',80);
INSERT INTO stock VALUES(DEFAULT,'台式电脑',15);
INSERT INTO stock VALUES(DEFAULT,'办公桌',18);
INSERT INTO stock VALUES(DEFAULT,'办公椅',15);
INSERT INTO stock VALUES(DEFAULT,'灯泡',30);
INSERT INTO stock VALUES(DEFAULT,'水龙头',40);
INSERT INTO stock VALUES(DEFAULT,'风扇',1);
INSERT INTO stock VALUES(DEFAULT,'空调',1);

#物料领用表
CREATE TABLE getgoods(
ggId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,	#-- 领用编号		
goodsName VARCHAR(20)NOT NULL ,			#-- 物品名称
ggNum INT NOT NULL,				#-- 领用数量
ggName	VARCHAR(10) NOT NULL,			#-- 领用人
ggTime	DATETIME NOT NULL,			#-- 领用时间
ggHandli VARCHAR(10) NOT NULL			#-- 经办人
);
#插入数据
INSERT INTO getgoods(goodsName,ggNum,ggName,ggTime,ggHandli) VALUES('水管', 20,'张宪','2019-08-02','俞倩');
INSERT INTO getgoods(goodsName,ggNum,ggName,ggTime,ggHandli) VALUES('笔', 200,'郭梦青','2019-08-12','俞倩');
INSERT INTO getgoods(goodsName,ggNum,ggName,ggTime,ggHandli) VALUES('笔记本', 20,'郭梦青','2019-08-22','俞倩');
INSERT INTO getgoods(goodsName,ggNum,ggName,ggTime,ggHandli) VALUES('台式电脑', 5,'郭梦青','2019-09-03','俞倩');
INSERT INTO getgoods(goodsName,ggNum,ggName,ggTime,ggHandli) VALUES('办公桌', 2,'张宪','2019-08-02','俞倩');
INSERT INTO getgoods(goodsName,ggNum,ggName,ggTime,ggHandli) VALUES('办公椅', 5,'张宪','2019-08-02','俞倩');
INSERT INTO getgoods(goodsName,ggNum,ggName,ggTime,ggHandli) VALUES('灯泡', 10,'张宪','2019-08-02','俞倩');
INSERT INTO getgoods(goodsName,ggNum,ggName,ggTime,ggHandli) VALUES('水龙头', 10,'张宪','2019-08-02','俞倩');
INSERT INTO getgoods(goodsName,ggNum,ggName,ggTime,ggHandli)VALUES('风扇', 1,'何杰','2019-06-21','俞倩');
INSERT INTO getgoods(goodsName,ggNum,ggName,ggTime,ggHandli) VALUES('空调', 1,'何杰','2019-08-02','俞倩');


#前端业主登录（user）
CREATE TABLE users(
uId INT NOT NULL PRIMARY KEY AUTO_INCREMENT, #-- 用户编号
uName VARCHAR(10) NOT NULL,			    # -- 用户姓名
uPassword VARCHAR(10) NOT NULL, 		    # -- 用户密码
uEmail	VARCHAR(20) NOT NULL,		            # -- 邮箱
uIphone	VARCHAR(20) NOT NULL                        # -- 电话 
);
INSERT INTO users(uName,uPassword,uEmail,uIphone) VALUES("李伶俐","123456","13517476757@163.com","13517476757");
INSERT INTO users(uName,uPassword,uEmail,uIphone) VALUES("候翰博","123456","15343313312@163.com","15343313312");
INSERT INTO users(uName,uPassword,uEmail,uIphone) VALUES("张耀来","123456","15274520022@163.com","15274520022");
INSERT INTO users(uName,uPassword,uEmail,uIphone) VALUES("张铁强","123456","13875991858@163.com","13875991858");
INSERT INTO users(uName,uPassword,uEmail,uIphone) VALUES("陈利媛","123456","13487490839@163.com","13487490839");
INSERT INTO users(uName,uPassword,uEmail,uIphone) VALUES("石爱华","123456","18874044571@163.com","18874044571");
INSERT INTO users(uName,uPassword,uEmail,uIphone) VALUES("陈方","123456","13973162902@163.com","13973162902");
INSERT INTO users(uName,uPassword,uEmail,uIphone) VALUES("李泽仲","123456","18574318169@163.com","18574318169");
INSERT INTO users(uName,uPassword,uEmail,uIphone) VALUES("柳婷婷","123456","13786198854@163.com","13786198854");
INSERT INTO users(uName,uPassword,uEmail,uIphone) VALUES("刘雄健","123456","15675353629@163.com","15675353629");


#收费标准表
CREATE TABLE rates(
	itemId INT PRIMARY KEY AUTO_INCREMENT,#项目编号
	itemName VARCHAR(12) NOT NULL,#收费项目
	itemDesc VARCHAR(20),#规格型号
	ratesMoney DECIMAL(8,2) NOT NULL#金额
);
INSERT INTO rates VALUES(DEFAULT,"住宅物业费","每平方米",2.5);
INSERT INTO rates VALUES(DEFAULT,"商铺物业费","每平方米",7);
INSERT INTO rates VALUES(DEFAULT,"私家车位费","每月",30);
INSERT INTO rates VALUES(DEFAULT,"月租车位费","每月",300);
INSERT INTO rates VALUES(DEFAULT,"临时车1","小于1小时",0);
INSERT INTO rates VALUES(DEFAULT,"临时车2","1-4小时",10);
INSERT INTO rates VALUES(DEFAULT,"临时车3","4-12小时",20);
INSERT INTO rates VALUES(DEFAULT,"临时车4","12-24小时",30);
INSERT INTO rates VALUES(DEFAULT,"临时车5","大于24小时",40);
INSERT INTO rates VALUES(DEFAULT,"灯泡","50W白炽灯",20);
INSERT INTO rates VALUES(DEFAULT,"水龙头","20mm镀锌",40);
INSERT INTO rates VALUES(DEFAULT,"空气开关","30A单相",80);
INSERT INTO rates VALUES(DEFAULT,"下水道疏通",NULL,50);
INSERT INTO rates VALUES(DEFAULT,"人工费",NULL,30);
INSERT INTO rates VALUES(DEFAULT,"装修押金","适用于住宅",2000);

#规章制度表
CREATE TABLE Rules
(
  rulesId VARCHAR(20) PRIMARY KEY NOT NULL,#编号
  rulesTitle VARCHAR(10) NOT NULL,#标题
  rulesTheme VARCHAR(50) NOT NULL,#主题
  rulesStatus VARCHAR(10) NOT NULL,#状态
  rulesTime DATE NOT NULL#开始执行时间
);
INSERT INTO rules() VALUES("2018011","上班纪律","员工管理","执行中","2018-1-1");
INSERT INTO rules() VALUES("2018012","冬季作息时间","员工管理","执行中","2018-1-1");
INSERT INTO rules() VALUES("2018013","夏季作息时间","员工管理","执行中","2018-1-1");	