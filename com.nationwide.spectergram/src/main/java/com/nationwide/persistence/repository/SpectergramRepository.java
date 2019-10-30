package com.nationwide.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nationwide.persistence.domain.spgposts;

public interface SpectergramRepository extends JpaRepository<spgposts, Long> {

}
