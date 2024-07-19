-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运营记录', '2000', '1', '/rent/operaterecord', 'C', '0', 'rent:operaterecord:view', '#', 'admin', sysdate(), '', null, '运营记录菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运营记录查询', @parentId, '1',  '#',  'F', '0', 'rent:operaterecord:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运营记录新增', @parentId, '2',  '#',  'F', '0', 'rent:operaterecord:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运营记录修改', @parentId, '3',  '#',  'F', '0', 'rent:operaterecord:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运营记录删除', @parentId, '4',  '#',  'F', '0', 'rent:operaterecord:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运营记录导出', @parentId, '5',  '#',  'F', '0', 'rent:operaterecord:export',       '#', 'admin', sysdate(), '', null, '');
