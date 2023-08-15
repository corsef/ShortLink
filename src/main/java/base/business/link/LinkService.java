package base.business.link;
import base.resources.link.LinkRequest;
import base.resources.link.LinkResponse;
import org.springframework.http.HttpHeaders;

import java.net.URISyntaxException;


public interface LinkService {

    LinkResponse createLink(LinkRequest linkRequest);

    HttpHeaders setLocation(LinkRequest linkRequest);
    //HttpHeaders setLocation(LinkRequest linkRequest) throws URISyntaxException;


}
