package de.mdelab.ldbc.snb.viatra.patterns.plain.run.bots;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.mdelab.ldbc_snb.Comment;
import de.mdelab.ldbc_snb.LdbcSNBModel;
import de.mdelab.ldbc_snb.Ldbc_snbFactory;
import de.mdelab.ldbc_snb.Ldbc_snbPackage;
import de.mdelab.ldbc_snb.Post;

public class LDBCSNBPostConverterBot extends LDBCSNBBot {

	private List<Post> postsToConvert;

	public LDBCSNBPostConverterBot(long seed, LdbcSNBModel model) {
		super(seed, model);
		this.postsToConvert = new ArrayList<Post>();
		EReferenceAdapter referenceAdapter = new EReferenceAdapter() {

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
	}
}
