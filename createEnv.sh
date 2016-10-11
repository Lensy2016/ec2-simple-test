#!/bin/bash

case $1 in
   "US-WEST")
	REGION="us-west-1"
        SGROUP="sg-e3ffd787"
	;;
   "EU-WEST")
	REGION="eu-west-1"
	SGROUP="sg-8e3222e9"
	;;
   "")
	echo "Requires a region (US-WEST, EU-WEST)"
	exit 0;
	;;
   *)
	echo "Invalid parameters; cannot continue"
	exit 0;
	;;
esac

ENDPOINT=$( aws elasticache describe-cache-clusters --region $REGION | grep Address | cut -d "\"" -f 4 )
if [ -z "$ENDPOINT" ]; then
   echo "No cache endpoint found - cannot continue"
   exit 0;
fi
echo "Using cache endpoint: $ENDPOINT"

eb create --cfg hpp-app-eu-full --elb-type classic -c ec2SimpleTest-env ec2SimpleTest-env --region $REGION --envvars "CLUSTER_PATH=${ENDPOINT}:11211"
