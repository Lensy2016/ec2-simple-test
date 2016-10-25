#!/bin/bash

case $1 in
   "US-WEST")
	REGION="us-west-1"
        SGROUP="sg-e3ffd787"
	DBPATH="hppdb.c2yswtdb86wd.us-west-1.rds.amazonaws.com"
	;;
   "EU-WEST")
	REGION="eu-west-1"
	SGROUP="sg-8e3222e9"
        DBPATH="hppdb.cfwotvi7qruw.eu-west-1.rds.amazonaws.com"
	;;
  "SA-EAST")
       REGION="sa-east-1"
       SGROUP="sg-72a53316"
       DBPATH="hppdb.caa5fnrisrfz.sa-east-1.rds.amazonaws.com"
        ;;
   "AP-NE")
       REGION="ap-northeast-1"
       SGROUP="sg-3c8b725b"
       DBPATH="hppdb.cdnd9b8bgbhu.ap-northeast-1.rds.amazonaws.com"
        ;;
   "AP-SE")
       REGION="ap-southeast-1"
       SGROUP="sg-02b7aa66"
       DBPATH="hppdb.chinuikz9n7t.ap-southeast-1.rds.amazonaws.com"
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

eb init ec2SimpleTest --region $REGION
eb create --cfg hpp-app-eu-full --elb-type classic -c ec2SimpleTest-env ec2SimpleTest-env --region $REGION --envvars "CLUSTER_PATH=${ENDPOINT}:11211,HPP_DB=${DBPATH}"
