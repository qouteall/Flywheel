package com.jozufozu.flywheel.backend;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelLastEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class RenderWork {
	private static final Queue<Runnable> runs = new ConcurrentLinkedQueue<>();


	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onRenderWorldLast(RenderLevelLastEvent event) {
		while (!runs.isEmpty()) {
			runs.remove()
					.run();
		}
	}

	/**
	 * Queue work to be executed at the end of a frame
	 */
	public static void enqueue(Runnable run) {
		runs.add(run);
	}
}
