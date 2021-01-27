%{
	#include "sintactico.tab.h"
%}



%%
"fin"	{return SALIDA;}
"autor" {return AUTOR;}
"lista" {return LISTA;}
"TipoDocumento" {return DOCUMENTO;}
("articulo"|"libro") {yylval.TIPO=strdup(yytext);return TIPO; }


[\n]	return '\n';
[+]		return '+';

[0-9]+ {yylval.NUM=atoi(yytext);
		return NUM;
		}

[a-z]* {
		yylval.VARIABLE=strdup(yytext);
		return VARIABLE;}

%%
