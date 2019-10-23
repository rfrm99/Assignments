file = 'data.txt'

def displaystaff(file):
    words = []
    with open(file,'r') as f:
        for line in f:
            line_new = '{:<10}{:<10}{:<10}{:<10}'.format("|" + line.split("#")[0],"|" + line.split("#")[1],"|" + line.split("#")[2],"|" + line.split("#")[3].strip('\n'))
            print(line_new)

class Company:
    __companyname = ''
    __name = ''
    __id = ''
    __position = ''
    __salary = ''

    def __init__(self, companyname):
        self.__companyname = companyname

    def addstaff(self, name, id, position, salary):
        if len(name) >= 20:
            self.__name = name
        else:
            print("Name not valid")
        if len(id) <= 5 and id[0] == 'S' and id[1:6] in '0123456789':
            self.__id = id
        else:
            print("ID Not Possible")
            pass
        if position == 'Staff' or position == 'Manager' or position == 'Officer':
            self.__position = position
        else:
            print("Position not available")
            pass
        if position == 'Staff' and int(salary('\n')) >= 3500000 and int(salary('\n')) <= 7000000:
            self.__salary = salary
        elif position == 'Manager' and int(salary.split('\n')) > 7000000 and int(salary('\n')) <= 10000000:
            self.__salary = salary
        elif position == 'Officer' and int(salary.strip('\n')) > 10000000:
            self.__salary = salary
        else:
            print("Salary not in bounds")
            pass
        if self.__salary != '' and self.__name != '' and self.__position != '' and self.__id != '':
            return (f'{self.__id}#{self.__name}#{self.__position}#{self.__salary}')
        else:
            pass

    def deletestaff(self, id):
        self.__id = id
        with open(file, 'r') as f:
            lines = f.readlines()
        with open(file, "w") as f:
            for line in lines:
                if self.__id not in line.split("#"):
                    f.write(line)

    def minmaxavg(self):
        self.__id = id
        staffsalarylist = []
        managersalarylist = []
        officersalarylist = []
        staffaverage = 0
        manageraverage = 0
        officeraverage = 0
        with open(file, 'r') as f:
            lines = f.readlines()
            for line in lines:
                if line.split("#")[2] == 'Staff':
                    staffsalarylist.append(str(line.split("#")[3]).strip("\n"))
                elif line.split("#")[2] == 'Manager':
                    managersalarylist.append(str(line.split("#")[3]).strip("\n"))
                elif line.split("#")[2] == 'Officer':
                    officersalarylist.append(str(line.split("#")[3]).strip("\n"))
            for number in staffsalarylist:
                staffaverage += int(number)/len(staffsalarylist)
            for number in managersalarylist:
                manageraverage += int(number)/len(managersalarylist)
            for number in officersalarylist:
                officeraverage += int(number)/len(officersalarylist)

            print("1. Staff")
            print("Minimum Salary " + min(staffsalarylist))
            print("Maximum Salary " + max(staffsalarylist))
            print("Average Salary " + str(int(staffaverage)))
            print("2. Manager")
            print("Minimum Salary " + min(managersalarylist))
            print("Maximum Salary " + max(managersalarylist))
            print("Average Salary " + str(int(manageraverage)))
            print("3. Officer")
            print("Minimum Salary " + min(officersalarylist))
            print("Maximum Salary " + max(officersalarylist))
            print("Average Salary " + str(int(officeraverage)))

def loadfile(file, companyname):
    name = input("Enter new staff name")
    id = input("Enter new staff id")
    position = input("Enter new staff position")
    salary = input("Enter new staff salary")
    with open(file) as f:
        for line in f:
            if id == line[0]:
                print("ID already registered")
            else:
                 return Company(companyname).addstaff(name, id, position, salary)

def savefile(file, newline):
    with open(file, "a") as f:
        f.writelines(newline + "\n")

def options(file, companyname):
    choice = input("Choose an option either 1 - 4 >> ")
    if choice == "1":
        newline = loadfile(file, companyname)
        if type(newline) == type(None):
            print("Your inputs dont match the requirements please re-input")
            options(file, companyname)
        else:
            savefile(file, newline)

    elif choice == '2':
        id = input("Enter the ID of the person to delete")
        Company(companyname).deletestaff(id)

    elif choice == '3':
        Company(companyname).minmaxavg()

    elif choice == '4':
        quit()

def yesorno():
    option = input("Yes or No >> ")
    if option.lower() == "yes":
        return True
    elif option.lower() == "no":
        return False
    else:
        print("Please enter either yes or no")
        yesorno()

def main():
    companyname = "Doofensmirtz Evil Incorporated"
    print("Welcome to " +companyname+ "do you want to manage staff salary data?")
    while yesorno():
        displaystaff(file)
        print("1. New Staff\n2. Delete Staff\n3. View Summary Data\n4. Save and Exit")
        options(file, companyname)
        print("Do you want to reuse it?")

main()










