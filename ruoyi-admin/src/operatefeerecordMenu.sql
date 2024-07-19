CREATE TABLE `rent_operating_expenses_record` (
                                                  `id` varchar(32) NOT NULL COMMENT '主键',
                                                  `item_type` varchar(2) DEFAULT NULL COMMENT '费用项目类型，1-水费；2-电费',
                                                  `start_date` date DEFAULT NULL COMMENT '开始计算时间',
                                                  `end_date` date DEFAULT NULL COMMENT '结束计算时间',
                                                  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                                  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                                  `operate_id` varchar(32) DEFAULT NULL COMMENT '关联运营项表',
                                                  `start_num` int(11) DEFAULT NULL COMMENT '开始数',
                                                  `end_num` int(11) DEFAULT NULL COMMENT '结束数',
                                                  PRIMARY KEY (`id`),
                                                  KEY `expenses_house_pk` (`operate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运营费用记录表';
-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运营费用记录', '2000', '1', '/rent/operatefeerecord', 'C', '0', 'rent:operatefeerecord:view', '#', 'admin', sysdate(), '', null, '运营费用记录菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运营费用记录查询', @parentId, '1',  '#',  'F', '0', 'rent:operatefeerecord:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运营费用记录新增', @parentId, '2',  '#',  'F', '0', 'rent:operatefeerecord:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运营费用记录修改', @parentId, '3',  '#',  'F', '0', 'rent:operatefeerecord:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运营费用记录删除', @parentId, '4',  '#',  'F', '0', 'rent:operatefeerecord:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运营费用记录导出', @parentId, '5',  '#',  'F', '0', 'rent:operatefeerecord:export',       '#', 'admin', sysdate(), '', null, '');
