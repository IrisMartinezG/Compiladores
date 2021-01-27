/*
Lenguaje YACC{yet another compiler of compilers}
GNU bison es la verson GNU de yacc.

flex y bison estan hechos para trabajar en conjunto 

*/
%{
	#include<stdio.h>
	#include<stdlib.h>
	#include<string.h>
	#include"TablaSimbolos.h"

	int yylex(void);/*cabecera*/
	
	void yyerror( char *mensaje){
		printf("ERROR: %s", mensaje);
		exit(0);
	}
%}

%define api.value.type union 
%token NUMERO SALIDA  AUTOR LISTA DOCUMENTO 
%token <int>  NUM         /* Simple double precision number.  */
%token <char *> TIPO
%token <char *> VARIABLE    /* Symbol table pointer: variable and function.  */

%left VARIABLE NUM TIPO

%%
programa:
;

programa: line programa
;

line: '\n'
;

line:
;

line: 
	|AUTOR VARIABLE '\n'	{printf("el AUTOR es %s \n", $2);insertarAutor($2);}
	|LISTA NUM '\n' {printf("los indices son : %d \n",$2); insertarItemize($2);}
	|DOCUMENTO TIPO '\n' {printf("tipo de documento %s",$2);}
;

line: SALIDA '\n' {/*GenerarLatex();*/return 0;}
;


%%
int main(){
	yyparse();
	return 0;
}
