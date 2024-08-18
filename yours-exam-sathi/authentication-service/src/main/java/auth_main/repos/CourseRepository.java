package auth_main.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auth_main.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
