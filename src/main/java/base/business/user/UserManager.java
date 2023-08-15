package base.business.user;

import base.core.constants.Messages;
import base.core.exceptions.BusinessException;
import base.core.util.mapping.IModelMapperService;
import base.dataAccess.UserRepository;
import base.entities.user.UserInfo;
import base.resources.user.UserRequest;
import base.resources.user.UserResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private ObjectId objectId = new ObjectId();
    private IModelMapperService mapperService;

    @Autowired
    public UserManager(UserRepository userRepository, IModelMapperService mapperService) {
        this.userRepository = userRepository;
        this.mapperService = mapperService;
    }

    @Override
    public List<UserResponse> getAll() {

        List<UserInfo> userInfos = userRepository.findAll();
        List<UserResponse> response = userInfos.stream()
                .map(userInfo -> mapperService.mapper().map(userInfo, UserResponse.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public UserResponse getById(ObjectId id) {
        UserInfo foundedUser = userRepository.findById(id);
        UserResponse response = mapperService.mapper().map(foundedUser,UserResponse.class);

        return response;
    }
    @Override
    public String delete(ObjectId id){
        UserInfo foundedUser = userRepository.findById(id);
        userRepository.delete(foundedUser);

        return "Başarıyla Silindi.";
    }
    @Override
    public UserResponse update(UserRequest userRequest,ObjectId id) throws Exception {

        UserInfo foundedUser = userRepository.findById(id);

        checkIfUserExists(foundedUser);


        foundedUser.setFirstName(userRequest.getFirstName());
        foundedUser.setLastName(userRequest.getLastName());
        userRepository.save(foundedUser);


        UserResponse response = mapperService.mapper().map(foundedUser,UserResponse.class);

        return response;

    }



    @Override
    public UserResponse add(UserRequest userRequest) {
        UserInfo userInfo = new UserInfo();
        UserResponse userResponse = new UserResponse();

        userInfo.setFirstName(userRequest.getFirstName());
        userInfo.setLastName(userRequest.getLastName());

        userRepository.save(userInfo);


        userResponse.setId(userInfo.getId());
        userResponse.setFirstName(userInfo.getFirstName());
        userResponse.setLastName(userInfo.getLastName());

        return userResponse;
    }

    private void checkIfUserExists(UserInfo foundedUser) {
        if (foundedUser == null){
            throw new BusinessException(Messages.User.userDoesNotExist);
        }
    }

}
