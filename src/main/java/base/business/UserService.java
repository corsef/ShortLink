package base.business;

import base.resources.UserRequest;
import base.resources.UserResponse;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponse> getAll();
    Optional<UserResponse> getById(ObjectId id);
    UserResponse add(UserRequest userRequest);
    String delete(ObjectId id);
    UserResponse update(UserRequest userRequest,ObjectId id);
}
