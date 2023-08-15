package base.business.user;

import base.resources.user.UserRequest;
import base.resources.user.UserResponse;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {
    List<UserResponse> getAll();
    UserResponse getById(ObjectId id);
    UserResponse add(UserRequest userRequest);
    String delete(ObjectId id);
    UserResponse update(UserRequest userRequest,ObjectId id) throws Exception;
}
