package com.us.wapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.us.wapp.model.History;

/**
 * @author UmaShankar
 * @since 14-Feb-2019
 *
 */
@Repository
public interface IHistoryRepository extends JpaRepository<History,Integer> {

	@Query("select h from History h where h.user.id=:id")
	List<History> findByUser(@Param("id") int id);
}
