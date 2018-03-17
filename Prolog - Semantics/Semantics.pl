%   Semantics.pl
%   Author : Gourav Siddhad

% Facts
parent(chetna, ishika).
parent(chetna, chintu).
parent(chetna, mahesh).
parent(ishika, raj).
parent(ishika, krishna).
parent(chintu, sunita).
parent(chintu, sharaj).
parent(chintu, charlie).
parent(mahesh, mary).
parent(krishna, nora).
parent(krishna, elizabeth).

female(chetna).
male(mahesh).
female(ishika).
female(sunita).
male(chintu).
male(sharaj).
male(raj).
female(mary).
male(krishna).
male(charlie).
female(nora).
female(elizabeth).

% Rules
father(X, Y):-
    parent(X, Y),
    male(X).
mother(X, Y):-
    parent(X, Y),
    female(Y).
grandparent(X, Y):-
    parent(X, Z),
    parent(Z, Y).
paternalgrandfather(X,Y):-
    father(X, Z),
    father(Z, Y).
sibling(X, Y):-
    parent(Z, X),
    parent(Z, Y).

closeRelative(X, Y):-
    parent(X, Y).
closeRelative(X, Y):-
    parent(Y, X).
closeRelative(X, Y):-
    sibling(X, Y).

ancestor(X, Y):-
    parent(X, Y).
ancestor(X, Y):-
    parent(X, Z),
    ancestor(Z, Y).
