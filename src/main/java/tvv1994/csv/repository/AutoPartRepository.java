package tvv1994.csv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tvv1994.csv.model.AutoPart;

public interface AutoPartRepository extends JpaRepository<AutoPart, Long> {
}
