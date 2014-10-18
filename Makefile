JFLAGS = -g
JC = javac
.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

PACKAGES := \
	. \
    Core \
    Cards \
    Cards/Abstract \

CLASSES := $(shell find $(PACKAGES) -type f -name '*.java')

.PHONY: default clean
	
default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) $(shell find $(PACKAGES) -type f -name '*.class')