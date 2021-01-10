# Module Imports
import os
from sys import *
import tkinter as tk
import subprocess as sub
import time

# Global variable initialization
numstack =[]
symbols = {}

# Function to open the file
def openFile(filename):
    data = open(filename,"r").read()
    data += "%EOF%"
    return data

#lexer function that groups the tokens together in a list.
def lex(filecontents):
    tokens = []
    tok = ""
    state=0
    isexpr = 0
    varstarted = 0
    var = ""
    string=""
    expr = ""
    n = ""
    filecontents = list(filecontents)
    for char in filecontents:
        tok += char
        if tok == " ":
            if varstarted == 1:
                tokens.append("VAR:" + var)
                var = ""
                varstarted = 0
            if state == 0:
                tok = ""
            else:
                tok = " "
        elif tok == "\n" or tok == "%EOF%":
            if expr != "" and isexpr == 1:
                tokens.append("EXPR:" + expr)
                expr = ""
                isexpr = 0
            elif expr != "" and isexpr == 0:
                tokens.append("NUM:" + expr)
                expr = ""
            elif var != "":
                tokens.append("VAR:"+var)
                var = ""
                varstarted = 0
            tok = ""
        elif tok == "=" and state == 0:
            if  expr != "" and isexpr == 0:
                tokens.append("NUM:" + expr)
                expr = ""
            if var != "":
                tokens.append("VAR:" + var)
                var = ""
                varstarted = 0
            if tokens[-1] == "EQUALS":
                tokens[-1] = "EQUALS2"
            elif tokens[-1] == "SMALLER":
                tokens[-1] = "SMALLEQ"
            elif tokens[-1] == "BIGGER":
                tokens[-1] = "BIGEQ"
            else:
                tokens.append("EQUALS")
            tok = ""
        elif tok == "<" and state == 0:
            if  expr != "" and isexpr == 0:
                tokens.append("NUM:" + expr)
                expr = ""
            if var != "":
                tokens.append("VAR:" + var)
                var = ""
                varstarted = 0
            else:
                tokens.append("SMALLER")
            tok = ""
        elif tok == ">" and state == 0:
            if  expr != "" and isexpr == 0:
                tokens.append("NUM:" + expr)
                expr = ""
            if var != "":
                tokens.append("VAR:" + var)
                var = ""
                varstarted = 0
            else:
                tokens.append("BIGGER")
            tok = ""
        elif tok == "$" and state == 0:
            varstarted = 1
            var += tok
            tok = ""
        elif varstarted == 1:
            if tok == "<" or tok == ">":
                if var != "":
                    tokens.append("VAR:" + var)
                    var = ""
                    varstarted = 0
            var += tok
            tok = ""
        elif tok == "prt":
            tokens.append("prt")
            tok = ""
        elif tok == "do":
            if expr != "" and isexpr == 1:
                tokens.append("EXPR:" + expr)
                expr = ""
                isexpr = 0
            elif expr != "" and isexpr == 0:
                tokens.append("NUM:" + expr)
                expr = ""
            elif var != "":
                tokens.append("VAR:" + var)
                var = ""
                varstarted = 0
            tokens.append("DO")
            tok = ""
        elif tok == "for":
            tokens.append("FOR")
            tok = ""
        elif tok == "while":
            tokens.append("WHILE")
            tok = ""
        elif tok == "if":
            tokens.append("IF")
            tok = ""
        elif tok == "elif":
            tokens.append("ELIF")
            tok = ""
        elif tok == "else":
            tokens.append("ELSE")
            tok = ""
        elif tok == "fin":
            tokens.append("FIN")
            tok = ""
        elif tok == "in":
            tokens.append("in")
            tok = ""
        elif tok == "0" or tok == "1" or tok == "2" or tok == "3" or tok == "4" or tok == "5" or tok == "6" or tok == "7" or tok == "8" or tok == "9":
            expr += tok
            tok = ""
        elif tok == "+" or tok == "-" or tok == "*" or tok == "/" or tok == "^" or tok == "(" or tok == ")":
            isexpr = 1
            expr += tok
            tok = ""
        elif tok == "\t":
            tok = ""
        elif tok =="\"" or tok == " \"":
            if state == 0:
                state = 1
            elif state == 1:
                tokens.append("STRING:" + string + "\"")
                string = ""
                state = 0
                tok = ""
        elif state == 1:
            string += tok
            tok = ""
    # print(tokens)
    return tokens

