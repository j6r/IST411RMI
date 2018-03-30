#!/usr/bin/sh

function shutdown() {
    echo "Shutting down"
    pkill rmiregistry
    exit 2
}

trap "shutdown" 2
trap "shutdown" 1

pkill rmiregistry

export PROJECT_DIR=`pwd`

echo "Building engine"
mvn clean package -q

echo "Starting rmiregistry"
cd $PROJECT_DIR/dist
rmiregistry &

echo "Starting engine"
java -cp $PROJECT_DIR/compute/target/compute-1.SNAPSHOT.jar \
    -Djava.rmi.server.codebase=file:$PROJECT_DIR/dist/ \
    -Djava.rmi.server.hostname=127.0.0.1 \
    -Djava.security.policy=$PROJECT_DIR/server.policy \
    -jar $PROJECT_DIR/engine/target/engine-1.0-SNAPSHOT.jar

#   -Djava.security.debug=access,failure \
