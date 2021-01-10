# E.R.IC
ERIC is a simple but Excessively Resource Intensive Computer programming language written in Python 
<br />

## Installation

### Pre-requisites

Python 3

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install the dependencies for ERIC.

```bash
pip install -r requirements.txt
```

## Usage

### Manual

> prt
>>prt is used to print the various data types that are available in E.R.I.C

>$
>>The dollar sign is used to specify the start of declaring a variable name

>in
>>in is used to declare an input variable.

>Arithmetic Operations
>>Arithmetic operations are declared when an expression is identified. 
An expression will be identified when one of the symbols eg. +, -, /, * are found in a token.

>for loops
>>For loops are declared with the syntax “for *number* do” and the code for the loop will be 
limited by “fin” so the code that will be runned by the loop will only be between do and fin. 
The number serves as how much loops will be repeated. 

>if
>>In eric the if statements syntax are almost the same as the for loop “if *condition* do” and 
it will also be limited to “fin” so the code that will be run is between do and fin.

### Starting the Program

#### Windows
```shell
python.exe .\eric.py
```

#### Linux/MacOS
```shell
python3 eric.py
```
As the program starts it will prompt the GUI with an empty textbox and a run button.

The textbox is where you can write the code for E.R.I.C programming language and after you are done 
with your code just type run and the output will be displayed in the command line.
