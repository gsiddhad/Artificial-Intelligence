%   First.pl
%   Author : Gourav Siddhad

% Write a prolog program to calculate the sum of two numbers.
% Sum of two numbers
sum2num:-
    write(' Enter First Number : '),
    read(X),
    write(' Enter Second Number : '),
    read(Y),
    sum(X, Y).

sum(X, Y):-
    Z is X+Y,
    write(' Sum is : '),
    write(Z).

% Write a prolog program to find the maximum of two numbers.
% Maximum of two numbers
max2num:-
    write(' Enter First Number : '),
    read(X),
    write(' Enter Second Number : '),
    read(Y),
    max(X, Y).
max(X, Y):-
    X>Y,!,
    write(X),
    write(' is greater than '),
    write(Y).
max(X, Y):-
    write(Y),
    write(' is greater than '),
    write(X).

% Write a prolog program to calculate the factorial of a given number.
% Factorial of a number
factorial:-
    write(' Enter Number : '),
    read(X),
    Y is 1,
    fact(X, Y).
fact(0, Y):-
    write(' Factorial is : '),
    write(Y).
fact(X, Y):-
    X1 is X-1,
    Y1 is Y*X,
    fact(X1, Y1).

% Write a prolog program to calculate the nth Fibonacci number.
% Fibonacci to nth number
fibonacci:-
    write(' Enter Number to Calculate Fibonacci : '),
    read(X),
    fibo(X, Y),
    write(X),
    write('th Number in Fibonacci Series is '),
    write(Y).
fibo(0, 0).
fibo(1, 1).
fibo(X, Y):-
    X>1,
    A is X-1,
    B is X-2,
    fibo(A, AF),
    fibo(B, BF),
    Y is AF+BF.
