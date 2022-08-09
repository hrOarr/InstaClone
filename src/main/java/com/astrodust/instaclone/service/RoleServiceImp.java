package com.astrodust.instaclone.service;

import com.astrodust.instaclone.entity.Role;
import com.astrodust.instaclone.enums.RoleEnum;
import com.astrodust.instaclone.repository.RoleRepository;
import com.astrodust.instaclone.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(RoleEnum roleEnum) {
        return roleRepository.findByName(roleEnum).orElse(null);
    }
}
