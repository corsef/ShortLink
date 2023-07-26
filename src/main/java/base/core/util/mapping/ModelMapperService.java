package base.core.util.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperService implements IModelMapperService{
    private ModelMapper modelMapper;

    @Autowired
    public void ModelMapperManager(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public ModelMapper mapper() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true) //araştır
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }
}
