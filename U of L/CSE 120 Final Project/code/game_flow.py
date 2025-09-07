import random
import sys

from SEC import invalidInput, generationError, unknownError


def game_round(player_answer, player_points: int = 0, cpu_points: int = 0, current_round: int = 1,  rounds_wanted: int = 1): #Start function


    isValid = False # verification bool

    while not isValid: # start verification loop

        generator = random.randint(1, 3) # generate computer answer

        match generator: # evaluate computer answer

            case 1: # on rock
                isValid = True
                cpu_answer = "rock"
            case 2: #on paper
                isValid = True
                cpu_answer = "paper"
            case 3: # on scissors
                isValid = True
                cpu_answer = "scissors"
            case _: # on generation out of range
                cpu_answer = ""
                generationError()

        # end verification loop

    print(f"You said \"{player_answer}\", the computer said \"{cpu_answer}\"") # show responses

    match cpu_answer: # evaluate response comparisons

        case "rock": # on cpu answer rock
            match player_answer:
                case "rock": # Rock vs Rock
                    draw(player_points, cpu_points, current_round, rounds_wanted)
                case "paper": # Paper vs Rock
                    victory(player_points, cpu_points, current_round, rounds_wanted)
                case "scissors": # Scissors vs Rock
                    defeat(player_points, cpu_points, current_round, rounds_wanted)

        case "paper": #on cpu answer paper
            match player_answer:
                case "rock": # Rock vs Paper
                    defeat(player_points, cpu_points, current_round, rounds_wanted)
                case "paper": # Paper vs Paper
                    draw(player_points, cpu_points, current_round, rounds_wanted)
                case "scissors": # Scissors vs Paper
                    victory(player_points, cpu_points, current_round, rounds_wanted)

        case "scissors": # on cpu answer scissors
            match player_answer:
                case "rock": # Rock vs Scissors
                    victory(player_points, cpu_points, current_round, rounds_wanted)
                case "paper": # Paper vs Scissors
                    defeat(player_points, cpu_points, current_round, rounds_wanted)
                case "scissors": # Scissors vs Scissors
                    draw(player_points, cpu_points, current_round, rounds_wanted)

        case _: # On gen error - verification escape
            generationError()


def flow(current_round, rounds_wanted, player_points: int = 0, cpu_points: int = 0): # start function

    isValid = False

    if current_round <= rounds_wanted: # on game continue
        while not isValid: # start verification loop // comment added on github - 5 / 6

            player_answer = input("ROCK - PAPER - SCISSORS! What do you choose? ").casefold()

            match player_answer:
                    case "rock" | "paper" | "scissors":
                        isValid = True
                        game_round(player_answer, player_points, cpu_points, current_round, rounds_wanted)
                    case _:
                        invalidInput()
                        
                # end match case // comment added on github - 5 / 6
            
            # end verification loop // comment added on github - 5 / 6
        
    
    else: # on game over
        final(player_points, cpu_points, current_round, rounds_wanted)

    # end if // comment added on github - 5 / 6
    
# end function // comment added on github - 5 / 6


def start(): # start function

    isValid = False # verification bool

    current_round = 1

    while not isValid:  # start verification loop

        try: # on proper integer input

            user_input = input("Welcome to Rock Paper Scissors! How many rounds would you like to play? ")
            rounds_wanted = int(user_input)
            if rounds_wanted <= 0: # on integer 0 or less
                invalidInput()
            else: # on integer 1 or more
                isValid = True

        except ValueError: # on non integer input
            invalidInput()

        except: # on unknown failure
            unknownError()

    # end verification loop

    flow(current_round, rounds_wanted)
    #end function


def restart(): # stat function // comment added on github - 5 / 6

    isValid = False

    while not isValid: # start verification loop // comment added on github - 5 / 6
        player_restart = input("Do you want to play again?  ").casefold()

        match player_restart:

            case "yes":
                isValid = True
                print("restarting...")
                start()

            case "no":
                isValid = True
                print("Now closing. Have a great day!")
                sys.exit()

            case _:
                invalidInput()
                
            # end match case // comment added on github - 5 / 6

    # end verification loop // comment added on github - 5 / 6

# end function // comment added on github - 5 / 6


def final(player_points, cpu_points, current_round, rounds_wanted):  #current round required for tie
    print(f"The score is {player_points} to {cpu_points}")
    if player_points > cpu_points: # on player win // comment added on github - 5 / 6
        print("The player wins!")
    elif player_points == cpu_points: # on tie // comment added on github - 5 / 6
        tie_response = (input("It's a draw; do you want to go for a tie breaker?  ").casefold())

        match tie_response:

            case "yes":
                current_round -= 1
                flow(current_round, rounds_wanted, player_points, cpu_points)

            case "no":
                print("We'll leave it as a draw")

            case _:
                invalidInput()
                final(player_points, cpu_points, current_round, rounds_wanted) # proper verification loops added later - may update on github on a later date // comment added on github - 5 / 6

            # end match case // comment added on github - 5 / 6

    else: # on computer win // comment added on github - 5 / 6
        
        print("The computer wins!")

    # end if // comment added on github - 5 / 6
    
    restart()
    
# end function // comment added on github - 5 / 6


def victory(player_points, cpu_points, current_round, rounds_wanted): # start function // comment added on github - 5 / 6
    print("You Won this round!")
    player_points += 1
    current_round += 1
    flow(current_round, rounds_wanted, player_points, cpu_points)

# end function // comment added on github - 5 / 6


def defeat(player_points, cpu_points, current_round, rounds_wanted): # start function // comment added on github - 5 / 6
    print("You lost this round")
    cpu_points += 1
    current_round += 1
    flow(current_round, rounds_wanted, player_points, cpu_points)

# end function // comment added on github - 5 / 6


def draw(player_points, cpu_points, current_round, rounds_wanted): # start function // comment added on github - 5 / 6
    print("It's a draw; the round will restart.")
    flow(current_round, rounds_wanted, player_points, cpu_points)

# end function // comment added on github - 5 / 6
