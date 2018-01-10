-- database
CREATE DATABASE IF NOT EXISTS cuiniaobao DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

-- admin
CREATE TABLE admin (
  admin_id BIGINT UNSIGNED NOT NULL COMMENT '管理员ID',
  admin_name VARCHAR(16) NOT NULL COMMENT '管理员姓名',
  username VARCHAR(16) NOT NULL COMMENT '登录名称',
  password VARCHAR(64) NOT NULL COMMENT '登录密码',
  registe_date DATETIME NOT NULL COMMENT '注册时间',
  login_times INT NOT NULL COMMENT '登录次数',
  last_login_date DATETIME NOT NULL COMMENT '最后登录时间',
  last_login_ip VARCHAR(16) NOT NULL COMMENT '最后登录IP',

  is_active BOOLEAN NOT NULL DEFAULT 1 COMMENT '是否有效',
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (admin_id),
  KEY idx_insert_time (insert_time),
  KEY idx_update_time (update_time)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- agent
CREATE TABLE agent (
  agent_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '代理人ID',
  agent_name VARCHAR(16) NOT NULL COMMENT '代理人姓名',
  agent_phone VARCHAR(16) NOT NULL COMMENT '代理人电话',
  agent_email VARCHAR(64) NOT NULL COMMENT '代理人邮箱',
  username VARCHAR(16) NOT NULL COMMENT '登录名称',
  password VARCHAR(64) NOT NULL COMMENT '登录密码',
  registe_date DATETIME NOT NULL COMMENT '注册时间',
  login_times INT NOT NULL COMMENT '登录次数',
  last_login_date DATETIME NOT NULL COMMENT '最后登录时间',
  last_login_ip VARCHAR(16) NOT NULL COMMENT '最后登录IP',

  is_active BOOLEAN NOT NULL DEFAULT 1 COMMENT '是否有效',
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
  company_desc VARCHAR(256) COMMENT '公司描述',
  create_date DATETIME NOT NULL COMMENT '创建时间',

  is_active BOOLEAN NOT NULL DEFAULT 1 COMMENT '是否有效',
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

  is_active BOOLEAN NOT NULL DEFAULT 1 COMMENT '是否有效',
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

  is_active BOOLEAN NOT NULL DEFAULT 1 COMMENT '是否有效',
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
  cid_type SMALLINT COMMENT '证件类型：0-未知; 1-;',
  cid_number VARCHAR(64) COMMENT '证件号码',
  create_date DATETIME NOT NULL COMMENT '创建时间',

  is_active BOOLEAN NOT NULL DEFAULT 1 COMMENT '是否有效',
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

  is_active BOOLEAN NOT NULL DEFAULT 1 COMMENT '是否有效',
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
  platform_phone VARCHAR(16) NOT NULL COMMENT '平台电话',
  platform_site VARCHAR(64) COMMENT '平台网址',
  platform_desc VARCHAR(256) COMMENT '平台描述',
  join_date DATETIME NOT NULL COMMENT '加入时间',
  quit_date DATETIME NOT NULL COMMENT '退出时间',
  platform_status SMALLINT NOT NULL DEFAULT 0 COMMENT '平台状态：0-新建; 1-已加入; 2-已退出;',

  is_active BOOLEAN NOT NULL DEFAULT 1 COMMENT '是否有效',
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (platform_id),
  KEY idx_insert_time (insert_time),
  KEY idx_update_time (update_time)
) ENGINE=innodb DEFAULT CHARSET=utf8 COMMENT='代理平台表';

-- policy
CREATE TABLE policy (
  policy_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '保单ID',
  plan_id BIGINT UNSIGNED NOT NULL COMMENT '所属方案ID',
  insured_id BIGINT UNSIGNED NOT NULL COMMENT '所属被保人ID',
  product_id BIGINT UNSIGNED NOT NULL COMMENT '所属产品ID',
  insured_period SMALLINT NOT NULL COMMENT '保障期限',
  policy_amount DECIMAL(10,2) NOT NULL DEFAULT 0 COMMENT '保单金额',
  payment_period SMALLINT NOT NULL COMMENT '缴费期限',
  period_amount DECIMAL(10,2) NOT NULL DEFAULT 0 COMMENT '每期金额',
  policy_desc VARCHAR(256) COMMENT '保单描述',
  income_date DATETIME COMMENT '收入时间',
  income_amount DECIMAL(10,2) NOT NULL DEFAULT 0 COMMENT '收入金额',
  income_platform_id VARCHAR(64) COMMENT '收入来源平台ID',
  policy_status SMALLINT NOT NULL DEFAULT 0 COMMENT '保单状态：0-新建; 1-已购买; 2-已添加;',

  is_active BOOLEAN NOT NULL DEFAULT 1 COMMENT '是否有效',
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (policy_id),
  KEY idx_insert_time (insert_time),
  KEY idx_update_time (update_time)
) ENGINE=innodb DEFAULT CHARSET=utf8 COMMENT='保单信息表';

-- product
CREATE TABLE product (
  product_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  company_id BIGINT UNSIGNED NOT NULL COMMENT '所属公司ID',
  product_type_id BIGINT UNSIGNED NOT NULL COMMENT '所属产品分类ID',
  product_name VARCHAR(16) NOT NULL COMMENT '产品名称',
  product_desc VARCHAR(256) COMMENT '产品描述',
  buy_code VARCHAR(16) NOT NULL COMMENT '购买二维码',
  buy_site VARCHAR(16) NOT NULL COMMENT '购买网站链接',

  is_active BOOLEAN NOT NULL DEFAULT 1 COMMENT '是否有效',
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (product_id),
  KEY idx_insert_time (insert_time),
  KEY idx_update_time (update_time)
) ENGINE=innodb DEFAULT CHARSET=utf8 COMMENT='产品信息表';

-- product_type
CREATE TABLE product_type (
  product_type_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '产品分类ID',
  product_type_name VARCHAR(16) NOT NULL COMMENT '产品分类名称',
  priority INT NOT NULL DEFAULT 0 COMMENT '优先级',

  is_active BOOLEAN NOT NULL DEFAULT 1 COMMENT '是否有效',
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (product_type_id),
  KEY idx_insert_time (insert_time),
  KEY idx_update_time (update_time)
) ENGINE=innodb DEFAULT CHARSET=utf8 COMMENT='产品分类表';

-- product_rate
CREATE TABLE product_rate (
  product_rate_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '产品利率ID',
  product_id BIGINT UNSIGNED NOT NULL COMMENT '所属产品ID',
  sex SMALLINT NOT NULL COMMENT '性别',
  age SMALLINT NOT NULL COMMENT '年龄',
  insured_period SMALLINT NOT NULL COMMENT '保障期限',
  payment_period SMALLINT NOT NULL COMMENT '缴费期限',
  price DECIMAL(10,2) NOT NULL DEFAULT 0 COMMENT '价格',

  is_active BOOLEAN NOT NULL DEFAULT 1 COMMENT '是否有效',
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (product_rate_id),
  KEY idx_insert_time (insert_time),
  KEY idx_update_time (update_time)
) ENGINE=innodb DEFAULT CHARSET=utf8 COMMENT='产品利率表';