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
    isactive TINYINT NOT NULL DEFAULT '1' COMMENT '是否有效',
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
    agent_phone
    agent_email
    create_date DATETIME NOT NULL COMMENT '创建时间',

    is_active TINYINT NOT NULL DEFAULT '1' COMMENT '是否有效',
    insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (agent_id),
    KEY idx_insert_time (insert_time),
    KEY idx_update_time (update_time)
) ENGINE=innodb DEFAULT CHARSET=utf8 COMMENT='代理人表';