# Displays final output 
def ericPrint(content):
    if content[0:6] == "STRING":
        content = content[8:]
        content = content[:-1]
    elif content[0:3] == "NUM":
        content = content[4:]
    elif content[0:4] == "EXPR":
        content = evaluate(content[5:])
    print(content)

# Evaluates expressions for arithmetics
def evaluate(expression):
    return eval(expression)

# Assigns data to variables
def assign(varname, varvalue):
    symbols[varname[4:]] = varvalue

# Variable getter
def getVariable(varname):
    varname = varname[4:]
    if varname in symbols:
        return symbols[varname]
    else:
        return("Undefined")

# Get input for 
def getInput(string, varname):
    i = input(string)
    symbols[varname] = "STRING:\"" + i + "\""

# Token parser
def parse(toks):
    iftokens = []
    i = 0
    while i < len(toks):
        if toks[i] == "FIN":
            i+=1
        
        #do limit checking
        elif toks[i] + " " + toks[i+1][0:6] == "prt STRING" or toks[i] + " " + toks[i+1][0:3] == "prt NUM" or toks[i] + " " + toks[i + 1][0:4] == "prt EXPR" or toks[i] + " " + toks[i + 1][0:3] == "prt VAR":
            if toks[i+1][0:6] == "STRING":
                ericPrint(toks[i + 1])
            elif toks[i+1][0:3] == "NUM":
                ericPrint(toks[i+1])
            elif toks[i+1][0:4] == "EXPR":
                ericPrint(toks[i + 1])
            elif toks[i+1][0:3] == "VAR":
                ericPrint(getVariable(toks[i+1]))
            i+=2
        elif toks[i][0:3] + " " + toks[i+1] + " " + toks[i+2][0:6] == "VAR EQUALS STRING" or toks[i][0:3] + " " + toks[i+1] + " " + toks[i+2][0:3] == "VAR EQUALS NUM" or toks[i][0:3] + " " + toks[i+1] + " " + toks[i+2][0:4] == "VAR EQUALS EXPR" or toks[i][0:3] + " " + toks[i+1] + " " + toks[i+2][0:3] == "VAR EQUALS VAR":
            if toks[i+2][0:6] == "STRING":
                assign(toks[i], toks[i+2])
            elif toks[i+2][0:3] == "NUM":
                assign(toks[i], toks[i+2])
            elif toks[i+2][0:4] == "EXPR":
                assign(toks[i], "NUM:" + str(evaluate(toks[i+2][5:])))
            elif toks[i + 2][0:3] == "VAR":
                assign(toks[i], getVariable(toks[i + 2]))
            i+=3

        # Do limit checking
        elif toks[i][0:3] + " " + toks[i + 1] + " " + toks[i + 2] + " " + toks[i + 3][0:6] == "VAR EQUALS in STRING":
            getInput(toks[i+3][8:-1], toks[i][4:])
            i+=4

        elif toks[i] + " " + toks[i + 1][0:3] + " " + toks[i+2] == "FOR NUM DO" or toks[i] + " " + toks[i + 1][0:3] + " " + toks[i+2] == "FOR VAR DO" or toks[i] + " " + toks[i + 1][0:4] + " " + toks[i+2] == "FOR EXPR DO":
                number = 0
                if(toks[i+1][0:3]!="NUM" and toks[i+1][0:3]!="VAR"):
                    number = evaluate(toks[i+1][5:])

                elif toks[i+1][0:3] == "VAR":
                    number = int(getVariable(toks[i+1])[4:])

                elif toks[i+1][0:3] == "NUM":
                    number = int(toks[i+1][4:])

                fortokens = []
                counter = 1
                for j in range(i+3,len(toks)):
                    if toks[j] == "FIN":
                        counter-=1
                        if counter == 0:
                            for k in range(number):
                                parse(fortokens)
                            i=j+1
                            break

                    if toks[j] == "DO":
                        counter+=1

                    fortokens.append(toks[j])
                        
        elif toks[i] + " " + toks[i + 1][0:3] + " " + toks[i + 2] + " " + toks[i + 3][0:3] + " " + toks[i+4] == "IF NUM EQUALS2 NUM DO" or \
                toks[i] + " " + toks[i + 1][0:3] + " " + toks[i + 2] + " " + toks[i + 3][0:3] + " " + toks[i+4] == "IF NUM BIGGER NUM DO" or\
                toks[i] + " " + toks[i + 1][0:3] + " " + toks[i + 2] + " " + toks[i + 3][0:3] + " " + toks[i+4] == "IF NUM SMALLER NUM DO" or\
                toks[i] + " " + toks[i + 1][0:3] + " " + toks[i + 2] + " " + toks[i + 3][0:3] + " " + toks[i+4] == "IF NUM BIGEQ NUM DO" or\
                toks[i] + " " + toks[i + 1][0:3] + " " + toks[i + 2] + " " + toks[i + 3][0:3] + " " + toks[i + 4] == "IF NUM SMALLEQ NUM DO":
            if toks[i + 2] == "EQUALS2":
                if toks[i + 1][4:] == toks[i + 3][4:] and toks[i] != "FIN":
                    iftokens = []
                    counter = 1
                    for j in range(i+5,len(toks)):
                        if toks[j] == "FIN":
                            counter-=1
                            if counter == 0:
                                parse(iftokens)
                                i=j+1
                                break

                        if toks[j] == "DO":
                            counter+=1

                        iftokens.append(toks[j])
                else:
                    for j in range(i+5,len(toks)):
                        if toks[j] == "FIN":
                            i=j+1
                            break
            elif toks[i + 2] == "SMALLER":
                if toks[i + 1][4:] < toks[i + 3][4:] and toks[i] != "FIN":
                    iftokens = []
                    counter = 1
                    for j in range(i + 5, len(toks)):
                        if toks[j] == "FIN":
                            counter -= 1
                            if counter == 0:
                                parse(iftokens)
                                i = j + 1
                                break

                        if toks[j] == "DO":
                            counter += 1

                        iftokens.append(toks[j])
                else:
                    for j in range(i + 5, len(toks)):
                        if toks[j] == "FIN":
                            i = j + 1
                            break
            elif toks[i + 2] == "BIGGER":
                if toks[i + 1][4:] > toks[i + 3][4:] and toks[i] != "FIN":
                    iftokens = []
                    counter = 1
                    for j in range(i + 5, len(toks)):
                        if toks[j] == "FIN":
                            counter -= 1
                            if counter == 0:
                                parse(iftokens)
                                i = j + 1
                                break

                        if toks[j] == "DO":
                            counter += 1

                        iftokens.append(toks[j])

                else:
                    for j in range(i + 5, len(toks)):
                        if toks[j] == "FIN":
                            i = j + 1
                            break
            elif toks[i + 2] == "SMALLEQ":
                if toks[i + 1][4:] <= toks[i + 3][4:] and toks[i] != "FIN":
                    iftokens = []
                    counter = 1
                    for j in range(i + 5, len(toks)):
                        if toks[j] == "FIN":
                            counter -= 1
                            if counter == 0:
                                parse(iftokens)
                                i = j + 1
                                break

                        if toks[j] == "DO":
                            counter += 1

                        iftokens.append(toks[j])

                else:
                    for j in range(i + 5, len(toks)):
                        if toks[j] == "FIN":
                            i = j + 1
                            break
            elif toks[i + 2] == "BIGEQ":
                if toks[i + 1][4:] >= toks[i + 3][4:] and toks[i] != "FIN":
                    iftokens = []
                    counter = 1
                    for j in range(i + 5, len(toks)):
                        if toks[j] == "FIN":
                            counter -= 1
                            if counter == 0:
                                parse(iftokens)
                                i = j + 1
                                break

                        if toks[j] == "DO":
                            counter += 1

                        iftokens.append(toks[j])

                else:
                    for j in range(i + 5, len(toks)):
                        if toks[j] == "FIN":
                            i = j + 1
                            break

# Saves file with contents of ERIC code
def savefile():
    file = open("erictest.eric", "w")
    file.write(textbox.get(1.0, tk.END))
    file.close()

# Run functions
def run():
    # start_time = time.time()
    savefile()
    data = openFile("erictest.eric")
    toks = lex(data)
    print(toks)
    parse(toks)
    # end_time = time.time()
    # print(f"Total runtime of the program is {(end_time - start_time)*1000} ms")

# TKinter window
window = tk.Tk()
window.geometry("500x450")
title = tk.Label(window, text = "E.R.I.C", font = "Cambria, 16")
title.pack(pady = 10)
textbox = tk.Text(window, width = 60, height = 15, font = "Cambria, 10")
textbox.pack(pady = 20)
save_button = tk.Button(window, text = "Run", width= 10, command = run)
save_button.pack(pady = 20)

window.mainloop()