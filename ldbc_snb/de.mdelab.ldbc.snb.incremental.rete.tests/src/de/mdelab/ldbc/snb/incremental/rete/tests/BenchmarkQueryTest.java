package de.mdelab.ldbc.snb.incremental.rete.tests;

import org.junit.Before;
import org.junit.Test;

public class BenchmarkQueryTest extends LDBCQueryTest {

	@Before
	public void setUp() {
		registerEPackages();
	}

	//batch tests (STATIC/DYNAMIC strategy)
	
	@Test
	public void testInteractive1Batch() {
		testBatchQuery("interactive_1.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive2Batch() {
		testBatchQuery("interactive_2.mlsp", "persons_50.log");
	}

//	skip this test as execution of interactive_3.mlsp is infeasible
//	due to excessive number of matches
//	@Test
//	public void testInteractive3() {
//		testBatchQuery("interactive_3.mlsp", "persons_50.log");
//	}
	
	@Test
	public void testInteractive4Batch() {
		testBatchQuery("interactive_4.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive5Batch() {
		testBatchQuery("interactive_5.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive6Batch() {
		testBatchQuery("interactive_6.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive7Batch() {
		testBatchQuery("interactive_7.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive8Batch() {
		testBatchQuery("interactive_8.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive9Batch() {
		testBatchQuery("interactive_9.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive10Batch() {
		testBatchQuery("interactive_10.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive11Batch() {
		testBatchQuery("interactive_11.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive12Batch() {
		testBatchQuery("interactive_12.mlsp", "persons_50.log");
	}

//	skip this test as execution of interactive_3_nac.mlsp is infeasible
//	with reference due to excessive number of matches for base pattern
//	@Test
//	public void testInteractive3NAC() {
//		testBatchQuery("interactive_3_nac.mlsp", "persons_50.log");
//	}

	@Test
	public void testInteractive4NACBatch() {
		testBatchQuery("interactive_4_nac.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive4NGCNestedBatch() {
		testBatchQuery("interactive_4_ngc_nested.mlsp", "persons_50.log");
	}
	
	//batch GDN tests (EMULATE strategy)

	@Test
	public void testInteractive1BatchGDN() {
		testBatchQueryGDN("interactive_1.gdn", "interactive_1.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive2BatchGDN() {
		testBatchQueryGDN("interactive_2.gdn", "interactive_2.mlsp", "persons_50.log");
	}

//	skip this test as execution of interactive_3.mlsp is infeasible
//	due to excessive number of matches
//	@Test
//	public void testInteractive3BatchGDN() {
//		testBatchQueryGDN("interactive_3.gdn", "interactive_3.mlsp", "persons_50.log");
//	}

	@Test
	public void testInteractive4BatchGDN() {
		testBatchQueryGDN("interactive_4.gdn", "interactive_4.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive5BatchGDN() {
		testBatchQueryGDN("interactive_5.gdn", "interactive_5.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive6BatchGDN() {
		testBatchQueryGDN("interactive_6.gdn", "interactive_6.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive7BatchGDN() {
		testBatchQueryGDN("interactive_7.gdn", "interactive_7.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive8BatchGDN() {
		testBatchQueryGDN("interactive_8.gdn", "interactive_8.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive9BatchGDN() {
		testBatchQueryGDN("interactive_9.gdn", "interactive_9.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive10BatchGDN() {
		testBatchQueryGDN("interactive_10.gdn", "interactive_10.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive11BatchGDN() {
		testBatchQueryGDN("interactive_11.gdn", "interactive_11.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive12BatchGDN() {
		testBatchQueryGDN("interactive_12.gdn", "interactive_12.mlsp", "persons_50.log");
	}

//	skip this test as execution of interactive_3_nac.mlsp is infeasible
//	with reference due to excessive number of matches for base pattern
//	@Test
//	public void testInteractive3NACGDN() {
//		testBatchQueryGDN("interactive_3_NGC.gdn", "interactive_3_nac.mlsp", "persons_50.log");
//	}

	@Test
	public void testInteractive4NACBatchGDN() {
		testBatchQueryGDN("interactive_4_nac.gdn", "interactive_4_nac.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive4NGCNestedBatchGDN() {
		testBatchQueryGDN("interactive_4_ngc_nested.gdn", "interactive_4_ngc_nested.mlsp", "persons_50.log");
	}
	
	//incremental static tests (STATIC strategy)
	
	@Test
	public void testInteractive1IncrementalStatic() {
		testIncrementalQueryStatic("interactive_1.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive2IncrementalStatic() {
		testIncrementalQueryStatic("interactive_2.mlsp", "persons_50.log");
	}

//	skip this test as execution of interactive_3.mlsp is infeasible
//	due to excessive number of matches
//	@Test
//	public void testInteractive3IncrementalStatic() {
//		testIncrementalQueryStatic("interactive_3.mlsp", "persons_50.log");
//	}
	
	@Test
	public void testInteractive4IncrementalStatic() {
		testIncrementalQueryStatic("interactive_4.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive5IncrementalStatic() {
		testIncrementalQueryStatic("interactive_5.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive6IncrementalStatic() {
		testIncrementalQueryStatic("interactive_6.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive7IncrementalStatic() {
		testIncrementalQueryStatic("interactive_7.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive8IncrementalStatic() {
		testIncrementalQueryStatic("interactive_8.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive9IncrementalStatic() {
		testIncrementalQueryStatic("interactive_9.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive10IncrementalStatic() {
		testIncrementalQueryStatic("interactive_10.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive11IncrementalStatic() {
		testIncrementalQueryStatic("interactive_11.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive12IncrementalStatic() {
		testIncrementalQueryStatic("interactive_12.mlsp", "persons_50.log");
	}

//	skip this test as execution of interactive_3_nac.mlsp is infeasible
//	with reference due to excessive number of matches for base pattern
//	@Test
//	public void testInteractive3NACIncrementalStatic() {
//		testIncrementalQueryStatic("interactive_3_nac.mlsp", "persons_50.log");
//	}

	@Test
	public void testInteractive4NACIncrementalStatic() {
		testIncrementalQueryStatic("interactive_4_nac.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive4NGCNestedIncrementalStatic() {
		testIncrementalQueryStatic("interactive_4_ngc_nested.mlsp", "persons_50.log");
	}

	//incremental GDN tests (EMULATE strategy)
	
	@Test
	public void testInteractive1IncrementalGDN() {
		testIncrementalQueryGDN("interactive_1.gdn", "interactive_1.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive2IncrementalStaticGDN() {
		testIncrementalQueryGDN("interactive_2.gdn", "interactive_2.mlsp", "persons_50.log");
	}

//	skip this test as execution of interactive_3.mlsp is infeasible
//	due to excessive number of matches
//	@Test
//	public void testInteractive3IncrementalGDN() {
//		testIncrementalQueryGDN("interactive_3.gdn", "interactive_3.mlsp", "persons_50.log");
//	}
	
	@Test
	public void testInteractive4IncrementalGDN() {
		testIncrementalQueryGDN("interactive_4.gdn", "interactive_4.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive5IncrementalGDN() {
		testIncrementalQueryGDN("interactive_5.gdn", "interactive_5.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive6IncrementalGDN() {
		testIncrementalQueryGDN("interactive_6.gdn", "interactive_6.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive7IncrementalGDN() {
		testIncrementalQueryGDN("interactive_7.gdn", "interactive_7.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive8IncrementalGDN() {
		testIncrementalQueryGDN("interactive_8.gdn", "interactive_8.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive9IncrementalGDN() {
		testIncrementalQueryGDN("interactive_9.gdn", "interactive_9.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive10IncrementalGDN() {
		testIncrementalQueryGDN("interactive_10.gdn", "interactive_10.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive11IncrementalGDN() {
		testIncrementalQueryGDN("interactive_11.gdn", "interactive_11.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive12IncrementalGDN() {
		testIncrementalQueryGDN("interactive_12.gdn", "interactive_12.mlsp", "persons_50.log");
	}

//	skip this test as execution of interactive_3_nac.mlsp is infeasible
//	with reference due to excessive number of matches for base pattern
//	@Test
//	public void testInteractive3NACIncrementalGDN() {
//		testIncrementalQueryGDN("interactive_3_ngc.gdn", "interactive_3_nac.mlsp", "persons_50.log");
//	}

	@Test
	public void testInteractive4NACIncrementalGDN() {
		testIncrementalQueryGDN("interactive_4_nac.gdn", "interactive_4_nac.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive4NGCNestedIncrementalGDN() {
		testIncrementalQueryGDN("interactive_4_ngc_nested.gdn", "interactive_4_ngc_nested.mlsp", "persons_50.log");
	}
	
	//incremental dynamic tests (DYNAMIC strategy)
	
	@Test
	public void testInteractive1IncrementalDynamic() {
		testIncrementalQueryDynamic("interactive_1.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive2IncrementalDynamic() {
		testIncrementalQueryDynamic("interactive_2.mlsp", "persons_50.log");
	}

//	skip this test as execution of interactive_3.mlsp is infeasible
//	due to excessive number of matches
//	@Test
//	public void testInteractive3IncrementalDynamic() {
//		testIncrementalQueryDynamic("interactive_3.mlsp", "persons_50.log");
//	}
	
	@Test
	public void testInteractive4IncrementalDynamic() {
		testIncrementalQueryDynamic("interactive_4.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive5IncrementalDynamic() {
		testIncrementalQueryDynamic("interactive_5.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive6IncrementalDynamic() {
		testIncrementalQueryDynamic("interactive_6.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive7IncrementalDynamic() {
		testIncrementalQueryDynamic("interactive_7.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive8IncrementalDynamic() {
		testIncrementalQueryDynamic("interactive_8.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive9IncrementalDynamic() {
		testIncrementalQueryDynamic("interactive_9.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive10IncrementalDynamic() {
		testIncrementalQueryDynamic("interactive_10.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive11IncrementalDynamic() {
		testIncrementalQueryDynamic("interactive_11.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive12IncrementalDynamic() {
		testIncrementalQueryDynamic("interactive_12.mlsp", "persons_50.log");
	}

//	skip this test as execution of interactive_3_nac.mlsp is infeasible
//	with reference due to excessive number of matches for base pattern
//	@Test
//	public void testInteractive3NACIncrementalDynamic() {
//		testIncrementalQueryDynamic("interactive_3_nac.mlsp", "persons_50.log");
//	}

	@Test
	public void testInteractive4NACIncrementalDynamic() {
		testIncrementalQueryDynamic("interactive_4_nac.mlsp", "persons_50.log");
	}

	@Test
	public void testInteractive4NGCNestedIncrementalDynamic() {
		testIncrementalQueryDynamic("interactive_4_ngc_nested.mlsp", "persons_50.log");
	}
	
}
