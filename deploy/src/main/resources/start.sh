#!/usr/bin/env bash
PROCESS=`ps -ef|grep "blogs-deploy-prod.jar"|grep -v grep|grep -v PPID|awk '{ print $2}'`
for i in $PROCESS
do
  sudo kill -15 $i
done