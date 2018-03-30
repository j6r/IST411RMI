#!/usr/bin/sh

function shutdown() {
    echo "\nShutting down engine\n"
    pkill rmiregistry
    exit 2
}

trap "shutdown" 2
trap "shutdown" 1

pkill rmiregistry

echo "Resetting\n"
export PROJECT_DIR=`pwd`/output
rm -rf $PROJECT_DIR
mkdir $PROJECT_DIR

echo "Building engine\n"
mvn clean package -q

echo "Starting rmiregistry\n"
cd $PROJECT_DIR/dist
rmiregistry &

echo "Starting engine\n"
java -cp $PROJECT_DIR/dist/compute-1.SNAPSHOT.jar \
    -Djava.rmi.server.codebase=file:$PROJECT_DIR/dist/ \
    -Djava.rmi.server.hostname=127.0.0.1 \
    -Djava.security.policy=$HOME/Documents/Class/IST411_workspace/L09RMISolo/server.policy \
    -jar $PROJECT_DIR/bin/engine-1.0-SNAPSHOT.jar

#   -Djava.security.debug=access,failure \
