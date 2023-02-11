package com.student.student.Repository;

import com.student.student.Enums.BranchName;
import com.student.student.Models.Hod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HodRepository extends JpaRepository<Hod,Integer> {
    Hod findByBranchName(BranchName branchName);
}
