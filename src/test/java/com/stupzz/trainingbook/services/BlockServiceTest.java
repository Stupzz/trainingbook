package com.stupzz.trainingbook.services;

import com.stupzz.trainingbook.domains.Block.Block;
import com.stupzz.trainingbook.domains.Block.BlockDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;

@ExtendWith(MockitoExtension.class)
public class BlockServiceTest {

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private BlockService blockService;

    @Test
    void createBlockFromDto(){
        BlockDto dto = new BlockDto();
        dto.setName("test1");

        Block result = blockService.blockDtoAsBlock(dto);

        Assertions.assertEquals("test1", result.getName());
    }
}
