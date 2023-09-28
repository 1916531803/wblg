package com.harrison.wblg.acl.service.impl;

import com.harrison.wblg.model.acl.AdminRole;
import com.harrison.wblg.acl.mapper.AdminRoleMapper;
import com.harrison.wblg.acl.service.AdminRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {
}
