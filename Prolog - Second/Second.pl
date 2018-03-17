%   Second.pl
%   Author : Gourav Siddhad

% Write a prolog program, insert_nth(item, n, into_list, result) that asserts that result is the list into_list with 
% item inserted as the n’th element into every list at all levels.
% Insert item at nth position in list
concat([], List2, List2).
concat([H|T], List2, [H|L]):-
    concat(T, List2, L).

insert_nth(Item, 0, Into_list, Result):-
    concat([Item], Into_list, Result).
insert_nth(Item, N, [H|T], [H|Rep]):-
    P is N-1,
    insert_nth(Item, P, T, Rep).

% Write a Prolog program to remove the Nth item from a list.
% Remove nth item from list
remove_nth(0, [_|T], T).
remove_nth(N, [H|T], [H|Rep]):-
    P is N-1,
    remove_nth(P, T, Rep).

% Write a Prolog program, remove-nth(Before, After) that asserts the After list is the Before list with the removal of 
% every n’th item from every list at all levels.
% Remove nth item from (before, after)
remove_nth_ba(Before, N, After):-
    N > 0,
    remove_nth_ba(Before, N, N, After).

remove_nth_ba([], _, _, []).
remove_nth_ba([_|T], 1, N, After):-
    remove_nth_ba(T, N, N, After).
remove_nth_ba([H|T], P, N, [H|After]):-
    Pn is P-1,
    remove_nth_ba(T, Pn, N, After).

% Write a Prolog program to implement append for two lists.
% Append two lists
append([], List2, List2).
append([H|T], List2, [H|L]):-
    append(T, List2, L).
