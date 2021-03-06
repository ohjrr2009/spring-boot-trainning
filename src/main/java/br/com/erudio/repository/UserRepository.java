package br.com.erudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.erudio.data.model.Person;
import br.com.erudio.data.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	//usando JPQL
	@Query("SELECT u FROM User u WHERE u.userName = :username")
	User findByUsername(@Param("username") String username);

}
