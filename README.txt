Shijing Zhou 52151500012 
On my honor, I have neither given nor received unauthorized aid on this assignment.

===========================================================================
* INTRODUCTION
===========================================================================
MIPSimulator is a project for the Project One of the lecture Computer Architecture taught by Prof. Mingsong Chen in East China Normal University. For the detail of project requirements, please read the introduction to the project. 

The project is developed in Java platform. I choose Java not only because of the convenience in Object-Oriented developing, but its expressiveness for Design Pattern, such as Simple Factory Pattern, Singleton Pattern, and Strategy Pattern. Therefore, rather than write the whole program in a single .java file, I divide it into different modules so as to enhance the readability of the code. 

First of all, I will illustrate how to run the program in command line. Then we will look into the architecture of the program. Finally, some issues about futher development are listed. 

===========================================================================
* RUN THE PROGRAM
===========================================================================
In the command line, find the path of MIPSsim.jar and put the input file(e.g. sample.txt) in the same path, execute the following command. 

>> MIPSsim.jar sample.txt

Then the program will create two files named "disassembly.txt" and "simulation.txt" in the same directory. 

Note: The project runs under Java Runtime Environment "jre1.8.0_73". Please make sure that you have installed this version of JRE or later. 

===========================================================================
* PROJECT ARCHITECTURE
===========================================================================

** Components
The project consists of two components, Disassembler and Simulator. Both of them implements the interface IExecutable, which can run and return a String of result for output. 

public interface IExecutable {
	public String run();
}


** Models 
The following class diagram shows the structure to handle the input machine code. 

                              ┏━━━━━━━━━┓
                              ┃  AbstractBinary  ┃
                              ┣━━━━━━━━━┫
                              ┃String machineCode┃
                              ┃int    currentLine┃
                              ┗━━━━┳━━━━┛
                    ┏━━━━━━━━━┻━━━━━━━┓
        ┏━━━━━┻━━━━━━━┓    ┏━━━━━━┻━━━━━━━┓
        ┃    AbstractInstruction   ┃    ┃        AbstractData        ┃
        ┣━━━━━━━━━━━━━┫    ┣━━━━━━━━━━━━━━┫
        ┃String opcode             ┃    ┃                            ┃
        ┃String instName           ┃    ┣━━━━━━━━━━━━━━┫
        ┃String assemblyCode       ┃    ┃abstract String calculate() ┃
        ┣━━━━━━━━━━━━━┫    ┃abstract int    getData()   ┃
        ┃abstract String parse()   ┃    ┃abstract void   setData(int)┃
        ┃abstract int    execute(*)┃    ┗━━━━━━━━━━━━━━┛
        ┗━━━━━┳━━━━━━━┛
        ┏━━━━━┻━━━━┳━━━━━━━━━━┓
┏━━━┻━━━┓    ┏━━━┻━━━┓    ┏━━━┻━━━┓
┃ CategoryOne  ┃    ┃ CategoryTwo  ┃    ┃CategoryThree ┃
┗━━━━━━━┛    ┗━━━━━━━┛    ┗━━━━━━━┛

1. AbstractBinary
Each line of the input machine code can be regarded as a AbstractBinary. It has a property machineCode to indicate the exact input text of 16-bit machine code, and a property currentLine to indicate the current line of this machine code, which starts from 128. 

2. AbstractInsturction
Before the program recognizes the BREAK instruction, the machine code will be treated as AbstractInstuction. It has three properties as well as two abstract methods. 
* opcode: the opcode in binary form. (e.g. "101" for BREAK)
* instName: the text of instruction. (e.g. "BREAK" for BREAK)
* assemblyCode: the assembly code with respect to a specific machine code after parsing. (e.g. "ADD R1, R0, R0" for "11000000000000000000100000000000")
* parse(): This method is used in Disassembler. After an instruction is instantiated, it should be able to parse the machine code, update and return the corresponding assembly code. 
* execute(): This method is used in Simulator. Each Instruction can be executed and affect the value of registers and data block. 

3. AbstractData
If the 16-bit machine code represents data, it will be treated as AbstractData. In this project, all data are treated as signed integer. However, if we want to support float point data, it is a natural way to extends this abstract class and implement the abstract methods. 
* calculate(): This methods is used in Disassembler. After a datum is instantiated, it should be able to calculate the machine code according to the given format. 

===========================================================================
* FURTHER DEVELOPMENT
===========================================================================
There are still some modifications need to be done. 

1. The functions of method parse() in AbstractInstruction and method calculate() in AbstractData are the same in nature. They should be combined into one method and moved to AbstractBianry. 

2. Some of the instructions listed in the specification but not appeared in the sample input are left unimplemented. 

3. The return type of getData() in AbstractData should be changed from int to String, if the project is to support float point data. 
