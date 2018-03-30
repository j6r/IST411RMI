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
export PROJECT_DIR=`pwd`
rm -rf $PROJECT_DIR/output
mkdir $PROJECT_DIR/output

echo "Building engine\n"
mvn clean package -q

echo "Starting rmiregistry\n"
cd $PROJECT_DIR/output/dist
rmiregistry &

echo "Starting engine\n"
java -cp $PROJECT_DIR/compute/target/compute-1.SNAPSHOT.jar \
    -Djava.rmi.server.codebase=file:$PROJECT_DIR/output/dist/ \
    -Djava.rmi.server.hostname=127.0.0.1 \
    -Djava.security.policy=$PROJECT_DIR/server.policy \
    -jar $PROJECT_DIR/engine/target/engine-1.0-SNAPSHOT.jar

#   -Djava.security.debug=access,failure \
