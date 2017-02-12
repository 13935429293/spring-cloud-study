package org.ywb.study.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ywb.study.entity.User;

/**
 * Created by Administrator on 2017/2/11.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
