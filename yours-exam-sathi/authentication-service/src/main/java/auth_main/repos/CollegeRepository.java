package auth_main.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auth_main.models.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long>{

}
