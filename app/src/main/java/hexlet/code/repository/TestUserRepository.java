package hexlet.code.repository;

import hexlet.code.model.TestUser;
import hexlet.code.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserRepository extends JpaRepository<TestUser, Long> {
}
