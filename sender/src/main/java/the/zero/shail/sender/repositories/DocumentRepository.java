package the.zero.shail.sender.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import the.zero.shail.sender.models.DocumentModel;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentModel, Integer> {
}
