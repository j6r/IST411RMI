#!/usr/bin/sh

export PROJECT_DIR=`pwd`

java -cp $PROJECT_DIR/compute/target/compute-1.SNAPSHOT.jar:$PROJECT_DIR/client/target/client-1.0-SNAPSHOT.jar \
     -Djava.rmi.server.codebase="file:$PROJECT_DIR/client/target/client-1.0-SNAPSHOT.jar" \
     -Djava.rmi.server.hostname=127.0.0.1 \
     -Djava.security.policy=$PROJECT_DIR/server.policy \
     -jar $PROJECT_DIR/client/target/client-1.0-SNAPSHOT.jar

#     -Djava.security.debug=access,failure \
