package com.Alpha.Alpha.Repo;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.aspectj.weaver.tools.Trace;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.Alpha.Alpha.Dto.BhaktDto;
import com.Alpha.Alpha.Model.Bhakt;

import jakarta.transaction.Transactional;

@Repository

public interface BhaktRepo extends JpaRepository<Bhakt, Integer> {

	@Query(value = "Select * from bhakt where mobile_no = :mobileNo and status=1", nativeQuery = true)
	Bhakt findByMobNo(String mobileNo);

	@Query(value = "Select * from bhakt where status=0", nativeQuery = true)
	List<Bhakt> getAllPendingRequest();

	@Modifying
	@Transactional
	@Query(value = "update bhakt set status=1 where id = :id", nativeQuery = true)
	void approve(String id);

}
