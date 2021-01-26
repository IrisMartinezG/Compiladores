Instructions
Práctica 1. Diseño e implementación de las clases AFN y AFD.
Tiempo de elaboración: 1 hora y media.

Objetivo:

Utilizar los conocimientos sobre el paradigma orientado a objetos y los
autómatas finitos, para diseñar e implementar las clases AFN y AFD.

Requerimientos:
Los autómatas se podrán almacenar en formato de archivo af. (ver Anexo.)
Las clases AFN y AFD deberán tener disponibles los siguientes métodos: (Nota: ninguno de los métodos usa la salida estándar.)
cargar_desde(nombre:string)
guardar_en(nombre:string)
agregar_transicion(inicio:int, fin:int, simbolo:char)
eliminar_transicion(inicio:int, fin:int, simbolo:char)
obtener_inicial():int
obtener_finales():vector<int>
establecer_inicial(estado:int)
establecer_final(estado:int)
esAFN(): bool
esAFD(): bool
acepta(cadena:string): bool
generar_cadena(): string
Anexo:

El formato af (autómata finito) se describe a continuación:

Los símbolos del alfabeto que pueden usar para el autómata son: a,c,d,...,x,y,z. (sin acentos, sin la ñ), 26 símbolos en total.
Se usa E para detonar a épsilon.
Las etiquetas de los estados son números enteros positivos: 1,2,3,4,...(no hay estado cero)
Cada línea define una transición del autómata, en el formato, estado->estado,simbolo
La primera línea indica al estado inicial: inicial:estado
La segunda línea indica a los estados finales: finales:estado,estado,estado,estado
Las lineas siguientes, cada una, indican una transición.
Por ejemplo, el autómata de la página 155 del libro del "dragón morado" (Aho, et al) sería:

inicial:1
finales:11
1->2,E
1->8,E
2->3,E
2->5,E
3->4,a
5->6,b
6->7,E
4->7,E
7->2,E
7->8,E
8->9,a
9->10,b
11->11,b
