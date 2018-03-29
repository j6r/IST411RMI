#!/usr/bin/sh

function shutdown() {
    echo "Shutting down ComputeEngine"
    pkill rmiregistry
    exit 2
}

trap "shutdown" 2

export PROJECT_DIR="$HOME/Documents/Class/IST411_workspace/L09RMISolo/output"
rm -rf $PROJECT_DIR

mvn clean package

cd $PROJECT_DIR/dist
pkill rmiregistry
rmiregistry &


java -cp $PROJECT_DIR/dist/compute-1.SNAPSHOT.jar:$PROJECT_DIR/dist \
    -Djava.rmi.server.codebase=file:$PROJECT_DIR/dist/compute-1.SNAPSHOT.jar \
    -Djava.rmi.server.hostname=127.0.0.1 \
    -Djava.security.policy=$HOME/Documents/Class/IST411_workspace/L09RMISolo/server.policy \
    -jar $PROJECT_DIR/bin/engine-1.0-SNAPSHOT.jar

#   -Djava.security.debug=access,failure \
