--mysql建表模板
--先drop 后create
--主键使用id，采用自增和雪花算法两种类型
--字段名中"_"两端不能使用单字符
--时间对象使用int(10),unix时间错
--在建表时指定索引，外键必须加上索引，非空的字段必须加上非空属性
--指定表引擎 innodb
drop table if exists table_demo;
create table if not exists table_demo
(
    id          	bigint(20) primary key comment '主键',
    url             varchar(100) not null comment 'url',
    access_flag     varchar(1) not null comment '是否可用 0：可用，1：不可用',
    login_flag      varchar(1) not null comment '是否需要登陆 0：需登陆，1：无需登录',
    description     varchar(100) comment '描述',
    created_by      varchar(100) not null default 'sys' comment '创建人',
    created_date    int(10) not null comment '创建时间',
    updated_by      varchar(100) not null default 'sys' comment '更新人',
    updated_date    int(10) not null comment '更新时间',
    unique index (url)
)   engine=innodb
    default charset=utf8
    comment='url权限控制表';