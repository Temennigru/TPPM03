JFLAGS = -g
JC = javac
.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

PACKAGES := \
	. \
    GameCore \
    GameCore/GameObjectImpl \
    GameCore/GameObjectImpl/Cards \
    GameCore/ConsoleCore \
    GameCore/GameObjectCore \
    GameCore/Ui/Tui \
    GameCore/Ui/Gui \
    GameCore/Util \

#CLASSES := $(shell find $(PACKAGES) -type f -name '*.java')
CLASSES := $(shell find $(PACKAGES) -type f -name LogicSolver.java)

.PHONY: default clean

default: classes lines

lines:
	$(eval TMP := $(shell find . -type f -name '*.java' | xargs wc -l))
	@echo $(TMP)

classes: $(CLASSES:.java=.class)

clean:
	$(RM) $(shell find $(PACKAGES) -type f -name '*.class')

run:
	java main