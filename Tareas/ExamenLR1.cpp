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

                        P(A$)=P(A)={b,c}         P(B$)=P(B)={b}
                                P(B)={b}                
                                P(C)={c}  

Cerradura H={|H->.A ,$|, (A->.Abc,$), (A->.BA,$), (A->.CB,$), 
        (B->.bCA,b/c), (B->.BcA,b/c), (B->.b,b/c), (C->.ABCa,b), (C->.CBAb,b), (C->.c,b)} .....1

                                                    P(Cab)=P(C)={c,b}
Mover(1,A)={|(H->A.,$), (A->A.bc,$), (C->A.BCa,b)|, (B->.bCA,b/c), (B->.BcA,b/c), (B->.b,b/c)}...2

                                        P($)=$        P(A$)=P(A)={b,c}      P(B$)=P(B)={b}
Mover(1,B)={|(A->B.A,$), (B->B.cA,b/c)|, (A->.Abc,$), (A->.BA,$), (A->.CB,$), (B->.bCA,b/c), (B->.BcA,b/c), B->.b,b/c), (C->.ABCa,b), (C->.CBAb,b), (C->.c,b)}.3


Mover(1,C)={|(A->C.B,$), (C->C.BAb,b)|, (B->.bCA,$), (B->.BcA,$), (B->.b,$)}......................4

                                        P(A,b/c)            P(BCa,b/c)              P(Bb)
                                            P(A)={b,c}          P(B)={b}                P(B)
Mover(1,b)={|(B->b.CA,b/c), (B->b.,b/c)|, (C->.ABCa,b/c), (C->.CBAb,b/c), (C->.c,b/c),(A->.BA,b), (A->.CB,b), (B->.bCA,b), (B->.BcA,b), (B->.b,b)} .5

Mover(1,c)={C->c.,b} ..................................................................6

Mover(2,b)={|A->Ab.c, B->b.CA, B->b.|, A->.Abc, A->.BA, A->.CB, B->.bCA, B->.BcA, B->.b, C->.ABCa, C->.CBAb, C->.c}..7
Mover(2,B)={|C->AB.Ca, B->B.cA|, A->.Abc, A->.BA, A->.CB, B->.bCA, B->.BcA, B->.b, C->.ABCa, C->.CBAb, C->.c}..8


Mover(3,A)={|A->BA., A->A.bc, C->A.BCa|, B->.bCA, B->.BcA, B->.b}..........9
Mover(3,c)={|B->Bc.A, C->c.|, A->.Abc, A->.BA, A->.CB, B->.bCA, B->.BcA, B->.b, C->.ABCa, C->.CBAb, C->.c}..10
Mover(3,B)={|A->B.A, B->B.cA|}=3
Mover(3,C)={|A->C.B, C->C.BAb|}=4
Mover(3,b)={|B->b.CA, B->b.|}=5

Mover(4,B)={|A->CB., C->CB.Ab, B->B.cA|, A->.Abc, A->.BA, A->.CB, B->.bCA, B->.BcA, B->.b, C->.ABCa, C->.CBAb, C->.c}.11
Mover(4,b)={|B->b.CA, B->b.|}=5

Mover(5,C)={|B->bC.A, A->C.B, C->C.BAb|,B->.bCA, B->.BcA, B->.b}.12
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

Mover(12,A)={|B->bCA.|}.18
Mover(12,B)={|A->CB., C->CB.Ab, B->B.cA|}=11
Mover(12,b)=5

Mover(13,b)={|A->Ab.c, B->b.CA, B->b.|}=7
Mover(13,B)={|C->AB.Ca, B->B.cA|}=8

Mover(15,a)={|C->ABCa.|}..19
Mover(15,B)={|A->CB., C->CB.Ab, B->B.cA|}=11
Mover(15,b)={|B->b.CA, B->b.|}=5

Mover(10,A)={|B->BcA., A->A.bc, C->A.BCa|, B->.bCA, B->.BcA, B->.b}.16

Mover(16,b)={|A->Ab.c, B->b.CA, B->b.|}=7
Mover(16,B)={|C->AB.Ca, B->B.cA|}=8

Mover(11,A)={|C->CBA.b, A->A.bc, C->A.BCa|, B->.bCA, B->.BcA, B->.b}.17
Mover(17,b)={|C->CBAb., A->Ab.c, B->b.CA,  B->b.|, A->.Abc, A->.BA, A->.CB, B->.bCA, B->.BcA, B->.b, C->.ABCa, C->.CBAb, C->.c}.18


