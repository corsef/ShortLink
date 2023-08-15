package base.api;

import base.business.link.LinkService;
import base.resources.link.LinkRequest;
import base.resources.link.LinkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.MOVED_PERMANENTLY;

@RestController
@RequestMapping("/link")
public class LinkController {

    private LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/asdf")
    public ResponseEntity<LinkResponse> getLink(@PathVariable LinkRequest linkRequest) throws URISyntaxException {
        return null;
    }
    @PostMapping("/asdfg")
    public ResponseEntity<LinkResponse> createLink(@RequestBody LinkRequest linkRequest){
        return ResponseEntity.ok(linkService.createLink(linkRequest));
    }
    @GetMapping ("/{alias}")
    public ResponseEntity<LinkRequest> setLocation(LinkRequest linkRequest) {
        return ResponseEntity.status(MOVED_PERMANENTLY).headers(linkService.setLocation(linkRequest)).body(linkRequest);
    }
}
