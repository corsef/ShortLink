package base.resources;

import lombok.*;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private ObjectId id;
    private String firstName;
    private String lastName;

}
