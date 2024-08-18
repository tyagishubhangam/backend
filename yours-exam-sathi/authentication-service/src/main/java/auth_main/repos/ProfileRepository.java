package auth_main.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auth_main.models.Profile;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
