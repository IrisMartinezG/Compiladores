#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include "TablaSimbolos.h"

Nodo * lista = NULL;

Nodo* nuevoNodoAutor(char* nombre){	
	Nodo *a ;
	a = (Nodo*)malloc(sizeof(Nodo)); 			
	a-> variable = "autor";
	a-> cadena = nombre;
	a-> siguiente = NULL;
	printf("insertando dentro de la lista\n");
	return a;
}

Nodo* nuevoNodoItemize(int tamanio){	
	Nodo *a ;
	a = (Nodo*)malloc(sizeof(Nodo)); 			
	a-> variable = "itemize";
	a-> tamanio = tamanio;
	a-> siguiente = NULL;
	printf("insertando dentro de la lista\n");
	return a;
}


void insertarAutor(char* cadena){
	printf("insertando %s \n", cadena);
	Nodo *nuevo ;
	nuevo = nuevoNodoAutor(cadena);
	nuevo->siguiente=lista;
    lista=nuevo;
	printf("insertada :) \n");
}

void insertarItemize(int tam){
	printf("insertando itemize de tamanio %d \n", tam);
	Nodo *nuevo ;
	nuevo = nuevoNodoItemize(tam);
	nuevo->siguiente=lista;
    lista=nuevo;
	printf("insertada :) \n");
}

char* obtenerVariable(char* nombre){
    Nodo * aux;
	for (aux=lista; aux != NULL; aux = aux->siguiente){
		if (strcmp(nombre, aux->variable) == 0){
			return aux->cadena;
        }
	}
}

void GenerarLatex(){
	Nodo *aux;char *autor;
	for (aux = lista; aux != NULL; aux = lista -> siguiente)
	{
		if(strcmp("autor", aux->variable) == 0)
			autor = lista -> cadena;
	}
	FILE *fp;
	fp = fopen("archivo.tex", "w+");
	fprintf(fp,"%cdocumentclass[a4paper,11pt]{article}\n",92);
  	fprintf(fp,"%cusepackage[latin1]{inputenc}\n",92);
  	fprintf(fp,"%cusepackage{graphicx}\n",92);
  	fprintf(fp,"%cusepackage{color}\n",92);
  	fprintf(fp,"%cparskip=2mm\n",92);
  	fprintf(fp,"%cautor{ %s }\n",92, autor);
  	fprintf(fp,"%cbegin{document}\n",92);
  	fprintf(fp,"%cmaketitle\n",92);
  	fprintf(fp,"%cend{document}\n",92);
  	fclose(fp);
}