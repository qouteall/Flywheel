package com.jozufozu.flywheel.backend.instancing.blockentity;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.level.block.entity.BlockEntity;

public interface BlockEntityTypeExtension<T extends BlockEntity> {
	@Nullable
	BlockEntityInstancingController<? super T> flywheel$getInstancingController();

	void flywheel$setInstancingController(@Nullable BlockEntityInstancingController<? super T> instancingController);
}
