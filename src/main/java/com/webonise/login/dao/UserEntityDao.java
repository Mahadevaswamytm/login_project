package com.webonise.login.dao;

import com.webonise.login.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEntityDao extends JpaRepository<UserEntity, Long> {
	
	/*Scenarioa 1
	 * query returns one or more result
	 */
	
	List<UserEntity> findByLoginIdAndPassword(String loginId, String password);
	
	/*Scenarioa 2
	 * avoiding this query make unique column
	 * 
	 **/
	// @Query(value = "SELECT * FROM USER u where u.LOGIN_ID = :loginId and u.PASSWORD =:password order by u.CREATED_AT limit 1", nativeQuery = true)
	//UserEntity findByLoginIdAndPassword(@Param("loginId")String loginId,@Param("password") String password);  
	
	/*Scenarioa 3
	 * 
	 * In this case check the list with not null and size of the list greater than zero then return true else false
	 * i.e if(list != null && list.size != 0) return true else return false.
	 * 
	 * @Query(value = "SELECT * FROM USER u where u.LOGIN_ID = :loginId and u.PASSWORD =:password", nativeQuery = true)
	List<UserEntity> findByLoginIdAndPassword(@Param("loginId")String loginId,@Param("password") String password);*/
	
	
	
}
