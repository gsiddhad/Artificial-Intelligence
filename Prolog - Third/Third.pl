%   Third.pl
%   Author : Gourav Siddhad

% Write a Prolog program to implement palindrome(List).
% Palindrome list
concat([], List2, List2).
concat([H|T], List2, [H|L]):-
    concat(T, List2, L).

reverse([], []).
reverse([H|T], Rlist):-
    reverse(T, Rtemp),
    concat(Rtemp, [H], Rlist).

palindrome1(X, X).
palindrome(X):-
    reverse(X, Revx),
    palindrome1(X, Revx).

% Write a Prolog program to implement max(X,Y,Max) so that Max is the greater of two numbers X and Y.
% Max is greater from X and Y max(X,Y,Max)
max(X, Y, Max):-
    X>Y,!,
    Max is X.
max(X, Y, Max):-
    Max is Y.

% Write a Prolog program to implement maxlist(List,Max) so that Max is the greatest number in the list of numbers List.
% Max is greatest in list maxlist(List, Max)
maxlist([], Max):-
    Max is 0.
maxlist([H|T], Max):-
    maxlist(T, Max1),
    max(H, Max1, Max).

% Write a Prolog program to implement sumlist(List,Sum) so that Sum is the sum of a given list of numbers List.
% Sum is sum of list sumlist(List, Sum)
sumlist([], S):-
    S is 0.
sumlist([H|T], S):-
    sumlist(T, S0),
    S is H+S0.
