/*
A->bCA
A->cAb
A->aB
B->bA
B->aCb
C->

*/

#include<stdio.h>
#include<stdlib.h>
int i;
char cadena[1024];
void consumir(char x){
	if(cadena[i]==x){
		i++;
	}else{
		printf("simbolo invalido");
		return(1);
	}
}

void A();
void B();

void A(){
	switch(cadena[i]){
		case 'b':
            i++;C();consumir('a');break;
			break;
        case 'c':
			break;
		default:
			printf("--Error :c \n");break;
	}
}

void B(){
	printf("---\n");
	switch(cadena[i]){
		case 'a':
			printf("---");
			i++;A();consumir('b');break;
		case 'b':
			i++;break;
		default:
			printf("Error :c ");	
	}
}

int main(){
	scanf("%s",cadena);
	i=0;
	if(cadena[0]=='a' && cadena[2]=='b'){
		B();
	}else{
		A();
	}
	if(cadena[i]=='\0'){
		printf("Aceptada");
	}else{
		printf("Nel\n");
	}
}
