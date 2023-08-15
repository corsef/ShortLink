package base.dataAccess;

import base.entities.user.UserInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserInfo, Integer> {
    UserInfo findById(ObjectId objectId);
//  Optional <UserInfo> findByIdOptional (ObjectId id);
}

