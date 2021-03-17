package user.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user.demo.model.Ide;

@Repository
public interface IdeRepository extends JpaRepository<Ide,Long> {
}
