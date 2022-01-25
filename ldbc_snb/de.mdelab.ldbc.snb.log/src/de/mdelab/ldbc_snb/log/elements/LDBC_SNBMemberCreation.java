package de.mdelab.ldbc_snb.log.elements;

import org.eclipse.emf.ecore.EObject;

import de.mdelab.ldbc_snb.Forum;
import de.mdelab.ldbc_snb.HasMemberLink;
import de.mdelab.ldbc_snb.LdbcSNBModel;
import de.mdelab.ldbc_snb.Person;

public class LDBC_SNBMemberCreation
		extends
			LDBC_SNBElementAction<HasMemberLink> {

	private HasMemberLink member;
	private Forum forum;
	private Person person;

	public LDBC_SNBMemberCreation(long creationTime, HasMemberLink member, Forum forum, Person person) {
		super(creationTime);
		this.member = member;
		this.forum = forum;
		this.person = person;
	}
	
	@Override
	public HasMemberLink executeAction(EObject model) {
		((LdbcSNBModel) model).getOwnedHasMemberLinks().add(member);
		member.setForum(forum);
		person.getIsMember().add(member);
		return member;
	}

	@Override
	public void undoAction(EObject model) {
		person.getIsMember().remove(member);
		member.setForum(null);
		((LdbcSNBModel) model).getOwnedHasMemberLinks().remove(member);
	}

}
