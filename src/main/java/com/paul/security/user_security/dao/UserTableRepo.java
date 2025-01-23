package com.paul.security.user_security.dao;

import com.paul.security.user_security.model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTableRepo extends JpaRepository<UserTable, String> {
}
