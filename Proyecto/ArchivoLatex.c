#include "ArchivoLatex.h"

#include <stdio.h>
#include <stdlib.h>

void generarArchivos(Nodo * ind){
	Nodo * aux;
	char* archivo = "";

	char* autor;
	int contador_campos = 0;
	//printf("checa nombre %s ", nombre);
	for (aux = ind; aux != NULL; aux = indice -> siguiente)
	{
		if(strcmp("autor", aux->variable) == 0)
			autor = indice -> cadena;
	}
	FILE *fp;
	fp = fopen("archivo.tex", "w+");
	fprintf(fp,"\documentclass[a4paper,11pt]{article}\n");
  	fprintf(fp,"\usepackage[latin1]{inputenc}\n");
  	fprintf(fp,"\usepackage{graphicx}\n");
  	fprintf(fp,"\usepackage{color}\n");
  	fprintf(fp,"\parskip=2mm\n");
  	fprintf(fp,"\autor{ %s }\n", autor);
  	fprintf(fp,"\begin{document}\n");
  	fprintf(fp,"\maketitle\n", autor);
  	fprintf(fp,"\end{document}\n");
  	fclose(fp);
}

