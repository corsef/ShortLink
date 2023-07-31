package base.api;

import base.business.UserManager;
import base.business.UserService;
import base.dataAccess.UserRepository;
import base.entities.UserInfo;
import base.resources.UserRequest;
import base.resources.UserResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class UserController {
    private ObjectId objectId = new ObjectId();
    private UserInfo userInfo = new UserInfo();
    /*
    * Ekran açık bırakılmaz, bırakırsan olmaz :)
    *
    *
    * */
    private final UserRepository userRepository;

    private final UserService userService;


    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/profile/get")
    public ResponseEntity<List<UserResponse>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
    @GetMapping("/profile/get/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable("id") ObjectId id){
        return ResponseEntity.ok(userService.getById(id));
    }
    @PostMapping("/profile/add")
    public ResponseEntity<UserResponse> createProfile(@RequestBody UserRequest userRequest){
        return ResponseEntity.status(201).body(userService.add(userRequest));
    }
    @DeleteMapping("/profile/delete/{id}")
    public ResponseEntity<String> deleteInfoById(@PathVariable("id") ObjectId id){
        return ResponseEntity.ok(userService.delete(id));

    }
    @PutMapping("/profile/update/{id}")
        public ResponseEntity<UserResponse> update(@PathVariable("id") ObjectId id, @RequestBody UserRequest userRequest) throws Exception {

        return ResponseEntity.ok(userService.update(userRequest,id));
        /*try {
            foundedUser = this.userRepository.findById(id).orElseThrow(
                    () -> new Exception("This person does not exist." + id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        foundedUser.setFirstName(userRequest.getFirstName());
        foundedUser.setLastName(userRequest.getLastName());

        this.userRepository.save(foundedUser);

        return ResponseEntity.ok(foundedUser);
    }*/

    /*@ResponseBody
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public String handleHttpMediaTypeNotAcceptableException() {
        return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
    }*/
}}
