package by.bsuir.artemyev.repository;

import by.bsuir.artemyev.domain.IdFileName;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IdFileNameRepository extends MongoRepository<IdFileName, String> {
    List<IdFileName> findAllByFileName(String fullFileName);
}
