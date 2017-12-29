-- database
CREATE DATABASE IF NOT EXISTS cuiniaobao DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

-- admin
CREATE TABLE admin (
    admin_id BIGINT UNSIGNED NOT NULL COMMENT '主键ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    loan_id BIGINT NOT NULL COMMENT '标的ID',
    agent_id INT COMMENT '债务转移ID',
    status_id TINYINT COMMENT '债务状态：0-未还,1-已还,2-迟还,3-提前还款所有金额,4-部分还款,5-债权转移,6-转移还款',
    repay_status_id TINYINT NOT NULL COMMENT '还款类型：1-Oneself,2-Auto,3-Admin',
    order_id TINYINT NOT NULL COMMENT '期数',
    amount DECIMAL(18,4) COMMENT '应还总金额',
    principal DECIMAL(18,4) COMMENT '应还本金',
    interest DECIMAL(18,4) COMMENT '应还利息',
    dun DECIMAL(18,4) COMMENT '应还催费',
    overdue DECIMAL(18,4) COMMENT '应还罚息',
    fees DECIMAL(18,4) COMMENT '应还总费用',
    due_date DATETIME COMMENT '应还款时间',
    owing_amount DECIMAL(18,4) COMMENT '待还总金额',
    owing_principal DECIMAL(18,4) COMMENT '待还本金',
    owing_interest DECIMAL(18,4) COMMENT '待还利息',
    owing_dun DECIMAL(18,4) COMMENT '待还催费',
    owing_overdue DECIMAL(18,4) COMMENT '待还罚息',
    owing_fees DECIMAL(18,4) COMMENT '待还总费用',
    repay_amount DECIMAL(18,4) COMMENT '已还总金额',
    repay_principal DECIMAL(18,4) COMMENT '已还本金',
    repay_interest DECIMAL(18,4) COMMENT '已还利息',
    repay_dun DECIMAL(18,4) COMMENT '已还催费',
    repay_overdue DECIMAL(18,4) COMMENT '已还罚息',
    repay_fees DECIMAL(18,4) COMMENT '已还总费用',
    creation_date DATETIME COMMENT '创建日期，应该和debt_total里面的时间对应',
    payment_date DATETIME COMMENT '最后还款时间',
    overdue_last_date DATETIME COMMENT '最后罚息时间',
    current_default_days INT COMMENT '逾期天数',
    overdue_status_id TINYINT COMMENT '罚息状态：NULL-罚息正常，1-罚息更新中',
    type_id TINYINT COMMENT '借款列表类型',
    sub_type_id INT COMMENT '借款列表子类型',
    guarantee INT COMMENT '担保/加赔',
    product_id INT COMMENT '产品ID',
    credit_category INT COMMENT '额度分类：1-PDL、2-主营、3-征信',
    credit_scene INT COMMENT '额度场景：1-现金、2-消费',
    valid_status_id INT COMMENT '生效状态：0-未生效；1-已生效',
    institution_id BIGINT COMMENT '机构ID',
    isactive TINYINT NOT NULL DEFAULT 1 COMMENT '是否有效',
    inserttime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    updatetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE uni_id (id),
    UNIQUE uni_loan_id_order_id (loan_id, order_id),
    KEY idx_user_id (user_id),
    KEY idx_loan_id (loan_id),
    KEY idx_status_id (status_id),
    KEY idx_inserttime (inserttime),
    KEY idx_updatetime (updatetime)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='债务表';

-- agent
CREATE TABLE agent (
    agent_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '代理人ID',
    agent_name VARCHAR(16) NOT NULL COMMENT '代理人姓名',
    agent_phone VARCHAR(16) NOT NULL COMMENT '代理人电话',
    agent_email VARCHAR(64) NOT NULL COMMENT '代理人邮箱',
    create_date DATETIME NOT NULL COMMENT '创建时间',

    is_active TINYINT NOT NULL DEFAULT 1 COMMENT '是否有效',
    insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (agent_id),
    KEY idx_insert_time (insert_time),
    KEY idx_update_time (update_time)
) ENGINE=innodb DEFAULT CHARSET=utf8 COMMENT='代理人表';

-- company
CREATE TABLE company (
  company_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '公司ID',
  company_name VARCHAR(16) NOT NULL COMMENT '公司名称',
  company_phone VARCHAR(16) NOT NULL COMMENT '公司电话',
  company_site VARCHAR(64) NOT NULL COMMENT '公司网址',

  is_active TINYINT NOT NULL DEFAULT 1 COMMENT '是否有效',
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (company_id),
  KEY idx_insert_time (insert_time),
  KEY idx_update_time (update_time)
) ENGINE=innodb DEFAULT CHARSET=utf8 COMMENT='公司信息表';

-- customer
CREATE TABLE customer (
  customer_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '客户ID',
  customer_name VARCHAR(16) NOT NULL COMMENT '客户姓名',
  customer_phone VARCHAR(16) NOT NULL COMMENT '客户电话',
  customer_email VARCHAR(64) NOT NULL COMMENT '客户邮箱',
  username VARCHAR(16) NOT NULL COMMENT '登录名称',
  password VARCHAR(64) NOT NULL COMMENT '登录密码',
  registe_date DATETIME NOT NULL COMMENT '注册时间',

  is_active TINYINT NOT NULL DEFAULT 1 COMMENT '是否有效',
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (customer_id),
  KEY idx_insert_time (insert_time),
  KEY idx_update_time (update_time)
) ENGINE=innodb DEFAULT CHARSET=utf8 COMMENT='客户信息表';

-- demand
CREATE TABLE demand (
  demand_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '需求ID',
  customer_id BIGINT UNSIGNED NOT NULL COMMENT '所属客户ID',
  agent_id BIGINT UNSIGNED NOT NULL COMMENT '代理人ID',
  demand_source VARCHAR(64) NOT NULL COMMENT '需求来源',
  demand_status SMALLINT NOT NULL DEFAULT 0 COMMENT '需求状态：0-新建; 10-已分配; 20-已规划;',
  demand_remark VARCHAR(64) COMMENT '需求备注',
  create_date DATETIME NOT NULL COMMENT '创建时间',
  assign_date DATETIME DEFAULT NULL COMMENT '分配时间',

  is_active TINYINT NOT NULL DEFAULT 1 COMMENT '是否有效',
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (demand_id),
  KEY idx_insert_time (insert_time),
  KEY idx_update_time (update_time)
) ENGINE=innodb DEFAULT CHARSET=utf8 COMMENT='需求信息表';

-- insured
CREATE TABLE insured (
  insured_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '被保人ID',
  customer_id BIGINT UNSIGNED NOT NULL COMMENT '所属客户ID',
  insured_name VARCHAR(16) NOT NULL COMMENT '被保人姓名',
  insured_sex SMALLINT NOT NULL COMMENT '被保人性别：0-男性; 1-女性;',
  insured_birthday TIME NOT NULL COMMENT '被保人生日',
  customer_phone VARCHAR(16) NOT NULL COMMENT '被保人电话',
  customer_email VARCHAR(64) NOT NULL COMMENT '被保人邮箱',
  cidType SMALLINT COMMENT '证件类型：0-未知; 1-;',
  cidNum VARCHAR(64) COMMENT '证件号码',
  create_date DATETIME NOT NULL COMMENT '创建时间',

  is_active TINYINT NOT NULL DEFAULT 1 COMMENT '是否有效',
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (insured_id),
  KEY idx_insert_time (insert_time),
  KEY idx_update_time (update_time)
) ENGINE=innodb DEFAULT CHARSET=utf8 COMMENT='被保人表';

-- plan
CREATE TABLE plan (
  plan_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '方案ID',
  demand_id BIGINT UNSIGNED NOT NULL COMMENT '所属需求ID',
  customer_id BIGINT UNSIGNED NOT NULL COMMENT '所属客户ID',
  agent_id BIGINT UNSIGNED NOT NULL COMMENT '方案代理人ID',
  plan_name VARCHAR(16) NOT NULL COMMENT '方案名称',
  plan_status SMALLINT NOT NULL DEFAULT 0 COMMENT '方案状态：0-新建;',
  create_date DATETIME NOT NULL COMMENT '创建时间',

  is_active TINYINT NOT NULL DEFAULT 1 COMMENT '是否有效',
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (plan_id),
  KEY idx_insert_time (insert_time),
  KEY idx_update_time (update_time)
) ENGINE=innodb DEFAULT CHARSET=utf8 COMMENT='规划方案表';

-- platform
CREATE TABLE platform (
  platform_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '平台ID',
  platform_name VARCHAR(16) NOT NULL COMMENT '平台名称',
  platform_site VARCHAR(64) COMMENT '公司网址',
  platform_desc VARCHAR(256) COMMENT '平台描述',
  platform_phone VARCHAR(16) NOT NULL COMMENT '平台电话',
  join_date DATETIME NOT NULL COMMENT '加入时间',
  quit_date DATETIME NOT NULL COMMENT '退出时间',
  platform_status SMALLINT NOT NULL DEFAULT 0 COMMENT '平台状态：0-新建; 1-已加入; 2-已退出;',

  is_active TINYINT NOT NULL DEFAULT 1 COMMENT '是否有效',
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (company_id),
  KEY idx_insert_time (insert_time),
  KEY idx_update_time (update_time)
) ENGINE=innodb DEFAULT CHARSET=utf8 COMMENT='代理平台表';

-- policy
CREATE TABLE policy (
  platform_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '平台ID',
  platform_name VARCHAR(16) NOT NULL COMMENT '平台名称',
  platform_site VARCHAR(64) COMMENT '公司网址',
  platform_desc VARCHAR(256) COMMENT '平台描述',
  platform_phone VARCHAR(16) NOT NULL COMMENT '平台电话',
  join_date DATETIME NOT NULL COMMENT '加入时间',
  quit_date DATETIME NOT NULL COMMENT '退出时间',
  platform_status SMALLINT NOT NULL DEFAULT 0 COMMENT '平台状态：0-新建; 1-已加入; 2-已退出;',

  is_active TINYINT NOT NULL DEFAULT 1 COMMENT '是否有效',
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (company_id),
  KEY idx_insert_time (insert_time),
  KEY idx_update_time (update_time)
) ENGINE=innodb DEFAULT CHARSET=utf8 COMMENT='保单信息表';