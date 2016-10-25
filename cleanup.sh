#!/bin/sh


for region in us-west-1 sa-east-1 ap-northeast-1 ap-southeast-1
do
aws elasticache delete-cache-cluster --cache-cluster-id hpp --region $region
aws rds delete-db-instance  --skip-final-snapshot --db-instance-identifier hppdb --region $region
eb terminate ec2SimpleTest-env --region $region --force 
done
