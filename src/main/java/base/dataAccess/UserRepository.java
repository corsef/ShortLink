package base.dataAccess;

import base.entities.UserInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserInfo, Integer> {
    //Optional<PersonInfo> findPersonInfoById(ObjectId objectId);
    UserInfo findById(ObjectId objectId);
}

