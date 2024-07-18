-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('楼宇管理', '2000', '1', '/rent/house', 'C', '0', 'rent:house:view', '#', 'admin', sysdate(), '', null, '楼宇管理菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('楼宇管理查询', @parentId, '1',  '#',  'F', '0', 'rent:house:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('楼宇管理新增', @parentId, '2',  '#',  'F', '0', 'rent:house:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('楼宇管理修改', @parentId, '3',  '#',  'F', '0', 'rent:house:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('楼宇管理删除', @parentId, '4',  '#',  'F', '0', 'rent:house:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('楼宇管理导出', @parentId, '5',  '#',  'F', '0', 'rent:house:export',       '#', 'admin', sysdate(), '', null, '');
