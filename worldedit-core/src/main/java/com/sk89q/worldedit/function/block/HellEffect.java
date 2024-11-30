
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

        import java.util.Random;

        /**
         * Changes the blocks of the building to make the building have a drought effect
         */
        public class HellEffect implements LayerFunction {

            private static final double SHROOMLIGHT = 0.05;
            private static final double TWISTING_VINES = 0.05;
            private static final double VINES_GROWTH = 0.5;
            private final EditSession editSession;
            private final Mask mask;
            private int affected = 0;
            private final Random random;

            /**
             * Make a new DroughtEffect object.
             *
             * @param editSession an edit session
             */
            public HellEffect(EditSession editSession) {
                checkNotNull(editSession);
                this.editSession = editSession;
                this.mask = new BlockTypeMask(editSession, BlockTypes.GRASS_BLOCK, BlockTypes.SHORT_GRASS,BlockTypes.POPPY,BlockTypes.FARMLAND,
                        BlockTypes.FLOWERING_AZALEA_LEAVES,BlockTypes.WATER, BlockTypes.CLAY, BlockTypes.STONE, BlockTypes.OAK_LOG,
                        BlockTypes.ACACIA_LOG, BlockTypes.CHERRY_LOG, BlockTypes.DARK_OAK_LOG, BlockTypes.JUNGLE_LOG, BlockTypes.BIRCH_LOG,
                        BlockTypes.MANGROVE_LOG, BlockTypes.SPRUCE_LOG, BlockTypes.WARPED_STEM, BlockTypes.ACACIA_LEAVES, BlockTypes.CHERRY_LEAVES, BlockTypes.JUNGLE_LEAVES,
                        BlockTypes.DARK_OAK_LEAVES, BlockTypes.MANGROVE_LEAVES, BlockTypes.OAK_LEAVES, BlockTypes.SPRUCE_LEAVES, BlockTypes.BIRCH_LEAVES,
                        BlockTypes.WARPED_WART_BLOCK, BlockTypes.SAND, BlockTypes.SHROOMLIGHT, BlockTypes.TALL_GRASS, BlockTypes.TWISTING_VINES, BlockTypes.DIRT);
                this.random = new Random();
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

            private BlockState getTargetBlock(BlockState currentBlock, BlockVector3 position) throws WorldEditException {

                if (random.nextDouble() < SHROOMLIGHT) {
                    addTreeDetail(position, BlockTypes.SHROOMLIGHT.getDefaultState());
                }
                if (random.nextDouble() < TWISTING_VINES) {
                    addTreeDetail(position, BlockTypes.TWISTING_VINES.getDefaultState());
                }
                if (currentBlock.getBlockType() == BlockTypes.TWISTING_VINES && random.nextDouble() < VINES_GROWTH) {
                    BlockVector3 bellowPosition = position.add(0, -1, 0);
                    editSession.setBlock(bellowPosition, BlockTypes.TWISTING_VINES.getDefaultState());
                }
                if (currentBlock.getBlockType() == BlockTypes.GRASS_BLOCK) {
                    return BlockTypes.WARPED_NYLIUM.getDefaultState();
                } else  if (currentBlock.getBlockType() == BlockTypes.SHORT_GRASS) {
                    return BlockTypes.NETHER_SPROUTS.getDefaultState();
                } else if (currentBlock.getBlockType() == BlockTypes.TALL_GRASS) {
                    return BlockTypes.WARPED_ROOTS.getDefaultState();
                } else if (currentBlock.getBlockType() == BlockTypes.POPPY) {
                    return BlockTypes.WARPED_FUNGUS.getDefaultState();
                } else if (currentBlock.getBlockType() == BlockTypes.FARMLAND) {
                    return BlockTypes.WARPED_NYLIUM.getDefaultState();
                } else if (currentBlock.getBlockType() == BlockTypes.FLOWERING_AZALEA_LEAVES) {
                    return BlockTypes.WARPED_ROOTS.getDefaultState();
                } else if (currentBlock.getBlockType() == BlockTypes.CLAY) {
                    return BlockTypes.BLACKSTONE.getDefaultState();
                } else if (currentBlock.getBlockType() == BlockTypes.STONE || currentBlock.getBlockType() == BlockTypes.DIRT) {
                    return BlockTypes.NETHERRACK.getDefaultState();
                } else if (currentBlock.getBlockType() == BlockTypes.SAND) {
                    return BlockTypes.SOUL_SAND.getDefaultState();
                } else if (currentBlock.getBlockType() == BlockTypes.WATER) {
                    return BlockTypes.LAVA.getDefaultState();
                } else if (isItLog(currentBlock)) {
                    return BlockTypes.WARPED_STEM.getDefaultState();
                } else if (isItLeave(currentBlock)) {
                    return BlockTypes.WARPED_WART_BLOCK.getDefaultState();
                } else{
                    return BlockTypes.AIR.getDefaultState();
                }
            }

            private void addTreeDetail(BlockVector3 position, BlockState choosenBlock)throws  WorldEditException {
                BlockVector3 bellowPosition = position.add(0, -1, 0);
                BlockState bellowBlock = editSession.getBlock(bellowPosition);

                // Somente adiciona neve se o bloco acima estiver vazio
                if (bellowBlock.getBlockType() == BlockTypes.AIR ) {
                    editSession.setBlock(bellowPosition, choosenBlock.getBlockType().getDefaultState());
                }
            }

            private boolean isItLog(BlockState currentBlock){
                if (currentBlock.getBlockType() == BlockTypes.OAK_LOG) {
                    return true;
                }else if (currentBlock.getBlockType() == BlockTypes.ACACIA_LOG) {
                    return true;
                }else if (currentBlock.getBlockType() == BlockTypes.JUNGLE_LOG) {
                    return true;
                }else if (currentBlock.getBlockType() == BlockTypes.BIRCH_LOG) {
                    return true;
                }else if (currentBlock.getBlockType() == BlockTypes.SPRUCE_LOG) {
                    return true;
                }else if (currentBlock.getBlockType() == BlockTypes.DARK_OAK_LOG) {
                    return true;
                }else if (currentBlock.getBlockType() == BlockTypes.MANGROVE_LOG) {
                    return true;
                }else if (currentBlock.getBlockType() == BlockTypes.CHERRY_LOG) {
                    return true;
                }else{
                    return false;}
            }

            private boolean isItLeave(BlockState currentBlock){
                if (currentBlock.getBlockType() == BlockTypes.OAK_LEAVES)
                    return true;
                else if (currentBlock.getBlockType() == BlockTypes.ACACIA_LEAVES)
                    return true;
                else if (currentBlock.getBlockType() == BlockTypes.JUNGLE_LEAVES)
                    return true;
                else if (currentBlock.getBlockType() == BlockTypes.BIRCH_LEAVES)
                    return true;
                else if (currentBlock.getBlockType() == BlockTypes.SPRUCE_LEAVES)
                    return true;
                else if (currentBlock.getBlockType() == BlockTypes.DARK_OAK_LEAVES)
                    return true;
                else if (currentBlock.getBlockType() == BlockTypes.MANGROVE_LEAVES)
                    return true;
                else if (currentBlock.getBlockType() == BlockTypes.CHERRY_LEAVES)
                    return true;
                else
                    return false;
            }

            private boolean applyHellEffect(BlockVector3 position, int depth) throws WorldEditException {
                BlockState currentBlock  = editSession.getBlock(position);
                BlockState targetBlock = getTargetBlock(currentBlock, position);

                if (currentBlock.equalsFuzzy(targetBlock)) {
                    return false;
                }

                return editSession.setBlock(position, targetBlock);
            }

            @Override
            public boolean apply(BlockVector3 position, int depth) throws WorldEditException {
                if (mask.test(position)) {
                    if (applyHellEffect(position, depth)) {
                        ++affected;
                    }
                }

                return true;
            }
        }
