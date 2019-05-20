# Host: localhost  (Version 5.5.62)
# Date: 2019-05-20 12:50:12
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Structure for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` varchar(8) NOT NULL COMMENT '管理员工号',
  `admin_name` varchar(50) NOT NULL COMMENT '管理员姓名',
  `admin_password` varchar(12) NOT NULL DEFAULT '112233' COMMENT '管理员密码',
  `admin_gender` int(1) DEFAULT '1' COMMENT '性别，1为男，0为女',
  `admin_mail` varchar(50) DEFAULT NULL COMMENT '邮箱地址',
  `admin_tel` varchar(20) NOT NULL COMMENT '电话号码',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

#
# Data for table "admin"
#

INSERT INTO `admin` VALUES ('04160908','逍遥','123456',1,'626753724@qq.com','13750002413'),('06160422','张三（管理员）','112233',1,'980121zxh@stu.jluzh.edu.cn','13726283533');

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` varchar(8) NOT NULL COMMENT '学号',
  `student_name` varchar(50) NOT NULL COMMENT '学生姓名',
  `student_password` varchar(20) NOT NULL DEFAULT '112233' COMMENT '学生密码',
  `student_department` varchar(6) NOT NULL COMMENT '学生班级',
  `student_gender` int(1) DEFAULT '1' COMMENT '性别，1为男，0为女',
  `student_mail` varchar(50) DEFAULT NULL COMMENT '邮箱地址',
  `student_tel` varchar(20) NOT NULL COMMENT '电话号码',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

#
# Data for table "student"
#

INSERT INTO `student` VALUES ('06160422','张三（学生）','112233','041609',1,'1305403965@qq.com','13690932011');

#
# Structure for table "teacher"
#

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` varchar(8) NOT NULL COMMENT '教师工号',
  `teacher_name` varchar(50) NOT NULL COMMENT '教师姓名',
  `teacher_password` varchar(20) NOT NULL DEFAULT '112233' COMMENT '教师密码',
  `teacher_gender` int(1) DEFAULT '1' COMMENT '性别，1为男，0为女',
  `teacher_mail` varchar(50) DEFAULT NULL COMMENT '邮箱地址',
  `teacher_tel` varchar(20) NOT NULL COMMENT '电话号码',
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师表';

#
# Data for table "teacher"
#

INSERT INTO `teacher` VALUES ('06160422','张三（教师）','112233',1,'1305403965@qq.com','13726283533');

#
# Structure for table "course"
#

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` varchar(8) NOT NULL COMMENT '课程编号',
  `course_name` varchar(50) NOT NULL COMMENT '课程名',
  `course_teacher` varchar(8) NOT NULL COMMENT '任课教师',
  `course_credit` int(2) NOT NULL COMMENT '学分',
  `course_semester` int(5) NOT NULL COMMENT '学期',
  PRIMARY KEY (`course_id`),
  KEY `course_teacher` (`course_teacher`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`course_teacher`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

#
# Data for table "course"
#

INSERT INTO `course` VALUES ('06160001','计算机导论','06160422',2,20191);

#
# Structure for table "grade"
#

DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `grade_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '成绩编号',
  `grade_course` varchar(8) NOT NULL COMMENT '课程编号',
  `grade_student` varchar(8) NOT NULL COMMENT '学号',
  `grade_fraction` int(3) NOT NULL DEFAULT '0' COMMENT '分数',
  `grade_semester` int(5) NOT NULL COMMENT '学期',
  PRIMARY KEY (`grade_id`),
  KEY `fk_id1` (`grade_course`),
  KEY `fk_id2` (`grade_student`),
  CONSTRAINT `fk_id1` FOREIGN KEY (`grade_course`) REFERENCES `course` (`course_id`),
  CONSTRAINT `fk_id2` FOREIGN KEY (`grade_student`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='成绩表';

#
# Data for table "grade"
#

INSERT INTO `grade` VALUES (1,'06160001','06160422',0,1);
