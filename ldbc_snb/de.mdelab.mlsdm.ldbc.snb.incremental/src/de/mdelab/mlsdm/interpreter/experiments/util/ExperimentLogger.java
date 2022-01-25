package de.mdelab.mlsdm.interpreter.experiments.util;

import java.io.PrintStream;

import de.mdelab.mlsdm.interpreter.incremental.QueryManagerNotificationReceiver;
import de.mdelab.mlsdm.interpreter.incremental.rete.ReteNet;
import de.mdelab.mlsdm.interpreter.incremental.rete.dynamic.DynamicReteQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.rete.nodes.ReteIndexer;
import de.mdelab.mlsdm.interpreter.incremental.rete.nodes.ReteNode;

public class ExperimentLogger implements QueryManagerNotificationReceiver {

	protected Runtime runtime;

	protected boolean logMem;
	protected int increments;
	protected String name;

	protected StringBuffer updateBuffer;
	protected StringBuffer memBuffer;
	protected StringBuffer recomputeBuffer;
	protected StringBuffer repopulateBuffer;
	protected StringBuffer customBuffer;

	protected long updateTime;
	protected long recomputeTime;
	protected long repopulateTime;
	
	protected int updateCount;

	protected long updateStart;
	protected long recomputeStart;
	protected long repopulateStart;

	public ExperimentLogger(int increments, boolean logMem) {
        this(increments, logMem, "");
	}

	public ExperimentLogger(int increments, boolean logMem, String name) {
        this.logMem = logMem;
		this.increments = increments;
		this.name = name;
        this.runtime = Runtime.getRuntime();
        this.updateBuffer = new StringBuffer();
        this.memBuffer = new StringBuffer();
        this.recomputeBuffer = new StringBuffer();
        this.repopulateBuffer = new StringBuffer();
        this.customBuffer = new StringBuffer();

        this.updateCount = 0;
        this.updateTime = 0;
        this.recomputeTime = 0;
        this.repopulateTime = 0;
	}
	
	@Override
	public void notifyStartUpdate() {
		updateCount++;
		updateStart = System.nanoTime();
	}

	@Override
	public void notifyCustom(Object... args) {
		if(updateCount % increments == 0) {
			if(args[0] instanceof DynamicReteQueryManager) {
				customBuffer.append(updateCount + "\t" + (long) computeNetSize(((DynamicReteQueryManager) args[0]).getCurrentNet()) + "\n");
			}
			else if(args[0] instanceof ReteNet) {
				customBuffer.append(updateCount + "\t" + (long) computeNetSize((ReteNet) args[0]) + "\n");
			}
		}
	}
	
	protected long computeNetSize(ReteNet net) {
		long size = 0;
		for(ReteNode node:net.getNodes().values()) {
			if(node instanceof ReteIndexer) {
				size += ((ReteIndexer) node).size();
			}
		}
		return size;
	}

	@Override
	public void notifyEndUpdate() {
		long updateEnd = System.nanoTime();
		updateTime += updateEnd - updateStart;
		

		if(updateCount % increments == 0) {
			updateBuffer.append(updateCount + "\t" + updateTime + "\n");
			updateTime = 0;

			repopulateBuffer.append(updateCount + "\t" + repopulateTime + "\n");
			repopulateTime = 0;

			recomputeBuffer.append(updateCount + "\t" + recomputeTime + "\n");
			recomputeTime = 0;
			
			if(logMem) {
		        runtime.gc();
		        long memory = runtime.totalMemory() - runtime.freeMemory();
		        memBuffer.append(updateCount + "\t" + memory / (1000000) + "\n");
			}
		}
	}

	@Override
	public void notifyStartRepopulate() {
		repopulateStart = System.nanoTime();
	}

	@Override
	public void notifyEndRepopulate() {
		repopulateTime += System.nanoTime() - repopulateStart;
	}

	@Override
	public void notifyStartRecompute() {
		recomputeStart = System.nanoTime();
	}

	@Override
	public void notifyEndRecompute() {
		recomputeTime += System.nanoTime() - recomputeStart;
	}

	public void flush(PrintStream stream) {
		stream.println("UPDATES " + name);
		stream.println(updateBuffer.toString());
		stream.println("-------------------------------------");
		stream.println("RECOMPUTES " + name);
		stream.println(recomputeBuffer.toString());
		stream.println("-------------------------------------");
		stream.println("REPOPULATES " + name);
		stream.println(repopulateBuffer.toString());
		stream.println("-------------------------------------");
		stream.println("MEMORY " + name);
		stream.println(memBuffer.toString());
		stream.println("-------------------------------------");
		stream.println("CUSTOM " + name);
		stream.println(customBuffer.toString());
		stream.println("-------------------------------------");
	}

	public void reset() {
        this.updateBuffer = new StringBuffer();
        this.memBuffer = new StringBuffer();
        this.recomputeBuffer = new StringBuffer();
        this.repopulateBuffer = new StringBuffer();

        this.updateCount = 0;
        this.updateTime = 0;
        this.recomputeTime = 0;
        this.repopulateTime = 0;
	}

}
