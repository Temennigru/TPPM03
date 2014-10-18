JFLAGS = -g
JC = javac
.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

PACKAGES := \
    Core \
    Cards \
    Cards/Abstract \
    
CLASSES := $(call getJava,$(PACKAGES))

.PHONY: default clean makeClasses

#$(PACKAGES):
	$(eval CLASSES := $(CLASSES) $@/*.java)

makeClasses:
	$(eval CLASSES := $(call getJava,$(PACKAGES)))

default: makeClasses classes

classes: $(CLASSES:.java=.class)

clean:
	$(foreach DIR,$(PACKAGES),$(eval $(RM $(DIR)/*.class) ) )