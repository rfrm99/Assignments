import csv

class Account:
    __balance = 0 #__ mean declared as private

    def __init__(self,balance): #init to declare the entire class as private
        self.__balance = balance

    def getBalance(self):
        return self.__balance

    def deposit(self,amt):
        if amt > 0:
            self.__balance += amt
            return self.__balance
        else:
            return False


    def withdraw(self,amt):
        if amt < self.__balance and amt > 0:
            self.__balance -= amt
            return self.__balance
        else:
            return False

class Customer:
    __firstname = ""
    __lastname = ""
    __account = Account(5000)

    def __init__(self, firstname, lastname):
        self.__firstname = firstname
        self.__lastname = lastname

    def getfirstname(self):
        return self.__firstname

    def getlastname(self):
        return self.__lastname

    def getAccount(self):
        return self.__account

    def setAccount(self, acct):
        self.__account = acct


class Bank:
    __bname = ""
    __numberofcustomers = 0
    __customers = []

    def __init__(self,bname):
        self.__bname = bname

    def addCustomer(self, firstname, lastname):
        self.__customers.append(Customer(firstname, lastname))
        self.__numberofcustomers += 1

    def getnumbofcustomers(self):
        return self.__numberofcustomers

    def getCustomer(self, index):
        return self.__customers[index]


def loadandsavefile(file, firstname, lastname, newvalue):
    with open(file, "r") as f:
        reader = csv.reader(f)
        fNameList = [row[0] for row in reader]
        f.seek(0)
        lastNameList = [row[1] for row in reader]
        f.seek(0)
        balanceList = [row[2] for row in reader]
        for i in range(len(fNameList)):
            if fNameList[i] == firstname and lastNameList[i] == lastname:
                balanceList[i] = newvalue
    with open(file, "w") as f:
            #writer = csv.writer(f)
        for j in range(len(fNameList)):
            f.writelines(f'{fNameList[j]},{lastNameList[j]},{balanceList[j]} \n')


def start():
    file = "bankfile.csv"
    firstname = input("firstname >> ")
    lastname = input("lastname >> ")
    print("Welcome to bank ABC")
    print("What do you want to do?\n A. Register\n B. Check Account\n C. Deposit\n D. Withdraw\n E. Exit" )
    choice = input("Enter either A - E to confirm your choice >> ")
    if choice.lower() == "a":
        with open(file) as f:
            reader = csv.reader(f)
            headerRow = next(reader)
            for row in reader:
                if firstname == row[0] and lastname == row[1]:
                    print("You are already registered")
                else:
                    Bank("ABC").addCustomer(firstname, lastname)
                    Bank("ABC").getCustomer(0).setAccount(5000)
            f.close()
        print("Thank you for registering")
        with open(file, "a") as f:
            #writer = csv.writer(f)
            answer = f'{Bank("ABC").getCustomer(0).getfirstname()},{Bank("ABC").getCustomer(0).getlastname()},{Bank("ABC").getCustomer(0).getAccount()}'
            f.writelines(f'{answer} \n')
    elif choice.lower() == "b":
            print(Customer(firstname,lastname).getAccount().getBalance())
    elif choice.lower() == "c":
        amt = int(input("Enter deposit amount: "))
        newvalue = (Customer(firstname,lastname).getAccount().deposit(amt))
        loadfile(file, firstname, lastname, newvalue)
    elif choice.lower() == "d":
        amt = int(input("Enter withdraw amount: "))
        newvalue = (Customer(firstname,lastname).getAccount().withdraw(amt))
        loadfile(file, firstname, lastname, newvalue)
    elif choice.lower() == "e":
        print("thank you for visiting ABC bank")
    else:
        print("Please input between A - E")

start()
