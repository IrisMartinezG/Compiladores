H->A

A->Abc
A->BA
A->CB
B->bCA
B->BcA
B->b
C->ABCa
C->CBAb
C->c

Cerradura H={|H->.A|, A->.Abc, A->.BA, A->.CB, B->.bCA, B->.BcA, B->.b, C->.ABCa, C->.CBAb, C->.c} .....1

Mover(1,A)={|H->A., A->A.bc, C->A.BCa|, B->.bCA, B->.BcA, B->.b,}........................2
Mover(1,B)={|A->B.A, B->B.cA|, A->.Abc, A->.BA, A->.CB, B->.bCA, B->.BcA, B->.b, C->.ABCa, C->.CBAb, C->.c}.3
Mover(1,C)={|A->C.B, C->C.BAb|, B->.bCA, B->.BcA, B->.b,}......................4
Mover(1,b)={|B->b.CA, B->b.|, A->.Abc, A->.BA, A->.CB, B->.bCA, B->.BcA, B->.b, C->.ABCa, C->.CBAb, C->.c} .5
Mover(1,c)={C->c.} ..................................................................6

Mover(2,b)={|A->Ab.c, B->b.CA, B->b.|, A->.Abc, A->.BA, A->.CB, B->.bCA, B->.BcA, B->.b, C->.ABCa, C->.CBAb, C->.c}..7
Mover(2,B)={|C->AB.Ca, B->B.cA|, A->.Abc, A->.BA, A->.CB, B->.bCA, B->.BcA, B->.b, C->.ABCa, C->.CBAb, C->.c}..8


Mover(3,A)={|A->BA., A->A.bc, C->A.BCa|, B->.bCA, B->.BcA, B->.b}..........9
Mover(3,c)={|B->Bc.A, C->c.|, A->.Abc, A->.BA, A->.CB, B->.bCA, B->.BcA, B->.b, C->.ABCa, C->.CBAb, C->.c}..10
Mover(3,B)={|A->B.A, B->B.cA|}=3
Mover(3,C)={|A->C.B, C->C.BAb|}=4
Mover(3,b)={|B->b.CA, B->b.|}=5

Mover(4,B)={|A->CB., C->CB.Ab, B->B.cA|, A->.Abc, A->.BA, A->.CB, B->.bCA, B->.BcA, B->.b, C->.ABCa, C->.CBAb, C->.c}.11
Mover(4,b)={|B->b.CA, B->b.|}=5

Mover(5,C)={|B->bC.A, A->C.B, C->C.BAb|,A->.Abc, A->.BA, A->.CB, B->.bCA, B->.BcA, B->.b}.12
Mover(5,A)={|A->A.bc, C->A.BCa|,B->.bCA, B->.BcA, B->.b}.13
Mover(5,B)={|A->B.A, B->B.cA|}=3
Mover(5,b)={|B->b.CA, B->b.|}=5
Mover(5,c)={|C->c.|}=6

Mover(7,c)={|A->Abc., C->c.|}..14
Mover(7,C)={|B->bC.A, A->C.B, C->C.BAb|}=12
Mover(7,A)={|A->A.bc, C->A.BCa|}=13
Mover(7,B)={|A->B.A, B->B.cA|}=3
Mover(7,b)={|B->b.CA, B->b.|}=5

Mover(8,C)={|C->ABC.a, A->C.B, C->C.BAb|, B->.bCA, B->.BcA, B->.b}.......15
Mover(8,c)={|B->Bc.A, C->c.}=10
Mover(8,A)={|A->A.bc, C->A.BCa|}=13
Mover(8,B)={|A->B.A, B->B.cA|}=3
Mover(8,b)={|B->b.CA, B->b.|}=5

Mover(9,b)={|A->Ab.c, B->b.CA, B->b.|}=7
Mover(9,B)={|C->AB.Ca, B->B.cA|}=8

Mover(10,A)={|B->BcA., A->A.bc, C->A.BCa|, B->.bCA, B->.BcA, B->.b}.16
Mover(10,B)={|A->B.A, B->B.cA|}=3
Mover(10,C)={|A->C.B, C->C.BAb|}=4
Mover(10,b)={|B->b.CA, B->b.|}=5
Mover(10,c)={|C->c.|}=6

Mover(11,A)={|C->CBA.b, A->A.bc, C->A.BCa|, B->.bCA, B->.BcA, B->.b}.17
Mover(11,c)={|B->Bc.A, C->c.|}=10
Mover(11,B)=3
Mover(11,C)={|A->C.B, C->C.BAb|}=4
Mover(11,b)=5

Mover(12,A)={|B->bCA., A->A.bc|}.18
Mover(12,B)={|A->CB., C->CB.Ab, A->B.A, B->B.cA|}=11
Mover(12,b)=5

Mover(13,b)={|A->Ab.c, B->b.CA, B->b.|}=7
Mover(13,B)={|C->AB.Ca, B->B.cA|}=8

Mover(15,a)={|C->ABCa.|}..19
Mover(15,B)={|A->CB., C->CB.Ab, B->B.cA|}=11
Mover(15,b)={|B->b.CA, B->b.|}=5

Mover(10,A)={|B->BcA., A->A.bc, C->A.BCa|, B->.bCA, B->.BcA, B->.b}.16

Mover(16,b)={|A->Ab.c, B->b.CA, B->b.|}=7
Mover(16,B)={|C->AB.Ca, B->B.cA|}=8

Mover(17,b)={|C->CBAb., A->Ab.c, B->b.CA, B->b.|, A->.Abc, A->.BA, A->.CB, B->.bCA, B->.BcA, B->.b, C->.ABCa, C->.CBAb, C->.c}.20
Mover(17,B)={|C->AB.Ca, B->B.cA1}=8

Mover(18,b)={|A->Ab.c|}.21

Mover(20,c)={|A->Abc., C->c.|}=14
Mover(20,C)={|B->bC.A, A->C.B, C->C.BAb|}=12
Mover(20,A)={|A->A.bc, C->A.BCa|}=13
Mover(20,B)={|A->B.A, B->B.cA|}=3
Mover(20,b)={|B->b.CA, B->b.|}=5

Mover(21,c)={|A->Abc.|}.22

H->A

A->Abc                  S(A)={b,$,}
A->BA                       S(B)=S(C)=
A->CB
B->bCA
B->BcA
B->b
C->ABCa
C->CBAb
C->c


        a       b       c       $          A           B        C    
1               d5      d6                 2           3        4   
2               d7              acc                    8
3               d5      d10                9           3         4    
4               d5                                     11                    
5      r6     d5/r6   d6/r6     r6         13          3        12               
6      r9       r9      r9        
7      r6     d5/r6  d10/r6     r6         13          3        15                                                                                                                                               
8               d5      d10                13          3        15    
9      r2     d7/r2     r2      r2                     8     
10     r9     d5/r9   d6/r9                16          3        4           
11     r3     d5/r3   d10/r3    r3         17          3        4      
12              d5                         18          11  
13              d7                                     8 
14     r9       r9      r9                                                            
15    d19       d5                                     11
16     r5     d7/r5     r5      r5                     8 
17              d20                                    8     
18     r4     d21/r4      r4      r4                                                  
19     r7       r7      r7
20   r6/r8   r6/r8/d5 d14/r6/r8 r8         13          3        12 
21
22      r1      r1      r1      r1