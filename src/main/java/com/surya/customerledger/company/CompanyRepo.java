package com.surya.customerledger.company;

import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyRepo extends CrudRepository<Company, Integer> {

  @NativeQuery("select name, email from company where owner_id = ?1")
  Optional<NameEmailOnly> findByOwnerPartial(Integer ownerId);

  @NativeQuery("select * from company where owner_id = ?1")
  Optional<Company> findByOwner(Integer ownerId);

  boolean existsByEmail(String email);

  @NativeQuery("select exists (select id from company where owner_id = ?1) as company_exists;")
  long existsByOwner(Integer owner);

  Company findByEmail(String email);

  interface NameEmailOnly {
    String getEmail();

    String getName();
  }
}
