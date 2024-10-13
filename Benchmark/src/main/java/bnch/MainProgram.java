package bnch;

import java.time.Duration;
import java.time.LocalTime;
import java.util.stream.IntStream;
import bnch.cloning.DeepCopy;
import bnch.cloning.ManualCopy;
import bnch.cloning.Shallow;

public class MainProgram {
	static final int WARMUP_ITERATIONS = 1, NUMBER_OF_ITERATIONS = 2;
	Runnable cloning = new Shallow(), manual = new ManualCopy(), serDer = new DeepCopy();

	long averageTimeTaken(Runnable r) {
		IntStream.range(0, WARMUP_ITERATIONS).forEach(n -> r.run());
		LocalTime start = LocalTime.now();
		IntStream.range(0, NUMBER_OF_ITERATIONS).forEach(n -> r.run());
		return Duration.between(start, LocalTime.now()).toMillis() / NUMBER_OF_ITERATIONS;
	}

	public static void main(String[] param) {
		var m = new MainProgram();
		switch (Integer.valueOf(param[0])) {
			case 1 :
				System.out.println("Measuring performance for Manual copy");
				System.out.printf("Average time taken is %d milliSeconds%n", m.averageTimeTaken(m.manual));
				break;
			case 2 :
				System.out.println("Measuring performance for Cloning");
				System.out.printf("Average time taken is %d milliSeconds%n", m.averageTimeTaken(m.cloning));
				break;
			case 3 :
				System.out.println("Measuring performance for Deep copy");
				System.out.printf("Average time taken is %d milliSeconds%n", m.averageTimeTaken(m.serDer));
				break;
			default :
				System.err.println("Run fat jar ./build/libs/Benchmark.jar [1|2|3]%n");
		}
	}
}
/*
On my laptop with Intel i5-10210U CPU @ 1.6 to 2.1 GHz
	Manual copy - 27sec
	Cloning - 14sec
	Serialization/Deserialization - many minutes.
		(For 2 iterations, total time to execute will be twice.)
 */