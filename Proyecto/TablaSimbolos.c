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
	return a;
}

void insertarAutor(char* cadena){
    Nodo *nuevo ;
	nuevo = nuevoNodoAutor(cadena);
	nuevo->siguiente=lista;
    lista=nuevo;
}

char* obtenerVariable(char* nombre){
    Nodo * aux;
	for (aux=lista; aux != NULL; aux = aux->siguiente){
		if (strcmp(nombre, aux->variable) == 0){
			return aux->cadena;
        }
	}
}