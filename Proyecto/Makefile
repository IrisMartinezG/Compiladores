simbolos.tab.c: simbolos.y
	bison -d simbolos.y

lex.yy.c: lexico.l TablaSimbolos.h simbolos.tab.c 
	flex lexico.l

lex.yy.o: lex.yy.c 
	gcc -c lex.yy.c

simbolos.tab.o: simbolos.tab.c
	gcc -c simbolos.tab.c

TablaSimbolos.o: TablaSimbolos.c
	gcc -c TablaSimbolos.c

a.out: lex.yy.o simbolos.tab.o TablaSimbolos.o
	gcc lex.yy.o simbolos.tab.o TablaSimbolos.o -ll -lm

run: a.out
	./a.out

clean: 
	rm *.o *.tab.h a.out
