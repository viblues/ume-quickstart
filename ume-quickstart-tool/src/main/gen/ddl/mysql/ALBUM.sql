
/* ALBUM : 唱片基本信息表 */
DROP TABLE IF EXISTS `ALBUM` ;
CREATE TABLE `ALBUM` (
    `ID` INT AUTO_INCREMENT PRIMARY KEY COMMENT '编号'
    ,`TITLE` VARCHAR(128) BINARY NOT NULL	 COMMENT '标题'
    ,`ARTIST` VARCHAR(32) BINARY NOT NULL	 COMMENT '艺术家'
    ,`ISSUE_DATE` DATE 	 COMMENT '发行时间'
    ,`GENRE` CHAR(2) BINARY 	 COMMENT '风格'
    ,`COVER_PHOTO` BLOB 	 COMMENT '封面设计'
    ,`CREATE_AUTHOR` VARCHAR(32) BINARY COMMENT '创建者'
    ,`CREATE_DATETIME` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
    ,`UPDATE_AUTHOR` VARCHAR(32) BINARY COMMENT '更新者'
    ,`UPDATE_DATETIME` TIMESTAMP  DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '唱片基本信息表' ;
