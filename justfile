all: clean install

clean:
    rm -rf target ~/.m2/repository/org/cavebeetle/

install:
    ~/bin/mvn install
