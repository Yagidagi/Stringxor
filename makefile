all:
	@javac *.java

run: Coder.class
	@java Coder $(ARGS)

Coder.class: Coder.java
	@javac Coder.java

clean: 
	@rm *.class