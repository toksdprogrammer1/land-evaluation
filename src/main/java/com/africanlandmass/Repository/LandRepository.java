package com.africanlandmass.Repository;


import com.africanlandmass.Model.Land;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandRepository extends JpaRepository<Land, Long> {

    Long findAllById (Long id);


}
