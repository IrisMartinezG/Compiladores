%{
	#include<stdio.h>
	#include<math.h>
	#include"calc.h"

	int yylex(void);
	void yyerror(char const * );
	
%}
%define api.value.type.union
%token <double> NUM
%token <symrec *> VAR FUN
%nterm <double> exp

%precendence '='
%left '-' '+'
%left '*' '/'
%precendence NEG 
%right '^'


%%

input:

| input line
;

line:
	'\n'
| exp '\n' {printf ("%.10g\n"),$1;}
| error '\n' {yyerror;}
;

exp:	
	NUM
| VAR	{$$ = $1->value.var;}
| VAR '=' exp	{$$ = $3; $1->value.var=$3;}
| FUN '(' exp ')'	{$$ = $1->value.fin ($3);}
| exp '+' exp {$$ = $1 + $3;}
| exp '-' exp {$$ = $1 - $3;}
| exp '*' exp {$$ = $1 * $3;} 
| exp '/' exp {$$ = $1 / $3;}
| '-' exp %prec NEG {$$ = -$2;}
| exp '^' exp {$$ = pow ($1,$3);}
| '(' exp ')'{$$=$2;}
;
%%
