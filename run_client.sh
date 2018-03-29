#!/usr/bin/sh

export PROJECT_DIR="$HOME/Documents/Class/IST411_workspace/L09RMISolo/output"


java -cp $PROJECT_DIR/dist/compute-1.SNAPSHOT.jar:$PROJECT_DIR/dist/:$PROJECT_DIR/bin/client-1.0-SNAPSHOT.jar \
     -Djava.rmi.server.codebase="file:$PROJECT_DIR/bin/client-1.0-SNAPSHOT.jar file:$PROJECT_DIR/dist/" \
     -Djava.rmi.server.hostname=127.0.0.1 \
     -Djava.security.policy=$HOME/Documents/Class/IST411_workspace/L09RMISolo/server.policy \
     -jar $PROJECT_DIR/bin/client-1.0-SNAPSHOT.jar

#     -Djava.security.debug=access,failure \
