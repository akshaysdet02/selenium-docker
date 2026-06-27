FROM bellsoft/liberica-openjdk-alpine

# Install curl jq
RUN apk add curl jq

# workspace
WORKDIR /home/selenium-docker

# Add the required files
ADD target/docker-resources ./
ADD runner.sh               runner.sh

#Environment Variables
#BROWSER
#HUB_HOST
#TEST_SUITE
#THREAD_COUNT

# Start the runner.sh
# ENTRYPOINT java -cp 'libs/*' \
#            -Dselenium.grid.enabled=true \
#            -Dselenium.grid.hubHost=${HUB_HOST} \
#            -Dbrowser=${BROWSER} \
#            org.testng.TestNG \
#            -threadcount ${THREAD_COUNT} \
#            test-suites/${TEST_SUITE}
ENTRYPOINT sh runner.sh