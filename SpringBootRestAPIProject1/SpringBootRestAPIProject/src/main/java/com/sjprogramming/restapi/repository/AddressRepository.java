package com.sjprogramming.restapi.repository;

//package com.sjprogramming.restapi.repository;

import com.sjprogramming.restapi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
