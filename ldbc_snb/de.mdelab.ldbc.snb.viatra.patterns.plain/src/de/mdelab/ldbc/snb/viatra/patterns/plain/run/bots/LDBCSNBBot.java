package de.mdelab.ldbc.snb.viatra.patterns.plain.run.bots;

import java.util.List;
import java.util.Random;

import de.mdelab.ldbc_snb.LdbcSNBModel;

public abstract class LDBCSNBBot {
	
	private Random random;

	protected LdbcSNBModel model;
	
	public LDBCSNBBot(long seed, LdbcSNBModel model) {
		this.random = new Random(seed);
		this.model = model;
	}
	
	protected <E> E getRandomElement(List<E> list) {
		int index = random.nextInt(list.size());
		return list.get(index);
	}

	public void addRandomElement() {
		throw new UnsupportedOperationException();
	}

	public void removeRandomElement() {
		throw new UnsupportedOperationException();
	}
	
	public void restoreTargetCharacteristics() {
		throw new UnsupportedOperationException();
	}
}
