package bnch.cloning;

public class Shallow implements Runnable {
	C1 oneInstance = new C1();
	public void run() {
		for (long i = 0; i < 100_000_000; i++)
			oneInstance.callClone();
	}

}
