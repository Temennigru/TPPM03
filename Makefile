JFLAGS = -g
JC = javac
.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

PACKAGES := \
    Core \
    Cards \
    Cards/Abstract \

CLASSES := main.java

.PHONY: default clean $(PACKAGES)

$(PACKAGES):
	$(eval CLASSES := $(CLASSES) $@/*.java)

default: $(PACKAGES) classes

classes: $(CLASSES:.java=.class)

clean:
	$(foreach DIR,$(PACKAGES),$(eval $(RM $(DIR)/*.class) ) )