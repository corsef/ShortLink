package base.business;

import base.core.constants.Messages;
import base.core.exceptions.BusinessException;
import base.core.util.mapping.IModelMapperService;
import base.dataAccess.UserRepository;
import base.entities.UserInfo;
import base.resources.UserRequest;
import base.resources.UserResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService{
    private final UserRepository userRepository;
    private ObjectId objectId = new ObjectId();
    UserInfo userInfo = new UserInfo();
    UserResponse userResponse = new UserResponse();
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
        /*Optional<UserInfo> optionalFoundedUser;

        try {
            optionalFoundedUser = Optional.of(userRepository.findByIdOptional(id)
                    .orElseThrow(()-> new Exception("This person does not exist")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        UserInfo actualFoundedUser = optionalFoundedUser.get();
        actualFoundedUser.setFirstName(userRequest.getFirstName());
        actualFoundedUser.setLastName(userRequest.getLastName());
        userRepository.save(actualFoundedUser);*/

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
        userInfo.setId(objectId);
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
