import csv

file = 'subjects.csv'
file2 = 'database.csv'


class Subject:
    __subjectname = ''
    __notelist = ''

    def __init__(self, subjectname):
        self.__subjectname = subjectname

    def addNote(self, note):
        self.__notelist = note
        return self.__notelist

    def clearNote(self):
        self.__notelist = ''
        return self.__notelist

    def getsubjectname(self):
        return self.__subjectname

    def getNote(self, classname, subjectname):
        with open(file2, "r") as f:
            reader = csv.reader(f)
            Classes = [row[0] for row in reader]
            f.seek(0)
            Subjects = [row[1] for row in reader]  # This part of the function gathers data from the csv file
            f.seek(0)
            Notes = [row[2] for row in reader]
            for i in range(len(Classes)):
                if Classes[i] == classname and Subjects[i] == subjectname:
                    self.__notelist = Notes[i]
        return self.__notelist


class Class:
    __classname = ''
    __listofsubjects = []
    with open(file, 'r') as f:
        reader = csv.reader(
            f)  # This part of the class gathers data from the csv file and appends it to __listofsubjects
        for row in reader:
            __listofsubjects.append(row[0])

    def __init__(self, classname):
        self.__classname = classname

    def callSubject(self, subjectname):
        return Subject(subjectname)

    def addsubject(self, subjectname):
        if subjectname.capitalize() in self.__listofsubjects:
            print("Subject already registered")
        else:
            self.__listofsubjects.append(subjectname.capitalize())

    def viewsubject(self):
        return self.__listofsubjects

    def getclassname(self):
        return self.__classname


class School:
    __schoolname = ""
    __classlist = ["CS1", "CS2", "FMFD1"]

    def __init__(self, schoolname):
        __schoolname = schoolname

    def addclass(self):
        classname = input("Enter new classname >> ")
        if classname.upper() in self.__classlist:
            print("Class already registered")
        else:
            self.__classlist.append(classname.upper())

    def viewclass(self):
        return self.__classlist

    def callClass(self, classname):
        return Class(classname)


def loadfile(file2, classname, subjectname, note):
    with open(file2, "r") as f:
        reader = csv.reader(f)
        Classes = [row[0] for row in reader]
        f.seek(0)
        Subjects = [row[1] for row in reader]  # This part is to get existing data from the csv file
        f.seek(0)
        Notes = [row[2] for row in reader]
        for i in range(len(Classes)):
            if Classes[i] == classname and Subjects[i] == subjectname:
                Notes[i] = note
    with open(file2, "w") as f:
        for j in range(len(Classes)):  # This part rewrites what was read previously and adds any changes made.
            f.writelines(f'{Classes[j]},{Subjects[j]},{Notes[j]} \n')


def options():
    option = input("Yes or No >> ")
    if option.lower() == "yes":
        return True
    elif option.lower() == "no":
        return False
    else:
        print("Please enter either yes or no")
        return options()


def identity(firstname, classname):
    teacher = {"CS1": ["Jude"], "CS2": ["Stavin"]}  # This is the list of teachers that are in the school's database
    student = {"CS1": ["Rowin", "Jeco", "Sunny"],
               "CS2": ["Eric", "Calvin", "Arell"],  # This is the list of students that are in the school's database
               "FMFD1": ["Phoebe"]}
    jobname = input("Are you a Student or a Teacher >> ")
    if jobname.lower() == "teacher":
        job = teacher
    elif jobname.lower() == "student":
        job = student
    for key in job.keys():
        if classname == key and firstname in job[key]:
            print("Welcome to the forum fellow " + jobname.lower())
            return jobname.lower()
    else:
        print("Sorry you're not registered in this school")
        start()


def student(schoolname, classname):
    choice = input("Choose between A or B >> ")  # This input will lead to the conditions below
    if choice.lower() == 'a':
        print(School(schoolname).callClass(classname).viewsubject()) #displays all subjects
    elif choice.lower() == 'b':
        print(School(schoolname).callClass(classname).viewsubject())
        subjectname = input("What is the name of the Subject you want to look into? ").capitalize()
        print(School(schoolname).callClass(classname).callSubject(subjectname).getNote(classname, subjectname)) #displays note of chosen subject
    else:
        print("Please input between A or B")
        student(schoolname, classname)


