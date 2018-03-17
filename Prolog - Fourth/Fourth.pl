%   Fourth.pl
%   Author : Gourav Siddhad

% Write a Prolog program to implement two predicates evenlength(List) and oddlength(List) so that they are true if their argument
% is a list of even or odd length respectively.
% evenlength and oddlength number of item in list evenlength(List)
listlength([], L):-
    L is 0.
listlength([_|T], L):-
    listlength(T, L1),
    L is L1+1.

oddlength(X):-
    length(X, L),
	L1 is L mod 2,
	L1 == 1.

evenlength(X):-
    length(X, L),
	L1 is L mod 2,
	L1 == 0.

% Write a Prolog program to implement reverse(List,ReversedList) that reverses lists.
% Reverse a list reverse(List, ReverseList)
concat([], List2, List2).
concat([H|T], List2, [H|L]):-
    concat(T, List2, L).

reverse([], []).
reverse([H|T], Rlist):-
    reverse(T, Rtemp),
    concat(Rtemp, [H], Rlist).

% Write a Prolog program to implement maxlist(List,Max) so that Max is the greatest number in the list of numbers using cut predicate.
% maxlist(List, Max) using cut predicate
max(X, Y, Max):-
    X>Y,!,
    Max is X.
max(X, Y, Max):-
    Max is Y.

maxlist([], Max):-
    Max is 0.
maxlist([H|T], Max):-
    maxlist(T, Max1),
    max(H, Max1, Max).

% Write a Prolog program to implement GCD of two numbers.
% GCD of two numbers
gcd(0,Y,Y):-
    !.
gcd(X,0,X):-
    !.
gcd(X,Y,G):-
    X1 is X mod Y,
	gcd(Y,X1,G).
