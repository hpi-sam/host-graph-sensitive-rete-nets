Installation:
- download and install Eclipse Modeling Tools (e.g. via the Eclipse installer from https://www.eclipse.org/downloads/)
- add the Eclipse Neon update-site (http://download.eclipse.org/releases/neon/) to the list of registered update-sites
- install SDM-related Eclipse-Plugins (required for reading query specifications , i.e., .mlsp-files) from our update-site: https://www.hpi.uni-potsdam.de/giese/update-site/ ("SDM Metamodels, Editors, and Interpreters" category)
- install the VIATRA Eclipse-Plugins from the VIATRA update-site: http://download.eclipse.org/viatra/updates/release/2.4.0

LDBC SNB
- the mdelab.mlsdm.ldbc.snb.incremental project contains classes with main methods for query execution using our RETE implementation and different construction techniques
- .mlsp (required for ExecuteDynamicIncremental, ExecutePeriodicIncremental, and ExecuteStaticIncremental) and .gdn (required for ExecuteGDNIncremental) specifications of the adapted benchmark queries used in our evaluation can be found in ldbc_snb/resources/rules
- the mdelab.ldbc.snb.viatra.patterns.plain project contains a class with a main method for query execution

Train Benchmark
- the Train Benchmark is available under https://github.com/ftsrg/trainbenchmark
- the project trainbenchmark-tool-sdm contains an implementation of the Train Benchmark with our RETE net construction technique and simple graph queries
- the project trainbenchmark-tool-viatra-patterns replaces the Train Benchmark project with the same name and contains simple graph query versions of the benchmark queries in VIATRA's query language

Tests
- the rete/de.mdelab.mlsdm.incremental.rete.tests project contains test cases for validating the host-graph-sensitive rete net construction techniques for a number of simple queries (SimpleQueryTest) and more complex queries from the LDBC SNB (LDBCQueryTest)
- as host graph for the tests, a small dataset generated with the LDBC SNB data generator (https://github.com/ldbc/ldbc_snb_datagen_hadoop) is used

Wiki

- additional measurement results and visualizations of the test queries can be found in the wiki
