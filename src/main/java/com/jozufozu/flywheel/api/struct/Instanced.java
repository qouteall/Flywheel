package com.jozufozu.flywheel.api.struct;

import com.jozufozu.flywheel.backend.gl.buffer.VecBuffer;
import com.jozufozu.flywheel.core.source.FileResolution;

public interface Instanced<S> extends StructType<S> {
	/**
	 * Create a {@link StructWriter} that will consume instances of S and write them to the given buffer.
	 *
	 * @param backing The buffer that the StructWriter will write to.
	 */
	StructWriter<S> getWriter(VecBuffer backing);

	FileResolution getInstanceShader();
}
