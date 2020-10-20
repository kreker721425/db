package com.github.kreker721425.db.repositories;

import com.github.kreker721425.db.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    Request findByNumber(String number);

    @Query(value = "select * from request where number like '%number%' and type_customer like '%typeCustomer%'" +
            "and name_customer like '%nameCustomer%' and address_customer like '%addressCustomer%' and type_owner like '%typeOwner%'" +
            "and name_owner like '%nameOwner%' and address_owner like '%addressOwner%'", nativeQuery = true)
    List<Request> findByAllAttribute(long number, String typeCustomer, String nameCustomer, String addressCustomer,
                                     String typeOwner, String nameOwner, String addressOwner);

    @Query(value = "select id from request", nativeQuery = true)
    List<BigInteger> findAllId();
}
