/*
Lenguaje YACC{yet another compiler of compilers}
GNU bison es la verson GNU de yacc.

flex y bison estan hechos para trabajar en conjunto 

*/
%{
	#include<stdio.h>
	#include<stdlib.h>
	
	int yylex(void);/*cabecera*/
	
	void yyerror( char *mensaje){
		printf("ERROR: %s", mensaje);
		exit(0);
	}
%}


%token NUMERO SALIDA

%%
programa:
;

programa: linea programa
;

linea: '\n'
;

linea: expresion '\n' 	{ printf("Valor = %d\n", $1 ); }
;

linea: SALIDA '\n' 	{ return(0); }
;

expresion: NUMERO	{$$=$1;}
;

expresion: expresion '+' expresion {$$ = $1 + $3;}
;

expresion: expresion '-' expresion {$$ = $1 + $3;}
;

%%
