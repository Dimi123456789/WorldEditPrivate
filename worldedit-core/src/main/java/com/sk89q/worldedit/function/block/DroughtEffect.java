
        /*
         * WorldEdit, a Minecraft world manipulation toolkit
         * Copyright (C) sk89q <http://www.sk89q.com>
         * Copyright (C) WorldEdit team and contributors
         *
         * This program is free software: you can redistribute it and/or modify
         * it under the terms of the GNU General Public License as published by
         * the Free Software Foundation, either version 3 of the License, or
         * (at your option) any later version.
         *
         * This program is distributed in the hope that it will be useful,
         * but WITHOUT ANY WARRANTY; without even the implied warranty of
         * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
         * GNU General Public License for more details.
         *
         * You should have received a copy of the GNU General Public License
         * along with this program.  If not, see <https://www.gnu.org/licenses/>.
         */
        package com.sk89q.worldedit.function.block;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.function.LayerFunction;
import com.sk89q.worldedit.function.mask.BlockTypeMask;
import com.sk89q.worldedit.function.mask.Mask;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.world.block.BlockState;
import com.sk89q.worldedit.world.block.BlockType;
import com.sk89q.worldedit.world.block.BlockTypes;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Changes the blocks of the building to make the building have a drought effect
 */
public class DroughtEffect implements LayerFunction {

    private final EditSession editSession;
    private final Mask mask;
    private int affected = 0;

    /**
     * Make a new DroughtEffect object.
     *
     * @param editSession an edit session
     */
    public DroughtEffect(EditSession editSession) {
        checkNotNull(editSession);
        this.editSession = editSession;
        this.mask = new BlockTypeMask(editSession, BlockTypes.GRASS_BLOCK, BlockTypes.SHORT_GRASS,BlockTypes.POPPY,BlockTypes.FARMLAND,
                BlockTypes.FLOWERING_AZALEA_LEAVES,BlockTypes.WATER,BlockTypes.ICE,BlockTypes.SNOW_BLOCK, BlockTypes.CLAY,
                BlockTypes.STONE,BlockTypes.STONE_SLAB, BlockTypes.CHERRY_LEAVES);
    }

    /**
     * Get the number of affected objects.
     *
     * @return the number of affected
     */
    public int getAffected() {
        return affected;
    }

    @Override
    public boolean isGround(BlockVector3 position) {
        return mask.test(position);
    }

    private BlockState getTargetBlock(BlockState currentBlock) {


        if (currentBlock.getBlockType() == BlockTypes.GRASS_BLOCK) {
            return BlockTypes.DIRT.getDefaultState();
        } else if (currentBlock.getBlockType() == BlockTypes.SHORT_GRASS) {
            return BlockTypes.DEAD_BUSH.getDefaultState();
        } else if (currentBlock.getBlockType() == BlockTypes.POPPY) {
            return BlockTypes.WITHER_ROSE.getDefaultState();
        } else if (currentBlock.getBlockType() == BlockTypes.FARMLAND) {
            return BlockTypes.DIRT_PATH.getDefaultState();
        }else if (currentBlock.getBlockType() == BlockTypes.FLOWERING_AZALEA_LEAVES) {
            return BlockTypes.AZALEA_LEAVES.getDefaultState();
        } else if (currentBlock.getBlockType() == BlockTypes.CLAY) {
            return BlockTypes.TERRACOTTA.getDefaultState();
        }  else if (currentBlock.getBlockType() == BlockTypes.STONE) {
            return BlockTypes.SANDSTONE.getDefaultState();
        } else if (currentBlock.getBlockType() == BlockTypes.STONE_SLAB) {
            return BlockTypes.SANDSTONE_SLAB.getDefaultState();
        }else{
            return BlockTypes.AIR.getDefaultState();
        }

    }

    private boolean naturalize(BlockVector3 position, int depth) throws WorldEditException {
        BlockState currentBlock  = editSession.getBlock(position);
        BlockState targetBlock = getTargetBlock(currentBlock );

        if (currentBlock .equalsFuzzy(targetBlock)) {
            return false;
        }

        return editSession.setBlock(position, targetBlock);
    }

    @Override
    public boolean apply(BlockVector3 position, int depth) throws WorldEditException {
        if (mask.test(position)) {
            if (naturalize(position, depth)) {
                ++affected;
            }
        }

        return true;
    }
}
