package com.astrodust.instaclone.service.interfaces;

import com.astrodust.instaclone.entity.Role;
import com.astrodust.instaclone.enums.RoleEnum;

public interface RoleService {
    Role findByName(RoleEnum roleEnum);
}
