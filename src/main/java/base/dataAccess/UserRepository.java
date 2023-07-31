package base.dataAccess;

import base.entities.UserInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserInfo, Integer> {
    UserInfo findById(ObjectId objectId);
//  Optional <UserInfo> findByIdOptional (ObjectId id);
}