def teacher(schoolname, classname):
    choice = input("Choose between A - G >> ")  # This input will lead to the conditions below
    if choice.lower() == 'a':
        print(School(schoolname).callClass(classname).viewsubject()) #Shows available subjects
    elif choice.lower() == 'b':
        print(School(schoolname).callClass(classname).viewsubject())
        subjectname = input("What is the name of the Subject you want to look into? ").capitalize() #input for subjectname
        if not subjectname in School(schoolname).callClass(classname).viewsubject(): #condition for subjectname
            print('Subject Name Unavailable')
        else:
            print(School(schoolname).callClass(classname).callSubject(subjectname).getNote(classname, subjectname)) #Views the notes of the subject chosen
    elif choice.lower() == 'c':
        School(schoolname).addclass() #adds a class to the classlist
    elif choice.lower() == 'd':
        subjectname = input("Please enter the subject you want to add >> ").capitalize()
        if not subjectname in School(schoolname).callClass(classname).viewsubject():
            print('Subject Name Unavailable')
        else:
            School(schoolname).callClass(classname).addsubject(subjectname) #adds a new subject
            with open(file, 'w') as f:
                for subject in School(schoolname).callClass(classname).viewsubject():
                    f.write(subject)
                    f.write("\n")
    elif choice.lower() == 'e':
        print(School(schoolname).callClass(classname).viewsubject())
        subjectname = input("What is the name of the Subject you want to add note? ").capitalize()
        if not subjectname in School(schoolname).callClass(classname).viewsubject():
            print('Subject Name Unavailable')
        else:
            note = input("Enter your note here >> ") #input for note
            School(schoolname).callClass(classname).callSubject(subjectname).addNote(note) #adds the note to the chosen subject
            loadfile(file2, classname, subjectname, note) #rewrites the database with the added note
    elif choice.lower() == "f":
        print(School(schoolname).callClass(classname).viewsubject())
        subjectname = input("What is the name of the Subject you want to clear? ").capitalize()
        if not subjectname in School(schoolname).callClass(classname).viewsubject():
            print('Subject Name Unavailable')
        else:
            note = School(schoolname).callClass(classname).callSubject(subjectname).clearNote()  #clears the note of chosen subject
            loadfile(file2, classname, subjectname, note)
    elif choice.lower() == 'g':
        subjectname = input("Enter the subject name you want to input to database >> ").capitalize()
        addtodatabase(classname, schoolname, subjectname) #adds new info to database
    else:
        print("Please input A-F")


def addtodatabase(classname, schoolname, subjectname):  # Adds to database.csv in the specified format below
    with open(file2) as f:
        reader = csv.reader(f)
        for row in reader:
            if classname == row[0] and subjectname == row[1]:
                return print("Class and subject are already registered")
        with open(file2, "a") as f:
            newline = f'{classname},' \
                        f'{School(schoolname).callClass(classname).callSubject(subjectname).getsubjectname()},' \
                        f'{School(schoolname).callClass(classname).callSubject(subjectname).getNote(classname, subjectname)} '
            f.writelines(f'{newline} \n')


def start():
    schoolname = "School of Underachievers"  # School Name set here
    print("Welcome to " + schoolname)
    firstname = input("Enter your 1st name >> ").capitalize()  # Input firstname to as part of login process
    print(School(schoolname).viewclass())  # Prints out all the classes that are in the database
    classname = input("Enter your class name >> ").upper() #Inputs the classname
    if not classname in School(schoolname).viewclass(): #Classname condition
        print('Class Unavailable')
        start()
    else:
        jobname = identity(firstname, classname)
        print("Do you want to use the forum?")
        while options(): #While loop to loop the forum so that the user can choose to use or not to use.
            if jobname == "student": #job condition to choose between teacher features or student features
                print("What do you want to do today?\n A. View Subjects\n B. View Subject Notes")
                student(schoolname, classname)
            elif jobname == "teacher":
                print("What do you want to do today?\n A. View Subjects\n B. View Subject Notes\n C. Add "
                      "New Class\n D. Add New Subject\n E. Add Subject Notes\n F. Clear Subject Notes\n G. Add to "
                      "database")
                teacher(schoolname, classname)
            print("Do you want to use the forum again?")


start()
