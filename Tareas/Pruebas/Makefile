a.out: lex.yy.o sintactico.tab.o TablaSimbolos.c
	gcc lex.yy.o sintactico.tab.o TablaSimbolos.c -ll

lex.yy.o: lex.yy.c
	gcc -c lex.yy.c

sintactico.tab.o: sintactico.tab.c
	gcc -c sintactico.tab.c

lex.yy.c: lexico.l sintactico.tab.c
	flex lexico.l

sintactico.tab.c: sintactico.y
	bison -d sintactico.y

clean:
	rm -f a.out sintactico.tab.* lex.yy.* archivo.tex

run: a.out
	./a.out
