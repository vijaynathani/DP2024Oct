package bnch.cloning;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeepCopy implements Runnable {
	C1 oneInstance = new C1();
	final byte[] byteArray;
	public DeepCopy() {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		try (ObjectOutputStream out = new ObjectOutputStream(bout)) {
			out.writeObject(oneInstance);
			out.flush();
		} catch (Exception ignore) {}
		byteArray = bout.toByteArray();
	}

	public void run() {
		for (long i = 0; i < 100_000_000; i++)
			deserialize();
	}

	private C1 deserialize() {
		C1 r = null;
		try {
			r = (C1) new ObjectInputStream(new ByteArrayInputStream(byteArray)).readObject();
		} catch (Exception ignore) {}
		return r;
	}
}
