H->E		

E->E+T  S(E)={$,+,)}
E->T    S(T)={*,$,+,)}=S(F)
T->T*F  
T->F
T->(E)
F->id

Cerradura H={|H->.E|, E->.E+T, E->.T, T->.T*F, T->.F, T->.(E), F->.id} .........1

Mover(1,E)={H->E., E->E.+T}..............................................................2
Mover(1,T)={|E->T., T->T.*F|}............................................................3
Mover(1,F)={T->F.}.......................................................................4
Mover(1, ( )={|T->(.E)|,E->.E+T, E->.T, T->.T*F, T->.F, T->.(E), F->.id} ................5
Mover(1, id )={F->id.} ..................................................................6

Mover(2,+)={|E->E+.T|,T->.T*F, T->.F, T->.(E), F->.id}...................................7

Mover(3,*)={|T->T*.F|,F->.id}............................................................8

Mover(5,E)={|T->(E.),E->E.+T }...........................................................9
Mover(5,T)=3
Mover(5,( )=5
Mover(5,F )=4
Mover(5,id )=6

Mover(7,T)={|E->E+T.|,T->T.*F}...................................10
Mover(7,F)= 4
Mover(7,( )=5
Mover(7,id )=6

Mover(8,F)={|T->T*F.|}...........................................11
Mover(8,id)= 6

Mover(9,))={|T->(E).|}...........................................12
Mover(9,+)=7
Mover(10,*)=8

E->E+T  S(E)={$,+,)}
E->T    S(T)={*,$,+,)}=S(F)
T->T*F  
T->F
T->(E)
F->id


	id		+		*		(       )       $		E       T       F
1	d6                      d5                      2       3       4
2			d7			                    Acc
3	        r2      d8              r2      r2                       
4           r4      r4              r4      r4
5  d6                       d5                      9       3       4       
6           r6      r6              r6      r6      			
7   d6      		d5      d5                              10      4
8	d6		                                                    	11
9	        d7                      d12
10          r1      d8              r1      r1  
11		    r3      r3              r3      r3
12          r5      r5              r5      r5

Entrada: id * (id + id)

Pila: 1 $
Entrada: id * (id + id) $
Tope, Entrada:
	1, id: ---->d6		Pila: 6 0 $ 

Entrada: * (id + id) $
Tope, Entrada:
	6, *: ---->d6		Pila: 6 1 $ 
	1) identificar la produccion: F->id
	2) contar alos simbolos de alfa: 1
	3) hacer el #(alpha) sobre la pila
		Pila:  1 $
	4) Push M[tope,produccion identificada]
		M[1,F]= 4	Pila: 4 1 $

Entrada: * (id + id) $
Tope, Entrada:
	4,*:	-->		r4 Pila: 3 1 $

Entrada: * (id + id) $
Tope, Entrada:
	3,*:	-->		d8 Pila: 8 3 1 $

Entrada: (id + id) $
Tope, Entrada:
	8, (:	-->		d8 Pila: 8 3 1 $

