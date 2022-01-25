package de.mdelab.ldbc.snb.viatra.patterns.plain.run.bots;

import de.mdelab.ldbc_snb.KnowsLink;
import de.mdelab.ldbc_snb.LdbcSNBModel;
import de.mdelab.ldbc_snb.Ldbc_snbFactory;
import de.mdelab.ldbc_snb.Person;

public class LDBCSNBKnowsBot extends LDBCSNBBot {

	public static int TARGET_KNOWS_PER_PERSON = 400;
	
	private int targetKnows;
	
	public LDBCSNBKnowsBot(int targetKnows, LdbcSNBModel model, long seed) {
		super(seed, model);
		this.targetKnows = targetKnows;
	}

	@Override
	public void addRandomElement() {
		Person p1 = getRandomElement(model.getOwnedPersons());
		Person p2 = getRandomElement(model.getOwnedPersons());
		
		KnowsLink k1 = Ldbc_snbFactory.eINSTANCE.createKnowsLink();
		KnowsLink k2 = Ldbc_snbFactory.eINSTANCE.createKnowsLink();
		model.getOwnedKnowsLinks().add(k1);
		model.getOwnedKnowsLinks().add(k2);

		p1.getKnows().add(k1);
		k1.setKnows(p2);

		p2.getKnows().add(k2);
		k2.setKnows(p1);
	}

	@Override
	public void removeRandomElement() {
		KnowsLink k = getRandomElement(model.getOwnedKnowsLinks());
		k.setKnowsOpp(null);
		k.setKnows(null);
		model.getOwnedKnowsLinks().remove(k);
	}

	public void restoreTargetCharacteristics() {
		if(model.getOwnedKnowsLinks().size() < model.getOwnedPersons().size() * targetKnows) {
			while(model.getOwnedKnowsLinks().size() < model.getOwnedPersons().size() * targetKnows) {
				addRandomElement();
			}
		}
		else if(model.getOwnedKnowsLinks().size() > model.getOwnedPersons().size() * targetKnows) {
			while(model.getOwnedKnowsLinks().size() > model.getOwnedPersons().size() * targetKnows) {
				removeRandomElement();
			}
		}
	}
	
	public int getKnowsToCreate() {
		return (int) (model.getOwnedPersons().size() * targetKnows - model.getOwnedKnowsLinks().size());
	}
}
