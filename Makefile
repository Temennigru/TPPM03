JFLAGS = -g
JC = javac
.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

PACKAGES := \
	. \
    GameCore \
    GameCore/Cards \
    GameCore/ConsoleCore \
    GameCore/GameObjectCore \
    GameCore/Ui/Tui \
    GameCore/Ui/Gui \

#CLASSES := $(shell find $(PACKAGES) -type f -name '*.java')
CLASSES := $(shell find $(PACKAGES) -type f -name PlayerConsoleImpl.java)

.PHONY: default clean

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) $(shell find $(PACKAGES) -type f -name '*.class')