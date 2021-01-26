#ifndef _TABLA_DE_SIMBOLOS_
#define _TABLA_DE_SIMBOLOS_

typedef struct Nodo{
    int tipo;
    char *cadena;
    char *variable;
    struct Nodo *siguiente;
} Nodo;

Nodo * nuevoNodoAutor(char* nombre);//del tipo cadena

void insertarAutor(char* nombre);

char* obtenerVariable(char* nombre);


#endif