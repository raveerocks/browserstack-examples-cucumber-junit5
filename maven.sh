echo 'Testing on-prem'
mvn test -P on-prem

echo 'Testing on-prem-suite'
mvn test -P on-prem-suite

echo 'Testing docker'
mvn test -P docker

echo 'Testing docker-parallel'
mvn test -P docker-parallel

echo 'Testing bstack-single'
mvn test -P bstack-single

echo 'Testing bstack-local'
mvn test -P bstack-local

echo 'Testing bstack-local-parallel'
mvn test -P bstack-local-parallel

echo 'Testing bstack-local-parallel'
mvn test -P bstack-local-parallel

echo 'Testing bstack-parallel'
mvn test -P bstack-parallel

echo 'Testing bstack-parallel-browsers'
mvn test -P bstack-parallel-browsers