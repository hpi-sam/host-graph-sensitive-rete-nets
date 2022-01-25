package de.mdelab.mlsdm.interpreter.experiments.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.mdelab.ldbc_snb.Comment;
import de.mdelab.ldbc_snb.LdbcSNBModel;
import de.mdelab.ldbc_snb.Ldbc_snbFactory;
import de.mdelab.ldbc_snb.Ldbc_snbPackage;
import de.mdelab.ldbc_snb.Post;
import de.mdelab.ldbc_snb.log.LDBC_SNBLogReader;
import de.mdelab.ldbc_snb.log.elements.LDBC_SNBElementDeletion;
import de.mdelab.mlsdm.interpreter.searchModel.patternMatcher.MLSDMReferenceAdapter;

public class LDBCSNBPostConverterBot extends LDBCSNBBot {

	private List<Post> postsToConvert;
	private LDBC_SNBLogReader logReader;

	public LDBCSNBPostConverterBot(long seed, LdbcSNBModel model, LDBC_SNBLogReader logReader) {
		super(seed, model);
		this.logReader = logReader;
		this.postsToConvert = new ArrayList<Post>();
		MLSDMReferenceAdapter referenceAdapter = new MLSDMReferenceAdapter() {

			protected void doAddEObject(EObject eObject) {
				if(eObject.eClass() == Ldbc_snbPackage.Literals.POST) {
					Post p = (Post) eObject;
					if(p.getContent() == null || p.getContent().length() < LDBCSNBPostConverter.MIN_LENGTH) {
						postsToConvert.add(p);
					}
				}
			}

		};
		referenceAdapter.registerEObject(model);
	}

	public List<Post> getPostsToConvert() {
		return postsToConvert;
	}
	
	public void convertPost() {
		Post p = postsToConvert.remove(postsToConvert.size() - 1);
		
		Comment c = Ldbc_snbFactory.eINSTANCE.createComment();
		model.getOwnedComments().add(c);
		c.setHasCreator(p.getHasCreator());
		c.getHasTag().addAll(p.getHasTag());
		

		p.setHasCreator(null);
		p.getHasTag().clear();
		model.getOwnedPosts().remove(p);
		
		LDBC_SNBElementDeletion deletion = logReader.getDeletion(p.getID());
		if(deletion != null) {
			deletion.setElement(c);
		}
	}
}
