#!/usr/bin/sh

export PROJECT_DIR="$HOME/Documents/Class/IST411_workspace/L09RMISolo/output"
rm -rf $PROJECT_DIR

mvn clean package

cd $PROJECT_DIR/dist
rmiregistry &


java -cp $PROJECT_DIR/dist/compute-1.SNAPSHOT.jar:$PROJECT_DIR/dist \
    -Djava.rmi.server.codebase=file:$PROJECT_DIR/dist/compute-1.SNAPSHOT.jar \
    -Djava.rmi.server.hostname=1ocalhost \
    -Djava.security.policy=$HOME/Documents/Class/IST411_workspace/L09RMISolo/server.policy \
    -jar $PROJECT_DIR/bin/engine-1.0-SNAPSHOT.jar

#   -Djava.security.debug=access,failure \
