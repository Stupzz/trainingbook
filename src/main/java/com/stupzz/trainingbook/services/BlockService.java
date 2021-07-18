package com.stupzz.trainingbook.services;

import com.stupzz.trainingbook.domains.Block.Block;
import com.stupzz.trainingbook.domains.Block.BlockDto;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class BlockService {

    private final MongoTemplate mongoTemplate;

    public BlockService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Block blockDtoAsBlock(BlockDto blockDto){
        return new Block(blockDto);
    }

    public Block createBlock(BlockDto blockDto) {
        Block block = new Block(blockDto);
        return this.mongoTemplate.insert(block);
    }


}
