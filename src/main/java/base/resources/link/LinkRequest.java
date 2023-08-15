package base.resources.link;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;

@Data
public class LinkRequest {

    @NotNull
    private String alias;
    @NotNull
    private String url;

    public LinkRequest() {
    }

    public LinkRequest(String alias, String url) {
        this.alias = alias;
        this.url = url;
    }


    public String getAlias() {
        return alias;
    }

    public String getUrl() {
        return url;
    }




    @Override
    public String toString() {
        return "LinkRequest{" +
                "alias='" + alias + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
