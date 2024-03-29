runs=$1
logMem=$2
datasets='sf_0-1'
rulesDir='rules/sdi'

if [ "$logMem" == true ];then
	suffix=mem
else
	suffix=time
fi

generalResultPath=.

for pathFrag in results local rete_incremental_$suffix emulate
do
	generalResultPath+=/
	generalResultPath+=$pathFrag
	if [ ! -d $generalResultPath ]; then
		mkdir $generalResultPath
	fi
done

for dataset in $datasets
do	
	dataDir=data/data_$dataset
	echo $size
	for ruleNumber in $(seq 1 12) '3_NGC' '4_NGC'
	do
		cleanRule='INTERACTIVE_'$ruleNumber
		echo -e '\t'$cleanRule
		
		resultPath=$generalResultPath
		for pathFrag in $dataset
		do
			resultPath+=/
			resultPath+=$pathFrag
			if [ ! -d $resultPath ]; then
				mkdir $resultPath
			fi
		done

		for run in $(seq 1 $runs)
		do
			echo -e '\t\t\tRUN '$run
			resultFile=$resultPath/$cleanRule'_run'$run'.txt'
			timeout 3h java -jar -Xms350g -Xmx350g incremental/execute_ldbc_query_viatra_rete_incremental.jar $dataDir $rulesDir'/interactive_'$ruleNumber'.gdn' $logMem > $resultFile
			retval=$?
			if [ "$retval" == 124 ]
			then
				echo -e '\t\t\tTIMEOUT'
				break
			fi
		done
	done
done
