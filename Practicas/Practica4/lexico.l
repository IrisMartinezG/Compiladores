%{
	/*Para generar un códgio en flex es necesario definir 3 
	  espacios o areas para que flex los identifique y 
	  trabaje con base en ellas.*/
	/*Primer sección: Sección de definición,definiciones del 
	  lenguaje C y definiciones regulares(Conjuntos)
	  Segunda seccion:Reglas para definir una expresión regular*/
	/*Un analizador lexico se define o se especifica 
	  usando expresiones regulares.
	  Expresión regular es una notación simplificada 
	  para lenguajes regulares: conjuntos finitos y operaciones.
	  OPeraciones: Union, concatenacion y la ceradura*/

	/*Código de C*/
	#include<stdio.h>
%}
digito [0-9]

%%
("tipo"|"Tipo"|"idioma"|"autor"):	{ printf("etiqueta informacion  ");}
("opemat"|"suma"|"sumatoria"):	{ printf("etiqueta matematica  ");}
("tamLetra"|"tipoLetra"): 	{ printf("etiqueta estilo ");}
{digito}+(pt|cm)	{ printf("info etiqueta tamanio  ");}
"esp"|"eng"	{ printf("palabra reservada idioma ");}
"documento"|"articulo"|"reporte"|"presentacion"	{ printf("palabra reservada idioma ");}
,	{ printf("union de etiquetas o parametros  ");}


%%
