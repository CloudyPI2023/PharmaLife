package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.Command;

public interface CommandRepository extends JpaRepository<Command, Long>
{
}
