/*
 * Gramatica 
 * A->aAa
 * A->bAb
 * A->c
 */
 

#include<stdio.h>
#include<stdlib.h>

char cadena[1024];
int i;

void consumir(char x){
	if(cadena[i]==x){
		i++;
	}else{
		return(1);
	}
}

void A(){
	switch(cadena[i]){
		case 'a':
			i++;A();consumir('a');break;
		case 'b':
			i++;A();consumir('b');break;
		case 'c':
			i++;break;
		default:
			printf("Simbolo invalido");
	}
}


int main(){
	scanf("%s",cadena);
	i=0;
	A();
	if(cadena[i]=='\0'){
		printf("Aceptada\n");
	}else{
		printf("Nel\n");
	}

}
