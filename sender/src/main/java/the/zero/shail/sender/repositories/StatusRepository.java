package the.zero.shail.sender.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import the.zero.shail.sender.models.StatusModel;

@Repository
public interface StatusRepository extends JpaRepository<StatusModel, Integer> {
    StatusModel getStatusModelById(int id);
}
