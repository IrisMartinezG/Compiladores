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
	  
	  
 //Decimal [0-9]*"."[0-9]+
 //Palabras [a-z]+
 //Variable "|"[a-z]*"|"
 
	  para lenguajes regulares: conjuntos finitos y operaciones.
	  OPeraciones: Union, concatenacion y la ceradura*/

	/*Código de C*/
	#include<stdio.h>
	#include <stdlib.h>
	#include "simbolos.tab.h"
	
%}


Entero [0-9]+
Decimal [0-9]*"."[0-9]+
Variable "("[a-z]+")"
autor "autor"
espacio " "
fin "fin"
 

%%
{autor}				{ /*Autor del documento*/
					printf("etiqueta informacion %s \n", yytext);
					return(AUTOR);
					}

{Variable}			{
					printf("constante %s", yytext);
					/*yylval.cad=strdup(yytext);*/
					/*return(CADENA);*/
					}

"documento:"|"articulo:"|"reporte:"	{/*tipo de documento*/ 
					printf("palabra reservada idioma ");}
					
"lista:"				{/*tipo de documento*/ 
					printf("para las  listas ");}
"imagen:"				{/*tipo de documento*/ 
					printf("para las imagenes ");}

{fin}				{
					printf("Fin del documento");
					return(FIN);
					}

%%

