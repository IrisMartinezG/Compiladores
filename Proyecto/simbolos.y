%{
	#include <math.h>
	#include <stdio.h>
	#include <stdlib.h>
	#include <string.h>
	#include "TablaSimbolos.h"
	int yylex (void);
	void yyerror(char * mensaje){
		printf("ERROR: %s", mensaje);
		exit(0);
	}

%}

%define api.value.type union 
%token <char *> CADENA
%token FIN AUTOR

%%
programa:
;

/*programa: AUTOR CADENA '\n'				{printf("%s > insertando\n",$2); insertarAutor($2);}	
;*/


programa:FIN '\n'						{printf("Generando Archivo"); exit(0);}
;
%%
int main(){
	yyparse();
}

