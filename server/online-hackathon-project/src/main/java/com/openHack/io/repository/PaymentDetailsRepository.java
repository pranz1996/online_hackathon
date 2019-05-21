package com.openHack.io.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.openHack.io.entity.PaymentDetailsEntity;

@Repository
public interface PaymentDetailsRepository extends CrudRepository<PaymentDetailsEntity, Long>{
	PaymentDetailsEntity findById(long id);
	
	@Query(value="SELECT * FROM payments where hackathon_name like ?1", nativeQuery = true)
	ArrayList<PaymentDetailsEntity> getHackathonPayments(String hackathonName);
}
