package dmacc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.model.Hand;

@Repository
public interface IHandRepo extends JpaRepository<Hand, Long> {}

