package base.entities.link;

import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.net.URI;

public class LinkInfo {
    @Id
    @Generated
    @Indexed(unique = true)
    private String id;
    private String alias;
    private String url;
    private String changedUrl;

    public LinkInfo() {
    }

    public LinkInfo(String id, String alias, String url, String changedUrl) {
        this.id = id;
        this.alias = alias;
        this.url = url;
        this.changedUrl = changedUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChangedUrl() {
        return changedUrl;
    }

    public void setChangedUrl(String changedUrl) {
        this.changedUrl = changedUrl;
    }
}
