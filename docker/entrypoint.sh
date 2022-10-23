#!/bin/bash
set -e

ARG_COUNT="$2"
ARG_QUERY="$1"

OUT_DIR="/github/workspace/build"
ES_INPUT_DIR="/github/workspace/src/main/java"
ES_OUT_FILE="/github/workspace/build/activities.ndjson"

mkdir "$OUT_DIR"

java -jar /opt/expr-service/full_deploy.jar analyzer source \
  --count="$ARG_COUNT" \
  --query="$ARG_QUERY" \
  "$ES_INPUT_DIR" > "$ES_OUT_FILE"
echo "$(cat $ES_OUT_FILE)"

java -jar /opt/expr-service/full_deploy.jar analyzer source \
  --format=ACTIVITY \
  --count="$ARG_COUNT" \
  --query="$ARG_QUERY" \
  "$ES_INPUT_DIR" > "$ES_OUT_FILE"
