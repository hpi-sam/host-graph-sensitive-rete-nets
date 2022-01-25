package de.mdelab.ldbc.snb.viatra.patterns.plain.run.bots;

import java.io.IOException;
import java.io.OutputStreamWriter;

import de.mdelab.ldbc_snb.Post;
import de.mdelab.ldbc_snb.Tag;
import de.mdelab.ldbc_snb.log.LDBC_SNBLogCreator;

public class LDBCSNBPostConverter extends LDBC_SNBLogCreator {

	public static double RELATIVE_TIPPING_POINT = 0.25;
	public static double MIN_LENGTH = 225;
	
	private int createdObjects = 0;
	private int tippingPoint;
	
	@Override
	protected void writePost(Post o, OutputStreamWriter fw) throws IOException {
		if(createdObjects > tippingPoint && (o.getContent() == null || o.getContent().length() < MIN_LENGTH)) {
			writeConvertedPost(o, fw);
		}
		else {
			super.writePost(o, fw);
		}
	}

	private void writeConvertedPost(Post o, OutputStreamWriter fw) throws IOException {
		fw.write(COMMENT);
		fw.write(SEP);
		fw.write(Long.toString(getCts(o)));
		fw.write(SEP);
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
		fw.write("\n");
	}
}
