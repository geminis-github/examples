drop table if exists test_user;
create table test_user
(
    id               bigint comment 'ID',
    created_by       bigint comment '创建人ID',
    updated_by       bigint comment '更新人ID',
    create_time      datetime default CURRENT_TIMESTAMP comment '创建时间',
    update_time      datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
    deleted          tinyint comment '是否删除：0=否，1=是',

    user_type        int comment '用户类型',
    sn               varchar(255) comment 'SN序号',
    nickname         varchar(32) comment '昵称',
    card_number      char(18) comment '身份证号码',
    real_name        varchar(256) comment '真实姓名',
    sex              tinyint comment '性别',
    census_register  varchar(1024) comment '户籍地',
    birthday         datetime comment '生日',
    email            varchar(255) comment '邮箱',
    mobile           char(11) comment '手机号码',
    we_chart_id      varchar(255) comment '微信号',
    qq               varchar(16) comment 'QQ号码',
    hobby            varchar(1024) comment '兴趣爱好',
    working_location varchar(1024) comment '工作地',
    salary           decimal(8, 2) comment '工资',
    occupation       varchar(1024) comment '职业',

    primary key (id)
) engine = InnoDB,
  charset = utf8;