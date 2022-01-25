package de.mdelab.mlsdm.interpreter.experiments.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.mdelab.ldbc_snb.LdbcSNBModel;
import de.mdelab.ldbc_snb.Ldbc_snbPackage;
import de.mdelab.ldbc_snb.Post;
import de.mdelab.ldbc_snb.Tag;
import de.mdelab.ldbc_snb.log.LDBC_SNBLogCreator;
import de.mdelab.ldbc_snb.parse.LDBC_SNBParser;
import de.mdelab.mlsdm.interpreter.experiments.snb.rete.incremental.evolution.EvolutionExecutor;

public class LDBCSNBPostConverter extends LDBC_SNBLogCreator {

	public static double MIN_LENGTH = 225;
	
	private int actionCount = 0;
	private int tippingPoint;
	
	@Override
	protected void writeObjects(List<Tuple<Action, EObject>> actions,
			boolean writeDeletions, String outputFile) throws IOException {
		tippingPoint = (int) (EvolutionExecutor.RELATIVE_TIPPING_POINT * actions.size());
		OutputStreamWriter fw = new OutputStreamWriter(
				new FileOutputStream(outputFile), StandardCharsets.UTF_8);
		for (Tuple<Action, EObject> action : actions) {
			if(writeDeletions || action.e1 != Action.DELETE) {
				writeAction(action, fw);
			}
			actionCount++;
		}
		fw.flush();
		fw.close();
	}
	
	protected void writeObjectCreation(EObject o, OutputStreamWriter fw)
			throws IOException {
		if(o.eClass() == Ldbc_snbPackage.Literals.POST &&
				(actionCount > tippingPoint && (((Post) o).getContent() == null || ((Post) o).getContent().length() < MIN_LENGTH))) {
			fw.write(Action.CREATE.toString());
			fw.write('_');
			fw.write(COMMENT);
			fw.write(SEP);
			fw.write(Long.toString(getCts(o)));
			fw.write(SEP);
			writeConvertedPost((Post) o, fw);
			fw.write("\n");
		}
		else {
			super.writeObjectCreation(o, fw);
		}
	}
	
//	@Override
//	protected void writePost(Post o, OutputStreamWriter fw) throws IOException {
//		if(createdObjects > tippingPoint && (o.getContent() == null || o.getContent().length() < MIN_LENGTH)) {
//			writeConvertedPost(o, fw);
//		}
//		else {
//			super.writePost(o, fw);
//		}
//	}

	private void writeConvertedPost(Post o, OutputStreamWriter fw) throws IOException {
		fw.write(Long.toString(o.getID()));
		fw.write(SEP);
		fw.write(Long.toString(o.getHasCreator().getID()));
		fw.write(SEP);
		fw.write(Long.toString(o.getIsLocatedIn().getID()));
		fw.write(SEP);
		fw.write(Long.toString(o.getID()));
		for(Tag t:o.getHasTag()) {
			fw.write(SEP);
			fw.write(Long.toString(t.getID()));
		}
	}
	
	@Override
	protected void writeObjectDeletion(EObject o, OutputStreamWriter fw)
			throws IOException {
		if(o.eClass() == Ldbc_snbPackage.Literals.POST &&
				(actionCount > tippingPoint && (((Post) o).getContent() == null || ((Post) o).getContent().length() < MIN_LENGTH))) {
			fw.write(Action.DELETE.toString());
			fw.write('_');
			fw.write(COMMENT);
			fw.write(SEP);
			fw.write(Long.toString(getDts(o)));
			fw.write(SEP);

			writeIds(o, fw);

			fw.write("\n");
		}
		else {
			super.writeObjectDeletion(o, fw);
		}
	}
	
//	public static void main(String[] args) {
//		LdbcSNBModel model = (LdbcSNBModel) LDBC_SNBParser.parseGraph(args[0]).get(0);
//		int converted = 0;
//		for(Post p:model.getOwnedPosts()) {
//			if(p.getContent() != null && p.getContent().length() > LDBCSNBPostConverter.MIN_LENGTH) {
//				converted++;
//			}
//		}
//		System.out.println("TOTAL:\t" + model.getOwnedPosts().size());
//		System.out.println("VALID:\t" + converted);
//	}
	
	public static void main(String[] args) throws IOException {
		if(args.length < 1) {
			System.out.println("1 argument: dataDir");
			return;
		}
		
		String dataDir = args[0];
		String outputFile = dataDir + "/stream_evolution.csv";
		
		LdbcSNBModel model = (LdbcSNBModel) LDBC_SNBParser.parseGraph(dataDir).get(0);
		LDBC_SNBLogCreator creator = new LDBCSNBPostConverter();
		try {
			creator.fixDeletions(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		creator.generateLogFromModel(model, true, true, outputFile);
	}
}
