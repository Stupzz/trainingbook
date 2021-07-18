package com.stupzz.trainingbook.controllers;

import com.stupzz.trainingbook.domains.Block.Block;
import com.stupzz.trainingbook.domains.Block.BlockDto;
import com.stupzz.trainingbook.services.BlockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/blocks")
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @PostMapping("create")
    public Block createNewBlock(@RequestBody BlockDto blockDto){
        return blockService.createBlock(blockDto);
    }
}
