package user.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user.demo.model.Version;

@Repository
public interface VersionRepository extends JpaRepository<Version,Long> {
}
