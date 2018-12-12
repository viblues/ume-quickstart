
/* ALBUM_CONTRIBUTOR : 参加该唱片录音的艺术家信息管理表 */
DROP TABLE IF EXISTS `ALBUM_CONTRIBUTOR` ;
CREATE TABLE `ALBUM_CONTRIBUTOR` (
    `ALBUM_ID` INT NOT NULL	 COMMENT '唱片编号'
    ,`TRACK_NO` INT(128) NOT NULL	 COMMENT '参与曲目'
    ,`CONTRIBUTOR` VARCHAR(32) BINARY NOT NULL	 COMMENT '艺术家'
    ,`COMMENT` VARCHAR(256) BINARY 	 COMMENT '备注'
    ,`CREATE_AUTHOR` VARCHAR(32) BINARY COMMENT '创建者'
    ,`CREATE_DATETIME` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
    ,`UPDATE_AUTHOR` VARCHAR(32) BINARY COMMENT '更新者'
    ,`UPDATE_DATETIME` TIMESTAMP  DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '参加该唱片录音的艺术家信息管理表' ;
ALTER TABLE `ALBUM_CONTRIBUTOR` ADD CONSTRAINT `PK_ALBUM_CONTRIBUTOR` PRIMARY KEY ( ALBUM_ID ,TRACK_NO ,CONTRIBUTOR ) ;
