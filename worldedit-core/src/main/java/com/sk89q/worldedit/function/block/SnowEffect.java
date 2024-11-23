
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
        public class SnowEffect implements LayerFunction {

            private final EditSession editSession;
            private final Mask mask;
            private int affected = 0;

            /**
             * Make a new DroughtEffect object.
             *
             * @param editSession an edit session
             */
            public SnowEffect(EditSession editSession) {
                checkNotNull(editSession);
                this.editSession = editSession;
                this.mask = new BlockTypeMask(editSession, BlockTypes.GRASS_BLOCK);
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


                if (currentBlock.getBlockType() == BlockTypes.GRASS_BLOCK)
                    return BlockTypes.SNOW_BLOCK.getDefaultState();
                else
                    return currentBlock;
            }

            private boolean applySnowEffect(BlockVector3 position, int depth) throws WorldEditException {
                BlockState currentBlock  = editSession.getBlock(position);
                BlockState targetBlock = getTargetBlock(currentBlock );

                if (currentBlock.equalsFuzzy(targetBlock)) {
                    return false;
                }

                return editSession.setBlock(position, targetBlock);
            }

            @Override
            public boolean apply(BlockVector3 position, int depth) throws WorldEditException {
                if (mask.test(position)) {
                    if (applySnowEffect(position, depth)) {
                        ++affected;
                    }
                }

                return true;
            }
        }
