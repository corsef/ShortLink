package base.dataAccess;

import base.entities.link.LinkInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkRepository extends MongoRepository<LinkInfo, Long> {

    Optional<LinkInfo> findByAlias(String alias);

    LinkInfo existsByAlias(String alias);
}
