all: clean install

clean:
    rm -rf target ~/.m2/repository/org/cavebeetle/

install:
    mvn install

check-plugin-updates:
    mvn -pl :parent-base-pom versions:display-plugin-updates     "-Dmaven.version.ignore=.*-M.*,.*-alpha.*,.*-beta.*,.*-rc.*"

check-dependency-updates:
    mvn -pl :parent-base-pom versions:display-dependency-updates "-Dmaven.version.ignore=.*-M.*,.*-alpha.*,.*-beta.*,.*-rc.*"

check-updates: check-plugin-updates check-dependency-updates
