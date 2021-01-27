%{
	#include "calculadora.tab.h"
%}

%%
"fin"	{
		return SALIDA;
	}

[0-9]+	{
		yylval=atoi(yytext);
		return NUMERO;
	}
[\n]	return '\n';
[+]	return '+';

%%
