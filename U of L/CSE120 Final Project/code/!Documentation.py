'''

Rock Paper Scissors
Made by Thomas Herm Jr
Started on 2/10/2025

File list:

!documentation.py - contains all documentation for project
SEC.py - Contains error handling code
game_flow.py - contains all gameflow functions
main.py - runs the program

Function list:

in game_flow.py:

start() - Entry point for the program - the only function found in main.py
restart() - handles restarting and exiting the program
flow(current_round, rounds_wanted, player_points, cpu_points) - facilitates player RPS choice, and tests for game end
game_round(player_answer, player_points, cpu_points, current_round, rounds_wanted) - generates computer choice, and
                                                                                     compares results
victory(player_points, cpu_points, current_round, rounds_wanted) - declares player win, adds 1 to player points and
                                                                   current round
draw(player_points, cpu_points, current_round, rounds_wanted) - declares draw - restarts (does not add to) round
defeat(player_points, cpu_points, current_round, rounds_wanted) - declares cpu victory - adds 1 to cpu points and
                                                                  current round
final(player_points, cpu_points, current_round, rounds_wanted) - called when final round finishes - displays score -
                                                                  declares victor - tests for tie - offers tie-breaker

in SEC.py:

invalidInput() - prints message when invalid input is found
generationError() - prints message when computer response generation out of range
unknownError() - prints message when an unknown error occurs

Problems faced:

Interdependency -- there used to be more files for better organization, but python doesn't allow #pragma once guards,
                   and forward declarations seemed a bit more involved than C / C++, so I put everything that needed
                   access to each other in one file, which in this case was either directly or indirectly everything.

Exception type -- While validation loops can handle valid input values, but the start function needs a type that can be
                  cast to an integer, so this needed a try / except block. I had difficulty with it at first, because
                  I had thought that I needed except TypeError, but that didn't work. After reviewing the code, I
                  realized the typing of the input is a string - which is correct - but the value needs to be something
                  that can be cast to an integer, so I tried ValueError - that did work.

'''
