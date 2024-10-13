package bnch.cloning;

import java.util.stream.IntStream;

public class ManualCopy implements Runnable {
	C1 oneInstance = new C1();
	
	public void run() {
		IntStream.range(0, 100_000_000).mapToObj(n -> new C1(oneInstance))
				.filter(x -> (x != null)).count();
		//filter is added to stop dead code like optimizations
	}
}
