/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.entity;

import com.sk89q.jnbt.CompoundTag;
import com.sk89q.worldedit.world.NbtValued;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A snapshot of an entity that can be reused and passed around.
 */
public class BaseEntity implements NbtValued {

    private String id;
    private CompoundTag nbtData;

    /**
     * Create a new base entity.
     *
     * @param id the entity type ID
     * @param nbtData NBT data
     */
    public BaseEntity(String id, CompoundTag nbtData) {
        setTypeId(id);
        setNbtData(nbtData);
    }

    /**
     * Create a new base entity with no NBT data.
     *
     * @param id the entity type ID
     */
    public BaseEntity(String id) {
        setTypeId(id);
    }

    /**
     * Make a clone of a {@link BaseEntity}.
     *
     * @param other the object to clone
     */
    public BaseEntity(BaseEntity other) {
        checkNotNull(other);
        setTypeId(other.getTypeId());
        setNbtData(other.getNbtData());
    }

    @Override
    public boolean hasNbtData() {
        return true;
    }

    @Override
    public CompoundTag getNbtData() {
        return nbtData;
    }

    @Override
    public void setNbtData(CompoundTag nbtData) {
        checkNotNull(nbtData);
        this.nbtData = nbtData;
    }

    /**
     * Get the entity that determines the type of entity.
     *
     * @return the entity ID
     */
    public String getTypeId() {
        return id;
    }

    /**
     * Set the entity ID that determines the type of entity.
     *
     * @param id the id
     */
    public void setTypeId(String id) {
        checkNotNull(id);
        this.id = id;
    }

}