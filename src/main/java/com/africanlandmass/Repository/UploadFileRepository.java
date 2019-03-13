package com.africanlandmass.Repository;

import com.africanlandmass.Model.Land;
import com.africanlandmass.Model.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UploadFileRepository extends JpaRepository<UploadFile, Long> {
}
