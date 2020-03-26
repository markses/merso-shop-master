package org.merso.mersoshop.repository;

import org.merso.mersoshop.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer>, JpaSpecificationExecutor<UserInfo> {

}
