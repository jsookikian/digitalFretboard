JFLAGS = -g
JC = javac

sources = $(wildcard *.java)
classes = $(sources:.java=.class)

all: $(classes)

default: $(classes)

clean:
	        $(RM) *.class

%.class : %.java 
		$(JC) $(JFLAGS) $<
