package base.business.link;

import base.dataAccess.LinkRepository;
import base.entities.link.LinkInfo;
import base.resources.link.LinkRequest;
import base.resources.link.LinkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class LinkManager implements LinkService{
    public LinkRepository linkRepository;

    @Autowired
    public LinkManager(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public LinkResponse createLink(LinkRequest linkRequest) {

        LinkInfo linkInfo = new LinkInfo();
        LinkResponse linkResponse = new LinkResponse();

        linkInfo.setAlias(linkRequest.getAlias());
        linkInfo.setUrl(linkRequest.getUrl());
        linkInfo.setChangedUrl(linkRequest.getUrl() + linkRequest.getAlias());
        this.linkRepository.save(linkInfo);

        linkResponse.setAlias(linkInfo.getAlias());
        linkResponse.setUrl(linkInfo.getUrl());
        linkResponse.setChangedUrl((linkRequest.getUrl() + linkRequest.getAlias()));


        return linkResponse;
    }
    @Override
    public HttpHeaders setLocation(LinkRequest linkRequest){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create(linkRequest.getUrl()));
        return httpHeaders;
    }

}
