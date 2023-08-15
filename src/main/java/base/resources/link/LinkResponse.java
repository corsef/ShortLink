package base.resources.link;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkResponse {

    private String id;

    private String alias;

    private String url;

    private String changedUrl;

}
