question1 = {"10" : 'Right' , "20" : 'Wrong', "30" : "Wrong", "5" : "Wrong"}
question2 = {"A" : 'Wrong' , "B" : 'Right', "C" : 'Wrong', "D" : 'Wrong'}
question3 = {"fly" : 'Wrong' , "walk" : 'Wrong', "swim" : 'Right', "run" :'Wrong'}

questions = [question1, question2, question3]

index = 0

reward = 0

used = []

def get_help(index,used):
    choice = input("yes or no")
    if choice == "yes":
        help = str(input("50:50 or call?"))
        if help in used:
            print("Sorry you used that already")
        elif help == '50:50':
            dict50 = {**questions[index]}
            for key, value in questions[index].items():
                if value == 'Wrong' and len(dict50) > 2:
                    del dict50[key]
            print(dict50.keys())
            used.append(help)

        elif help == 'call':
            for key, value in questions[index].items():
                if value == "Wrong":
                    print(key, (1/4*100))
                else:
                    print(key, 3/4*100)
            used.append(help)

        else:
            print("please input either 50:50 or call")
    elif choice == 'no':
        pass
    else:
        print('please type yes or no')
        get_help(index, used)


def quest(index, reward):
    if index == 0:
        quest1(index, reward)
    elif index == 1:
        quest2(index, reward)
    elif index == 2:
        quest3(index, reward)

def quest1(index, reward):
    print('Question 1. What is the result of 5+5?')
    print(questions[index].keys())
    print("Do you want to get help?")
    get_help(index, used)
    answer = input("Answer here >>> ")
    if questions[index][answer] == 'Right':
        print("Next Question")
        index += 1
        reward += 1000
        print("You now have " + str(reward) + " dollars")
        print("Next Question")
        quest(index, reward)

    else:
        print("You lost")

def quest2(index, reward):
    print('Question 2. What is the second letter of the alphabet?')
    print(questions[index].keys())
    print("Do you want to get help?")
    get_help(index, used)
    answer = input("Answer here >>> ")
    if questions[index][answer] == 'Right':
        index += 1
        reward += 1000
        print("You now have " + str(reward) + " dollars")
        print("Next Question")
        quest(index, reward)
    else:
        print("You lost")

def quest3(index, reward):
    print('Question 3. What does a fish do?')
    print(questions[index].keys())
    print("Do you want to get help?")
    get_help(index, used)
    answer = input("Answer here >>> ")
    if questions[index][answer] == 'Right':
        index += 1
        reward += 1000
        print("You Won! You received a total of " + str(reward) + " dollars!")

    else:
        print("You lost")

print("Welcome to do you wanna get 3000 dollars!")
start = input("If you wish to start type yes, if you wish to quit type no >>")
if start == 'yes':
    quest(index, reward)
elif start == 'no':
    print('See you next time!')
else:
    print("please type yes or no")