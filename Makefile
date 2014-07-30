ifeq ($(OS),Windows_NT)
	SRCMAKE=dir /s /B *.java > sources.txt
else
	SRCMAKE=find . -name "*.java" > sources.txt
endif

JC=javac
NAME=GeoMago
all: jar
jar:
	mkdir -p bin/
	$(SRCMAKE)
	$(JC) -encoding utf8 -d bin @sources.txt
	jar cfe $(NAME).jar org.poo.geomago.GeoMago -C bin/ .
	rm sources.txt
clean:
	rm -rf bin/
	rm -rf $(NAME).jar
	rm -rf docs/
run:
	java -jar $(NAME).jar
doc:
	javadoc -d docs/ -sourcepath src/ -encoding utf8 -subpackages org
