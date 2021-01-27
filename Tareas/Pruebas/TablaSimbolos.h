#ifndef _TABLA_DE_SIMBOLOS_
#define _TABLA_DE_SIMBOLOS_

typedef struct Nodo{
    int tipo;
    int tamanio;
    char *cadena;
    char *variable;
    struct Nodo *siguiente;
} Nodo;

Nodo * nuevoNodoAutor(char* nombre);
Nodo * nuevoNodoItemize(int tam);


void insertarAutor(char* nombre);
void insertarItemize(int tam);

char* obtenerVariable(char* nombre);

void GenerarLatex();


#endif