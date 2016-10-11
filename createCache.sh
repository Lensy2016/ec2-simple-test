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
	exit 0
	;;
   *)
	echo "Invalid parameters; cannot continue"
	exit 0
	;;
esac

function waitForCache() {
  while true; do

  STATUS=$( aws elasticache describe-cache-clusters --region $REGION | grep CacheClusterStatus | cut -d "\"" -f 4 )

  if [ "$STATUS" != "creating" ]; then
	return;
  fi

  done
}

aws elasticache create-cache-cluster --region $REGION \
--cache-cluster-id "HPP" \
--num-cache-nodes 3 \
--az-mode cross-az \
--cache-node-type cache.t2.micro \
--engine memcached \
--security-group-ids "$SGROUP" \
--tags "Key=WPG-APP,Value=HPP Key=WPG-TIER,Value=Cache Key=WPG-REGION,Value=EU"

if [ -n "$2" ]; then
   waitForCache
   echo "Cache status is $STATUS"
fi

